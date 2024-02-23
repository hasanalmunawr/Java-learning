package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {

    @Test
    void testCommit() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false); // untuk mematikan auto comit di mysql
        String sql = """
                INSERT INTO comments(email, comment) VALUES(?, ?) 
                """;

        for(int i = 0; i < 50; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "hasan"+i+"gmail.com");
            preparedStatement.setString(2, "hello");
            preparedStatement.executeUpdate();
        }

        connection.commit();
        connection.close();
    }
}
