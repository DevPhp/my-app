package com.benefit.pilot.rba.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.benefit.pilot.rba.CommonConstants.APIConstant;
import com.benefit.pilot.rba.CommonConstants.APIResponse;
import com.benefit.pilot.rba.Models.UserMGT.UserManagement;
import com.benefit.pilot.rba.Models.UserMGT.UserManagementDTO;
import com.benefit.pilot.rba.Repositories.UserManagementRepo;

@RestController
@RequestMapping("/api/v1")
public class UserMGTController {
	
	private final UserManagementRepo userManagementRepo;
	
	@Autowired
	public UserMGTController(UserManagementRepo userManagementRepo)
	{
		
		this.userManagementRepo=userManagementRepo;
	}
	
	@GetMapping("/users")
	public APIResponse<List<UserManagement>> getUsers()
	{
		APIResponse<List<UserManagement>> response = new APIResponse<>();
		List<UserManagement> listOfUser=userManagementRepo.findAllDTO();
		response.setStatus(APIConstant.SUCCESS.intValue());
		response.setMessage("success");
		response.setResponse(listOfUser);
		return response;
	}
	
	@PostMapping("/add-user")
	public APIResponse<UserManagement> addUser(@RequestBody UserManagement userManagement)
	{
		APIResponse<UserManagement> response=new APIResponse<>();
		UserManagement user=userManagementRepo.save(userManagement);
		if(user!=null) {
		response.setStatus(APIConstant.SUCCESS.intValue());
		response.setMessage("success");
		response.setResponse(user);
		}
		return response;
	}
	
	@GetMapping("/get-user/{id}")
	public APIResponse<UserManagementDTO> getUserById(@PathVariable("id") int id)
	{
		APIResponse<UserManagementDTO> response=new APIResponse<>();
		UserManagementDTO user=userManagementRepo.findUserById(id);
		if(user!=null) {
		response.setStatus(APIConstant.SUCCESS.intValue());
		response.setMessage("success");
		response.setResponse(user);
		}
		
		return response;
	}
}
