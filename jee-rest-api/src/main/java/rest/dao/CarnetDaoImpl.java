package rest.dao;

import rest.models.Adresse;
import rest.models.Carnet;
import rest.db.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarnetDaoImpl implements CarnetDao {
    private Connection connection;

    public CarnetDaoImpl() {
        this.connection = SingletonConnection.getConnection();
    }

    @Override
    public Carnet findById(int id) {
        // Implement the logic to fetch a Carnet by id
        // This is just a placeholder and may not work with your actual database schema
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM carnet WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Create and return a Carnet object from the ResultSet
                // This will depend on the structure of your Carnet class
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addContact(String nomPersonne, Adresse adresse) {
        // Implement the logic to add a contact
    }

    @Override
    public void deleteContact(String nomPersonne) {
        // Implement the logic to delete a contact
    }

    @Override
    public void updateContact(String nomPersonne, Adresse adresse) {
        // Implement the logic to update a contact
    }

    @Override
    public void listContacts() {
        // Implement the logic to list all contacts
    }

    @Override
    public void deleteAllContacts() {
        // Implement the logic to delete all contacts
    }
}