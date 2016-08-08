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

import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.Attack;
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

	public Mem2XMIFormat(TargetOfEvaluation dominio, Map<String, Attack> ataques) {
		this.dominio = dominio;
		this.ataques = ataques;
		this.testId = "secTest01";
		this.testName = "Test01";
	}
	
	public Mem2XMIFormat(TargetOfEvaluation dominio, Map<String, Attack> ataques, String testId, String testName) {
		this.dominio = dominio;
		this.ataques = ataques;
		this.testId = testId;
		this.testName = testName;
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
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<securityTest:Test xmi:version=\"2.0\" "
				+ "xmlns:xmi=\"http://www.omg.org/XMI\" "
				+ "xmlns:securityTest=\"http://udea/vulnfinder/securityTest\" id=\""+testId+"\" name=\""+testName+"\">\n");
		// for (TargetOfEvaluation d : dominios) {
		TargetOfEvaluation d = dominio;
		sb.append("  <scope domain=\"" + d.getNombre() + "\">\n");
		for (WebComponent p : d.getPaginas()) {
			sb.append("    <components path=\"" + p.getRuta() + "\"");
			enlaces = p.getEnlaces();
			if (!enlaces.isEmpty()) {
				sb.append(" targetLinks=\"");
				for (int[] en : enlaces) {
					// sb.append("//@dominios.");
					// sb.append(en[0]);
					sb.append("//@scope");
					sb.append("/@components.");
					// sb.append(en[1]);
					sb.append(en[0]);
					sb.append(" ");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append('\"');
			}
			if (!p.getEntradas().isEmpty()) {
				sb.append(">\n");
				for (Input e : p.getEntradas()) {
					sb.append("      <inputs name=\"" + e.getNombre() + "\"");
					if (!e.getAttList().isEmpty()) {
						sb.append(" attacks=\"");
						for (Attack a : e.getAttList()) {
							sb.append("//@possibleAttacks.");
							sb.append(a.getIndex());
							sb.append(" ");
						}
						sb.deleteCharAt(sb.length() - 1);
						sb.append("\"");
					}
					sb.append("/>\n");

				}
				sb.append("    </components>\n");
			} else {
				sb.append("/>\n");
			}
		}
		sb.append("  </scope>\n");

		for (Map.Entry<String, Attack> e : ataques.entrySet()) {
			sb.append("  <possibleAttacks name=\"" + e.getValue().getName() + "\" severity=\""
					+ e.getValue().getSeverity() + "\"/>\n");
		}

		sb.append("</securityTest:Test>");
		return sb.toString();
	}

}
