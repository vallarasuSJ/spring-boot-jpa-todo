package com.codewithkv.springbootjpa.Controller;

import com.codewithkv.springbootjpa.Model.AppUser;
import com.codewithkv.springbootjpa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public AppUser loginUser(@RequestBody AppUser appUser){
        return userService.existingUser(appUser);
    }


    @RequestMapping("/register")
    public AppUser registerUser(@RequestBody AppUser appUser){

        return userService.registerUser(appUser);
    }



}
