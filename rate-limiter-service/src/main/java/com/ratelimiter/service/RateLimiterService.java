package com.ratelimiter.service;

import org.springframework.stereotype.Service;

import com.ratelimiter.model.Client;
import com.ratelimiter.model.RateLimitResult;
import com.ratelimiter.repository.ClientRepository;
import com.ratelimiter.strategy.RateLimitStrategy;

@Service
public class RateLimiterService {
	private final ClientRepository clientRepository;
	private final RateLimitStrategy rateLimitStrategy;
	
	public RateLimiterService( ClientRepository clientRepository,RateLimitStrategy rateLimitStrategy) {
		// TODO Auto-generated constructor stub
		this.rateLimitStrategy=rateLimitStrategy;
		this.clientRepository=clientRepository;
	}
	
	public RateLimitResult checkRateLimit(String cleintId) {
		Client client = clientRepository.findById(cleintId).orElse(null);
		return rateLimitStrategy.tryAquire(cleintId, client.getLimitPerMinute());
	}

}
