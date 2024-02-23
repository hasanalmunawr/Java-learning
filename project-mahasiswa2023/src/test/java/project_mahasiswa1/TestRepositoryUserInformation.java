package project_mahasiswa1;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.entity.UserInformation;
import project_mahasiswa1.repository.RepositoryUserInformation;
import project_mahasiswa1.repository.RepositoryUserInformationIMPL;

public class TestRepositoryUserInformation {

    private HikariDataSource dataSource;

    private RepositoryUserInformation repositoryUserInformation;

    @BeforeEach
    void setUp() {
        dataSource = ConnectionUtil.getDataSource();
        repositoryUserInformation = new RepositoryUserInformationIMPL(dataSource);
    }

    @Test
    void testAddUser() {
        UserInformation user1 = new UserInformation("M002", "almu", "Sistem informasi");
        repositoryUserInformation.addUser(user1);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
