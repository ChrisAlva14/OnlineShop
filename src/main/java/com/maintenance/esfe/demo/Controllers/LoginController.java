package com.maintenance.esfe.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login/login"; // Asegúrate de que tu archivo HTML se llame index.html y esté en
                        // src/main/resources/templates
    }
}
