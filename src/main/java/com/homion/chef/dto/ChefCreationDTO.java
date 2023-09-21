package com.homion.chef.dto;

import com.homion.chef.model.Address;
import com.homion.chef.model.Role;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ChefCreationDTO {

    @NotBlank(message = "Username should not be blank")
    private String userName;

    @NotBlank(message = "FirstName should not be blank")
    private String firstName;

    @NotBlank(message = "LastName should not be blank")
    private String lastName;

    @NotBlank(message = "Email should not be blank")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Password should not be blank")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;

    @NotBlank(message = "Mobile should not be blank")
    @Min(10) @Max(10)
    @Pattern(regexp = "^[0-9]{10}$")
    private String mobile;

    @NotBlank(message = "PAN number should not be blank")
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$")
    private String pan;

    private Role role = Role.CHEF;

    private List<AddressDTO> addressList;
}
