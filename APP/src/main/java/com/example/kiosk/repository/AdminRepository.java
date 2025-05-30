package com.example.kiosk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kiosk.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Optional<Admin> findByUsernameAndPassword(String username, String password);
}
