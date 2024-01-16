package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class PanelCRUD extends JPanel{
	
	private OptionPanel potion;
	private JPanel pcontainer;
	private DataPanel pdata;
	private ListPanel plist;
	
	public PanelCRUD() {
		setLayout(new BorderLayout());
		
		startingComponents();
		
		setVisible(false);
	}
	
	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		potion=new OptionPanel();
		add(potion,BorderLayout.NORTH);
		
		pcontainer=new JPanel(new GridBagLayout());
		pcontainer.setBackground(Color.DARK_GRAY);
		pdata=new DataPanel();
		plist=new ListPanel();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		pcontainer.add(pdata,gbc);
		pcontainer.add(plist,gbc);
		
		add(pcontainer,BorderLayout.CENTER);
	}

	public OptionPanel getPotion() {
		return potion;
	}

	public void setPotion(OptionPanel potion) {
		this.potion = potion;
	}

	public JPanel getPcontainer() {
		return pcontainer;
	}

	public void setPcontainer(JPanel pcontainer) {
		this.pcontainer = pcontainer;
	}

	public DataPanel getPdata() {
		return pdata;
	}

	public void setPdata(DataPanel pdata) {
		this.pdata = pdata;
	}

	public ListPanel getPlist() {
		return plist;
	}

	public void setPlist(ListPanel plist) {
		this.plist = plist;
	}
	

}
