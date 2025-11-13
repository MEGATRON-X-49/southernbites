package com.southernbites;

import com.southernbites.entity.MenuItem;
import com.southernbites.repository.MenuItemRepository;
import com.southernbites.service.AdminService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SouthernbitesApplication {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public static void main(String[] args) {
        SpringApplication.run(SouthernbitesApplication.class, args);
    }

    @PostConstruct
    public void init() {
        // ✅ Ensure admin exists
        adminService.createAdmin("admin", "kingstonzoozoo");

        // ✅ Seed Menu Items only if none exist
        if (menuItemRepository.count() == 0) {
            menuItemRepository.save(new MenuItem("Chicken Fry", "Crispy golden fried chicken, South-style", 180.0, "chicken_fry.jpg"));
            menuItemRepository.save(new MenuItem("Chicken Curry", "Authentic spicy Andhra chicken curry", 220.0, "chicken_curry.jpg"));
            menuItemRepository.save(new MenuItem("Fish Curry", "Tangy fish curry cooked with tamarind and spices", 250.0, "fish_curry.jpg"));
            menuItemRepository.save(new MenuItem("Mutton Kebab", "Juicy kebabs grilled to perfection", 270.0, "mutton-kebab.jpg"));
            menuItemRepository.save(new MenuItem("Paneer Butter Masala", "Creamy tomato gravy with soft paneer cubes", 200.0, "paneer_butter.jpg"));
            menuItemRepository.save(new MenuItem("Veg Thali", "Traditional South Indian vegetarian thali", 150.0, "veg_thali.jpg"));
            System.out.println("✅ Default Menu Items Added Successfully!");
        } else {
            System.out.println("ℹ️ Menu Items Already Exist – Skipping Seeding");
        }
    }
}
