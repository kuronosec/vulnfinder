
package edu.udea.vulnfinder.server.plugin.handlers;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.internal.Workbench;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;

public class GenerateReport {
	@Execute
	public void execute(Shell shell) {
		
		IFolder generated = null;
		ArrayList<String> elements = null;
		
		try{
			generated = getCurrentProject().getFolder("generated");
		}catch(NullPointerException npe){
			MessageLauncher.showError(shell, "Error", "Please select a project on the Project Explorer first.");
			return;
		}
		
		
		if(!generated.exists()){
			MessageLauncher.showError(shell, "Error", "The selected project doesn't have a 'generated' folder, please run the tests first or select the right project.");
			return;
		}
		try {
			generated.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			elements = new ArrayList<>();
			for(IResource member : generated.members()){
				if(member instanceof IContainer){
					elements.add(member.getName());
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		if(elements == null || elements.isEmpty()){
			MessageLauncher.showError(shell, "Error", "The 'generated' folder is empty or doesn't exists, please run the tests firsts or select the right project");
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
		String result = (String)dialog.getFirstResult();
		System.out.println("Seleccionado: "+result);
	}
	
	public static IProject getCurrentProject(){    
        ISelectionService selectionService =     
            Workbench.getInstance().getActiveWorkbenchWindow().getSelectionService();    

        ISelection selection = selectionService.getSelection();    

        IProject project = null;    
        if(selection instanceof IStructuredSelection) {    
            Object element = ((IStructuredSelection)selection).getFirstElement();    

            if (element instanceof IResource) {    
                project= ((IResource)element).getProject();    
            }
        }     
        return project;    
    }

}