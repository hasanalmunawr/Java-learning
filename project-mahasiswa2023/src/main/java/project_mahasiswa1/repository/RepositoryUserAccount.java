package project_mahasiswa1.repository;

import project_mahasiswa1.entity.UserAccount;

public interface RepositoryUserAccount {

    boolean login(UserAccount userAccountLogin);
    void register(UserAccount userAccountRegis);
}
