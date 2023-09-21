package com.homion.chef.service;

import com.homion.chef.dto.ChefCreationDTO;
import com.homion.chef.dto.ChefDTO;
import com.homion.chef.dto.Response;
import com.homion.chef.model.Chef;
import com.homion.chef.repo.ChefRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class AuthService {

    @Autowired
    ChefRepository chefRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    HttpServletRequest request;

    public Response save(ChefCreationDTO chefCreationDTO) {
        Chef chef = new Chef();
        BeanUtils.copyProperties(chefCreationDTO, chef);
        ChefDTO chefDTO = new ChefDTO();
        chef.setPassword(bCryptPasswordEncoder.encode(chef.getPassword()));
        BeanUtils.copyProperties(chefRepository.save(chef), chefDTO);
        return Response.builder().status(HttpStatus.CREATED).data(chefDTO).build();
    }

    public Response login(String email, String password) {
        Optional<Chef> optionalChef = chefRepository.findByEmail(email);
        if (optionalChef.isEmpty()) {
            return Response.builder().status(HttpStatus.OK).message("No such user exists").build();
        } else {
            //this will handle authenticate the user with email and password,
            // and throws exception with respective message
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            //if the above line does not throw any exception, means the email, password are valid
            Chef chef = optionalChef.get();
            if(email.equalsIgnoreCase(chef.getEmail()) && bCryptPasswordEncoder.matches(password, chef.getPassword())) {
                Map<String, Object> map = new HashMap<>();
                map.put("userName", chef.getUsername());
                map.put("role", chef.getRole());
                String token = jwtService.generateToken(map, chef);
                log.info("token = " + token);
                return Response.builder().status(HttpStatus.OK).data(token).build();
            } else {
                return Response.builder().status(HttpStatus.FORBIDDEN).message("Invalid username or password").build();
            }
        }
    }

    public Response verifyToken() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Chef chef = Chef.builder().email(auth.getName()).build();
        String token = request.getHeader("Authorization").substring(7);
        if(jwtService.isTokenValid(token, chef)) {
            String role = jwtService.getRoleFromToken(token);
            return Response.builder().status(HttpStatus.OK).data(role).build();
        }
        return Response.builder().status(HttpStatus.FORBIDDEN).message("Invalid jwt token").build();
    }
}
