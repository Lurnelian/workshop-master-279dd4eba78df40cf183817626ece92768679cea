package ru.relex.workshop.dto;

public class ExceptionDto {
	
	private String message;
	private String stacktrace;
	
	public ExceptionDto() {
		
	}
	
	public ExceptionDto(String message, String stacktrace) {
		this.message = message;
		this.stacktrace = stacktrace;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStacktrace() {
		return stacktrace;
	}
	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
	
	

}
