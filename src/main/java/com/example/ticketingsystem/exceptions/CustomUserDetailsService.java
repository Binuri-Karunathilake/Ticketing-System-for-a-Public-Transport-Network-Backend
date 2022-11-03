package com.example.ticketingsystem.exceptions;



import com.example.ticketingsystem.model.CustomUserDetails;
import com.example.ticketingsystem.model.User;
import com.example.ticketingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    public CustomUserDetailsService() {
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return new CustomUserDetails(user);
        }
    }
}