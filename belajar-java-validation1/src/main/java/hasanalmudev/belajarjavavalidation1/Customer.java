package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {

    @Email(message = "email must be valid")
    @NotBlank(message = "email can not blank")
    private String email;

    @NotBlank(message = "username can not blank")
    private String username;

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
