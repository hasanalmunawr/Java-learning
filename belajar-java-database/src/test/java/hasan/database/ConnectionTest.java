package hasan.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    static {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "B@d1r0@12";
        try {
            Connection connectionMysql = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("succes connected");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "B@d1r0@12";
        try {
            Connection connectionMysql = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("succes connected");
            connectionMysql.close();
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
    @Test
    void testConnectionClose2() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "B@d1r0@12";
        try (Connection connectionMysql = DriverManager.getConnection(jdbcUrl, username, password);){
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

}
