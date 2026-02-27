package com.ratelimiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratelimiter.model.Client;
import com.ratelimiter.model.dto.ClientRegistrationRequest;
import com.ratelimiter.model.dto.ClientRegistrationResponse;
import com.ratelimiter.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@PostMapping
	public ResponseEntity<ClientRegistrationResponse> registerClient(
			@Valid @RequestBody ClientRegistrationRequest request){
		
		boolean exists = clientService.getClient(request.getClientId()).isPresent();
		Client client = clientService.registerClient(request.getClientId(), request.getLimitPerMinute());
		
		ClientRegistrationResponse response = new ClientRegistrationResponse(
				client.getClientId(), 
				client.getLimitPerMinute(),
				exists?"Client Updated":"Client registerd");
				
		return ResponseEntity.status(exists ? HttpStatus.OK:HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Client> getClient(@PathVariable String clientId){
		return clientService.getClient(clientId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> deleteClient(@PathVariable String clientId){
		return clientService.deleteClient(clientId)
				? ResponseEntity.noContent().build()
						: ResponseEntity.notFound().build();
	}
}
