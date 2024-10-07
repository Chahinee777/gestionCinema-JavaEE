package src.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.dao.UserDao;
import src.model.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get form data
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String profil = req.getParameter("profil"); // Get profil from form

        // Create new User object
        User user = new User(username, password, profil);

        // Add new user to database
        UserDao userDatabaseStatements = new UserDao();
        try {
            userDatabaseStatements.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            // You could forward to an error page here or handle the error in some other way
        }

        // Redirect to login page
        resp.sendRedirect("index.html");
    }
}
