/*
 * Copyright (C) 2016 raven
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
package edu.udea.vulnfinder.xmigenerator.generator.metaclasses;

/**
 *
 * @author raven
 */
public class Attack {

    private String name;
    private String severity;
    private int index;

    public Attack(String name) {
        this.name = name;
        severity = "High";
    }

    public Attack(String name, String severity) {
        this.name = name;
        this.severity = severity;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

	@Override
	public String toString() {
		return "Attack [name=" + name + ", severity=" + severity + ", index=" + index + "]";
	}
    
    

}
