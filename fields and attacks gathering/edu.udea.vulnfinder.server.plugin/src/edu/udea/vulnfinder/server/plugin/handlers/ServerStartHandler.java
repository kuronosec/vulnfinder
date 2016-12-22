package edu.udea.vulnfinder.server.plugin.handlers;

import java.io.IOException;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.zaproxy.clientapi.core.ClientApiException;

import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;

public class ServerStartHandler {

	@Execute
	public void execute(Shell shell) {

		try {
			Main.startServer();
			MessageDialog.openInformation(shell, "Information", "VulnFinder Server is now running.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			MessageDialog.openError(shell, "Error",
					"The port is currently under use or you might not have permissions to start a server on that port.");
			e.printStackTrace();
		} catch (VulnServerException e) {
			MessageDialog.openError(shell, "Error", e.getMessage());
		}
	}
}
