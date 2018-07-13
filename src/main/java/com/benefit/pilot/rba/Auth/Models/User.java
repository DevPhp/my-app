package com.benefit.pilot.rba.Auth.Models;


import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_user",schema="DB_RBA")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String role;
    private String last_login;
    private String last_reset;
    private boolean active;

   



    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

   
    
}
