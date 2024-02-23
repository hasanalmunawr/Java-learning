package project_mahasiswa1;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_mahasiswa1.Util.ConnectionUtil;
import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.entity.UserInformation;
import project_mahasiswa1.repository.RepositoryAccountFull;
import project_mahasiswa1.repository.RepositoryAccountFullIMPL;

import java.util.List;

public class TestGetAllUser {

    private HikariDataSource dataSource;
    private RepositoryAccountFull repositoryAccountFull;

    @BeforeEach
    void setUp() {
        dataSource = ConnectionUtil.getDataSource();
        repositoryAccountFull = new RepositoryAccountFullIMPL(dataSource);

    }

    @Test
    void getAllUser() {
        List<UserInformation> userInformationList = repositoryAccountFull.getAll();
        System.out.println(userInformationList.size());
    }

    @Test
    void testgetUser() {
        UserAccount account = new UserAccount("hasan@contoh.com", "password");
         UserInformation userInformation = repositoryAccountFull.getUser(account);
        System.out.println(userInformation.getNim());
        System.out.println(userInformation.getNama());
        System.out.println(userInformation.getProdi());
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
