
package edu.udea.vulnfinder.server.plugin.handlers;

import java.io.IOException;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.server.plugin.view.dialog.VulnConfigDialog;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;

public class VulnConfigurationHandler {
	@Execute
	public void execute(Shell shell) {
		VulnConfigDialog dialog;
		int oldServerPort = Main.getServerPort();

		do {
			dialog = new VulnConfigDialog(shell);
			// get the new values from the dialog
			if (dialog.open() == Window.OK) {
				
				Main.setServerPort(dialog.getVulnPortInt());
				Main.setZapHost(dialog.getZapHost());
				Main.setZapPort(dialog.getZapPortInt());
				Main.setMaxSpiderMilliseconds(dialog.getSpiderMillisInt());
				Main.setExcludedExtensionsInSpidering(dialog.getFilteredExtensionsInSpidering());
				Main.setExcludedExtensionsInModel(dialog.getFilteredExtensionsInModel());

				if (oldServerPort != Main.getServerPort() || !Main.isServerUp()) {
					try {
						Main.restartServer();
					} catch (VulnServerException | IOException e) {
						MessageLauncher.showError(shell, "Error", "Error while restarting the server, try again using another port.");
						continue;
					}
				}
			}else{
				Main.setServerPort(oldServerPort);
			}

			break;

		} while (true);
	}

}