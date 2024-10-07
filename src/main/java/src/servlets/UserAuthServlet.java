package src.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.dao.UserDao;
import src.model.User;

import java.io.IOException;

@WebServlet(name = "UserAuthServlet", urlPatterns = {"/UserAuthServlet"})
public class UserAuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDatabaseStatements = new UserDao();
        User user = userDatabaseStatements.getUser(new User(username, password));

        try {
            if (user != null) {
                // Check if the user's profile is 'user'
                if (!"user".equals(user.getProfil())) {
                    // Login failed. Redirect back to the login page.
                    response.sendRedirect("user-login.html");
                } else {
                    // Login successful. Redirect to the user's home page.
                    response.sendRedirect("movies-and-salles.jsp");
                }
            } else {
                // Login failed. Redirect back to the login page.
                response.sendRedirect("user-login.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
