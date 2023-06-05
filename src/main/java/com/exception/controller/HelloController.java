package com.exception.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/globalexceptionhandler")
	public String getMessage(@RequestParam("msg") String msg) throws CustomException, IOException
	{
		if(msg.equalsIgnoreCase("IllegalArgument"))
		{
			throw new IllegalArgumentException("Illegal Argument");
		}
		
		if(msg.equalsIgnoreCase("IOException"))
		{
			throw new IOException("IO Exception");
		}
		
		if(msg.equalsIgnoreCase("Custom"))
		{
			throw new CustomException("My Custom Error Message");
		}
		if(msg.equalsIgnoreCase("NullPointer"))
		{
			throw new NullPointerException("NullPointer Exception");
		}
		return "Hello "+msg;
		
	}
}
