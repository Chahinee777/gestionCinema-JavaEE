package src.utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncinema", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
