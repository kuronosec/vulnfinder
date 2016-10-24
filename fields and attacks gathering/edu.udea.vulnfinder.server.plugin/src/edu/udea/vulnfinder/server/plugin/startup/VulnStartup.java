package edu.udea.vulnfinder.server.plugin.startup;

import java.io.IOException;

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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;

import edu.udea.vulnfinder.server.plugin.utils.MessageLauncher;
import edu.udea.vulnfinder.xmigenerator.generator.Main;
import edu.udea.vulnfinder.xmigenerator.generator.exception.VulnServerException;

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
						menuSetup();
						startServer();
					}
					
					public void startServer(){
						try {
							Main.startServer();
							//MessageLauncher.showInformation(null, "Information", "VulnFinder Server is now running.");
							System.out.println("VulnFinder Server is now running.");
						} catch (IOException e) {
							MessageLauncher.showError(null, "Error",
									"The server port is currently under use or you might not have permissions to start a server on that port. "
									+ "\nTry changing the port in the VulnFinder configuration.");
							e.printStackTrace();
						} catch (VulnServerException e) {
							MessageLauncher.showError(null, "Error", e.getMessage());
						}
					}
					
					
					public void menuSetup(){
						Workbench wb;
						WorkbenchWindow ww;
						MenuManager menuManager;
						MenuManager mmVuln;
						
						
						wb = Workbench.getInstance();
						ww = (WorkbenchWindow) wb.getActiveWorkbenchWindow();
						menuManager = ww.getMenuManager();
						mmVuln = (MenuManager) menuManager.findMenuUsingPath(VULN_MENU_ID);
						mmVuln.getMenu().addMenuListener(new MenuListener() {

							@Override
							public void menuShown(MenuEvent ev) {
								Menu vMenu = (Menu)ev.getSource();
								
								if (Main.getState() == 0) { // Nothing started
															// yet
									vMenu.getItem(0).setEnabled(true);
									vMenu.getItem(1).setEnabled(false);
									vMenu.getItem(2).setEnabled(false);
									vMenu.getItem(3).setEnabled(true);
									vMenu.getItem(4).setEnabled(false);

								} else if (Main.getState() == 1) { // Server
																	// started
									vMenu.getItem(0).setEnabled(true);
									vMenu.getItem(1).setEnabled(false);
									vMenu.getItem(2).setEnabled(false);
									vMenu.getItem(3).setEnabled(true);
									vMenu.getItem(4).setEnabled(false);

								} else if (Main.getState() == 2) { // Server
																	// stopped
																	// but no
																	// spidering
									vMenu.getItem(0).setEnabled(true);
									vMenu.getItem(1).setEnabled(false);
									vMenu.getItem(2).setEnabled(false);
									vMenu.getItem(3).setEnabled(true);
									vMenu.getItem(4).setEnabled(false);
								} else if (Main.getState() == 3) { // Spidering
																	// started
									vMenu.getItem(0).setEnabled(true);
									vMenu.getItem(1).setEnabled(false);
									vMenu.getItem(2).setEnabled(false);
									vMenu.getItem(3).setEnabled(false);
									vMenu.getItem(4).setEnabled(false);
								} else if (Main.getState() == 4) { // Spidering
																	// done
									vMenu.getItem(0).setEnabled(true);
									vMenu.getItem(1).setEnabled(false);
									vMenu.getItem(2).setEnabled(false);
									vMenu.getItem(3).setEnabled(true);
									vMenu.getItem(4).setEnabled(true);
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
