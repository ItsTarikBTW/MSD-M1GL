package rest.dao;

import rest.models.Adresse;
import rest.models.Carnet;

public interface CarnetDao {
    Carnet findById(int id);

    void addContact(String nomPersonne, Adresse adresse);

    void deleteContact(String nomPersonne);

    void updateContact(String nomPersonne, Adresse adresse);

    void listContacts();

    void deleteAllContacts();

}
