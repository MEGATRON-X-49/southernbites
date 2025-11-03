package com.southernbites.service;

import com.southernbites.entity.Admin;
import com.southernbites.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createAdmin(String username, String password) {
        if (adminRepository.findByUsername(username).isEmpty()) {
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(passwordEncoder.encode(password));
            adminRepository.save(admin);
        }
    }

    public boolean validateAdmin(String username, String rawPassword) {
        return adminRepository.findByUsername(username)
                .map(admin -> passwordEncoder.matches(rawPassword, admin.getPassword()))
                .orElse(false);
    }
}
