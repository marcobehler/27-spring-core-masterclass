package com.marcobehler.trading;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Thanks for watching this episode! If you want to, drop me a line to info@marcobehler.com.
 */
public class TradingApplication {

    public static class User {
        private final String name;
        private final String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class UserService {

        public void register(User user) {
            new MailService("localhost", 463, "magic@smtp.com").sendWelcomeEmail(user);
            new UserDao(dataSource()).save(user);
            // 1. save the user to a database.persistent storage..
            // 2. send the user a welcome email
            // 3..risk /balance check....
        }

        private DataSource dataSource() {
            return new DataSource() {
                @Override
                public Connection getConnection() throws SQLException {
                    return null;
                }

                @Override
                public Connection getConnection(String username, String password) throws SQLException {
                    return null;
                }

                @Override
                public <T> T unwrap(Class<T> iface) throws SQLException {
                    return null;
                }

                @Override
                public boolean isWrapperFor(Class<?> iface) throws SQLException {
                    return false;
                }

                @Override
                public PrintWriter getLogWriter() throws SQLException {
                    return null;
                }

                @Override
                public void setLogWriter(PrintWriter out) throws SQLException {

                }

                @Override
                public void setLoginTimeout(int seconds) throws SQLException {

                }

                @Override
                public int getLoginTimeout() throws SQLException {
                    return 0;
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            };
        }
    }

    public static class MailService {
        private final String hostname;
        private final Integer port;
        private final String username;

        public MailService(String hostname, Integer port, String username) {
            this.hostname = hostname;
            this.port = port;
            this.username = username;
        }

        public void sendWelcomeEmail(User user) {
            // TODO send the real email
            System.out.println("Sending out welcome email via " + hostname + " " + port + " to : user.getEmail() = " + user.getEmail());;
        }
    }

    public static class UserDao {

        private final DataSource dataSource;

        public UserDao(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        public void save(User user) {
            System.out.println("saving user to the database via datasource " + dataSource + " : user.getEmail() = " + user.getEmail());
            // TODO saving to the db here....
        }
    }

    public static void main(String[] args) {
        User user = new User("Hans", "hans@forest.de");
        System.out.println("user.getEmail() = " + user.getEmail());

        new UserService().register(user);
    }
}
