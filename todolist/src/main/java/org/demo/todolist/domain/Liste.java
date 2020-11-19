package org.demo.todolist.domain;

import java.util.ArrayList;
import java.util.List;

public class Liste {

    private Long liste_id;
    private String tittel;
    private List<Punkt> punkter = new ArrayList<>();

    public List<Punkt> getPunkter() {
		return punkter;
	}

	public Liste() {
    }

    public Long getListe_id() {
		return liste_id;
	}

	public void setListe_id(Long liste_id) {
		this.liste_id = liste_id;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public Liste(Long liste_id, String tittel) {
        this.liste_id = liste_id;
        this.tittel = tittel;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Liste{");
        sb.append("{liste_id=").append(liste_id);
        sb.append(", tittel='").append(tittel).append('\'');
        sb.append('}');
        return sb.toString();
    }

	public void addPunkter(List<Punkt> punkter) {
		this.punkter.addAll(punkter);
	}
}
