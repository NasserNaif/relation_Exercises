package com.example.day1relations.Repos;

import com.example.day1relations.DTO.ProfileDTO;
import com.example.day1relations.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {

    @Query("select p from Profile p where p.id=?1")
    Profile findProfileByCustomerID(Integer id);

    Profile findProfileById(Integer id);

    @Query("select p from Profile p where p.id=?1")
    ProfileDTO findProfileByDTO(Integer id);

}
