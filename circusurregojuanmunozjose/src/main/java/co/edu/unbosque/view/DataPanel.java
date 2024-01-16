package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class DataPanel extends JPanel{
	
	private JLabel eid,enumbercard,ename,estudylevel,lextra;
	private JTextField tid,tnumbercard,tname,tstudylevel,textra;
	private JButton bcreate,bupdate,bclear;
	private PanelImage pfondo;
	private JComboBox<String> cbopenmic;
	
	public DataPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		startingComponents();
		
		setVisible(true);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		eid=new JLabel("Enter id:");
		eid.setForeground(Color.white);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(eid,gbc);
		
		enumbercard=new JLabel("Enter number card:");
		enumbercard.setForeground(Color.white);
		gbc.gridy=1;
		add(enumbercard,gbc);
		
		ename=new JLabel("Enter name:");
		ename.setForeground(Color.white);
		gbc.gridy=2;
		add(ename,gbc);
		
		estudylevel=new JLabel("Enter level of study: ");
		estudylevel.setForeground(Color.white);
		gbc.gridy=3;
		add(estudylevel,gbc);
		
		lextra=new JLabel();
		lextra.setForeground(Color.white);
		gbc.gridy=4;
		add(lextra,gbc);
		
		tid=new JTextField();
		tid.setPreferredSize(new Dimension(200,30));
		tid.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=0;
		gbc.gridx=1;
		add(tid,gbc);
		
		tname=new JTextField();
		tname.setPreferredSize(new Dimension(200,30));
		tname.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=2;
		add(tname,gbc);
		
		tnumbercard=new JTextField();
		tnumbercard.setPreferredSize(new Dimension(200,30));
		tnumbercard.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=1;
		add(tnumbercard,gbc);
		
		tstudylevel=new JTextField();
		tstudylevel.setPreferredSize(new Dimension(200,30));
		tstudylevel.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=3;
		add(tstudylevel,gbc);
		
		textra=new JTextField();
		textra.setPreferredSize(new Dimension(200,30));
		textra.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=4;
		add(textra,gbc);
		
		cbopenmic=new JComboBox<>(new String[] {"YES","NO"});
		cbopenmic.setPreferredSize(new Dimension(200,30));
		cbopenmic.setBorder(new LineBorder(Color.black,2));
		cbopenmic.setForeground(Color.white);
		cbopenmic.setBackground(Color.red);
		add(cbopenmic,gbc);
		
		bcreate=new JButton("Create");
		bcreate.setActionCommand("SAVE");
		bcreate.setPreferredSize(new Dimension(150,30));
		bcreate.setBackground(Color.red);
		bcreate.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=5;
		add(bcreate,gbc);
		
		bupdate=new JButton("Update");
		bupdate.setActionCommand("UPDATE PERSON");
		bupdate.setPreferredSize(new Dimension(150,30));
		bupdate.setBackground(Color.red);
		bupdate.setBorder(new LineBorder(Color.black,2));
		bupdate.setVisible(false);
		add(bupdate,gbc);
		
		bclear=new JButton("Clear");
		bclear.setActionCommand("CLEAR");
		bclear.setPreferredSize(new Dimension(150,30));
		bclear.setBackground(Color.red);
		bclear.setBorder(new LineBorder(Color.black,2));
		gbc.gridx=0;
		add(bclear,gbc);
		
		pfondo=new PanelImage("src/images/Circo.jpg");
		pfondo.setOpaque(false);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.gridheight=6;
		gbc.fill=GridBagConstraints.BOTH;
		add(pfondo,gbc);
		
	}

	public JLabel getEid() {
		return eid;
	}

	public void setEid(JLabel eid) {
		this.eid = eid;
	}

	public JLabel getEnumbercard() {
		return enumbercard;
	}

	public void setEnumbercard(JLabel enumbercard) {
		this.enumbercard = enumbercard;
	}

	public JLabel getEname() {
		return ename;
	}

	public void setEname(JLabel ename) {
		this.ename = ename;
	}

	public JLabel getEstudylevel() {
		return estudylevel;
	}

	public void setEstudylevel(JLabel estudylevel) {
		this.estudylevel = estudylevel;
	}

	public JLabel getLextra() {
		return lextra;
	}

	public void setLextra(JLabel lextra) {
		this.lextra = lextra;
	}

	public JTextField getTid() {
		return tid;
	}

	public void setTid(JTextField tid) {
		this.tid = tid;
	}

	public JTextField getTnumbercard() {
		return tnumbercard;
	}

	public void setTnumbercard(JTextField tnumbercard) {
		this.tnumbercard = tnumbercard;
	}

	public JTextField getTstudylevel() {
		return tstudylevel;
	}

	public void setTstudylevel(JTextField tstudylevel) {
		this.tstudylevel = tstudylevel;
	}

	public JTextField getTextra() {
		return textra;
	}

	public void setTextra(JTextField textra) {
		this.textra = textra;
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

	public JButton getBclear() {
		return bclear;
	}

	public void setBclear(JButton bclear) {
		this.bclear = bclear;
	}

	public PanelImage getPfondo() {
		return pfondo;
	}

	public void setPfondo(PanelImage pfondo) {
		this.pfondo = pfondo;
	}
	
	public JTextField getTname() {
		return tname;
	}
	
	public void setTname(JTextField tname) {
		this.tname = tname;
	}

	public JComboBox<String> getCbopenmic() {
		return cbopenmic;
	}

	public void setCbopenmic(JComboBox<String> cbopenmic) {
		this.cbopenmic = cbopenmic;
	}
	
}
