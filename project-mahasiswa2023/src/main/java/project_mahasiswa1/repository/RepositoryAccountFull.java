package project_mahasiswa1.repository;

import com.zaxxer.hikari.HikariDataSource;
import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.entity.UserInformation;

import java.util.List;

public interface RepositoryAccountFull {

    List<UserInformation> getAll();

    UserInformation getUser(UserAccount userAccount);



}
