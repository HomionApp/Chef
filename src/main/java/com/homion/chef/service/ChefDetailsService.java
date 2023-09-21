package com.homion.chef.service;

import com.homion.chef.model.Chef;
import com.homion.chef.repo.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChefDetailsService implements UserDetailsService {

    @Autowired
    ChefRepository chefRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Chef> chefOptional = chefRepository.findByEmail(username);
        if (chefOptional.isPresent()) {
            return chefOptional.get();
        } else {
            throw new UsernameNotFoundException("No user found with given email");
        }
    }
}
