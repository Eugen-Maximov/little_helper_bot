package helpers.db;

import helpers.LogHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static helpers.LogHelper.SESSION_ID;
import static java.util.logging.Level.SEVERE;

public class DataBaseConnectionHelper {

    static Logger LOGGER = LogHelper.LOGGER;
    //TODO getEnvValue(Environments.DB_URL);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static Connection connection;

    public List<NoteDbObject> processingQuery(String sqlQuery) {
        try {
            setConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            closeConnection();
            return parseSelectResult(resultSet);
        } catch (SQLException e) {
            LOGGER.log(SEVERE, "Fail processing sql query" + SESSION_ID, e);
            throw new RuntimeException(e);
        }
    }

    public void processingQueryWithoutResult(String sqlQuery) {
        try {
            setConnection();
            connection.createStatement().executeUpdate(sqlQuery);
            closeConnection();
        } catch (SQLException e) {
            LOGGER.log(SEVERE, "Fail processing sql query without response" + SESSION_ID, e);
            throw new RuntimeException(e);
        }
    }

    private void setConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            LOGGER.log(SEVERE, "Fail set DB connection" + SESSION_ID, e);
            throw new RuntimeException(e);
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.log(SEVERE, "Fail close DB connection" + SESSION_ID, e);
            throw new RuntimeException(e);
        }
    }

    private List<NoteDbObject> parseSelectResult(ResultSet resultSet) {
        List<NoteDbObject> objects = new ArrayList<>();
        try {
            while (resultSet.next()) {
                try {
                    NoteDbObject noteDbObject = new NoteDbObject(
                            resultSet.getLong("user_id"),
                            resultSet.getString("user_note")
                    );
                    objects.add(noteDbObject);
                } catch (SQLException e) {
                    LOGGER.log(SEVERE, "Fail read db values by columns names" + SESSION_ID, e);
                }
            }
            return objects;
        } catch (SQLException e) {
            LOGGER.log(SEVERE, "Fail read the result set from DB query" + SESSION_ID, e);
            throw new RuntimeException();
        }
    }
}
