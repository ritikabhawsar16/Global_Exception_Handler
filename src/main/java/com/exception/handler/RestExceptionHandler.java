package com.exception.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exception.controller.CustomException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	protected  ErrorResponse errorHandler(IllegalArgumentException ex ,WebRequest req)
	{
		ErrorResponse err=new ErrorResponse();
	    err.setMessage(ex.getMessage());
	    err.setErrorCode("IllegalArgumentException");
		err.setTime(new java.util.Date());
	    return err;
	}
	
	
	@ExceptionHandler(value = {IOException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected  ErrorResponse errorHandler(IOException ex ,WebRequest req)
	{
		ErrorResponse err=new ErrorResponse();
	    err.setMessage(ex.getMessage());
	    err.setErrorCode("IOException");
		err.setTime(new java.util.Date());
	    return err;
	}
	
	
	@ExceptionHandler(value = {CustomException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected  ErrorResponse errorHandler(CustomException ex ,WebRequest req)
	{
		ErrorResponse err=new ErrorResponse();
	    err.setMessage(ex.getMessage());
	    err.setErrorCode("CustomException");
		err.setTime(new java.util.Date());
	    return err;
	}
	
	
	@ExceptionHandler(value = {NullPointerException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected  ErrorResponse errorHandlerExc(NullPointerException ex ,WebRequest req)
	{
		ErrorResponse err=new ErrorResponse();
	    err.setMessage(ex.getMessage());
	    err.setErrorCode("NullPointerException");
		err.setTime(new java.util.Date());
	    return err;
	}
}
