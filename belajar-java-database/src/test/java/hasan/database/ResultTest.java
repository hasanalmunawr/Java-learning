package hasan.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultTest {

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                select * from customers;
                """;
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String id = resultSet.getString("customers.id");
            String nama = resultSet.getString("nama");
            String email = resultSet.getString("email");

            System.out.println(
                    String.join(", ",id, nama, email)
            );
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "hasanalmu'; #";
        String password = "diro12";

        String sql = "SELECT * FROM admin WHERE username = '" + username +
                "' AND passowrd = '" + password + "'";
        ResultSet resultSet = statement.executeQuery(sql);

//        cek username and password falid
        if(resultSet.next()) {
            System.out.println("sukses login " + resultSet.getString("admin.username"));
        } else {
            System.out.println(username + "tidak terdaftar");
        }


        resultSet.close();
        statement.close();
        connection.close();
    }
}
