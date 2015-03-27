package es.josocas;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EngineersInsert {

    /**
     * Populates the engineers table and closes the connection afterward.
     *
     * @param connection The connection to be used.
     */
    public static void populateEngineers(Connection connection) throws SQLException {
        ConnectionHealthChecker.checkConnectionHealth(connection);
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO engineers VALUES (null, 'Lucian', 'Enache', 'lucian.enache@zanox.com')");
        statement.execute("INSERT INTO engineers VALUES (null, 'Mike', 'Zuhlke', 'mike.zuhlke@zanox.com')");
        statement.execute("INSERT INTO engineers VALUES (null, 'Iryna', 'Sribna', 'iryna.sribna@zanox.com')");
        connection.close();
    }

    /**
     * Inserts the given engineer into engineers table. Connection is not closed.
     * @param connection
     * @param name
     * @param lastName
     * @param email
     * @throws SQLException
     */
    public static void insertEngineer(Connection connection, String name, String lastName, String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO engineers VALUES (null, ?, ?, ?)");
        statement.setString(1, name);
        statement.setString(2, lastName);
        statement.setString(3, email);
        statement.execute();
    }
}
