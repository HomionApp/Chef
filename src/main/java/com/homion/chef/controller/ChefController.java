package com.homion.chef.controller;

import com.homion.chef.dto.ChefCreationDTO;
import com.homion.chef.dto.ChefDTO;
import com.homion.chef.model.Address;
import com.homion.chef.model.Chef;
import com.homion.chef.repo.ChefRepository;
import com.homion.chef.service.ChefService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/chef")
public class ChefController {

    @Autowired
    private ChefService chefService;

    @Autowired
    private ChefRepository chefRepository;

    @PostMapping("/address")
    public Address saveAddress(@RequestBody Address address) {
        return chefService.saveAddress(address);
    }

    @GetMapping("/address/{id}")
    public Chef getChefFromAddress(@PathVariable long id) {
        return chefService.getChefFromAddress(id);
    }

    @PutMapping("/")
    public ChefDTO update(@RequestBody ChefCreationDTO chefCreationDTO) {
        log.info(chefCreationDTO.toString());
        return null;
    }

    @GetMapping("/")
    public List<ChefDTO> getAllChefs() {
        return chefService.getAllChefs();
    }
}
