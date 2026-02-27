package com.ratelimiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratelimiter.model.RateLimitResult;
import com.ratelimiter.model.dto.RateLimitResponse;
import com.ratelimiter.service.RateLimiterService;

@RestController
@RequestMapping("/allow")
public class RateLimiterController {
	
	@Autowired
	RateLimiterService rateLimiterService;
	
	@GetMapping("/{clientId}")
	public ResponseEntity<RateLimitResponse> checkRateLimit (@PathVariable String clientId){
		RateLimitResult result = rateLimiterService.checkRateLimit(clientId);
		
		return ResponseEntity.ok(new RateLimitResponse(result.isAllowed()));
	}
	
}
