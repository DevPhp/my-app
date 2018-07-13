package com.benefit.pilot.rba.Models.Dashboard;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientDTO {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private int id;
	 private String clientName;
	 private String accountNo;
	 private int employees;
	 private int members;
	 private String renewalDate;
	 private String agency;
	 private String clientManager;
	 private int clientID;
	 
	 public ClientDTO(int id, String clientName, String accountNo, int employees, int members,  String renewalDate, String agency, String clientManager, int clientID) {
		 
		 this.id=id;
		 this.clientName=clientName;
		 this.accountNo=accountNo;
		 this.employees=employees;
		 this.members=members;
		 this.renewalDate=renewalDate;
		 this.agency=agency;
		 this.clientManager=clientManager;
		 this.clientID=clientID;
		
	 }
}
