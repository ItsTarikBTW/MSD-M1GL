package root.Model;

import java.util.HashMap;
import java.io.Serializable;
public class Carnet implements Serializable {
    public int id;
    public String nom;
    public HashMap<String, Adress> ensemble;

    public Carnet() {
        this.nom = "Carnet";
        this.ensemble = new HashMap<String, Adress>();
    }

    public Carnet(String nom) {
        this.nom = nom;
        this.ensemble = new HashMap<String, Adress>();
    }

    public void enregistrer(String personne, Adress newAddress) {

        try {
            ensemble.put(personne, newAddress);
            //add to db
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void effacer(String personne) {
        try {
            ensemble.remove(personne);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public Adress chercher(String personne) {
        try {
            return ensemble.get(personne);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public void lister() {

        for (String personne : ensemble.keySet()) {
            System.out.println(personne + " : " + ensemble.get(personne));
        }
        if (ensemble.isEmpty()) {
            System.out.println("Le carnet est vide");
        }
    }
    

}
