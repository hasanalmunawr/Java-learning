package project_mahasiswa1.viewApk;

import project_mahasiswa1.Util.InputUtil;
import project_mahasiswa1.entity.UserAccount;
import project_mahasiswa1.entity.UserInformation;
import project_mahasiswa1.repository.RepositoryAccountFull;
import project_mahasiswa1.repository.RepositoryUserAccount;
import project_mahasiswa1.repository.RepositoryUserInformation;
import project_mahasiswa1.service.ServiceAccountUser;
import project_mahasiswa1.service.ServiceAccountUserIMPL;

public class ViewDatabase {

    private RepositoryUserAccount repositoryUserAccount;
    private RepositoryUserInformation repositoryUserInformation;
    private RepositoryAccountFull repositoryAccountFull;
    private ServiceAccountUser serviceAccountUser = new ServiceAccountUserIMPL(repositoryUserAccount, repositoryUserInformation, repositoryAccountFull);

    public ViewDatabase(ServiceAccountUser serviceAccountUser) {
        this.serviceAccountUser = serviceAccountUser;
    }

    public void viewMenu() throws InterruptedException {
        System.out.println("Welcome to DataBase Student");
        System.out.println("1. Register ");
        System.out.println("2. Login ");
        int choice = InputUtil.inputInt("Please input your choice : ");
        switch (choice) {
            case 1 :
               registerMenu();
               break;
            case 2 :
                loginMenu();
                break;
        }
        System.out.println("final from system");
    }

    public void registerMenu() throws InterruptedException {
                System.out.println("Input your register email and password !");
                String email = InputUtil.inputStr("");
                while (email.isBlank()) {
                    String email2 = InputUtil.inputStr("Email : ");
                    String password = InputUtil.inputStr("Password : ");
                    UserAccount userAccountRegis = new UserAccount(email2, password);
                    serviceAccountUser.register(userAccountRegis);

                    Thread.sleep(2000);
                    inputDateRegis();
                    break;
                }
    }

    void inputDateRegis(){
        System.out.println("Input your information for register");
        String nim = InputUtil.inputStr("Nim : ");
        String nama = InputUtil.inputStr("Nama : ");
        String prodi = InputUtil.inputStr("Progam studi : ");
        UserInformation userAdd = new UserInformation(nim, nama, prodi);
        serviceAccountUser.addUser(userAdd);
    }
    public void loginMenu() {
        System.out.println("Login with your email and Password!");

        String email = InputUtil.inputStr("");
        while (email.isEmpty()) {
            email = InputUtil.inputStr("Email : ");
        }

        String password = InputUtil.inputStr("Password : ");
        boolean isSuccess = serviceAccountUser.login(email, password);
        UserAccount accountlg = new UserAccount(email, password);

        if (isSuccess) {
            serviceAccountUser.showUser(accountlg);
        } else {
            System.out.println("Account not found");
        }
    }

}
