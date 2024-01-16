package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ListPanel extends JPanel{
	
	private JLabel elist;
	private JTextField tflist;
	private JTable tlist;
	private JScrollPane splist;
	private JButton bremove;
	private PanelImage pfondo;
	
	public ListPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		startingComponents();
		
		setVisible(false);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		elist=new JLabel("Type or choose:");
		elist.setForeground(Color.white);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(elist,gbc);
		
		tflist=new JTextField();
		tflist.setPreferredSize(new Dimension(200,30));
		tflist.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=1;
		add(tflist,gbc);
		
		tlist=new JTable();
		tlist.setBorder(new LineBorder(Color.black));
		String arr[][]=new String[6][6];
		DefaultTableModel mod=new DefaultTableModel(arr, new String[]{"o","o","o","o","o","o"});
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j]=i+"-"+j;
			}
		}
		tlist.setModel(mod);
		splist=new JScrollPane(tlist);
		splist.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=2;
		add(splist,gbc);
		
		bremove=new JButton("Eliminate");
		bremove.setActionCommand("ELIMINATE");
		bremove.setPreferredSize(new Dimension(150,30));
		bremove.setBackground(Color.red);
		bremove.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=3;
		add(bremove,gbc);
		
		pfondo=new PanelImage("src/images/Circo.jpg");
		pfondo.setOpaque(false);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=4;
		gbc.fill=GridBagConstraints.BOTH;
		add(pfondo,gbc);
		
	}
	
	

	public JLabel getElist() {
		return elist;
	}

	public void setElist(JLabel elist) {
		this.elist = elist;
	}

	public JTextField getTflist() {
		return tflist;
	}

	public void setTflist(JTextField tflist) {
		this.tflist = tflist;
	}

	public JTable getTlist() {
		return tlist;
	}

	public void setTlist(JTable tlist) {
		this.tlist = tlist;
	}

	public JScrollPane getSplist() {
		return splist;
	}

	public void setSplist(JScrollPane splist) {
		this.splist = splist;
	}

	public JButton getBremove() {
		return bremove;
	}

	public void setBremove(JButton bremove) {
		this.bremove = bremove;
	}
	
}
