package com.exception.handler;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse {

	private String message;
	private String errorCode;
	private String time;
	public void setTime(Date date) {
		
	}
}
