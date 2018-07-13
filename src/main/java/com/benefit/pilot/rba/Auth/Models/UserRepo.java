package com.benefit.pilot.rba.Auth.Models;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findFirstById(long id);
    User findFirstByUsername(String username);
    void deleteById(long id);
    
    


}
