package org.demo.todolist;

import java.util.List;

import org.demo.todolist.domain.Bruker;
import org.demo.todolist.domain.Deltaker;
import org.demo.todolist.domain.Liste;
import org.demo.todolist.domain.Punkt;

public interface ITodoRepository {

    List<Bruker> findAllBrukere();
    List<Liste> findAllLister();
    List<Liste> getLister(long bruker_id);
    Bruker getBruker(long bruker_id);
    List<Deltaker> findAllDeltakere();
    Liste getListe(long liste_id);
    List<Punkt> getPunkter(long liste_id);
    Punkt getPunkt(long liste_id, long punkt_id);
    void insertPunkt(long liste_id,String tekst);
    void deletePunkt(long liste_id, long punkt_id);
    void updatePunkt(Punkt punkt);
	void addKategori(long liste_id, long punkt_id, String kategori);
	void delKategori(long liste_id, long punkt_id, String kategori);
}