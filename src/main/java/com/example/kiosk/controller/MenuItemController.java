package com.example.kiosk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kiosk.model.MenuItem;
import com.example.kiosk.service.MenuItemService;

@RestController
@RequestMapping("/admin/menu")
@CrossOrigin(origins = "*")
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuitemservice;
	
	@GetMapping
	public List<MenuItem> getAllItems()
	{
		return menuitemservice.getAllItems();
	}
	
	@GetMapping("/{id}")
    public MenuItem getItemById(@PathVariable Long id) 
	{
        return menuitemservice.getItemById(id).orElse(null);
    }
	
	@PostMapping
	public MenuItem addItem(@RequestBody MenuItem item) 
	{
		return menuitemservice.addItem(item);
	}
	
	@PutMapping("/{id}")
	public MenuItem updateItem(@PathVariable Long id, @RequestBody MenuItem item)
	{
		return menuitemservice.updateItem(id,item);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id)
	{
		menuitemservice.deleteItem(id);
	}
}
