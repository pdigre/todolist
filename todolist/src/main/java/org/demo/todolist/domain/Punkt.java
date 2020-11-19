package org.demo.todolist.domain;

public class Punkt {

	private Long liste_id;
	private Long punkt_id;
	private String tekst;
	private String kategorier;
	private boolean erFerdig;

	public Long getListe_id() {
		return liste_id;
	}

	public Punkt() {
	}

	public void setListe_id(Long liste_id) {
		this.liste_id = liste_id;
	}

	public Long getPunkt_id() {
		return punkt_id;
	}

	public void setPunkt_id(Long punkt_id) {
		this.punkt_id = punkt_id;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public String getKategorier() {
		return kategorier;
	}

	public void setKategorier(String kategorier) {
		this.kategorier = kategorier;
	}

	public Punkt(Long liste_id, Long punkt_id, String tekst, String kategorier, boolean erFerdig) {
		super();
		this.liste_id = liste_id;
		this.punkt_id = punkt_id;
		this.tekst = tekst;
		this.kategorier = kategorier;
		this.erFerdig = erFerdig;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Punkt{");
		sb.append("{punkt_id=").append(punkt_id);
		sb.append(", tekst='").append(tekst).append('\'');
		sb.append(", kategorier='").append(kategorier).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public boolean isErFerdig() {
		return erFerdig;
	}

	public void setErFerdig(boolean erFerdig) {
		this.erFerdig = erFerdig;
	}
}
