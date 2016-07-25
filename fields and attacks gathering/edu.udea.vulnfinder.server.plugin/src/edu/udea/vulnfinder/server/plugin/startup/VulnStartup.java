package edu.udea.vulnfinder.server.plugin.startup;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;

import edu.udea.vulnfinder.xmigenerator.generator.Main;

public class VulnStartup implements IStartup {

	public static final String VULN_MENU_ID = "edu.udea.vulnfinder.server.plugin.menuPrincipal";

	@Override
	public void earlyStartup() {
		Job startJob = new Job("VulnStartupJob") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						Workbench.getInstance().getActiveWorkbenchWindow().getShell().getMenuBar().getItem(8).getMenu()
								.addMenuListener(new MenuListener() {
									
									private Workbench wb = Workbench.getInstance();
									private WorkbenchWindow ww = (WorkbenchWindow) wb.getActiveWorkbenchWindow();
									private MenuManager menuManager = ww.getMenuManager();
									private MenuManager mmVuln;

									@Override
									public void menuShown(MenuEvent arg0) {
										mmVuln = (MenuManager) menuManager.findMenuUsingPath(VULN_MENU_ID);
										if (Main.getState() == 0) { //Nothing started yet
											mmVuln.getMenu().getItem(0).setEnabled(true);
											mmVuln.getMenu().getItem(1).setEnabled(true);
											mmVuln.getMenu().getItem(2).setEnabled(false);
											mmVuln.getMenu().getItem(3).setEnabled(false);
											mmVuln.getMenu().getItem(4).setEnabled(false);

										} else if (Main.getState() == 1) { //Server started
											mmVuln.getMenu().getItem(0).setEnabled(true);
											mmVuln.getMenu().getItem(1).setEnabled(false);
											mmVuln.getMenu().getItem(2).setEnabled(true);
											mmVuln.getMenu().getItem(3).setEnabled(true);
											mmVuln.getMenu().getItem(4).setEnabled(false);
											
										}else if (Main.getState() == 2) { //Server stopped but no spidering
											mmVuln.getMenu().getItem(0).setEnabled(true);
											mmVuln.getMenu().getItem(1).setEnabled(true);
											mmVuln.getMenu().getItem(2).setEnabled(false);
											mmVuln.getMenu().getItem(3).setEnabled(true);
											mmVuln.getMenu().getItem(4).setEnabled(false);
										}else if (Main.getState() == 3) { //Spidering started
											mmVuln.getMenu().getItem(0).setEnabled(true);
											mmVuln.getMenu().getItem(1).setEnabled(false);
											mmVuln.getMenu().getItem(2).setEnabled(false);
											mmVuln.getMenu().getItem(3).setEnabled(false);
											mmVuln.getMenu().getItem(4).setEnabled(false);
										}else if (Main.getState() == 4) { //Spidering done
											mmVuln.getMenu().getItem(0).setEnabled(true);
											mmVuln.getMenu().getItem(1).setEnabled(true);
											mmVuln.getMenu().getItem(2).setEnabled(false);
											mmVuln.getMenu().getItem(3).setEnabled(true);
											mmVuln.getMenu().getItem(4).setEnabled(true);
										}

										menuManager.update();
									}

									@Override
									public void menuHidden(MenuEvent arg0) {
										// TODO Auto-generated method stub

									}
								});

					}
				});
				return Status.OK_STATUS;
			}
		};
		startJob.schedule();
	}

}
