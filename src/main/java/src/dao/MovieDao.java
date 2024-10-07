package src.dao;

import src.controller.DatabaseUtility;
import src.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDao {
    public static void addMovie(Movie movie) {
        Connection connection = DatabaseUtility.getConnection();

        if (connection == null) {
            System.err.println("Unable to perform query due to connection issue. See previous error message.");
            return;
        }

        String query = "INSERT INTO Movies (title, revenue) values (?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getRevenue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Issue with adding movie: " + e.getMessage());
        }
    }

    public static void deleteMovie(int id) {
        Connection connection = DatabaseUtility.getConnection();

        if (connection == null) {
            System.err.println("Unable to perform query due to connection issue. See previous error message.");
            return;
        }

        String query = "DELETE FROM Movies WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Issue with deleting movie: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void updateMovie(Movie movie) {
        Connection connection = DatabaseUtility.getConnection();

        if (connection == null) {
            System.err.println("Unable to perform query due to connection issue. See previous error message.");
            return;
        }

        String query = "UPDATE Movies SET title=?, revenue=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getRevenue());
            preparedStatement.setInt(3, movie.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Issue with updating movie: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ResultSet getAllMovies() {
        Connection connection = DatabaseUtility.getConnection();

        if (connection == null) {
            System.err.println("Unable to perform query due to connection issue. See previous error message.");
            return null;
        }

        String query = "SELECT id, title, revenue FROM Movies";
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            System.out.println("Movies ResultSet: " + resultSet); // Debug print statement
        } catch (SQLException e) {
            System.err.println("Issue with getting all movies: " + e.getMessage());
        }

        return resultSet;
    }

    public static String getHTMLTable(ResultSet resultSet) {
        StringBuilder table = new StringBuilder();
        table.append("<table>\n");

        try {
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("revenue")
                );

                table.append("<tr>");
                table.append("\t<td>");
                table.append("<h4>").append(movie.getTitle()).append("</h4>");
                table.append("</td>");

                table.append("\t<td>");
                table.append("<h4>").append("Revenue: $").append(movie.getRevenue()).append("</h4>");
                table.append("</td>");

                table.append("\t<td>");
                table.append("<form action=\"filter-movies-by-revenue\" method=\"post\">");
                table.append("<input type=\"hidden\" name=\"revenue\" value=\"").append(movie.getRevenue()).append("\">");
                table.append("<input type=\"submit\" value=\"Filter\">");
                table.append("</form>");
                table.append("</td>");

                table.append("\t<td>");
                table.append("<form action=\"update-movie-form\" method=\"post\">");
                table.append("<input type=\"hidden\" name=\"id\" value=\"").append(movie.getId()).append("\">");
                table.append("<input type=\"submit\" value=\"Update\">");
                table.append("</form>");
                table.append("</td>");

                table.append("\t<td>");
                table.append("<form action=\"delete-movie\" method=\"post\">");
                table.append("<input type=\"hidden\" name=\"id\" value=\"").append(movie.getId()).append("\">");
                table.append("<input type=\"submit\" value=\"Delete\">");
                table.append("</form>");
                table.append("</td>");

                table.append("</td>\n");
                table.append("</tr>\n");
            }

            table.append("</table>");
        } catch (SQLException e) {
            System.err.println("Issue with getting data from movies result set: " + e.getMessage());
        }

        return table.toString();
    }

    public static String getHTMLTableWithoutActions(ResultSet resultSet) {
    StringBuilder table = new StringBuilder();
    table.append("<table>\n");

    try {
        while (resultSet.next()) {
            Movie movie = new Movie(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getInt("revenue")
            );

            table.append("<tr>");
            table.append("\t<td>");
            table.append("<h4>").append(movie.getTitle()).append("</h4>");
            table.append("</td>");

            table.append("\t<td>");
            table.append("<h4>").append("Revenue: $").append(movie.getRevenue()).append("</h4>");
            table.append("</td>");

            table.append("</tr>\n");
        }

        table.append("</table>");
    } catch (SQLException e) {
        System.err.println("Issue with getting data from movies result set: " + e.getMessage());
    }

    return table.toString();
}

    public static Movie getMovie(int id) {
        Connection connection = DatabaseUtility.getConnection();

        if (connection == null) {
            System.err.println("Unable to perform query due to connection issue. See previous error message.");
            return null;
        }

        String query = "SELECT * FROM Movies WHERE id = ?";
        ResultSet resultSet;
        Movie movie = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("revenue")
                );
            }
        } catch (SQLException e) {
            System.err.println("Issue with getting all movies: " + e.getMessage());
            throw new RuntimeException("Issue in getMovie()" + e.getMessage());
        }

        return movie;
    }

    public static ResultSet filterMoviesByRevenue(int revenue) {
        Connection connection = DatabaseUtility.getConnection();

        if (connection == null) {
            System.err.println("Unable to perform query due to connection issue. See previous error message.");
            return null;
        }

        String query = "SELECT id, title, revenue FROM Movies WHERE revenue=?";
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, revenue);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Issue with getting all movies: " + e.getMessage());
        }

        return resultSet;
    }

    public static String getDisplayTable(ResultSet resultSet) {
        StringBuilder table = new StringBuilder();
        table.append("<table>\n");

        try {
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("revenue")
                );

                table.append("<tr>");
                table.append("\t<td>");
                table.append("<h4>").append(movie.getTitle()).append("</h4>");
                table.append("</td>");

                table.append("\t<td>");
                table.append("<h4>").append("Revenue: $").append(movie.getRevenue()).append("</h4>");
                table.append("</td>");

                table.append("</tr>\n");
            }

            table.append("</table>");
        } catch (SQLException e) {
            System.err.println("Issue with getting data from movies result set: " + e.getMessage());
        }

        String tableString = table.toString();
        System.out.println("Table String: " + tableString); // Debug print statement
        return tableString;
    }
    public static String DisplayTableWithoutActions(ResultSet resultSet) {
        StringBuilder table = new StringBuilder();
        table.append("<table>\n");

        try {
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("revenue")
                );

                table.append("<tr>");
                table.append("\t<td>");
                table.append("<h4>").append(movie.getTitle()).append("</h4>");
                table.append("</td>");

                table.append("\t<td>");
                table.append("<h4>").append("Revenue: $").append(movie.getRevenue()).append("</h4>");
                table.append("</td>");

                table.append("</tr>\n");
            }

            table.append("</table>");
        } catch (SQLException e) {
            System.err.println("Issue with getting data from movies result set: " + e.getMessage());
        }

        String tableString = table.toString();
        System.out.println("Table String Without Actions: " + tableString); // Debug print statement
        return tableString;
    }

}
