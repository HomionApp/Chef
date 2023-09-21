package com.homion.chef.controller;

import com.homion.chef.dto.ChefCreationDTO;
import com.homion.chef.dto.ChefDTO;
import com.homion.chef.dto.Response;
import com.homion.chef.service.AuthService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public Response save(@RequestBody ChefCreationDTO chefCreationDTO) {
        return authService.save(chefCreationDTO);
    }

    @PostMapping("/login")
    public Response login(@RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO.getEmail(), loginDTO.getPassword());
    }

    @PostMapping("/verifyToken")
    public Response verifyToken() {
        return authService.verifyToken();
    }

}

@Data
class LoginDTO {
    String email;
    String password;
    String type;
}
