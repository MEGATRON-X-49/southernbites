package com.southernbites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.southernbites.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
