package src.servlets;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.model.User;
import src.dao.UserDao;

@WebServlet(name = "AuthServlet", urlPatterns = {"/AuthServlet"})
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDatabaseStatements = new UserDao();
        User user = userDatabaseStatements.getUser(new User(username, password));

        try {
            if (user != null) {
                // Check if the user's profile is 'admin'
                if (!"admin".equals(user.getProfil())) {
                    // Login failed. Redirect back to the login page.
                    response.sendRedirect("login.html");
                } else {
                    // Login successful. Redirect to the user's home page.
                    response.sendRedirect("great-movies-collection.jsp");
                }
            } else {
                // Login failed. Redirect back to the login page.
                response.sendRedirect("login.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
