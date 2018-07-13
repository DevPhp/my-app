package com.benefit.pilot.rba.Auth.Models;

import java.util.List;


public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);
    User Create(String s, String s1, int i);
    User findById(Long id);
        
    
}
