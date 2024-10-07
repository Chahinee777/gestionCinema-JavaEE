package src.servlets.movie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.dao.MovieDao;
import src.model.Movie;

import java.io.IOException;

@WebServlet(name = "updateMovie", value = "/update-movie")
public class UpdateMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Call doPost() since we do not want to allow changes via GET
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the form data and store in movie object
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        int revenue = Integer.parseInt(req.getParameter("revenue"));

        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setRevenue(revenue);

        //Perform update
        MovieDao.updateMovie(movie);

        //Pass control
        String url = "/view-movies";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
