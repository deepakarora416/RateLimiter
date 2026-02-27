package com.ratelimiter.model;

public class Client {
	private final String clientId;
	private final int limitPerMinute;
	
	public Client(String clientId,int limitPerMinute) {
		// TODO Auto-generated constructor stub
		this.clientId=clientId;
		this.limitPerMinute=limitPerMinute;
	}
	
	public String getClientId() {
		return clientId;
	}
	public int getLimitPerMinute() {
		return limitPerMinute;
	}
	

}
