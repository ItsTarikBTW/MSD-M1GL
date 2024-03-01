package com.example.exomsd.Interfaces;

import com.example.exomsd.Models.Cours;
import com.example.exomsd.jdbc.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ICoursDaoImpl implements ICoursDao {
    SingletonConnection singletonConnection;

    public ICoursDaoImpl(SingletonConnection singletonConnection) {
        this.singletonConnection = singletonConnection;
    }

    @Override
    public void addCours(Cours cours) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into cours(titre, contenu, auteur) values(?,?,?)");
        stmt.setString(1, cours.getTitre());
        stmt.setString(2, cours.getContenu());
        stmt.setString(3, cours.getAuteur());

        stmt.execute();
    }

    @Override
    public List<Cours> getCours() throws SQLException {
        List<Cours> cours = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cours");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cours cour = new Cours(rs.getLong("id"), rs.getString("titre"), rs.getString("contenu"), rs.getString("auteur"));
            cours.add(cour);
        }

        return cours;
    }

    @Override
    public Cours getCoursById(Long id) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cours WHERE id = ?");
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return new Cours(rs.getLong("id"), rs.getString("titre"), rs.getString("contenu"), rs.getString("auteur"));
    }

    @Override
    public void updateCours(Cours cours) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE cours SET titre = ?, contenu = ?, auteur = ? WHERE id = ?");
            stmt.setString(1, cours.getTitre());
            stmt.setString(2, cours.getContenu());
            stmt.setString(3, cours.getAuteur());
            stmt.setLong(4, cours.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCours(Long id) {
        try {
            Connection connection = SingletonConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM cours WHERE id = ?");
            stmt.setInt(1, Math.toIntExact(id));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}