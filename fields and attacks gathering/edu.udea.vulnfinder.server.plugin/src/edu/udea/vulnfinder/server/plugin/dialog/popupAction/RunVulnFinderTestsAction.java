package edu.udea.vulnfinder.server.plugin.dialog.popupAction;

import java.io.FileNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;


import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
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
		runTestsFromMenu();
	}
	
	private void runTestsFromMenu(){
		
		IFile textModelFile;
		

		if (files.size() != 1) {
			MessageLauncher.showError(null, "Error", "You can only run one test at a time.");
			return;
		}
		textModelFile = files.get(0);

		if (textModelFile != null) {
			runTests(textModelFile);
		}
	}
	
	public static void runTests(IFile textModelFile){
		String textModelPath;
		String outputTestPath;
		
		IFolder outputFolder;
		Workbench wb;
		WorkbenchWindow ww;
		Shell shell;
		boolean accepted = false;
		
		outputFolder = textModelFile.getProject().getFolder("generated");
		
		try {
			if (!outputFolder.exists()) {
				outputFolder.create(false, true, null);
				// outputFolder.delete(true, null);
			}
			if (outputFolder.exists()) {
				outputTestPath = outputFolder.getLocation().makeAbsolute().toOSString();
				textModelPath = textModelFile.getLocation().makeAbsolute().toOSString();
			} else {
				MessageLauncher.showError(null, "Error", "Error creating the folder :(");
				return;
			}
		} catch (CoreException e) {
			MessageLauncher.showError(null, "Error",
					"We weren't able to create the temporary folder, check your permissions.");
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

		// MessageLauncher.showInformation(null, "Information", "Running
		// Tests");
		try {

			accepted = MessageDialog.openConfirm(shell, "Action Required",
					"Before clicking Ok and running the tests, make sure ZAP is running and you have logged into the TOE "
							+ "or the session is in the required state while using ZAP as a proxy.");
			if (accepted) {
				IRunnableWithProgress op = new TestRunThread(shell, textModelPath, outputTestPath, outputFolder);
				new ProgressMonitorDialog(shell).run(true, true, op);
			}
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	protected List<? extends Object> getArguments() {
		return new ArrayList<String>();
	}

	private static class TestRunThread implements IRunnableWithProgress {

		private Shell thisShell;
		private String textModelPath;
		private String outputTestPath;
		private IFolder generatedFolder;
		
		private static final String EXEC_FILE = "./exec.sh";
		
	    private static final String EXEC_PATH = "/mnt/Data/vulnfinder/integracion/";

		public TestRunThread(Shell thisShell, String textModelPath, String outputTestPath, IFolder generated) {
			super();
			this.thisShell = thisShell;
			this.textModelPath = textModelPath;
			this.outputTestPath = outputTestPath;
			this.generatedFolder = generated;
		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			// Tell the user what you are doing
			// monitor.beginTask("Running tests...", IProgressMonitor.UNKNOWN);
			// monitor.subTask("Running tests");

			SubMonitor subMonitor = SubMonitor.convert(monitor);
			/*
			ArrayList<String> params = new ArrayList<>();
			params.add(EXEC_FILE);
			params.add("localhost");
			params.add("8090");
			params.add(textModelPath);
			params.add(outputTestPath);
			
			
			ProcessBuilder probuilder = new ProcessBuilder(params);
			probuilder.directory(new File(EXEC_PATH));
			Process process;
			try {
				process = probuilder.start();
				InputStream is = process.getInputStream();
		        InputStreamReader isr = new InputStreamReader(is);
		        BufferedReader br = new BufferedReader(isr);
		        String line;
		        while ((line = br.readLine()) != null) {
		            System.out.println(line);
		        }

		        //Wait to get exit value
		        try {
		            int exitValue = process.waitFor();
		        } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
	        
			
			
			try {
				core.start(textModelPath, outputTestPath, (Object)(new ProgressController(subMonitor)), Main.getZapHost(), Main.getZapPort());
				//new VulnOrchestator().run(textModelPath, outputTestPath);
				System.out.println("---FIN DE EJECUCIÓN DE core.start---");

			} catch (Exception e) {
				// e.printStackTrace();
				if (e instanceof NoRouteToHostException || e instanceof ConnectException) {
					MessageLauncher.showError(null, "Error",
							"Couldn't connect to the TOE, are you sure it's running in the specified host and port?.");
				} else if (e instanceof FileNotFoundException) {
					MessageLauncher.showError(null, "Error",
							"Couldn't find the VulnFinder temporary files, are you sure you have the right permissions?.");
				} else if (e instanceof OperationCanceledException) {
					MessageLauncher.showError(null, "Error", "Operation cancelled by user.");
				} else {
					MessageLauncher.showError(null, "Error",
							"An unknown error happened while trying to run the tests.");
					System.err.println(e.getMessage());
				}
				try {
					generatedFolder.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} catch (CoreException ce) {
					MessageLauncher.showError(null, "Error",
							"Error while refreshing the generated folder, try doing it manually.");
				}
				// monitor.done();

				return;
			}

			try {
				generatedFolder.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException ce) {
				MessageLauncher.showError(null, "Error",
						"Error while refreshing the generated folder, try doing it manually.");
			}
			// monitor.done();
			MessageLauncher.showInformation(null, "Information", "Tests ran successfully");
		}
	}

	public interface IProgressController {
		void updateProgress(int progressDone, String progressMessage) throws Exception;

		void updateProgress(int progressDone) throws Exception;
	}

	private static class ProgressController implements IProgressController {

		SubMonitor subMonitor;

		public ProgressController(SubMonitor s) {
			subMonitor = s;
		}

		@Override
		public void updateProgress(int progressDone, String progressMessage) throws Exception {
			// System.out.println("UPDATE PROGRESS "+progressDone + " MESSAGE:
			// "+progressMessage);
			try {
				subMonitor.setWorkRemaining(1000).split(1);
				subMonitor.subTask(progressMessage);
			} catch (OperationCanceledException e) {
				subMonitor.subTask("Canceling tests...");

				throw e;
			}
		}

		@Override
		public void updateProgress(int progressDone) throws Exception {
			// System.out.println("UPDATE PROGRESS "+progressDone);
			try {
				subMonitor.setWorkRemaining(1000).split(1);
			} catch (OperationCanceledException e) {
				subMonitor.subTask("Canceling tests...");
				throw e;
			}
		}

	}
}
