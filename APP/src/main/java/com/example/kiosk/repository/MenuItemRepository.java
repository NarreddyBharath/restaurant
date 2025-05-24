package com.example.kiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kiosk.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{
	
}
