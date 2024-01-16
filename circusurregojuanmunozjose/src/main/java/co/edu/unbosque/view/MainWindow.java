package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	private MenuPanel pmenu;
	private PanelCRUD pcrud;
	private ShowPanel pshow;
	
	public MainWindow() {
		setTitle("Circus");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000,800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		
		startingComponents();
		
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		
		pmenu=new MenuPanel();
		getContentPane().add(pmenu,gbc);
		
		pcrud=new PanelCRUD();
		getContentPane().add(pcrud,gbc);
		
		pshow=new ShowPanel();
		getContentPane().add(pshow,gbc);
	}

	public MenuPanel getPmenu() {
		return pmenu;
	}

	public void setPmenu(MenuPanel pmenu) {
		this.pmenu = pmenu;
	}

	public PanelCRUD getPcrud() {
		return pcrud;
	}

	public void setPcrud(PanelCRUD pcrud) {
		this.pcrud = pcrud;
	}
	
	public ShowPanel getPshow() {
		return pshow;
	}
	
	public void setPshow(ShowPanel pshow) {
		this.pshow = pshow;
	}

}
