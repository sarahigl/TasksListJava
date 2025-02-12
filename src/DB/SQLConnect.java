package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class SQLConnect {
    static final String DB_URL =
            "jdbc:mysql://localhost/taskJava?serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    //Connexion à la BDD
    private static Connection connexion;
    static {
        try {
            connexion = DriverManager.getConnection(DB_URL, USERNAME,
                    PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnexion() {
        return connexion;
    }
}
