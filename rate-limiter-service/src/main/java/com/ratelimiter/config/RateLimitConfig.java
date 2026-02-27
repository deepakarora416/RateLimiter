package com.ratelimiter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ratelimiter.strategy.RateLimitStrategy;
import com.ratelimiter.strategy.SlidingWindowStrategy;

@Configuration
public class RateLimitConfig{

	@Bean
	public RateLimitStrategy rateLimitStrategy(@Value("$ratelimit.strategy") String strategy) {
		
		// we can add switch case for choosing the rate limit strategy
		return new SlidingWindowStrategy();
	}
}
