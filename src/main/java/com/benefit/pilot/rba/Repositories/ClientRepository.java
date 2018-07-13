package com.benefit.pilot.rba.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.benefit.pilot.rba.Models.Dashboard.Client;
import com.benefit.pilot.rba.Models.Dashboard.ClientDTO_1;


public interface ClientRepository extends CrudRepository<Client,Integer>{
	
	@Query("select new com.benefit.pilot.rba.Models.Dashboard.ClientDTO(c.id, c.clientName, c.accountNo, c.employees, c.members, c.renewalDate, c.agency, c.clientManager, c.clientID) from Client c")
	List<Client> findAllDTO();
	
	/*@Query("select new com.benefit.pilot.rba.Models.Dashboard.ClientDTO(c.id,c.clientName, c.accountNo, c.employees, c.members, c.renewalDate, c.agency, c.clientManager, c.primaryContact, c.clientID) from Client c where clientName=?1")
	List<Client> findByClientName(String clientName); */

	//@Query("select new com.benefit.pilot.rba.Models.Dashboard.ClientDTO(c.id,c.clientName, c.accountNo, c.employees, c.members, c.renewalDate, c.agency, c.clientManager, c.primaryContact, c.clientID) from Client c where id=?1")
	//List<Client> findByClientId(int id);
	
	@Query("select new com.benefit.pilot.rba.Models.Dashboard.ClientDTO_1(c.id, c.clientName, c.clientManager, c.clientID) from Client c where id=?1")
	ClientDTO_1 findByClientId(int id);
}
