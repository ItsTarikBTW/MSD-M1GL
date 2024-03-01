package com.example.exomsd.Interfaces;

import com.example.exomsd.Models.Cours;

import java.sql.SQLException;
import java.util.List;

public interface ICoursDao {
    void addCours(Cours cours) throws SQLException;

    List<Cours> getCours() throws SQLException;

    Cours getCoursById(Long id) throws SQLException;

    void updateCours(Cours cours) throws SQLException;

    void deleteCours(Long id);
}
