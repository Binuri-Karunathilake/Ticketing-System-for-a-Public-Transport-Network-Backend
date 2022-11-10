package com.example.ticketingsystem.controller;


import java.util.List;

import com.example.ticketingsystem.model.User;
import com.example.ticketingsystem.model.UserLogin;
import com.example.ticketingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @PostMapping("/login")
    public User showRegistrationForm(@RequestBody User user) {
        String username = user.getEmail();
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User refUser = userRepo.findByEmail(username);
        System.out.println(refUser.getPassword());
        System.out.println(passwordEncoder.encode(password));
        if(refUser == null) {
            throw new UsernameNotFoundException("A user with the given email doesn't exist");
        } else if(passwordEncoder.matches(password, refUser.getPassword())) {
            return refUser;
        } else {
            throw new UsernameNotFoundException("Incorrect Credentials");
        }
    }

    @PostMapping("/process_register")
    public User processRegister(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        User refUser = userRepo.findByEmail(user.getEmail());
        if(refUser != null) {
            throw new UsernameNotFoundException("A user with the given email already exists");
        }

        return userRepo.save(user);

    }

    @GetMapping("/users")
    public List<User> listUsers(Model model) {
        return userRepo.findAll();
    }
}

