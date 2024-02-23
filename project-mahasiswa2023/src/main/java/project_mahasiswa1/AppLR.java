package project_mahasiswa1;

import com.zaxxer.hikari.HikariDataSource;
import project_mahasiswa1.repository.*;
import project_mahasiswa1.service.ServiceAccountUser;
import project_mahasiswa1.service.ServiceAccountUserIMPL;
import project_mahasiswa1.viewApk.ViewDatabase;

/**
 * Hello world!
 *
 */
public class AppLR {
    public static void main(String[] args) throws InterruptedException {

        HikariDataSource hikariDataSource = new HikariDataSource();

        RepositoryUserAccount repositoryUserAccount = new RepositoryUserAccountIMPL(hikariDataSource);
        RepositoryUserInformation repositoryUserInformation = new RepositoryUserInformationIMPL(hikariDataSource);
        RepositoryAccountFull repositoryAccountFull = new RepositoryAccountFullIMPL(hikariDataSource);
        ServiceAccountUser serviceAccountUser = new ServiceAccountUserIMPL(repositoryUserAccount, repositoryUserInformation, repositoryAccountFull);
        ViewDatabase viewDatabase = new ViewDatabase(serviceAccountUser);

        viewDatabase.viewMenu();
    }

}
