package com.api.Model;

import java.util.HashMap;
import java.io.Serializable;

public class Carnet implements Serializable {
    private int id;
    private String nom;
    public HashMap<String, Address> ensemble;

    public Carnet(int id) {
        this.id = id;
        this.nom = "Carnet" + id;
        this.ensemble = new HashMap<String, Address>();
    }

    public Carnet(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.ensemble = new HashMap<String, Address>();
    }

    public void enregistrer(String name, Address newAddress) {
        try {
            ensemble.put(name, newAddress);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void effacer(String name) {
        try {
            ensemble.remove(name);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public Address chercher(String name) {
        try {
            return ensemble.get(name);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public void lister() {

        for (String name : ensemble.keySet()) {
            System.out.println(name + " : " + ensemble.get(name));
        }
        if (ensemble.isEmpty()) {
            System.out.println("Le carnet est vide");
        }
    }

    public String toString() {
        String header = "Carnet " + this.id + " : " + this.nom + "\n";
        String body = "";
        for (String name : ensemble.keySet()) {
            body += "\t" +name + " : " + ensemble.get(name) + "\n";
        }
        return header + body;
    }

}
