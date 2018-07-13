package com.benefit.pilot.rba.Auth.Controllers;


import com.benefit.pilot.rba.Auth.Models.AuthToken;
import com.benefit.pilot.rba.Auth.Models.LoginUser;
import com.benefit.pilot.rba.Auth.Models.User;
import com.benefit.pilot.rba.Auth.Models.UserRepo;
import com.benefit.pilot.rba.Config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.benefit.pilot.rba.Auth.Models.Constants.HEADER_STRING;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserRepo userRepo;
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserRepo userRepo) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;

    }

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser, HttpServletResponse response, HttpServletRequest request) {
        final Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            // bad username/password...
            return ResponseEntity.status(401).body(null);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userRepo.findFirstByUsername(loginUser.getUsername());

        //Update user's last login datetime
        user.setLast_login(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        userRepo.save(user);


        final String token = jwtTokenUtil.generateToken(user);
        Cookie authCookie = new Cookie( HEADER_STRING ,"Bearer+"+token);
        authCookie.setPath("/");
        authCookie.setHttpOnly(true);
        authCookie.setMaxAge(24*60*60);
        authCookie.setDomain(request.getServerName());
        response.addCookie(authCookie);
        return ResponseEntity.ok(new AuthToken(token));
    }
}
