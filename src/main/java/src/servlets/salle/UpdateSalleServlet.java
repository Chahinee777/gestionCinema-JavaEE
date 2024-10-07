package src.servlets.salle;

import src.dao.SalleDao;
import src.model.Salle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateSalle", value = "/salle-update")
public class UpdateSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Salle salle = SalleDao.getSalle(id);
        request.setAttribute("salle", salle);
        request.getRequestDispatcher("update-salle-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParameter = request.getParameter("id");
        String capaciteParameter = request.getParameter("capacite");

        // Check if idParameter and capaciteParameter are not empty
        if (idParameter != null && !idParameter.isEmpty() && capaciteParameter != null && !capaciteParameter.isEmpty()) {
            int id = Integer.parseInt(idParameter);
            String nom = request.getParameter("nom");
            int capacite = Integer.parseInt(capaciteParameter);
            String localisation = request.getParameter("localisation");

            Salle salle = new Salle(id, nom, capacite, localisation);
            SalleDao.updateSalle(salle);

            response.sendRedirect("view-salles"); // Redirect to the list of salles after update
        }
    }
}
