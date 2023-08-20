package com.example.day1relations.Services;

import com.example.day1relations.APIs.ApiException;
import com.example.day1relations.DTO.ProfileDTO;
import com.example.day1relations.Models.Customer;
import com.example.day1relations.Models.Profile;
import com.example.day1relations.Repos.CustomerRepo;
import com.example.day1relations.Repos.ProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final ProfileServices profileServices;
    private final ProfileRepo profileRepo;

    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    public void addCustomer(Customer newCustomer) {
        customerRepo.save(newCustomer);
    }

    public void updateCustomer(Integer id, Customer newCustomer) {
        Customer customer = customerRepo.findCustomerById(id);

        if (customer != null) {
            customer.setUsername(newCustomer.getUsername());
            customerRepo.save(customer);
        } else
            throw new ApiException("wrong ID");
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepo.findCustomerById(id);

        if (customer != null) {
            profileRepo.deleteById(id);
            customerRepo.delete(customer);
        } else
            throw new ApiException("wrong ID");
    }

    public void setProfile(ProfileDTO profile) {
        profileServices.addProfile(profile);
    }

    public void updateProfile(Integer customerID, ProfileDTO profileDTO) {
        profileServices.updateProfile(customerID, profileDTO);
    }

    public void deleteProfile(Integer customerID) {
        Customer customer = customerRepo.findCustomerById(customerID);
        if (customer != null) {
            profileRepo.deleteById(customerID);
        } else
            throw new ApiException("wrong customer ID");

    }

    public List<Profile> getProfile() {
        return profileServices.getAllProfile();
    }
}
