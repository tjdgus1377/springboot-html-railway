package com.example.birthday;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";  // templates/login.html 반환
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";  // templates/welcome.html 반환
    }
}
