package com.southernbites.controller;

import com.southernbites.entity.MenuItem;
import com.southernbites.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/order")
    public String showOrderPage(@RequestParam(name = "item", required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("error", "Invalid or missing item selection. Please go back to menu.");
            return "order";
        }

        MenuItem item = menuService.getItemById(id);
        if (item == null) {
            model.addAttribute("error", "Invalid item. Please go back to menu.");
            return "order";
        }

        model.addAttribute("item", item);
        return "order";
    }

    @PostMapping("/order/confirm")
    public String confirmOrder(
            @RequestParam("itemId") Long itemId,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            Model model
    ) {
        MenuItem item = menuService.getItemById(itemId);
        if (item == null) {
            model.addAttribute("error", "Invalid item. Please go back to menu.");
            return "order";
        }

        // You can later save order details in DB here
        model.addAttribute("item", item);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("address", address);

        return "thankyou-order";
    }

    @GetMapping("/thankyou-order")
    public String thankYouPage() {
        return "thankyou-order";
    }
}
