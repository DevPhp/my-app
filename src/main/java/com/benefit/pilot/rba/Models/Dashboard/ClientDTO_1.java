package com.benefit.pilot.rba.Models.Dashboard;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientDTO_1 {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private int id;
	 private String clientName;
	 private String clientManager;
	 private int clientID;
	 
	 public ClientDTO_1(int id, String clientName, String clientManager,  int clientID) {
		 
		 this.id=id;
		 this.clientName=clientName;
		 this.clientManager=clientManager;
		 this.clientID=clientID;
		
	 }
}
