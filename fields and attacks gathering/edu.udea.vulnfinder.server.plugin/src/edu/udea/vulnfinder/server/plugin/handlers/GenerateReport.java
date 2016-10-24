
package edu.udea.vulnfinder.server.plugin.handlers;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.internal.Workbench;

import co.edu.udea.generadorreportesvuln.ReportGenerator;
import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.xmigenerator.generator.Main;

public class GenerateReport {
	@Execute
	public void execute(Shell shell) {
		generateReport(shell,null);
	}
	
	public static void generateReport(Shell shell, IProject project){
		IFolder generated = null, toeFolder;
		IFile sqlMapLog;
		ArrayList<String> elements = null;
		List<String> sqlMapPaths;
		String htmlString = null;
		IFile outHtmlFile;
		
		if(project == null){
			project = getCurrentProject();
		}
		
		try {
			generated = project.getFolder("generated");
		} catch (NullPointerException npe) {
			MessageLauncher.showError(shell, "Error", "Please select a project on the Project Explorer first.");
			return;
		}

		if (!generated.exists()) {
			MessageLauncher.showError(shell, "Error",
					"The selected project doesn't have a 'generated' folder, please run the tests first or select the right project.");
			return;
		}
		try {
			generated.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			elements = new ArrayList<>();
			for (IResource member : generated.members()) {
				if (member instanceof IContainer) {
					elements.add(member.getName());
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		if (elements == null || elements.isEmpty()) {
			MessageLauncher.showError(shell, "Error",
					"The 'generated' folder is empty or doesn't exists, please run the tests firsts or select the right project");
			return;
		}

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, new LabelProvider());

		dialog.setElements(elements.toArray());
		dialog.setMultipleSelection(false);
		dialog.setTitle("Select the TOE to generate the report from");
		// user pressed cancel
		if (dialog.open() != Window.OK) {
			return;
		}

		String result = (String) dialog.getFirstResult();

		toeFolder = generated.getFolder(result);
		sqlMapLog = toeFolder.getFile("log");
		System.out.println("Seleccionado: " + result);
		sqlMapPaths = new ArrayList<>();
		sqlMapPaths.add(sqlMapLog.getLocation().makeAbsolute().toOSString());
		
		try {
			htmlString = ReportGenerator.generateReport(Main.getZapHost(), Main.getZapPort(), "http://" + result, sqlMapPaths);
		} catch (IOException e) {
			MessageLauncher.showError(null, "Error", "Error while generating report.");
			return;
		}
		
		outHtmlFile = toeFolder.getFile("FinalReport.html");
		
		try {
			outHtmlFile.create((new ByteArrayInputStream(htmlString.getBytes())), IResource.NONE, null);
			//MessageDialog.openInformation(shell, "Information", "Report successfully generated.");
		} catch (CoreException e) {
			MessageDialog.openError(shell, "Error", "Error generating the report: " + e.getMessage());
			return;
		} 
		
		try {
			IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser(null);
			browser.openURL(outHtmlFile.getLocationURI().toURL());
		} catch (PartInitException | MalformedURLException e) {
			MessageDialog.openInformation(shell, "Information", "Report successfully generated but we couldn't open the browser.");
			e.printStackTrace();
		}
	}

	public static IProject getCurrentProject() {
		
		ISelectionService selectionService = Workbench.getInstance().getActiveWorkbenchWindow().getSelectionService();

		ISelection selection = selectionService.getSelection();

		IProject project = null;
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();

			if (element instanceof IResource) {
				project = ((IResource) element).getProject();
			}
		}
		return project;
	}

}