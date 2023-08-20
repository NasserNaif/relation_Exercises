package com.example.day1relations.Controllers;

import com.example.day1relations.APIs.ApiResponse;
import com.example.day1relations.DTO.ProfileDTO;
import com.example.day1relations.Models.Customer;
import com.example.day1relations.Services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("get")
    public ResponseEntity getAllCustomer() {
        return ResponseEntity.status(200).body(customerService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer newCustomer) {
        customerService.addCustomer(newCustomer);
        return ResponseEntity.status(201).body(new ApiResponse("customer added"));
    }


    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Customer newCustomer) {
        customerService.updateCustomer(id, newCustomer);
        return ResponseEntity.status(201).body(new ApiResponse("customer updated"));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(201).body(new ApiResponse("customer deleted"));
    }

    @GetMapping("profiles")
    public ResponseEntity getProfiles() {
        return ResponseEntity.status(200).body(customerService.getProfile());
    }

    @PostMapping("setprofile")
    public ResponseEntity setProfile(@RequestBody @Valid ProfileDTO profile) {
        customerService.setProfile(profile);
        return ResponseEntity.status(201).body(new ApiResponse("profile updated"));
    }

    @PutMapping("update/profile/{customerId}")
    public ResponseEntity updateProfile(@PathVariable Integer customerId, @RequestBody @Valid ProfileDTO profile) {
        customerService.updateProfile(customerId, profile);
        return ResponseEntity.status(201).body(new ApiResponse("profile updated"));
    }


    @DeleteMapping("profile/delete/{customerId}")
    public ResponseEntity deleteProfile(@PathVariable Integer customerId) {
        customerService.deleteProfile(customerId);
        return ResponseEntity.status(201).body(new ApiResponse("profile delete"));
    }
}
