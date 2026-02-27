package com.ratelimiter.model;

public class RateLimitResult {
	private final boolean allowed;
	private final int remainingRequests;
	private final long windowResetTimeMs;
	
	public RateLimitResult(boolean allowed,int remainingRequests,long windowResetTimeMs) {
		// TODO Auto-generated constructor stub
		this.allowed=allowed;
		this.remainingRequests=remainingRequests;
		this.windowResetTimeMs=windowResetTimeMs;
	}

	public boolean isAllowed() {
		return allowed;
	}

	public int getRemainingRequests() {
		return remainingRequests;
	}

	public long getWindowResetTimeMs() {
		return windowResetTimeMs;
	}
	public static RateLimitResult allowed(int remaning, long resetTimeMs) {
		return new RateLimitResult(true, remaning, resetTimeMs);
	}
	
	public static RateLimitResult denied(long resetTimeMs) {
		return new RateLimitResult(false, 0, resetTimeMs);
	}

}
