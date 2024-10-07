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

@WebServlet(name = "updateSalleForm", value = "/update-salle-form")
public class UpdateSalleFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get data for dynamic form that shows current values
        int id = Integer.parseInt(req.getParameter("id"));

        //Get salle's current data from DB
        Salle salle = SalleDao.getSalle(id);

        if (salle == null) {
            System.err.println("Issue with getting the salle's existing data.");
        }

        //Set salle and pass control
        req.setAttribute("salle", salle);
        String url = "/great-salles-collection-update.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
