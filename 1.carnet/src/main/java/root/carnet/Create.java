package root.carnet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import root.carnet.Model.Adress;
import root.carnet.Model.CarnetDAO;
import root.carnet.Model.CarnetDAOImpl;
import root.carnet.Model.Personne;

import java.io.IOException;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "createServlet", value = "/create/*")
public class Create extends HttpServlet {
    CarnetDAO carnerDao ;
    public void init() {
        carnerDao = new CarnetDAOImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String name = request.getParameter("name");
        String nomA = request.getParameter("nomA");
        String rue = request.getParameter("numRue");
        String ville = request.getParameter("ville");
        Personne personne = new Personne(name);
        Adress adress = new Adress(nomA, Integer.parseInt(rue), ville);
        carnerDao.addEnsemble(personne, adress);
        response.sendRedirect("/index");
    }

}