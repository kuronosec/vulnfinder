package edu.udea.vulnfinder.xmigenerator.generator.exception;

public class VulnRequestParseException extends Exception {
	public VulnRequestParseException(String reason, Throwable cause){
		super(reason, cause);
	}
	
	public VulnRequestParseException(Throwable cause){
		super(cause);
	}
	
	public VulnRequestParseException(String message){
		super(message);
	}
	
}
