package src.dao;

import src.controller.DatabaseUtility;
import src.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User getUser(User U){
        User u = null;
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")) {
            ps.setString(1, U.getUsername());
            ps.setString(2, U.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setProfil(rs.getString("profil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void addUser(User user) throws SQLException {
    String sql = "INSERT INTO user (username, password, profil) VALUES (?, ?, ?)";
    try (Connection connection = DatabaseUtility.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getProfil());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
