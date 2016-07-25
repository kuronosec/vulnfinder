package edu.udea.vulnfinder.server.plugin.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;

public class ServerStopHandler {

  @Execute
  public void execute(Shell shell) {
    
	try {
		Main.stopServer();
		MessageDialog.openInformation(shell, "Information", "Stopping server");
	} catch (VulnServerException e) {
		MessageDialog.openError(shell, "Error", e.getMessage());
	}
	  
    
  }
} 