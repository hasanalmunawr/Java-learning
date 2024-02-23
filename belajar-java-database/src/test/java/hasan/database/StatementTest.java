package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    @Test
    void testStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();


        statement.close();
        connection.close();
    }

    @Test
    void testExuteUpdate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO customers(id, nama, email)
                VALUES('M003', 'almu2', 'gente@test.com')
                """;
        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();
        connection.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                select * from customers;
                """;
        ResultSet resultSet = statement.executeQuery(sql);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
