
package edu.udea.vulnfinder.server.plugin.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import edu.udea.vulnfinder.server.plugin.dialog.popupAction.RunVulnFinderTestsAction;
import edu.udea.vulnfinder.server.plugin.handlers.SpiderStartHandler.Callback;
import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.server.plugin.utils.VulnFinderProjectCreator;
import edu.udea.vulnfinder.server.plugin.view.dialog.AuthParamsDialog;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;
import edu.udea.vulnfinder.m2t.ui.popupMenus.*;

public class QuickFinder {
	@Execute
	public void execute(Shell shell) {
		
		try {
			PostSpidering ps = new PostSpidering();
			SpiderStartHandler.startFullSpiderInThread(shell, false, ps);
		} catch (VulnServerException e) {
			MessageLauncher.showError(shell, "Error", "Couldn't execute QuickFinder:\nReason: " + e.getMessage());
		}
	}
	
	

	public class PostSpidering implements Callback {

		@Override
		public void execute(Shell shell) {
			
			String name = Main.getDomain().getTOEOnly();
			IProject p = VulnFinderProjectCreator.createNewProject(name);
			IFile fileRep = p.getFolder("model").getFile(name + ".sxmi");
			List<IFile> flist = new ArrayList<IFile>();
			try {
				GenerateXMIHandler.createXMIFile(fileRep, name, true, false, shell);
				flist.add(fileRep);
			} catch (VulnServerException e) {
				MessageDialog.openError(shell, "Error", "Couldn't execute QuickFinder:\nReason: " + e.getMessage());
			}

			Job startJob = new Job("GenerateCode") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					Display.getDefault().syncExec(new Runnable() {

						@Override
						public void run() {

							AcceleoGenerateVulnFinderAction agcf = new AcceleoGenerateVulnFinderAction();
							agcf.externalGenerate(flist);
							runAttacks();
						}

						public void runAttacks() {
							IFile f;
							try {
								for(IResource ir : p.getFolder("text-model").members()){
									if("s".equalsIgnoreCase(ir.getFileExtension())){
										
										MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
												"Are you sure you want to run the vulnerability tests against the following TOE: "+ir.getName(), MessageDialog.QUESTION,
												new String[] { "Yes", "No" }, 0);
										int result = dialog.open();
										if(result == 0){
											RunVulnFinderTestsAction.runTests((IFile)ir);
										}
									}
								}
							} catch (CoreException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					return Status.OK_STATUS;
				}
			};
			startJob.schedule();

		}

	}
}