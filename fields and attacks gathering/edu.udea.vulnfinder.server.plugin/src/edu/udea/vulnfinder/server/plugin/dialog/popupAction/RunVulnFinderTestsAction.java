package edu.udea.vulnfinder.server.plugin.dialog.popupAction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;


import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnSpideringException;
import transformation.core;

public class RunVulnFinderTestsAction extends ActionDelegate implements IActionDelegate {
	protected List<IFile> files;


	@SuppressWarnings("unchecked")
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			files = ((IStructuredSelection) selection).toList();
		}
	}

	public void run(IAction action) {
		String textModelPath;
		String outputTestPath;
		IFile textModelFile;
		IFolder outputFolder;
		Workbench wb;
		WorkbenchWindow ww;
		Shell shell;
		URI platformUri;
		File platformFile;
		IPath platformPath;
		
		
		
		if(files.size() != 1){
			MessageLauncher.showError(null, "Error", "You can only run one test at a time.");
			return;
		}
        textModelFile = files.get(0);
        
        if (textModelFile != null) {
        	
        	
        	
        	/*FIXXXX*/
        	try {
				platformUri = Platform.getInstallLocation().getURL().toURI();
				platformFile = new java.io.File(platformUri);
	        	platformPath = new Path(platformFile.getAbsolutePath());
			} catch (URISyntaxException e1) {
				MessageLauncher.showError(null, "Error", "Error while looking for folder: "+e1.getMessage());
				return;
			}
        	
        	/*FIXXXXX*/
        	
        	
        	outputFolder = textModelFile.getProject().getFolder("generated");
        	
        	
        	try {
        		if(!outputFolder.exists()){
        			outputFolder.create(false, true, null);
            		//outputFolder.delete(true, null);
            	}
				
				if(outputFolder.exists()){
					outputTestPath = outputFolder.getLocation().makeRelativeTo(platformPath).toOSString();
					textModelPath = textModelFile.getLocation().makeRelativeTo(platformPath).toOSString();
				}else{
					MessageLauncher.showError(null, "Error","Error creating the folder :(");
					return;
				}
			} catch (CoreException e) {
				MessageLauncher.showError(null, "Error", "We weren't able to create the temporary folder, check your permissions.");
				e.printStackTrace();
				return;
			}
        	
        	
    		System.setProperty("http.proxyHost", Main.getZapHost());
    		System.setProperty("http.proxyPort", String.valueOf(Main.getZapPort()));
    		System.setProperty("https.proxyPort", String.valueOf(Main.getZapPort()));
    		System.setProperty("https.proxyHost", Main.getZapHost());
    		System.setProperty("http.nonProxyHosts", "");
    		wb = Workbench.getInstance();
    		ww = (WorkbenchWindow) wb.getActiveWorkbenchWindow();
    		shell = ww.getShell();
    		
    		//MessageLauncher.showInformation(null, "Information", "Running Tests");
    		try {
    			
    			IRunnableWithProgress op = new TestRunThread(shell, textModelPath, outputTestPath);
    			new ProgressMonitorDialog(shell).run(true, true, op);
    		} catch (InvocationTargetException ex) {
    			ex.printStackTrace();
    		} catch (InterruptedException ex) {
    			ex.printStackTrace();
    		}
    		
        }
        
	}

	protected List<? extends Object> getArguments() {
		return new ArrayList<String>();
	}
	
private static class TestRunThread implements IRunnableWithProgress {
		
		private Shell thisShell;
		private String textModelPath;
		private String outputTestPath;

		public TestRunThread(Shell thisShell, String textModelPath, String outputTestPath) {
			super();
			this.thisShell = thisShell;
			this.textModelPath = textModelPath;
			this.outputTestPath = outputTestPath;
		}




		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			// Tell the user what you are doing
			monitor.beginTask("Running tests...", IProgressMonitor.UNKNOWN);
			//monitor.subTask("Running tests");
			
			System.out.println(System.getProperty("http.proxyHost"));
			System.out.println(System.getProperty("http.proxyPort"));
			
			try{
				core.start(textModelPath, outputTestPath);
				System.out.println("---FIN DE EJECUCIÓN DE core.start---");
			}catch(Exception e){
				e.printStackTrace();
				if(e instanceof NoRouteToHostException || e instanceof ConnectException){
					MessageLauncher.showError(null, "Error", "Couldn't connect to the TOE, are you sure it's running in the specified host and port?.");
				}else if(e instanceof FileNotFoundException){
					MessageLauncher.showError(null, "Error", "Couldn't find the VulnFinder temporary files, are you sure you have the right permissions?.");
				}else{
					MessageLauncher.showError(null, "Error", "An unknown error happened while trying to run the tests.");
					System.err.println(e.getMessage());
				}
				monitor.done();
				return;
			}
			monitor.done();
			MessageLauncher.showInformation(null, "Information", "Tests ran successfully");
		}

	}

}
