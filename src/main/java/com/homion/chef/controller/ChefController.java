package com.homion.chef.controller;

import com.homion.chef.dto.ChefCreationDTO;
import com.homion.chef.dto.ChefDTO;
import com.homion.chef.repo.ChefRepository;
import com.homion.chef.service.ChefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chef")
@Slf4j
public class ChefController {

    @Autowired
    private ChefService chefService;

    @Autowired
    private ChefRepository chefRepository;

    @PostMapping("/")
    public ChefDTO save(@RequestBody ChefCreationDTO chefCreationDTO) {
        return chefService.save(chefCreationDTO);
    }

    @PutMapping("/")
    public ChefDTO update(@RequestBody ChefCreationDTO chefCreationDTO) {
        return chefService.update(chefCreationDTO);
    }

    @GetMapping("/")
    public List<ChefDTO> getAllChefs() {
        return chefService.getAllChefs();
    }
}
