package src.servlets.salle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.dao.SalleDao;

import java.io.IOException;

@WebServlet(name = "deleteSalle", value = "/delete-salle")
public class DeleteSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get salle id
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            // Handle the case where the id parameter is not provided or is empty
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing 'id' parameter");
            return;
        }
        int id = Integer.parseInt(idParam);

        //Delete salle record on the DB
        SalleDao.deleteSalle(id);

        //Pass execution control to the ViewSalles servlet
        String url = "/view-salles";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
