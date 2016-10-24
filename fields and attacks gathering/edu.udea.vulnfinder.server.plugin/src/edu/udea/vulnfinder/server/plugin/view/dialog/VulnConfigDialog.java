package edu.udea.vulnfinder.server.plugin.view.dialog;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import edu.udea.vulnfinder.xmigenerator.generator.Main;

public class VulnConfigDialog extends Dialog {
	private Text txtVulnPort;
	private String vulnPort = "";
	private Text txtZapHost;
	private String zapHost = Main.getZapHost();
	private Text txtZapPort;
	private String zapPort = "";
	private Text txtFilteredExtensionsInSpidering;
	private String filteredExtensionsInSpidering = "";
	
	private Text txtFilteredExtensionsInModel;
	private String filteredExtensionsInModel = "";
	private Spinner txtSpiderMillis;
	private String spiderMillis = "";
	
	private int zapPortInt = Main.getZapPort();
	private int vulnPortInt = Main.getZapPort();
	private int spiderMillisInt = Main.getMaxSpiderMilliseconds();

	public VulnConfigDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = new GridLayout(2, true);
		
		layout.marginRight = 5;
		layout.marginLeft = 10;
		
		container.setLayout(layout);
		
		Label lblVulnPort = new Label(container, SWT.NONE);
		lblVulnPort.setText("Vulnfinder Server Port:");

