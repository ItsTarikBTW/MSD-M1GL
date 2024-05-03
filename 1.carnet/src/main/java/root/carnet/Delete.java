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
@WebServlet(name = "deleteServlet", value = "/delete/*")
public class Delete extends HttpServlet {
    CarnetDAO carnerDao ;
    public void init() {
        carnerDao = new CarnetDAOImpl();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String name = request.getParameter("carnet");
        carnerDao.deleteEnsemble(name);
        response.sendRedirect("/index");
    }

}