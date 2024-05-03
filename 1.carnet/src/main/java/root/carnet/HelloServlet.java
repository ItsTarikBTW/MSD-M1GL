package root.carnet;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import root.carnet.Model.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import root.carnet.jdbc.SingletonConnection;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "helloServlet", value = "/index/*")
public class HelloServlet extends HttpServlet {
    List<Carnet> listCarnet;
    CarnetDAO carnerDao ;
    public void init() {
        Personne tarik = new Personne("Tarik");
        Adress tarikAdr = new Adress("TIENT", 2511, "GHAZAOUET");
        Personne hadi = new Personne("Hadi");
        Adress hadiAdr = new Adress("OUDJLIDA", 707, "TLEMCEN");
        Personne yacine = new Personne("Yacine");
        Adress yacineAdr = new Adress("LES DAHLIAS", 1408, "TLEMCEN");
        Personne nardjes = new Personne("Nardjes");
        Adress nardjesAdr = new Adress("XYZ", 103 , "NEDROMA");
        Carnet carnet = new Carnet("c1");
        carnet.enregistrer(tarik, tarikAdr);
        carnet.enregistrer(hadi, hadiAdr);
        carnet.enregistrer(yacine, yacineAdr);
        carnet.enregistrer(nardjes, nardjesAdr);
        carnet.effacer(hadi);
        carnet.lister();
        carnet.chercher(tarik).print();
        listCarnet = new ArrayList<Carnet>();
        carnerDao = new CarnetDAOImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        listCarnet = carnerDao.listCarnet();
        request.setAttribute("listCarnet", listCarnet);
        request.getRequestDispatcher("/lister.jsp").forward(request, response);
    }

    public void destroy() {
        SingletonConnection.closeConnection();
    }
}