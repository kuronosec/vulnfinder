package edu.udea.vulnfinder.xmigenerator.generator.exception;

public class VulnServerException extends Exception{
	public VulnServerException(String reason, Throwable cause){
		super(reason, cause);
	}
	
	public VulnServerException(Throwable cause){
		super(cause);
	}
	
	public VulnServerException(String message){
		super(message);
	}
}
