package project_mahasiswa1;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import project_mahasiswa1.Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    @Test
    void testConnection() throws SQLException {
        HikariDataSource dataSource = ConnectionUtil.getDataSource();
        Connection connection = dataSource.getConnection();

        connection.close();
        dataSource.close();
    }


}
