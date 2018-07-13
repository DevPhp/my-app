package com.benefit.pilot.rba.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.benefit.pilot.rba.CommonConstants.APIConstant;
import com.benefit.pilot.rba.CommonConstants.APIResponse;
import com.benefit.pilot.rba.Models.Dashboard.Client;
import com.benefit.pilot.rba.Models.Dashboard.ClientDTO_1;
import com.benefit.pilot.rba.Repositories.ClientRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1")
public class ClientController {
	
	private final ClientRepository clientRepository;
	
	@Autowired
	public ClientController(ClientRepository clientRepository)
	{
		this.clientRepository=clientRepository;
		
	}
	
	@GetMapping("/clients")
	public APIResponse<List<Client>> getClients(Authentication auth)
	{
		Integer clientID=(Integer) auth.getPrincipal();
		System.out.println("clientID==="+clientID);
		APIResponse<List<Client>> response=new APIResponse<>();
		List<Client> client=clientRepository.findAllDTO();
		response.setStatus(APIConstant.SUCCESS.intValue());
		response.setMessage("success");
		response.setResponse(client);
		return response;
	}
	
	@PostMapping("/add-client")
	public APIResponse<Client> addClients(@RequestBody Client client, Authentication auth)
	{
		Integer clientID=(Integer) auth.getPrincipal();
		APIResponse<Client> response=new APIResponse<>();
		Client clientValue=clientRepository.save(client);
		if(clientValue!=null) {
		response.setStatus(APIConstant.SUCCESS.intValue());
		response.setMessage("success");
		response.setResponse(clientValue);
		}
		return response;
	}
	
/*	@GetMapping("/get-clients/{clientName}")
	public APIResponse<List<Client>> getClientByName(@PathVariable("clientName") String clientName){
		
		APIResponse<List<Client>> response=new APIResponse<>();
		List<Client> listOfClient=clientRepository.findByClientName(clientName);
		
		if(listOfClient!=null) {
			response.setStatus(APIConstant.SUCCESS.intValue());
			response.setMessage("success");
			response.setResponse(listOfClient);
		}
		return response;
	}*/
	
	@GetMapping("/get-client/{id}")
	public APIResponse<ClientDTO_1> getClientById(@PathVariable("id") int id){
		
		APIResponse<ClientDTO_1> response=new APIResponse<>();
		ClientDTO_1 client=clientRepository.findByClientId(id);
		
		if(client!=null) {
			response.setStatus(APIConstant.SUCCESS.intValue());
			response.setMessage("success");
			response.setResponse(client);
		}
		return response;
	}
}
