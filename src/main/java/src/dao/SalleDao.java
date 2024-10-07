package src.dao;

import src.controller.DatabaseUtility;
import src.model.Salle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDao {
    // Other methods...

    public static ResultSet getAllSalles() {
        try {
            Connection connection = DatabaseUtility.getConnection();
            String query = "SELECT * FROM Salle";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Salles ResultSet: " + resultSet); // Debug print statement
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Salle> resultSetToSalleList(ResultSet resultSet) {
        List<Salle> salles = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Salle salle = new Salle();
                salle.setId(resultSet.getInt("id"));
                salle.setNom(resultSet.getString("nom"));
                salle.setCapacite(resultSet.getInt("capacite"));
                salle.setLocalisation(resultSet.getString("localisation"));
                salles.add(salle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Salle List: " + salles); // Debug print statement
        return salles;
    }

    public static void addSalle(Salle salle) {
        try {
            Connection connection = DatabaseUtility.getConnection();
            String query = "INSERT INTO Salle (id, nom, capacite, localisation) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, salle.getId());
            preparedStatement.setString(2, salle.getNom());
            preparedStatement.setInt(3, salle.getCapacite());
            preparedStatement.setString(4, salle.getLocalisation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSalle(int id) {
        try {
            Connection connection = DatabaseUtility.getConnection();
            String query = "DELETE FROM Salle WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Salle getSalle(int id) {
        try {
            Connection connection = DatabaseUtility.getConnection();
            String query = "SELECT * FROM Salle WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Salle salle = new Salle();
                salle.setId(resultSet.getInt("id"));
                salle.setNom(resultSet.getString("nom"));
                salle.setCapacite(resultSet.getInt("capacite"));
                salle.setLocalisation(resultSet.getString("localisation"));
                return salle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateSalle(Salle salle) {
        try {
            Connection connection = DatabaseUtility.getConnection();
            String query = "UPDATE Salle SET nom = ?, capacite = ?, localisation = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, salle.getNom());
            preparedStatement.setInt(2, salle.getCapacite());
            preparedStatement.setString(3, salle.getLocalisation());
            preparedStatement.setInt(4, salle.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
