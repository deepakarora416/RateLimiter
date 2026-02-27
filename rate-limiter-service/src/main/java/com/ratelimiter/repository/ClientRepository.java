package com.ratelimiter.repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.ratelimiter.model.Client;

@Repository
public class ClientRepository {
	private final ConcurrentHashMap<String, Client> clients = new ConcurrentHashMap<String, Client>();
	
	public Client save(Client client) {
		clients.put(client.getClientId(), client);
		return client;
	}
	
	public Optional<Client> findById(String clientId){
		return Optional.ofNullable(clients.get(clientId));
	}
	
	public boolean deleteById(String clientId) {
		return clients.remove(clientId) != null;
	}

}
