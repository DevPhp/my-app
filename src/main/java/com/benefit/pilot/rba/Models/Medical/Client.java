package com.benefit.pilot.rba.Models.Medical;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
		
		 @Id
		 @GeneratedValue(strategy = GenerationType.AUTO)
		 private int id;
		 private String clientName;
		 private String accountNo;
		 private int employees;
		 private int members;
		 private String renewalDate;
		 private String agency;
		 private String clientManager;
		 private String primaryContact;
		 private int clientID;
}


