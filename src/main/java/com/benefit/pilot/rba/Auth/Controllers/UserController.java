package com.benefit.pilot.rba.Auth.Controllers;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableGlobalMethodSecurity
public class UserController {

    //example of how to fetch user's id from Authentication principal
    @GetMapping("/my-id")
    public Integer me(Authentication authentication) {
        return (Integer) authentication.getPrincipal();
    }
    
    
    

    

}
