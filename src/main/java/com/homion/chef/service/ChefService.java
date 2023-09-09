package com.homion.chef.service;

import com.homion.chef.dto.ChefCreationDTO;
import com.homion.chef.dto.ChefDTO;
import com.homion.chef.dto.ChefMapper;
import com.homion.chef.exception.NoUserFoundException;
import com.homion.chef.model.Chef;
import com.homion.chef.repo.AddressRepository;
import com.homion.chef.repo.ChefRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ChefService {

    @Autowired
    ChefMapper chefMapper;
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private AddressRepository addressRepository;

    public ChefDTO save(ChefCreationDTO chefCreationDTO) {
        Chef chef = chefMapper.toChef(chefCreationDTO);
        chef.setPassword(chefCreationDTO.getPassword());
        return chefMapper.toChefDto(chefRepository.save(chef));
    }

    public ChefDTO update(ChefCreationDTO chefCreationDTO) {
        Optional<Chef> chefOptional = chefRepository.findByEmail(chefCreationDTO.getEmail());
        if (chefOptional.isPresent()) {
            Chef chef = chefOptional.get();
            chefOptional.get().setAddress(chefCreationDTO.getAddressList());
            chefRepository.save(chef);
            log.info(chefMapper.toChefDto(chef).toString());
            return chefMapper.toChefDto(chef);
        } else {
            throw new NoUserFoundException("No such user found");
        }
    }

    public Chef findByEmail(String email) {
        return chefRepository.findByEmail(email).orElseThrow(NoUserFoundException::new);
    }

    public List<ChefDTO> getAllChefs() {
        List<Chef> chefList = chefRepository.findAll();
        return chefList.stream().map(chef -> new ChefMapper().toChefDto(chef)).collect(Collectors.toList());
    }
}

