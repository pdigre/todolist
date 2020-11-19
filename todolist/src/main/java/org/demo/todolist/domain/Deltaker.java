package org.demo.todolist.domain;

public class Deltaker {

    private Long bruker_id;
    private Long liste_id;

    public Long getBruker_id() {
		return bruker_id;
	}

	public void setBruker_id(Long bruker_id) {
		this.bruker_id = bruker_id;
	}

	public Long getListe_id() {
		return liste_id;
	}

	public void setListe_id(Long liste_id) {
		this.liste_id = liste_id;
	}

	public Deltaker(Long bruker_id, Long liste_id) {
		super();
		this.bruker_id = bruker_id;
		this.liste_id = liste_id;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Deltaker{");
        sb.append("{bruker_id=").append(bruker_id);
        sb.append(", liste_id=").append(liste_id);
        sb.append('}');
        return sb.toString();
    }
}
