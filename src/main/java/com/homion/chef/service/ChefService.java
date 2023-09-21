package com.homion.chef.service;

import com.homion.chef.dto.AddressDTO;
import com.homion.chef.dto.ChefCreationDTO;
import com.homion.chef.dto.ChefDTO;
import com.homion.chef.exception.NoUserFoundException;
import com.homion.chef.model.Address;
import com.homion.chef.model.Chef;
import com.homion.chef.repo.AddressRepository;
import com.homion.chef.repo.ChefRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ChefService {

    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        Chef chef = new Chef();
        chef.setId(1L);
        address.setChef(chef);
        return addressRepository.save(address);
    }

    public Chef getChefFromAddress(long id) {
        return addressRepository.getChef(id).get();
    }

    private void updateAddress(AddressDTO addressDTO, long id) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        address.setId(id);
        addressRepository.save(address);
    }

    public Chef findByEmail(String email) {
        return chefRepository.findByEmail(email).orElseThrow(NoUserFoundException::new);
    }

    public List<ChefDTO> getAllChefs() {
        List<Chef> chefList = chefRepository.findAll();
//        return chefList.stream().map(chef -> new ChefMapper().toChefDto(chef)).collect(Collectors.toList());
        return null;
    }
}

