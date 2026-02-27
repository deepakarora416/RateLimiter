package com.ratelimiter.model.dto;

public class RateLimitResponse {
	private boolean allowed;
	
	public RateLimitResponse(boolean allowed) {
		// TODO Auto-generated constructor stub
		this.allowed=allowed;
		
	}

	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}

}
