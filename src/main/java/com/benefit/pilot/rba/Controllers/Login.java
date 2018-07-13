package com.benefit.pilot.rba.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Controller
public class Login {
	
	
    @GetMapping("/login")
    public String login(Authentication authentication) {
    	System.out.println("authentication  =="+authentication);
		System.out.println("in Login");
        if(authentication != null && authentication.isAuthenticated()) {
        	System.out.println("in Login if part");
            return "redirect:/";
        }
        return "login";
    }
}
