package com.zaf3r.tacocloud.service;

import com.zaf3r.tacocloud.model.User;
import com.zaf3r.tacocloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserRepositoryUserDetailsService implements UserDetailsService {

    UserRepository userRepo;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepo.findByUsername(username);
        if(user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
    }
}
