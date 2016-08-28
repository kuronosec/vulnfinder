package edu.udea.vulnfinder.server.plugin.view.dialog;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.wizards.datatransfer.WizardArchiveFileResourceImportPage1;
import org.eclipse.ui.internal.wizards.datatransfer.WizardFileSystemResourceImportPage1;
import org.eclipse.ui.internal.wizards.datatransfer.WizardProjectsImportPage;

public class RunAttacksWizard extends Wizard {

	protected IWizardPage one;
    

    public RunAttacksWizard() {
            super();
            setNeedsProgressMonitor(true);
    }

    @Override
    public String getWindowTitle() {
            return "Export My Data";
    }

    @Override
    public void addPages() {
    	
    	
            
    }

    @Override
    public boolean performFinish() {
            return true;
    }

}
