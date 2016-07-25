package edu.udea.vulnfinder.server.plugin.utils;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.Workbench;

public class MessageLauncher {
	private MessageLauncher(){}
	
	public static void showInformation(Shell shell, String title, String message){
		showMessage(shell, title, message, 0);
	}
	
	public static void showError(Shell shell, String title, String message){
		showMessage(shell, title, message, 1);
	}
	
	private static void showMessage(Shell shell, String title, String message, int messageType){
		Job startJob = new Job("VulnStartupJob") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						Shell thisShell = shell;
						if(thisShell == null){
							thisShell = Workbench.getInstance().getActiveWorkbenchWindow().getShell();
						}
						
						if(messageType == 0){
							MessageDialog.openInformation(thisShell, title, message);
						}else{
							MessageDialog.openError(thisShell, title, message);
						}
					}
				});
				
				return Status.OK_STATUS;
			}
		};
		startJob.schedule();
	}
	
	
}
