package com.ratelimiter.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ratelimiter.model.Client;
import com.ratelimiter.repository.ClientRepository;
import com.ratelimiter.strategy.RateLimitStrategy;

@Service
public class ClientService {

	private final ClientRepository clientRepository;
	private final RateLimitStrategy rateLimitStrategy;
	public ClientService(ClientRepository clientRepository, RateLimitStrategy rateLimitStrategy) {
		// TODO Auto-generated constructor stub
		this.clientRepository=clientRepository;
		this.rateLimitStrategy=rateLimitStrategy;
				
	}
	public Client registerClient(String clientId, int limitPerMinute) {
		Client client = new Client(clientId, limitPerMinute);
		return clientRepository.save(client);
	}
	
	public Optional<Client> getClient(String clientId){
		return clientRepository.findById(clientId);
	}
	
	public boolean deleteClient(String clientId) {
		boolean deleeted = clientRepository.deleteById(clientId);
		if(deleeted) rateLimitStrategy.clearClient(clientId);
		
		return deleeted;
	}
}
