package src.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import src.dao.MovieDao;
import src.dao.SalleDao;
import src.model.Salle; // Assuming Salle is in the 'src.models' package

@WebServlet(name = "moviesAndSalles", value = "/movies-and-salles")
public class MoviesandSallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve 'table' and 'salles' data from your database or another data source
        ResultSet resultSet = MovieDao.getAllMovies();
        if (resultSet == null) {
            System.err.println("Issue with displaying all movies. Result set is null.");

            return;
        }

        String table =  MovieDao.DisplayTableWithoutActions(resultSet);
        ResultSet resultSet1 = SalleDao.getAllSalles();

        if (resultSet1 == null) {
            System.err.println("Issue with displaying all salles. Result set is null.");

            return;
        }

        List<Salle> salles = SalleDao.resultSetToSalleList(resultSet1);

        req.setAttribute("table", table);
        req.setAttribute("salles", salles);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/movies-and-salles.jsp");
        dispatcher.forward(req, resp);
    }
}
