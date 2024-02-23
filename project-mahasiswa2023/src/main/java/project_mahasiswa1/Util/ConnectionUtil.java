package project_mahasiswa1.Util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {

    private static HikariDataSource dataSource;



    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/project_mahasiswa2023");
        config.setUsername("root");
        config.setPassword("B@d1r0@12");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

         dataSource = new HikariDataSource(config);

    }

    public static void setDataSource(HikariDataSource dataSource) {
        ConnectionUtil.dataSource = dataSource;
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}
