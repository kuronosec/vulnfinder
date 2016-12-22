package edu.udea.vulnfinder.server.plugin.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.server.plugin.view.dialog.AuthParamsDialog;
import edu.udea.vulnfinder.server.plugin.view.dialog.VulnConfigDialog;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnSpideringException;
import edu.udea.vulnfinder.xmigenerator.generator.metaclasses.AuthSetting;

public class SpiderStartHandler {

	@Execute
	public void execute(Shell shell) {
		
		try {
			startFullSpiderInThread(shell, true, null);
		} catch (VulnServerException e) {
			return;
		}
		
	}
	
	public static void askUserForAuthInfo(Shell shell){
		AuthSetting aSetting = Main.getAuthSetting();
		AuthParamsDialog dialog = new AuthParamsDialog(shell);
		
		MessageDialog wantToChange = new MessageDialog(null, "Confirmation", null,
				"Do you want to set up the auth information?: ", MessageDialog.QUESTION,
				new String[] { "Yes", "No" }, 0);
		if(wantToChange.open() == 1){
			return;
		}
		
		while(true){
			if (dialog.open() == Window.OK) {
				aSetting.setLoginMessagePattern(dialog.getLoggedIn());
				aSetting.setLogoutMessagePattern(dialog.getLoggedOut());
				aSetting.setUsernameParam(dialog.getUserField());
				aSetting.setUsername(dialog.getUsername());
				aSetting.setPasswordParam(dialog.getPassField());
				aSetting.setPassword(dialog.getPassword());
				aSetting.setLoginTargetUrl(dialog.getLoginUrl());
				aSetting.setRoles(dialog.getRoles());
				aSetting.setComplete(dialog.isComplete());
				if(!dialog.isComplete()){
					MessageDialog yesNoDialog = new MessageDialog(null, "Confirmation", null,
							"The provided auth info is incomplete, do you want to continue WITHOUT setting up the auth information?: ", MessageDialog.QUESTION,
							new String[] { "Yes", "No" }, 0);
					if(yesNoDialog.open() == 1){
						continue;
					}
				}
				break;
			}else{
				MessageDialog yesNoDialog = new MessageDialog(null, "Confirmation", null,
						"Do you want to continue without setting up the auth information?: ", MessageDialog.QUESTION,
						new String[] { "Yes", "No" }, 0);
				if(yesNoDialog.open() == 0){
					break;
				}
			}
		}
	}
	
	public static void startFullSpiderInThread(Shell shell, boolean verbose ,Callback c) throws VulnServerException{
		defineTOE(shell);
		startSpiderInThread(shell, verbose,c);
	}
	
	public static void startSpiderInThread(Shell shell, boolean verbose, Callback c){
		try {
			Main.readyUpZapAPI();
			SpiderStartHandler.askUserForAuthInfo(shell);
			IRunnableWithProgress op = new SpiderThread(shell, verbose, c);
			new ProgressMonitorDialog(shell).run(true, true, op);
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void defineTOE(Shell shell) throws VulnServerException {
		String toe;
		try {
			toe = selectTOE(shell);
			Main.insertDomain(toe);
		} catch (VulnServerException e) {
			MessageLauncher.showError(shell, "Error", e.getMessage());
			throw e;
		}
		
	}
	
	public static String selectTOE(Shell shell) throws VulnServerException{
		ArrayList<String> possibleToes = Main.getZAPSites();
		String result = null;
		ElementListSelectionDialog dialog;
		
		if(possibleToes.size() == 0){
			throw new VulnServerException("You must surf through the TOE using OWASP ZAP before using VulnFinder.");
		}
		
		if(possibleToes.size() == 1){
			return possibleToes.get(0);
		}
		
		dialog = new ElementListSelectionDialog(shell, new LabelProvider());

		dialog.setElements(possibleToes.toArray());
		dialog.setMultipleSelection(false);
		dialog.setTitle("Select the TOE to generate the report from");
		
		if (dialog.open() != Window.OK) {
			throw new VulnServerException("Operation cancelled by user.");
		}
		result = (String) dialog.getFirstResult();
		return result;
	}

	private static class SpiderThread implements IRunnableWithProgress {
		
		private Shell thisShell;
		Callback callback;
		boolean verbose;
		
		
		public SpiderThread(Shell thisShell, boolean verbose, Callback c) {
			super();
			this.thisShell = thisShell;
			this.callback = c;
			this.verbose = verbose;
		}


		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			// Tell the user what you are doing
			monitor.beginTask("Spidering with ZAP", IProgressMonitor.UNKNOWN);
			Main.setMonitor(monitor);
			try {
				Main.startSpidering();
				if(callback != null){
					callback.execute(thisShell);
				}
				if(verbose)
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
	
	public interface Callback{
		public void execute(Shell shell);
	}
}
