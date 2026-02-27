package com.ratelimiter.strategy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

import com.ratelimiter.model.RateLimitResult;

public class SlidingWindowStrategy implements RateLimitStrategy{
	private static final long WINDOW_SIZE_MS = 60_000L;
	private final ConcurrentHashMap<String, ConcurrentLinkedDeque<Long>> logs = new ConcurrentHashMap<String, ConcurrentLinkedDeque<Long>>();

	@Override
	public RateLimitResult tryAquire(String clientId, int limitPerMinute) {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis();
		ConcurrentLinkedDeque<Long> timestamps = logs.computeIfAbsent(clientId, k -> new ConcurrentLinkedDeque<Long>());
		
		//remove old timestamps
		while(!timestamps.isEmpty() && timestamps.peekFirst()<now-WINDOW_SIZE_MS) {
			timestamps.pollFirst();
		}
		if(timestamps.size() < limit) {
			timestamps.addLast(now);
			return RateLimitResult.allowed(limit-timestamps.size(), now+WINDOW_SIZE_MS);
		}
		return RateLimitResult.denied(now+WINDOW_SIZE_MS);
	}

	@Override
	public void clearClient(String clientId) {
		// TODO Auto-generated method stub
		logs.remove(clientId);
	}

}
