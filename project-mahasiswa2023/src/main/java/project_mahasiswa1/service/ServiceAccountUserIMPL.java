package project_mahasiswa1.service;

import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.entity.UserInformation;
import project_mahasiswa1.repository.RepositoryAccountFull;
import project_mahasiswa1.repository.RepositoryUserAccount;
import project_mahasiswa1.repository.RepositoryUserInformation;

public class ServiceAccountUserIMPL implements ServiceAccountUser {

    private RepositoryUserAccount repositoryUserAccount;
    private  RepositoryUserInformation repositoryUserInformation;

    private RepositoryAccountFull repositoryAccountFull;

    public ServiceAccountUserIMPL(RepositoryUserAccount userAccount, RepositoryUserInformation userInformation) {
        this.repositoryUserAccount = userAccount;
        this.repositoryUserInformation = userInformation;
    }

    public ServiceAccountUserIMPL(RepositoryUserAccount repositoryUserAccount, RepositoryUserInformation repositoryUserInformation, RepositoryAccountFull repositoryAccountFull) {
        this.repositoryUserAccount = repositoryUserAccount;
        this.repositoryUserInformation = repositoryUserInformation;
        this.repositoryAccountFull = repositoryAccountFull;
    }

    @Override
    public boolean login(String email, String password) {
        boolean isSucces = repositoryUserAccount.login(new UserAccount(email, password));
        return isSucces;
    }

    @Override
    public void register(UserAccount userAccount) {
        repositoryUserAccount.register(userAccount);
    }

    @Override
    public void addUser(UserInformation userInformation) {
        repositoryUserInformation.addUser(userInformation);
    }

    @Override
    public void showUser(UserAccount userAccount) {
        UserInformation userInformation = repositoryAccountFull.getUser(userAccount);
        System.out.println("Nama   = " + userInformation.getNama());
        System.out.println("Nim    = " + userInformation.getNim());
        System.out.println("Prodi  = " + userInformation.getProdi());
    }
}
