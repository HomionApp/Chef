package com.homion.chef.dto;

import com.homion.chef.model.Address;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class ChefCreationDTO {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Address> addressList;
}
