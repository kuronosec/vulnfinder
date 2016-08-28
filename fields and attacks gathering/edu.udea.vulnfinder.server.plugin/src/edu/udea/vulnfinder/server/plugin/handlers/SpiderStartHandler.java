package edu.udea.vulnfinder.server.plugin.handlers;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.server.plugin.view.dialog.VulnConfigDialog;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnSpideringException;

public class SpiderStartHandler {

	@Execute
	public void execute(Shell shell) {
		
		try {
			IRunnableWithProgress op = new SpiderThread(shell);
			new ProgressMonitorDialog(shell).run(true, true, op);
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}


	}

	private static class SpiderThread implements IRunnableWithProgress {
		
		private Shell thisShell;
		
		
		
		public SpiderThread(Shell thisShell) {
			super();
			this.thisShell = thisShell;
		}


		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			// Tell the user what you are doing
			monitor.beginTask("Spidering with ZAP", IProgressMonitor.UNKNOWN);
			Main.setMonitor(monitor);
			try {
				Main.startSpidering();
				MessageLauncher.showInformation(thisShell, "Success", "Spidering finished successfully.");
			} catch (VulnSpideringException e) {
				MessageLauncher.showError(thisShell, "Error", e.getErrorMessage());
				e.printStackTrace();
			} catch(VulnServerException e){
				MessageLauncher.showError(thisShell, "Error", e.getMessage());
				e.printStackTrace();
			}
			// You are done
			monitor.done();
		}

	}
}
