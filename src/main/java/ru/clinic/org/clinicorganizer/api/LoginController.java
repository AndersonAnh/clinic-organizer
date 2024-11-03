package ru.clinic.org.clinicorganizer.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/")
    public String defaultAfterLogin(){
        return "redirect:/users";
    }
}
