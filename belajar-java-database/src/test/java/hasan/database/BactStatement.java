package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.PreparedStatement;

public class BactStatement {
    @Test
    void testbactStatement() throws SQLException     {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO comments(email, comment) " +
                "VALUES('tes.com', 'halo tes')";
        for(int i = 1; i < 100; i++) {
            statement.addBatch(sql); //dikumpulkan di memori java
        }
        statement.executeBatch(); //baru di kirim kan kedatabase
        statement.close();
        connection.close();
    }

    @Test
    void testBactPreparedStatement() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(int i = 0; i < 100; i++) {
        preparedStatement.clearParameters();
        preparedStatement.setString(1, "tesPrepared@.com");
        preparedStatement.setString(2, "halo prepared");
        preparedStatement.addBatch();

        }
        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }

    @Test
    void biasa() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                INSERT INTO comments(email, comment) VALUES('tes', 'halo tes')
                """;
        int resultSet = statement.executeUpdate(sql);
        System.out.println(resultSet);

        statement.close();
        connection.close();
    }
}
