package edu.udea.vulnfinder.xmigenerator.generator.exception;

public class VulnSpideringException extends Exception {
	
	private int errorCode;
	private final static String errorMessages[] = {
			"Undefined error while spidering",
			"Domain was not defined, you have to select at least one element on the Vulnfinder Web Interface before spidering.",
			"Spidering was cancelled by user.",
			"Error while retrieving info from ZAP, are you sure that ZAP is running in the host and port defined in the configuration menu?"
			};
	
	public VulnSpideringException(Throwable cause, int errorCode){
		super(VulnSpideringException.getErrorMessageForCode(errorCode),cause);
		this.errorCode = errorCode;
	}
	
	public VulnSpideringException(int errorCode){
		super(VulnSpideringException.getErrorMessageForCode(errorCode));
		this.errorCode = errorCode;
	}
	
	public VulnSpideringException(){
		super(VulnSpideringException.getErrorMessageForCode(0));
	}
	
	public String getErrorMessage(){
		return VulnSpideringException.getErrorMessageForCode(errorCode);
	}
	
	private static String getErrorMessageForCode(int code){
		if(code < 0 || code >= errorMessages.length){
			return errorMessages[0];
		}
		return errorMessages[code];
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
