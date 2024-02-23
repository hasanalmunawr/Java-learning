package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.PreparedStatement;

public class AutoIncrementTest {
    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
                INSERT INTO comments(email, comment) VALUES(?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,"tes2");
        preparedStatement.setString(2,"halo tes2");
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

//        mencari index terakhir position
        if(resultSet.next()) {
            System.out.println("id comment = "+ resultSet.getInt(1));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
