package ru.clinic.org.clinicorganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class ClinicOrganizerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClinicOrganizerApplication.class, args);

       String password = "privet";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encodedPassword = encoder.encode(password);

        System.out.println(encodedPassword);
    }
}
