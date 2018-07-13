package com.benefit.pilot.rba.Controllers;


import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static com.benefit.pilot.rba.Auth.Models.Constants.HEADER_STRING;

@CrossOrigin
@Controller
public class Home {
	
    @GetMapping("/")
    public String home(Authentication authentication) {
        if(authentication != null && authentication.isAuthenticated()) {
        	System.out.println("in Home if part");
            return "redirect:/app";
        } else {
        	System.out.println("in Home Else part");
            return "redirect:/login";
        }
    }
	
	
    @GetMapping("/app")
    public String app(Authentication authentication) {
        if(authentication != null && authentication.isAuthenticated()) {
            return "angularapp";
        } else  {
            return "redirect:/login";
        }
    }
    @GetMapping("/app/{next}")
    public String homeNext() {
        return "forward:/app";
    }
    @GetMapping("/app/{next}/{next2}")
    public String homeNextNext() {
        return "forward:/app";
    }
    @GetMapping("/app/{next}/{next2}/{next3}")
    public String homeNextNextNext() {
        return "forward:/app";
    }
    
    /*@GetMapping("/logout")
    public ModelAndView logout(Authentication authentication, HttpServletResponse response , ModelAndView modelview) throws IOException {
    	
    	System.out.println("Log Out.................................");
        authentication.setAuthenticated(false);
        Cookie unsetAuthCookie = new Cookie(HEADER_STRING, null);
        unsetAuthCookie.setPath("/");
        unsetAuthCookie.setHttpOnly(true);
        unsetAuthCookie.setMaxAge(0);
        response.addCookie(unsetAuthCookie);
      //  response.sendRedirect("/login");
        
        System.out.println("HEADER_STRING ...................."+HEADER_STRING);
        
        modelview.setViewName("/login");
        return modelview;

    }*/
    
    /*@GetMapping("/logout")
    public String getLogoutPage(HttpServletRequest request, HttpServletResponse response){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "redirect:/login";
    }*/
}
