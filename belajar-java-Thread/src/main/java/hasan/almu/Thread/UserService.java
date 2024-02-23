package hasan.almu.Thread;

public class UserService {

    private final ThreadLocal<String> local = new ThreadLocal<>();
    private String user ;

    public void setUser(String user) {
//        local.set(user);
        this.user = user;
    }

    public void doAction() {
//        String user = local.get();
        System.out.println(user + " do action");
    }
}
