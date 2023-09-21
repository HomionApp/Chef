package com.homion.chef.repo;

import com.homion.chef.model.Address;
import com.homion.chef.model.Chef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Long> {

    @Query("select chef from Address where id = :addressId")
    Optional<Chef> getChef(@Param("addressId") Long addressId);
}
