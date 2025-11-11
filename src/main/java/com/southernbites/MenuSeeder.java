package com.southernbites;

import com.southernbites.entity.MenuItem;
import com.southernbites.repository.MenuItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuSeeder {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @PostConstruct
    public void seedMenu() {
        if (menuItemRepository.count() == 0) {
            MenuItem[] items = {
                createItem("Chicken Fry", "Crispy golden fried chicken served hot.", 180, "chicken_fry.jpg"),
                createItem("Chicken Curry", "Rich spicy chicken curry in authentic southern style.", 220, "chicken_curry.jpg"),
                createItem("Fish Curry", "Tangy and spicy fish curry cooked with tamarind.", 250, "fish_curry.jpg"),
                createItem("Mutton Kebab", "Tender mutton kebabs grilled with herbs.", 300, "mutton-kebab.jpg"),
                createItem("Paneer Butter Masala", "Creamy paneer curry with butter and rich gravy.", 200, "paneer_butter.jpg"),
                createItem("Veg Thali", "Traditional South Indian thali with multiple curries.", 180, "veg_thali.jpg")
            };
            for (MenuItem item : items) {
                menuItemRepository.save(item);
            }
            System.out.println("✅ Menu items seeded successfully!");
        } else {
            System.out.println("Menu already present, skipping seeder.");
        }
    }

    private MenuItem createItem(String name, String desc, double price, String image) {
        MenuItem item = new MenuItem();
        item.setName(name);
        item.setDescription(desc);
        item.setPrice(price);
        item.setImage(image);
        return item;
    }
}
