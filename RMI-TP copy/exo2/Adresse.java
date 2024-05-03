package exo2;

import java.io.Serializable;

public class Adresse implements Serializable{
    private String rue;
    private String ville;

    public Adresse(String rue, String ville) {
        this.rue = rue;
        this.ville = ville;
    }

    // getters and setters
    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}