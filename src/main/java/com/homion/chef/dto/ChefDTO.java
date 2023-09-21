package com.homion.chef.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChefDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String pan;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AddressDTO> addressDTOList;
}
