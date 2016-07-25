package edu.udea.vulnfinder.xmigenerator.generator.exception;

public class VulnXMIGenerateException extends Exception {
	public VulnXMIGenerateException(String reason, Throwable cause){
		super(reason, cause);
	}
	
	public VulnXMIGenerateException(Throwable cause){
		super(cause);
	}
	
	public VulnXMIGenerateException(String message){
		super(message);
	}
}
