package project_mahasiswa1;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.repository.*;
import project_mahasiswa1.service.ServiceAccountUser;
import project_mahasiswa1.service.ServiceAccountUserIMPL;
import project_mahasiswa1.viewApk.ViewDatabase;

public class TestView {

    private HikariDataSource dataSource;
    private RepositoryUserInformation repositoryUserInformation;
    private RepositoryUserAccount userAccount;
    private RepositoryAccountFull repositoryAccountFull;
    private ServiceAccountUser serviceAccountUser;
    private ViewDatabase viewDatabase;

    @BeforeEach
    void setUp() {
        dataSource = ConnectionUtil.getDataSource();
        repositoryUserInformation = new RepositoryUserInformationIMPL(dataSource);
        userAccount = new RepositoryUserAccountIMPL(dataSource);
        repositoryAccountFull = new RepositoryAccountFullIMPL(dataSource);
        serviceAccountUser = new ServiceAccountUserIMPL(userAccount, repositoryUserInformation);
        viewDatabase = new ViewDatabase(serviceAccountUser);
    }

    @Test
    void testViewMenu() throws InterruptedException {
        viewDatabase.viewMenu();
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
