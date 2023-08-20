package com.example.day1relations.Services;

import com.example.day1relations.APIs.ApiException;
import com.example.day1relations.DTO.ProfileDTO;
import com.example.day1relations.Models.Customer;
import com.example.day1relations.Models.Profile;
import com.example.day1relations.Repos.CustomerRepo;
import com.example.day1relations.Repos.ProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServices {

    private final CustomerRepo customerRepo;

    private final ProfileRepo profileRepo;


    public List<Profile> getAllProfile() {
        return profileRepo.findAll();
    }

    public void addProfile(ProfileDTO profileDTO) {
        Customer customer = customerRepo.findCustomerById(profileDTO.getCustomer_id());

        if (customer != null) {
            Profile profile =
                    new Profile(null,
                            profileDTO.getFullName(),
                            profileDTO.getGender(),
                            profileDTO.getAge(),
                            profileDTO.getEmail(),
                            customer);
            profileRepo.save(profile);
        } else
            throw new ApiException("customer noy found");
    }

    public void updateProfile(Integer id, ProfileDTO profile) {
        Profile profile1 = profileRepo.findProfileById(id);

        if (profile1 != null) {
            profile1.setAge(profile.getAge());
            profile1.setFullName(profile.getFullName());
            profile1.setGender(profile.getGender());
            profile1.setEmail(profile.getEmail());
            profileRepo.save(profile1);
        } else
            throw new ApiException("customer noy found");
    }

    public void deleteProfile(Profile delProfile) {
        ProfileDTO pDTo = profileRepo.findProfileByDTO(delProfile.getId());

        System.out.println(pDTo.getCustomer_id());
    }
}
