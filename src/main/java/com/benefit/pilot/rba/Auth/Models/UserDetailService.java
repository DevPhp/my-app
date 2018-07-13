package com.benefit.pilot.rba.Auth.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service()
@Primary
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findFirstByUsername(s);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));

    }
    private List<SimpleGrantedAuthority> getAuthority(User user) {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
	}
}
