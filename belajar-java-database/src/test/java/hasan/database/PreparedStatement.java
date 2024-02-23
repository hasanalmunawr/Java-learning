package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement {
//    untuk mengatasi SQL injection
    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String username = "hasanalmu";
        String password = "badiro12";

        String sql = """
                SELECT * FROM admin
                WHERE username = ? AND password = ?;
                """;

        java.sql.PreparedStatement preparedStatement =  connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
    //        cek username and password falid
        if(resultSet.next()) {
            System.out.println("sukses login akun " + resultSet.getString("username"));
        } else {
            System.out.println("gagal login");
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
