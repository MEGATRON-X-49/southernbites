package com.southernbites;

import com.southernbites.service.AdminService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SouthernbitesApplication {

    @Autowired
    private AdminService adminService;

    public static void main(String[] args) {
        SpringApplication.run(SouthernbitesApplication.class, args);
    }

    @PostConstruct
    public void init() {
        adminService.createAdmin("admin", "kingstonzoozoo");
    }
}
