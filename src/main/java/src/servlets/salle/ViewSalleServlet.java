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
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "viewSalles", value = {"/view-salles"})
public class ViewSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get a list of the salles in DB
        ResultSet resultSet = SalleDao.getAllSalles();

        if (resultSet == null) {
            System.err.println("Issue with displaying all salles. Result set is null.");

            return;
        }

        List<Salle> salles = SalleDao.resultSetToSalleList(resultSet);

        //Pass execution control
        req.setAttribute("salles", salles);
        String url = "/great-salles-collection.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
