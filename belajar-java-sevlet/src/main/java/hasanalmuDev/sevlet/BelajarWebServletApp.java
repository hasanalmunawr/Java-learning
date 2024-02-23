package hasanalmuDev.sevlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BelajarWebServletApp {

    public static void main(String[] args) {
        SpringApplication.run(BelajarWebServletApp.class);
    }
}
