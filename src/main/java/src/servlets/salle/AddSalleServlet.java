package src.servlets.salle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.dao.SalleDao;
import src.model.Salle;

import java.io.IOException;

@WebServlet(name = "addSalle", value = "/add-salle")
public class AddSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        int capacite = Integer.parseInt(req.getParameter("capacite"));
        String localisation = req.getParameter("localisation");

        //Init salle object
        Salle salle = new Salle(nom, capacite, localisation);

        //Add salle to the database
        SalleDao.addSalle(salle);

        //Pass execution control to the ViewSalles servlet
        String url = "/view-salles";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
