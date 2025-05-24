package com.example.kiosk.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kiosk.model.MenuItem;
import com.example.kiosk.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	public MenuItemRepository menuitemrepo;

	public List<MenuItem> getAllItems() {
		return menuitemrepo.findAll(); 
	}

	public Optional<MenuItem> getItemById(Long id) {
		return menuitemrepo.findById(id);
	}

	public MenuItem addItem(MenuItem item) {
		return menuitemrepo.save(item);
	}

	public MenuItem updateItem(Long id, MenuItem updateditem) {
		return menuitemrepo.findById(id).map(item -> {
			item.setName(updateditem.getName());
			item.setCategory(updateditem.getCategory());
			item.setPrice(updateditem.getPrice());
			item.setImageUrl(updateditem.getImageUrl());
			item.setDescription(updateditem.getDescription());
			return menuitemrepo.save(item);
		}).orElse(null);
	}

	public void deleteItem(Long id) {
		menuitemrepo.deleteById(id);
	}

}
