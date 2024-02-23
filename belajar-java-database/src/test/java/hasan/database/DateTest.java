package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.PreparedStatement;

public class DateTest {

    @Test
    void testDatebyPrepared() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
                INSERT INTO times(sample_date, sample_time, sample_timeStamp) VALUES(?, ?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
        preparedStatement.setTime(2, new Time(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testdataQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
                SELECT * FROM times
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Date date = resultSet.getDate("sample_date");
            System.out.println(date);
            Time time = resultSet.getTime("sample_time");
            System.out.println(time);
            Timestamp timestamp = resultSet.getTimestamp("sample_timeStamp");
            System.out.println(timestamp);
            System.out.println("\n");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
