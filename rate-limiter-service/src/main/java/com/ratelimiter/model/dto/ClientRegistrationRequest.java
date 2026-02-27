package com.ratelimiter.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientRegistrationRequest {
	ClientRegistrationRequest(){}
	ClientRegistrationRequest(String clientId, Integer limitPerMinute){
		this.clientId=clientId;
		this.limitPerMinute=limitPerMinute;
	}

	@NotBlank(message="clientId is required")
	private String clientId;
	
	@NotNull(message="limitPerMinute is required")
	@Min(value=1,message = "limitPerMinute must be at least 1")
	private Integer limitPerMinute;
	

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Integer getLimitPerMinute() {
		return limitPerMinute;
	}

	public void setLimitPerMinute(Integer limitPerMinute) {
		this.limitPerMinute = limitPerMinute;
	}
	
}
