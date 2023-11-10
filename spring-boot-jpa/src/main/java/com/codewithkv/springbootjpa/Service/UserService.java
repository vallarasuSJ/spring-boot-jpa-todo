package com.codewithkv.springbootjpa.Service;

import com.codewithkv.springbootjpa.Model.AppUser;
import com.codewithkv.springbootjpa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AppUser existingUser(AppUser appUser) {
        AppUser user=userRepository.findUser(appUser.getUsername(),appUser.getPassword());
        return  user;
    }

    public AppUser registerUser(AppUser appUser) {
         userRepository.save(appUser);
         return appUser;
    }
}
