package org.demo.todolist.domain;

import java.util.Objects;

public class Bruker {

    private Long bruker_id;
    private String login;
    private String navn;
    private String epost;

    public Bruker() {
    }

    public Bruker(Long bruker_id, String login, String navn, String epost) {
        this.bruker_id = bruker_id;
        this.login = login;
        this.navn = navn;
        this.epost = epost;
    }

    public Long getBruker_id() {
        return bruker_id;
    }

    public void setBruker_id(Long bruker_id) {
        this.bruker_id = bruker_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.bruker_id);
        hash = 29 * hash + Objects.hashCode(this.login);
        hash = 29 * hash + Objects.hashCode(this.navn);
        hash = 29 * hash + Objects.hashCode(this.epost);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bruker other = (Bruker) obj;
        if (this.epost != other.epost) {
            return false;
        }
        if (!Objects.equals(this.navn, other.navn)) {
            return false;
        }
        if (!Objects.equals(this.bruker_id, other.bruker_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bruker{");
        sb.append("{bruker_id=").append(bruker_id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", navn='").append(navn).append('\'');
        sb.append(", epost='").append(epost).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
