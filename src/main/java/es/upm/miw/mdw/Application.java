package es.upm.miw.mdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class, SecurityAutoConfiguration.class}) // Not: /error
public class Application {

    // mvn clean spring-boot:run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
