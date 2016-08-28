 
package edu.udea.vulnfinder.server.plugin.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;

import edu.udea.vulnfinder.server.plugin.view.dialog.RunAttacksWizard;
import edu.udea.vulnfinder.xmigenerator.generator.Main;

public class RunVulnFinderTestsHandler {
	@Execute
	public void execute(Shell shell) {
		System.out.println("YEAHHHHHHHHHHHHHHHHHHHHHH");
		Workbench wb = Workbench.getInstance();
		WorkbenchWindow ww = (WorkbenchWindow) wb.getActiveWorkbenchWindow();
		ISelection selection = ww.getSelectionService().getSelection();
		
		if (selection instanceof IStructuredSelection) {
			WizardDialog wizardDialog = new WizardDialog(shell,
                    new RunAttacksWizard());
			wizardDialog.open();
	        /*IStructuredSelection ssel = (IStructuredSelection) selection;
	        Object obj = ssel.getFirstElement();
	        IFile file = (IFile) Platform.getAdapterManager().getAdapter(obj,
	                IFile.class);
	        if (file == null) {
	            if (obj instanceof IAdaptable) {
	                file = (IFile) ((IAdaptable) obj).getAdapter(IFile.class);
	            }
	        }
	        if (file != null) {
	            System.out.println(file.getFullPath().toString());
	        }*/
	    }
		
		

		
	}
		
}