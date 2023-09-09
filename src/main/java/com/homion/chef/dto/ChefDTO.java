package com.homion.chef.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ChefDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressDTO> addressDTOList;
}
