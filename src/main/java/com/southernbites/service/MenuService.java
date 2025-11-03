package com.southernbites.service;

import com.southernbites.entity.MenuItem;
import com.southernbites.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository repo;

    public MenuItem getItemById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<MenuItem> getAllItems() {
        return repo.findAll();
    }

    public void save(MenuItem item) {
        repo.save(item);
    }
}
