package com.benefit.pilot.rba.Models.UserMGT;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
public class UserManagementDTO {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 private String userName;
	 private String permissionStatus;
	 private int clientAssigned;
	 private String agency;
	 private String accountStatus;
	 
public UserManagementDTO(int id, String userName, String permissionStatus, int clientAssigned, String agency,  String accountStatus) {
		 
		 this.id=id;
		 this.userName=userName;
		 this.permissionStatus=permissionStatus;
		 this.clientAssigned=clientAssigned;
		 this.agency=agency;
		 this.accountStatus=accountStatus;
	}
}
