
package edu.udea.vulnfinder.server.plugin.handlers;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SaveAsDialog;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;

public class GenerateXMIHandler {

	private static final String[] FILTER_NAMES = {
			"VulnFinder Security Test Model (*.securitytest)"/* , "All Files (*.*)" */ };

	// These filter extensions are used to filter which files are displayed.
	private static final String[] FILTER_EXTS = { "*.securitytest"/* , "*.*" */ };

	@Execute
	public void execute(Shell shell) {
		try {
			generateXMI(shell, null);
		} catch (VulnServerException e) {
			MessageDialog.openError(shell, "Error", e.getMessage());
		}
	}
	
	public static void generateXMI(Shell shell, String filename) throws VulnServerException{
		SaveAsDialog saveAsDialog;
		IPath fpath;
		String modelName;
		String xmi;
		int posIni, posFin;
		IWorkspaceRoot rootws;
		IFile fileRep;
		
		
		rootws = ResourcesPlugin.getWorkspace().getRoot();
		//if(filename == null){
			saveAsDialog = new SaveAsDialog(shell);
			/*if(filename != null)
				saveAsDialog.setOriginalName(filename);
			else*/
				saveAsDialog.setOriginalName("Untitled.securitytest");
			saveAsDialog.open();
			
			fpath = saveAsDialog.getResult();
			
		//}
		
		if (fpath != null) {
			modelName = fpath.toString();
			if (!modelName.endsWith(".securitytest")) {
				throw new VulnServerException("The generated file must have the .securitytest extension.");
				
			}
			
			posFin = modelName.lastIndexOf('.');
			if (posFin > 0) {
				modelName = modelName.substring(0, posFin);
			}
			posIni = modelName.lastIndexOf("/");
			if(posIni > 0){
				modelName = modelName.substring(posIni+1);
			}
			
			fileRep = rootws.getFile(fpath);
			
			createXMIFile(fileRep, modelName, false, true, shell);

		} else {
			MessageDialog.openError(shell, "Error", "You must choose a save path.");
		}
	}
	
	public static void createXMIFile(IFile fileRep, String modelName, boolean allAttacks, boolean verbose, Shell shell) throws VulnServerException{
		String xmi = Main.generateXMI(modelName, modelName, allAttacks);
		try {
			fileRep.create((new ByteArrayInputStream(xmi.getBytes())), IResource.NONE, null);
			if(verbose)
				MessageLauncher.showInformation(shell, "Information", "Sucessfully generated.");
		} catch (CoreException e) {
			throw new VulnServerException("Error generating the XMI: "+e.getMessage(),e);
		}
	}

}