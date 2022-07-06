package helpers;

import data.Environments;
import java.sql.*;

public class DataBaseConnection {

    private final String url = System.getenv(Environments.DB_URI.getName());
    private Connection connection;

    public void openConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet sendSQLScript(String sqlExpression){
        Statement st;
        try {
            st = connection.createStatement();
            return st.executeQuery(sqlExpression);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
