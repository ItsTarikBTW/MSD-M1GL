package root.carnet.Model;

import java.util.HashMap;

public class Carnet {
    public String nom;
    public HashMap<Personne, Adress> ensemble;

    public Carnet() {
        this.nom = "Carnet";
        this.ensemble = new HashMap<Personne, Adress>();
    }

    public Carnet(String nom) {
        this.nom = nom;
        this.ensemble = new HashMap<Personne, Adress>();
    }

    public void enregistrer(Personne personne, Adress newAddress) {

        try {
            ensemble.put(personne, newAddress);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void effacer(Personne personne) {
        try {
            ensemble.remove(personne);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public Adress chercher(Personne personne) {
        try {
            return ensemble.get(personne);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public void lister() {

        for (Personne personne : ensemble.keySet()) {
            System.out.println(personne.nom + " : " + ensemble.get(personne));
        }
        if (ensemble.isEmpty()) {
            System.out.println("Le carnet est vide");
        }
    }
    

}
