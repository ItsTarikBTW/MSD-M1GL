package com.example.exomsd;

import com.example.exomsd.Interfaces.ICoursDao;
import com.example.exomsd.Interfaces.ICoursDaoImpl;
import com.example.exomsd.Models.Cours;
import com.example.exomsd.jdbc.SingletonConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "coursServlet", value = "/index/*")
public class CoursServlet extends HttpServlet {
    ICoursDao metier;
    SingletonConnection singletonConnection;
    List<Cours> cours = new ArrayList<>();

    public void init() {
        singletonConnection = new SingletonConnection();
        metier = new ICoursDaoImpl(singletonConnection);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pathInfo = request.getPathInfo();
        try {
            if (pathInfo != null && !pathInfo.equals("/")) {
                // There is a parameter in the request
                long id = Long.parseLong(pathInfo.substring(1));
                Cours cour = metier.getCoursById(id);
                if (cour == null) {
                    throw new RuntimeException("Cours not found");
                } else {
                    request.setAttribute("cour", cour);
                    request.getRequestDispatcher("/show-cours.jsp").forward(request, response);
                }
            } else {
                // There is no parameter in the request
                cours = metier.getCours();
                request.setAttribute("cours", cours);
                request.getRequestDispatcher("/cours.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String method = request.getParameter("_method");
        if (method != null && method.equals("DELETE")) {
            doDelete(request, response);
        } else if (method != null && method.equals("PUT")) {
            doPut(request, response);
        } else {
            String titre = request.getParameter("titre");
            String contenu = request.getParameter("contenu");
            String auteur = request.getParameter("auteur");

            // Check if the parameters are not null and not empty
            if (titre == null || titre.isEmpty() || contenu == null || contenu.isEmpty() || auteur == null || auteur.isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required");
                return;
            }

            Cours cour = new Cours(titre, contenu, auteur);

            try {
                metier.addCours(cour);
                metier.getCours();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("index");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Cours cour = metier.getCoursById((long) id);
            if (cour != null) {
                String titre = req.getParameter("titre");
                String contenu = req.getParameter("contenu");
                String auteur = req.getParameter("auteur");

                System.out.println("titre " + titre);
                System.out.println("contenu " + contenu);
                System.out.println("auteur " + auteur);

                if (titre != null && !titre.isEmpty()) {
                    cour.setTitre(titre);
                }
                if (contenu != null && !contenu.isEmpty()) {
                    cour.setContenu(contenu);
                }
                if (auteur != null && !auteur.isEmpty()) {
                    cour.setAuteur(auteur);
                }

                metier.updateCours(cour);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect("/index");

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        System.out.println("path info " + pathInfo);
        long id = Long.parseLong(pathInfo.substring(1));
        Cours cours;
        try {
            cours = metier.getCoursById(id);
            if (cours == null) {
                throw new RuntimeException("Cours not found");
            } else {
                System.out.println("Cours found");
                metier.deleteCours(id);
                metier.getCours();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/index");
    }

    public void destroy() {
        SingletonConnection.closeConnection();
    }
}