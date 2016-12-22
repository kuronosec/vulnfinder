/*
 * Copyright (C) 2015 raven
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.udea.vulnfinder.xmigenerator.generator.exporter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.Attack;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.AuthSetting;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.Input;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.TargetOfEvaluation;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.WebComponent;

/**
 *
 * @author raven
 */
public class Mem2XMIFormat {

	// private ArrayList<TargetOfEvaluation> dominios;
	private TargetOfEvaluation dominio;
	Map<String, Attack> ataques;
	//private String savePath;
	private String testId;
	private String testName;
	private AuthSetting aSetting;
	private boolean allAttacks;

	public Mem2XMIFormat(TargetOfEvaluation dominio, Map<String, Attack> ataques, AuthSetting aSetting, boolean allAttacks) {
		this.dominio = dominio;
		this.ataques = ataques;
		this.testId = "secTest01";
		this.testName = "Test01";
		this.allAttacks = allAttacks;
		this.aSetting = aSetting;
	}
	
	public Mem2XMIFormat(TargetOfEvaluation dominio, Map<String, Attack> ataques, String testId, String testName, AuthSetting aSetting, boolean allAttacks) {
		this.dominio = dominio;
		this.ataques = ataques;
		this.testId = testId;
		this.testName = testName;
		this.allAttacks = allAttacks;
		this.aSetting = aSetting;
	}

	public boolean genAndSaveXMIFile(String savePath) {
		String xmi = generateXMIFormat();
		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(savePath), "utf-8"))) {
			writer.write(xmi);
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String generateXMIFormat() {
		StringBuilder sb = new StringBuilder();
		List<int[]> enlaces;
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" 
				+ "<securityTest:Test xmi:version=\"2.0\" "
				+ "xmlns:xmi=\"http://www.omg.org/XMI\" "
				+ "xmlns:securityTest=\"http://udea/vulnfinder/securityTest\" id=\""+testId+"\" name=\""+testName+"\" severity=\"Medium\">\n");
		
		appendTOE(sb, dominio);
		appendPossibleAttacks(sb, ataques);
		appendAuthSettings(sb, aSetting);
		sb.append("</securityTest:Test>");
		return sb.toString();
	}
	
	private void appendAuthSettings(StringBuilder sb, AuthSetting as){
		sb.append("  <authSetting usernameParam=\"");
		sb.append(as.getUsernameParam());
		sb.append("\" passwordParam=\"");
		sb.append(as.getPasswordParam());
		sb.append("\" loginTargetURL=\"");
		sb.append(as.getLoginTargetUrl());
		sb.append("\" loginMessagePattern=\"");
		sb.append(as.getLoginMessagePattern());
		sb.append("\" logoutMessagePattern=\"");
		sb.append(as.getLogoutMessagePattern());
		sb.append("\">\n");
		appendRoles(sb, as.getRoles());
		sb.append("  </authSetting>");
	}
	
	private void appendRoles(StringBuilder sb, String[] roles){
		for(String s : roles){
			sb.append("<roles>").append(s).append("</roles>");
;		}
	}
	
	private void appendTOE(StringBuilder sb, TargetOfEvaluation d){
		sb.append("  <scope domain=\"" + d.getName() + "\">\n");
		appendWebComponents(sb, d.getWebComponents());
		sb.append("  </scope>\n");
	}
	
	private void appendWebComponents(StringBuilder sb, List<WebComponent> webcomponents){
		for (WebComponent p : webcomponents) {
			sb.append("    <components path=\"" + p.getPath() + "\"");
			appendLinks(sb, p.getLinks());
			if (!p.getInputs().isEmpty()) {
				sb.append(">\n");
				appendInputs(sb, p.getInputs());
				sb.append("    </components>\n");
			} else {
				sb.append("/>\n");
			}
		}
	}
	
	private void appendLinks(StringBuilder sb, List<int[]> enlaces){
		
		if (!enlaces.isEmpty()) {
			sb.append(" targetLinks=\"");
			for (int[] en : enlaces) {
				sb.append("//@scope");
				sb.append("/@components.");
				sb.append(en[0]);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append('\"');
		}
	}
	
	private void appendInputs(StringBuilder sb, List<Input> inputs){
		for (Input e : inputs) {
			sb.append("      <inputs name=\"" + e.getName() + "\"");
			appendAttacks(sb, e.getAttList());
			sb.append("/>\n");

		}
	}
	
	private void appendAttacks(StringBuilder sb, Set<Attack> attList){
		
		if (!attList.isEmpty() || allAttacks) {
			sb.append(" attacks=\"");
			if(allAttacks){
				sb.append("//@possibleAttacks.");
				sb.append(ataques.get("*").getIndex());
				sb.append(" ");
			}else{
				for (Attack a : attList) {
					sb.append("//@possibleAttacks.");
					sb.append(a.getIndex());
					sb.append(" ");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append("\"");
		}
	}
	
	private void appendPossibleAttacks(StringBuilder sb, Map<String, Attack> attacks){
		for (Map.Entry<String, Attack> e : attacks.entrySet()) {
			sb.append("  <possibleAttacks name=\"" + e.getValue().getName() + "\" severity=\""
					+ e.getValue().getSeverity() + "\"/>\n");
		}
	}

}
