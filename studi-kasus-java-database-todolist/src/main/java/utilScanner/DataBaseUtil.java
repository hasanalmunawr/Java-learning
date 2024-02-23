package utilScanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataBaseUtil {

    private static HikariDataSource datasource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_database_todolist");
        config.setUsername("root");
        config.setPassword("B@d1r0@12");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        datasource = new HikariDataSource(config);

    }
    public  static HikariDataSource getDataSource() {
        return datasource;
    }
}
