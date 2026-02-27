package com.ratelimiter.model.dto;

public class ClientRegistrationResponse {
	private String clientId;
	private int limitPerMinute;
	private String message;
	
	public ClientRegistrationResponse(String clientId,int limitPerMinute,String message) {
		// TODO Auto-generated constructor stub
		this.clientId=clientId;
		this.limitPerMinute=limitPerMinute;
		this.message=message;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getLimitPerMinute() {
		return limitPerMinute;
	}

	public void setLimitPerMinute(int limitPerMinute) {
		this.limitPerMinute = limitPerMinute;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
