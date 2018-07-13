package com.benefit.pilot.rba.Models.Medical;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_management")
public class UserManagement {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private int id;
	 private String userName;
	 private String permissionStatus;
	 private int clientAssigned;
	 private String agency;
	 private String accountStatus;
}
