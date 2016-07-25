package edu.udea.vulnfinder.xmigenerator.generator.gsonClasses;

import java.util.Arrays;

public class VulnJsonRequestElement {
	private String actionForm;
	private String inputName;
	private String[] attacks;
	
	public VulnJsonRequestElement(String actionForm, String inputName, String[] attacks) {
		super();
		this.actionForm = actionForm;
		this.inputName = inputName;
		this.attacks = attacks;
	}
	public String getActionForm() {
		return actionForm;
	}
	public void setActionForm(String actionForm) {
		this.actionForm = actionForm;
	}
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	public String[] getAttacks() {
		return attacks;
	}
	public void setAttacks(String[] attacks) {
		this.attacks = attacks;
	}
	@Override
	public String toString() {
		return "VulnJsonRequestElement [actionForm=" + actionForm + ", inputName=" + inputName + ", attacks="
				+ Arrays.toString(attacks) + "]";
	}
	
	
	
}
