package com.homion.chef.dto;

import com.homion.chef.model.Chef;
import org.springframework.stereotype.Component;

@Component
public class ChefMapper {

    public ChefDTO toChefDto(Chef chef) {
        return ChefDTO.builder().firstName(chef.getFirstName())
                .lastName(chef.getLastName())
                .userName(chef.getUserName())
                .email(chef.getEmail())
                .build();
    }

    public Chef toChef(ChefCreationDTO chefCreationDTO) {
        return Chef.builder()
                .email(chefCreationDTO.getEmail())
                .firstName(chefCreationDTO.getFirstName())
                .lastName(chefCreationDTO.getLastName())
                .userName(chefCreationDTO.getUserName())
                .build();
    }
}
