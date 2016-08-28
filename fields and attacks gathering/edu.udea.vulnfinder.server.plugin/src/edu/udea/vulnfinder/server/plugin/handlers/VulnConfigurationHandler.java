
package edu.udea.vulnfinder.server.plugin.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import edu.udea.vulnfinder.server.plugin.view.dialog.VulnConfigDialog;
import edu.udea.vulnfinder.xmigenerator.generator.Main;

public class VulnConfigurationHandler {
	@Execute
	public void execute(Shell shell) {
		VulnConfigDialog dialog = new VulnConfigDialog(shell);
		
		// get the new values from the dialog
		if (dialog.open() == Window.OK) {
			Main.setServerPort(dialog.getVulnPortInt());
			Main.setZapHost(dialog.getZapHost());
			Main.setZapPort(dialog.getZapPortInt());
			Main.setMaxSpiderMilliseconds(dialog.getSpiderMillisInt());
			Main.setExcludedExtensionsInSpidering(dialog.getFilteredExtensionsInSpidering());
			Main.setExcludedExtensionsInModel(dialog.getFilteredExtensionsInModel());
		}
	}

}