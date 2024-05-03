package root.carnet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import root.carnet.Model.*;

import java.io.IOException;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "updateServlet", value = "/update*")
public class Update extends HttpServlet {
    CarnetDAO carnerDao ;

    public void init() {
        carnerDao = new CarnetDAOImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String nomA = request.getParameter("nomA");
        String rue = request.getParameter("numRue");
        String ville = request.getParameter("ville");
        Personne personne = new Personne(name);
        Adress adress = new Adress(nomA, Integer.parseInt(rue), ville);
        carnerDao.updateEnsemble(id, personne, adress);
        response.sendRedirect("/index");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO: GET OLD DATA TO INPUT FIELDS
        System.out.println("Update do get");
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    }