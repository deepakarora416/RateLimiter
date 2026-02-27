package com.ratelimiter.strategy;

import com.ratelimiter.model.RateLimitResult;

public interface RateLimitStrategy {
	RateLimitResult tryAquire(String clientId, int limitPerMinute);
	void clearClient(String clientId);

}
