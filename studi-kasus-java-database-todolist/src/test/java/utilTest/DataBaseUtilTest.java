package utilTest;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import utilScanner.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseUtilTest {

    @Test
    void testConnection() throws SQLException {
        HikariDataSource dataSource = DataBaseUtil.getDataSource();
        Connection connection = dataSource.getConnection();
        connection.close();
        dataSource.close();
    }
}
