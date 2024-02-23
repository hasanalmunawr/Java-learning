package project_mahasiswa1;

import com.zaxxer.hikari.HikariDataSource;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.repository.RepositoryUserAccount;
import project_mahasiswa1.repository.RepositoryUserAccountIMPL;

public class TestRepositoryUserAccount {

    private HikariDataSource dataSource;
    private RepositoryUserAccount repositoryUserAccount;
    @BeforeEach
    void setUp() {
        dataSource = ConnectionUtil.getDataSource();
        repositoryUserAccount = new RepositoryUserAccountIMPL(dataSource);
    }

    @Test
    void testLogin() {
        UserAccount account1 = new UserAccount("hasan@contoh.com", "password");
        repositoryUserAccount.login(account1);
    }

    @Test
    void testRegister() {
        UserAccount account2 = new UserAccount("almu@cth.com", "almu321");
     }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

    @Test
    void tesTemporal() {
        Temporal temporal = LocalDateTime.now();
        System.out.println(temporal);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        Duration duration = Duration.between(LocalTime.now(), LocalTime.now().plusMinutes(231));
        System.out.println(duration);

        
    }
}
