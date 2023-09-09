package com.homion.chef.repo;

import com.homion.chef.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ChefRepository extends JpaRepository<Chef, Long> {

    Optional<Chef> findByUserName(String userName);

    Optional<Chef> findByEmail(String email);

//    @Modifying
//    @Query("update Chef c set ")
//    Chef updateChefAddress()
}
