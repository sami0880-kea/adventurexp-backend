package com.example.adventurexp_backend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.adventurexp_backend.service.EmployeeService;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/login")
    public String login(@RequestParam String email, String password, HttpSession session) {
        if (employeeService.verifyLogin(email, password)) {
            session.setAttribute("user", email);
            session.setAttribute("auth", true);
            return "redirect:/dash";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/dash")
    public String dashboard(HttpSession session) {
        Boolean isAuthenticated = (Boolean) session.getAttribute("auth");
        if (isAuthenticated != null && isAuthenticated) {
            return "dash";
        } else {
            return "redirect:/login";
        }
    }
}