		txtVulnPort = new Text(container, SWT.BORDER);
		txtVulnPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtVulnPort.setText(Main.getServerPort()+"");
		txtVulnPort.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String userText = textWidget.getText();
				vulnPort = userText;
			}
		});
		
		Label lblZapHost = new Label(container, SWT.NONE);
		lblZapHost.setText("ZAP Proxy host:");

		txtZapHost = new Text(container, SWT.BORDER);
		txtZapHost.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtZapHost.setText(Main.getZapHost());
		txtZapHost.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String zapHostText = textWidget.getText();
				zapHost = zapHostText;
			}
		});
		
		Label lblZapPort = new Label(container, SWT.NONE);
		lblZapPort.setText("Zap Proxy Port:");

		txtZapPort = new Text(container, SWT.BORDER);
		txtZapPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtZapPort.setText(Main.getZapPort()+"");
		txtZapPort.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String zapPortText = textWidget.getText();
				zapPort = zapPortText;
			}
		});
		
		Label lblSpiderMillis = new Label(container, SWT.NONE);
		lblSpiderMillis.setText("Spider duration per URL (ms):");

		txtSpiderMillis = new Spinner(container, SWT.BORDER);
		txtSpiderMillis.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtSpiderMillis.setMaximum(120000);
		txtSpiderMillis.setSelection(Main.getMaxSpiderMilliseconds());
		txtSpiderMillis.setMinimum(1000);
		txtSpiderMillis.setIncrement(100);
		txtSpiderMillis.setPageIncrement(1000);
		txtSpiderMillis.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Spinner textWidget = (Spinner) e.getSource();
				String spiderTime = textWidget.getText();
				spiderMillis = spiderTime;
			}
		});
		
		Label lblFilteredExtensionsInSpidering = new Label(container, SWT.NONE);
		lblFilteredExtensionsInSpidering.setText("Spidering Filtered Extensions:");

		txtFilteredExtensionsInSpidering = new Text(container, SWT.BORDER);
		txtFilteredExtensionsInSpidering.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtFilteredExtensionsInSpidering.setText(Main.getExcludedExtensionsInSpidering());
		txtFilteredExtensionsInSpidering.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String filteredExtensionsText = textWidget.getText();
				filteredExtensionsInSpidering = filteredExtensionsText;
			}
		});
		
		Label lblFilteredExtensionsInModel = new Label(container, SWT.NONE);
		lblFilteredExtensionsInModel.setText("Filtered Extensions on Model:");
		txtFilteredExtensionsInModel = new Text(container, SWT.BORDER);
		txtFilteredExtensionsInModel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtFilteredExtensionsInModel.setText(Main.getExcludedExtensionsInSpidering());
		txtFilteredExtensionsInModel.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text textWidget = (Text) e.getSource();
				String filteredExtensionsText = textWidget.getText();
				filteredExtensionsInModel = filteredExtensionsText;
			}
		});

		
		if(Main.getState() == 1){
			txtVulnPort.setEnabled(true);
			txtZapHost.setEnabled(true);
			txtZapPort.setEnabled(true);
			txtSpiderMillis.setEnabled(true);
			txtFilteredExtensionsInSpidering.setEnabled(true);
			txtFilteredExtensionsInModel.setEnabled(true);
		}else if(Main.getState() == 3){
			txtVulnPort.setEnabled(true);
			txtZapHost.setEnabled(false);
			txtZapPort.setEnabled(false);
			txtSpiderMillis.setEnabled(false);
			txtFilteredExtensionsInSpidering.setEnabled(false);
			txtFilteredExtensionsInModel.setEnabled(true);
		}else{
			txtVulnPort.setEnabled(true);
			txtZapHost.setEnabled(true);
			txtZapPort.setEnabled(true);
			txtSpiderMillis.setEnabled(true);
			txtFilteredExtensionsInSpidering.setEnabled(true);
			txtFilteredExtensionsInModel.setEnabled(true);
		}
		container.pack();
		return container;
	}

	// 
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(500, 350);
	}

	@Override
	protected void okPressed() {
		vulnPort = txtVulnPort.getText().trim();
		zapHost = txtZapHost.getText().trim();
		zapPort = txtZapPort.getText().trim();
		spiderMillis = txtSpiderMillis.getText().trim();
		filteredExtensionsInSpidering = txtFilteredExtensionsInSpidering.getText().trim();
		filteredExtensionsInModel = txtFilteredExtensionsInModel.getText().trim();
		String[] filteredExtsArrSpider = filteredExtensionsInSpidering.split("\\|");
		String[] filteredExtsArrSpiderModel = filteredExtensionsInModel.split("\\|");
		
		for(String s : filteredExtsArrSpider){
			if( !s.chars().allMatch(x -> Character.isLetterOrDigit(x)) ){
				System.out.println(s);
				MessageDialog.openError(getShell(), "Error", "Invalid extension on the spider filtered extension list.");
				return;
			}
		}
		
		for(String s : filteredExtsArrSpiderModel){
			if( !s.chars().allMatch(x -> Character.isLetterOrDigit(x)) ){
				System.out.println(s);
				MessageDialog.openError(getShell(), "Error", "Invalid extension on the model filtered extension list.");
				return;
			}
		}
		
		
		
		try{
			vulnPortInt = Integer.parseInt(vulnPort);
			zapPortInt = Integer.parseInt(zapPort);
			spiderMillisInt = Integer.parseInt(spiderMillis);
			if((vulnPortInt < 1 || vulnPortInt > 65535) || (zapPortInt < 1 || zapPortInt > 65535)){
				showPortError();
			}else{
				try {
					URI uri = new URI("http://"+zapHost+":"+zapPort);
					uri.getPort();
					uri.getHost();
					super.okPressed();
				} catch (URISyntaxException e) {
					MessageDialog.openError(getShell(), "Error", "You entered an invalid host, please check it out and try again.");
				}
				
			}
		}catch(NumberFormatException nfe){
			showPortError();
		}
		
	}
	
	protected boolean isResizable() {
	    return true;
	}
	
	private void showPortError(){
		MessageDialog.openError(getShell(), "Error!", "Port must be a numeric value between 1-65535");
	}


	public String getZapHost() {
		return zapHost;
	}

	public void setZapHost(String zapHost) {
		this.zapHost = zapHost;
	}

	public int getZapPortInt() {
		return zapPortInt;
	}

	public void setZapPortInt(int zapPortInt) {
		this.zapPortInt = zapPortInt;
	}

	public int getVulnPortInt() {
		return vulnPortInt;
	}

	public void setVulnPortInt(int vulnPortInt) {
		this.vulnPortInt = vulnPortInt;
	}

	public int getSpiderMillisInt() {
		return spiderMillisInt;
	}

	public void setSpiderMillisInt(int spiderMillisInt) {
		this.spiderMillisInt = spiderMillisInt;
	}
	
	public String getFilteredExtensionsInSpidering() {
		return filteredExtensionsInSpidering;
	}
	
	
	public void setFilteredExtensionsInSpidering(String filteredExtensions) {
		this.filteredExtensionsInSpidering = filteredExtensions;
	}
	
	public String getFilteredExtensionsInModel() {
		return filteredExtensionsInModel;
	}
	
	public Text getTxtFilteredExtensionsInModel() {
		return txtFilteredExtensionsInModel;
	}
	
	

}