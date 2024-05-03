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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        listCarnet = carnerDao.listCarnet();
        request.setAttribute("listCarnet", listCarnet);
        request.getRequestDispatcher("/lister.jsp").forward(request, response);
        /*
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html class='bg-gray-950 text-white'>");
        out.println("<head><script src='https://cdn.tailwindcss.com'></script></head");
        out.println("<body>");
        out.println("<div class='flex flex-col h-screen'>");
        navBar(out);
        out.println("<div class='flex justify-center items-center flex-1' >");
        registerForm(out);
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");*/
    }
    public static void navBar(PrintWriter out){
        out.println("<header class='bg-gray-800'>");
        out.println("<nav class='container mx-auto px-6 py-3'>");
        out.println("<div class='flex items-center justify-between'>");
        out.println("<div class='text-white font-bold text-xl'>");
        out.println("<a href='#'>Logo</a>");
        out.println("</div>");
        out.println("<div class='hidden md:block'>");
        out.println("<ul class='flex items-center space-x-8'>");
        out.println("<li><a href='#' class='text-white'>Home</a></li>");
        out.println("<li><a href='#' class='text-white'>About</a></li>");
        out.println("<li><a href='#' class='text-white'>Services</a></li>");
        out.println("<li><a href='#' class='text-white'>Contact</a></li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("<div class='md:hidden'>");
        out.println("<button class='outline-none mobile-menu-button'>");
        out.println("<svg class='w-6 h-6 text-white' x-show='!showMenu' fill='none' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' viewBox='0 0 24 24' stroke='currentColor'>");
        out.println("<path d='M4 6h16M4 12h16M4 18h16'></path>");
        out.println("</svg>");
        out.println("</button>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class='mobile-menu hidden md:hidden'>");
        out.println("<ul class='mt-4 space-y-4'>");
        out.println("<li><a href='#' class='block px-4 py-2 text-white bg-gray-900 rounded'>Home</a></li>");
        out.println("<li><a href='#' class='block px-4 py-2 text-white bg-gray-900 rounded'>About</a></li>");
        out.println("<li><a href='#' class='block px-4 py-2 text-white bg-gray-900 rounded'>Services</a></li>");
        out.println("<li><a href='#' class='block px-4 py-2 text-white bg-gray-900 rounded'>Contact</a></li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</nav>");
        out.println("</header>");
    }

    public static void listView(PrintWriter out){
        out.println("<div class='flex flex-col gap-4 justify-center items-center ring-2 rounded-lg ring-blue-500 p-5'>");
        out.println("<table class='table-auto'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th class='px-4 py-2'>Name</th>");
        out.println("<th class='px-4 py-2'>Address</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td class='border px-4 py-2'>Tarik</td>");
        out.println("<td class='border text-center px-4 py-2'>");
        addressTableView(out);
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class='border px-4 py-2'>Yacine</td>");
        out.println("<td class='border px-4 py-2'>");
        addressTableView(out);
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class='border px-4 py-2'>Nardjes</td>");
        out.println("<td class='border px-4 py-2'>");
        addressTableView(out);
        out.println("</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
    public static void addressTableView(PrintWriter out){
        out.println("TIENT");
        out.println("<hr>");
        out.println("2511");
        out.println("<hr>");
        out.println("GHAZAOUET");
    }
    public static void searchForm(PrintWriter out){
        out.println("<form class='flex flex-col gap-4 justify-center items-center ring-2 rounded-lg ring-blue-500 p-5'>");
        out.println("<h1 class='text-center text-2xl'> Search in carnet </h1>");
        out.println("<div class='flex gap-4 justify-center items-center py-2'>");
        out.println("<input type='search' class='text-black border-2 border-blue-500 rounded-lg p-2' placeholder='Enter your name'>");
        out.println("<button type='submit' class='bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded'>Search</button>");
        out.println("</div>");
        out.println("</form>");
    }
    public static void registerForm(PrintWriter out){
        out.println("<form class='flex flex-col gap-4 justify-center items-center ring-2 rounded-lg ring-blue-500 p-5'>");
        out.println("<h1 class='text-center text-3xl'> Add to carnet </h1>");
        out.println("<div class='flex items-start justify-center gap-4'>");
        out.println("<div class='flex flex-col gap-4 justify-center items-center ring-2 ring-red-500 p-2 rounded-md'>");
        out.println("<h2 class='text-center text-2xl'>Person</h2>");
        out.println("<div class='flex gap-4 justify-center items-center py-2'>");
        out.println("<label for='name'>name:</label>");
        out.println("<input type='text' class='text-black border-2 border-blue-500 rounded-lg p-2' placeholder='Enter your name'>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class='flex flex-col gap-4 justify-center items-center ring-2 ring-red-500 p-2 rounded-md'>");
        out.println("<h2 class='text-center text-2xl'>Address</h2>");
        out.println("<div class='flex gap-4 justify-center items-center py-2'>");
        out.println("<label for='name'>nom:</label>");
        out.println("<input type='text' class='text-black border-2 border-blue-500 rounded-lg p-2' placeholder='Enter your name'>");
        out.println("</div>");
        out.println("<div class='flex gap-4 justify-center items-center py-2'>");
        out.println("<label for='name'>Rue:</label>");
        out.println("<input type='number' class='text-black border-2 border-blue-500 rounded-lg p-2' placeholder='Enter your name'>");
        out.println("</div>");
        out.println("<div class='flex gap-4 justify-center items-center py-2'>");
        out.println("<label for='name'>Ville:</label>");
        out.println("<input type='text' class='text-black border-2 border-blue-500 rounded-lg p-2' placeholder='Enter your name'>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<button type='submit' class='bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded'>Submit</button>");
        out.println("</form>");
    }

    public void destroy() {
        SingletonConnection.closeConnection();
    }
}