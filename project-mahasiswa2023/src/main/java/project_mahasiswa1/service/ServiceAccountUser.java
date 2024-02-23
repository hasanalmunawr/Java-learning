package project_mahasiswa1.service;

import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.entity.UserInformation;

public interface ServiceAccountUser {

    boolean login(String email, String password);
    void register(UserAccount userAccount);
    void addUser(UserInformation userInformation);
    void showUser(UserAccount userAccount);


}
