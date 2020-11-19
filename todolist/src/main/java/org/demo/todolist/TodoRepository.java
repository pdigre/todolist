package org.demo.todolist;

import java.util.Arrays;
import java.util.List;

import org.demo.todolist.domain.Bruker;
import org.demo.todolist.domain.Deltaker;
import org.demo.todolist.domain.Liste;
import org.demo.todolist.domain.Punkt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TodoRepository implements ITodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Bruker> findAllBrukere() {
        return jdbcTemplate.query(
        		"SELECT * FROM bruker", 
        		new BeanPropertyRowMapper<>(Bruker.class));
    }

	@Override
	public List<Liste> findAllLister() {
        return jdbcTemplate.query(
        		"SELECT * FROM liste", 
        		new BeanPropertyRowMapper<>(Liste.class));
	}

	@Override
	public List<Deltaker> findAllDeltakere() {
        return jdbcTemplate.query(
        		"SELECT * FROM deltaker", 
        		new BeanPropertyRowMapper<>(Deltaker.class));
	}

	@Override
	public Liste getListe(long liste_id) {
        Liste liste = jdbcTemplate.queryForObject(
        		"SELECT * FROM liste WHERE liste_id = ?",
        		new BeanPropertyRowMapper<>(Liste.class),
        		liste_id);
		return liste;
	}

	@Override
	public void insertPunkt(long liste_id, String tekst) {
		List<Punkt> punkter = getPunkter(liste_id);
		long max = 1L;
		for (Punkt punkt : punkter) {
			max= Math.max(max, punkt.getPunkt_id()+1);
		}
		jdbcTemplate.update(
				"INSERT INTO punkt VALUES (?, ?, ?, ?, ?)",
				liste_id,
				max++,
				tekst,
				"",
				false
				);
	}

	@Override
	public void deletePunkt(long liste_id,long punkt_id) {
		jdbcTemplate.update(
				"DELETE FROM punkt WHERE liste_id = ? AND punkt_id = ?",
				liste_id,
				punkt_id
				);
	}

	@Override
	public void updatePunkt(Punkt punkt) {
		jdbcTemplate.update(
				"UPDATE punkt SET tekst = ?, kategorier = ?, erFerdig = ? WHERE liste_id = ? AND punkt_id = ?",
				punkt.getTekst(),
				punkt.getKategorier(),
				punkt.isErFerdig(),
				punkt.getListe_id(),
				punkt.getPunkt_id()
				);
	}

	@Override
	public List<Liste> getLister(long bruker_id) {
		List<Liste> lister = jdbcTemplate.query(
        		"SELECT * FROM liste WHERE "+
        				"EXISTS(SELECT * FROM deltaker WHERE deltaker.liste_id = liste.liste_id AND deltaker.bruker_id = ?)",
        		new BeanPropertyRowMapper<>(Liste.class),
        		bruker_id );
		return lister;
	}

	@Override
	public List<Punkt> getPunkter(long liste_id) {
        List<Punkt> punkter = jdbcTemplate.query(
        		"SELECT * FROM punkt WHERE liste_id = ?", 
        		new BeanPropertyRowMapper<>(Punkt.class),
        		liste_id);
        return punkter;
	}

	@Override
	public Punkt getPunkt(long liste_id, long punkt_id) {
        Punkt punkt = jdbcTemplate.queryForObject(
        		"SELECT * FROM punkt WHERE liste_id = ? AND punkt_id = ?", 
        		new BeanPropertyRowMapper<>(Punkt.class),
        		liste_id,
        		punkt_id);
        return punkt;
	}

	@Override
	public void addKategori(long liste_id, long punkt_id, String kategori) {
		Punkt punkt = getPunkt(liste_id, punkt_id);
		List<String> kats = Arrays.asList(punkt.getKategorier().split(","));
		if(!kats.contains(kategori))
			kats.add(kategori);
		punkt.setKategorier(String.join(",", kats));
		updatePunkt(punkt);
	}

	@Override
	public void delKategori(long liste_id, long punkt_id, String kategori) {
		Punkt punkt = getPunkt(liste_id, punkt_id);
		List<String> kats = Arrays.asList(punkt.getKategorier().split(","));
		kats.remove(kategori);
		punkt.setKategorier(String.join(",", kats));
		updatePunkt(punkt);
	}

	@Override
	public Bruker getBruker(long bruker_id) {
		Bruker bruker = jdbcTemplate.queryForObject(
        		"SELECT * FROM bruker WHERE bruker_id = ?",
        		new BeanPropertyRowMapper<>(Bruker.class),
        		bruker_id);
		return bruker;
	}
    
}