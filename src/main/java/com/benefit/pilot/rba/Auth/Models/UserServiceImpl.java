package com.benefit.pilot.rba.Auth.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepo userRepo;

	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepo.findFirstByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private List<SimpleGrantedAuthority> getAuthority(User user) {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public User Create(String username, String password, int id) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(encoder().encode(password));
		newUser.setId(id);
		newUser.setActive(false);
		userRepo.save(newUser);
		return newUser;
	}
	@Override
	public void delete(long id) {
		userRepo.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userRepo.findFirstByUsername(username);
	}

	

	@Override
	public User findById(Long id) {
		return userRepo.findFirstById(id);
	}

	@Override
    public User save(User user) {
        return userRepo.save(user);
    }
	
	

}
