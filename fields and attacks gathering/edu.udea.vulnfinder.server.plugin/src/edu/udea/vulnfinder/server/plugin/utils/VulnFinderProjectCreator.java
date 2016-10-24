package edu.udea.vulnfinder.server.plugin.utils;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ui.business.api.session.UserSession;
import org.eclipse.swt.widgets.Display;

public class VulnFinderProjectCreator {

	public static IProject createNewProject(String name) {
		IFolder modelF;
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);
		try {

			project.create(null);
			project.open(null);
			IProjectDescription description = project.getDescription();

			description.setNatureIds(new String[] { /*
													 * "org.eclipse.pde.PluginNature",
													 * "org.eclipse.acceleo.ide.ui.acceleoNature",
													 */ "org.eclipse.sirius.nature.modelingproject",
					"org.eclipse.xtext.ui.shared.xtextNature" });
			project.setDescription(description, null);

			URI sessionResourceURI = URI.createPlatformResourceURI("/" + name + "/representations.aird", true);
			//System.out.println("URI: " + sessionResourceURI);
			Session createdSession = SessionManager.INSTANCE.getSession(sessionResourceURI, new NullProgressMonitor());
			createdSession.open(new NullProgressMonitor());

			modelF = project.getFolder("model");
			try {
				if (!modelF.exists()) {
					modelF.create(false, true, null);
					// outputFolder.delete(true, null);
				}
				if (!modelF.exists()) {
					MessageLauncher.showError(null, "Error", "Error creating the model folder :(");
					return project;
				}
			} catch (CoreException e) {
				MessageLauncher.showError(null, "Error",
						"We weren't able to create the models folder, check your permissions.");
				e.printStackTrace();
				return project;
			}

			/*
			 * UserSession userSession = UserSession.from(createdSession);
			 * userSession.selectViewpoint("SecTestView");
			 */

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}

	/*public static void setViewpoint(String name) {
		URI sessionResourceURI = URI.createPlatformResourceURI("/" + name + "/representations.aird", true);
		System.out.println("URI: " + sessionResourceURI);
		Session createdSession = SessionManager.INSTANCE.getSession(sessionResourceURI, new NullProgressMonitor());
		createdSession.open(new NullProgressMonitor());
		UserSession userSession = UserSession.from(createdSession);

		new Thread(new Runnable() {
			public void run() {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						userSession.selectViewpoint("SecTestView");
					}
				});

			}
		}).start();
	}*/
}
