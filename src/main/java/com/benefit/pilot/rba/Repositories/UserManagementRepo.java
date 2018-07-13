package com.benefit.pilot.rba.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.benefit.pilot.rba.Models.UserMGT.UserManagement;
import com.benefit.pilot.rba.Models.UserMGT.UserManagementDTO;

public interface UserManagementRepo  extends CrudRepository<UserManagement,Integer>{

	@Query("select new com.benefit.pilot.rba.Models.UserMGT.UserManagementDTO(c.id,c.userName, c.permissionStatus, c.clientAssigned, c.agency, c.accountStatus) from UserManagement c")
	List<UserManagement> findAllDTO();
	
	@Query("select new com.benefit.pilot.rba.Models.UserMGT.UserManagementDTO(c.id,c.userName, c.permissionStatus, c.clientAssigned, c.agency, c.accountStatus) from UserManagement c where id=?1")
	UserManagementDTO findUserById(int id);
}
