package es.josocas;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by josesoler on 26.03.15.
 */
public class ConnectionHealthChecker {

    public static void checkConnectionHealth(Connection connection) {

        try {
            if (connection.isClosed() || connection.isReadOnly()) {
                throw new UnsupportedOperationException("Unhealthy connection !!");
            }
        } catch (SQLException e) {
            throw new UnsupportedOperationException("Wrong connection !!");
        } finally {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new UnsupportedOperationException("Wrong connection !!");
            }
        }
    }
}
