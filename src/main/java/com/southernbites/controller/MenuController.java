package com.southernbites.controller;

import com.southernbites.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("menuItems", menuService.getAllItems());
        return "menu";
    }
}
