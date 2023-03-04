package com.driver.controllers;

import com.driver.services.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestParam String username, @RequestParam String password) {
        try {
            Admin admin = adminService.registerAdmin(username, password);
            return ResponseEntity.ok(admin);
        } catch (InvalidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/addProvider")
    public ResponseEntity<ServiceProvider> addServiceProvider(@RequestParam String name) {
        try {
            ServiceProvider provider = adminService.addServiceProvider(name);
            return ResponseEntity.ok(provider);
        } catch (InvalidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@RequestParam Long providerId, @RequestParam String countryName) {
        try {
            Country country = adminService.addCountry(providerId, countryName);
            return ResponseEntity.ok(country);
        } catch (InvalidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
