package project_mahasiswa1;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.entity.UserInformation;
import project_mahasiswa1.repository.*;
import project_mahasiswa1.service.ServiceAccountUser;
import project_mahasiswa1.service.ServiceAccountUserIMPL;

public class TestService {

    private HikariDataSource dataSource;
    private RepositoryUserInformation repositoryUserInformation;
    private RepositoryUserAccount userAccount;
    private RepositoryAccountFull repositoryAccountFull;
    private ServiceAccountUser serviceAccountUser;

    @BeforeEach
    void setUp() {
        dataSource = ConnectionUtil.getDataSource();
        repositoryUserInformation = new RepositoryUserInformationIMPL(dataSource);
        userAccount = new RepositoryUserAccountIMPL(dataSource);
        repositoryAccountFull = new RepositoryAccountFullIMPL(dataSource);
        serviceAccountUser = new ServiceAccountUserIMPL(userAccount, repositoryUserInformation, repositoryAccountFull);
    }

    @Test
    void testLoginService() {
        boolean password = serviceAccountUser.login("hasan@contoh.com", "password");
        Assertions.assertTrue(password);
        System.out.println(password);
    }

    @Test
    void testRegisterService() {
        serviceAccountUser.register(new UserAccount("deva@contoh.com", "password"));
    }

    @Test
    void testAddUser() {
        serviceAccountUser.addUser(new UserInformation("M0023", "kayla", "hukum"));
    }

    @Test
    void testShowUser() { // maintance
        serviceAccountUser.showUser(new UserAccount("deva@contoh.com", "password"));
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
