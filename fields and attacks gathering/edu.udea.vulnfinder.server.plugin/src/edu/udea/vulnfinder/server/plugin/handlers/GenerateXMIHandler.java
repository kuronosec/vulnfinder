
package edu.udea.vulnfinder.server.plugin.handlers;

import java.io.File;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import edu.udea.vulnfinder.xmigenerator.generator.Main;

public class GenerateXMIHandler {

	private static final String[] FILTER_NAMES = { "VulnFinder Security Test Model (*.securitytest)"/*, "All Files (*.*)"*/ };

	// These filter extensions are used to filter which files are displayed.
	private static final String[] FILTER_EXTS = { "*.securitytest"/*, "*.*"*/ };

	@Execute
	public void execute(Shell shell) {
		FileDialog saveVulnFile = new FileDialog(shell, SWT.SAVE);
        saveVulnFile.setFilterNames(FILTER_NAMES);
        saveVulnFile.setFilterExtensions(FILTER_EXTS);
        String fn = saveVulnFile.open();
        String modelName;
        int pos;
        if (fn != null) {
        	MessageDialog.openInformation(shell, "Information", "Generating: "+fn);
        	modelName = new File(fn).getName();
        	pos = modelName.lastIndexOf('.');
        	if(pos > 0){
        		modelName = modelName.substring(0,pos);
        	}
        	if(Main.generateXMI(fn, modelName, modelName )){
        		MessageDialog.openInformation(shell, "Information", "Sucessfully generated: "+fn);
        	}else{
            	MessageDialog.openError(shell, "Error", "Error generating the XMI");
        	}
        }else{
        	MessageDialog.openError(shell, "Error", "You must choose a save path.");
        }
		
	}

}