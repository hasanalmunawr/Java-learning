package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.constraint.CheckPassword;
import hasanalmudev.belajarjavavalidation1.constraint.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

@CheckPassword(message = "password and retypePassword must be same")
public class Register {

    @NotBlank(message = "username can not blank")
    private String username;
    @NotBlank(message = "password can not blank")
    private String password;
    @NotBlank(message = "password can not blank")
    private String retypePassword;

    public Register() {
    }

    @CheckPasswordParameter(
            passwordParam = 1,
            retypePasswordParam = 2

    )
    public Register(@NotBlank(message = "Can not blank") String username,
                    @NotBlank(message = "Can not blank") String password,
                    @NotBlank(message = "Can not blank") String retypePassword) {
        this.username = username;
        this.password = password;
        this.retypePassword = retypePassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                '}';
    }
}
