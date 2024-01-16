package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class OptionPanel extends JPanel{
	
	private JButton bcreate,bupdate,bdelete,bshow,bmenu;
	
	public OptionPanel() {
		setLayout(new GridBagLayout());
		
		inicializarComponentes();
		
		setVisible(true);
	}

	private void inicializarComponentes() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		bcreate=new JButton("Create");
		bcreate.setActionCommand("CREATE");
		bcreate.setBackground(Color.red);
		bcreate.setBorder(new LineBorder(Color.black));
		bcreate.setFocusPainted(false);
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.ipady=10;
		gbc.fill=GridBagConstraints.BOTH;
		add(bcreate,gbc);
		
		bupdate=new JButton("Update");
		bupdate.setActionCommand("UPDATE");
		bupdate.setBackground(Color.red);
		bupdate.setBorder(new LineBorder(Color.black));
		bupdate.setFocusPainted(false);
		gbc.gridx=1;
		add(bupdate,gbc);
		
		bdelete=new JButton("Delete");
		bdelete.setActionCommand("DELETE");
		bdelete.setBackground(Color.red);
		bdelete.setBorder(new LineBorder(Color.black));
		bdelete.setFocusPainted(false);
		gbc.gridx=2;
		add(bdelete,gbc);
		
		bshow=new JButton("Show");
		bshow.setActionCommand("SHOW");
		bshow.setBackground(Color.red);
		bshow.setBorder(new LineBorder(Color.black));
		bshow.setFocusPainted(false);
		gbc.gridx=3;
		add(bshow,gbc);
		
		bmenu=new JButton("Menu");
		bmenu.setActionCommand("MENU");
		bmenu.setBackground(Color.red);
		bmenu.setBorder(new LineBorder(Color.black));
		bmenu.setFocusPainted(false);
		gbc.gridx=4;
		add(bmenu,gbc);
		
		
	}

	public JButton getBcreate() {
		return bcreate;
	}

	public void setBcreate(JButton bcreate) {
		this.bcreate = bcreate;
	}

	public JButton getBupdate() {
		return bupdate;
	}

	public void setBupdate(JButton bupdate) {
		this.bupdate = bupdate;
	}

	public JButton getBdelete() {
		return bdelete;
	}

	public void setBdelete(JButton bdelete) {
		this.bdelete = bdelete;
	}

	public JButton getBshow() {
		return bshow;
	}

	public void setBshow(JButton bshow) {
		this.bshow = bshow;
	}

	public JButton getBmenu() {
		return bmenu;
	}

	public void setBmenu(JButton bmenu) {
		this.bmenu = bmenu;
	}

}
