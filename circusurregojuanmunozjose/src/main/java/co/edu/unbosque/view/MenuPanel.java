package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;

public class MenuPanel extends JPanel{
	
	private JLabel lmenu;
	private JButton bclown,bcomedian, ball;
	private PanelImage pfondo;
	
	public MenuPanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);
		
		inicializarComponentes();
		
		setVisible(true);
		
	}
	
	
	public void inicializarComponentes() {
		
		GridBagConstraints gcb= new GridBagConstraints();
		LineBorder borde= new LineBorder(Color.white);
		Color rojo= new Color(237,28,36);
		
		
		lmenu= new JLabel("Circus");
		lmenu.setForeground(rojo);
		lmenu.setFont(new Font("ArcadeOut.ttf", ALLBITS, 66));
		gcb.gridx=0;
		gcb.gridy=0;
		gcb.gridwidth=3;
		gcb.gridheight=1;
		gcb.weightx=1.5;
		gcb.weighty=1.5;
		add(lmenu,gcb);
		
		bclown=new JButton("Clowns");
		bclown.setActionCommand("CLOWNS");
		bclown.setForeground(Color.WHITE);
		bclown.setFont(new Font("Arial",ALLBITS, 30));
		bclown.setBackground(rojo);
		bclown.setBorder(borde);
		bclown.setPreferredSize(new Dimension(165, 50));
		gcb.gridx=1;
		gcb.gridy=3;
		gcb.gridwidth=1;
		gcb.gridheight=1;
		gcb.weightx=1.5;
		gcb.weighty=1.5;
		add(bclown,gcb);
		
		bcomedian=new JButton("Comedians");
		bcomedian.setActionCommand("COMEDIANS");
		bcomedian.setForeground(Color.WHITE);
		bcomedian.setFont(new Font("Arial",ALLBITS, 30));
		bcomedian.setBackground(rojo);
		bcomedian.setPreferredSize(new Dimension(165, 50));
		bcomedian.setBorder(borde);
		gcb.gridx=1;
		gcb.gridy=4;
		gcb.gridwidth=1;
		gcb.gridheight=1;
		gcb.weightx=1.5;
		gcb.weighty=1.5;
		add(bcomedian,gcb);
		
		ball=new JButton("Show all");
		ball.setActionCommand("SHOW ALL");
		ball.setForeground(Color.white);
		ball.setFont(new Font("Arial",ALLBITS, 30));
		ball.setBackground(rojo);
		ball.setBorder(borde);
		ball.setPreferredSize(new Dimension(165, 50));
		gcb.gridx=1;
		gcb.gridy=5;
		gcb.weightx=1.5;
		gcb.weighty=1.5;
		add(ball,gcb);
		
		pfondo=new PanelImage("src/images/Circo.jpg");
		pfondo.setOpaque(false);
		gcb.gridx=0;
		gcb.gridy=0;
		gcb.gridwidth=3;
		gcb.gridheight=7;
		gcb.fill=GridBagConstraints.BOTH;
		add(pfondo,gcb);
		
	}


	public JLabel getLmenu() {
		return lmenu;
	}


	public void setLmenu(JLabel lmenu) {
		this.lmenu = lmenu;
	}


	public JButton getBclown() {
		return bclown;
	}


	public void setBclown(JButton bclown) {
		this.bclown = bclown;
	}


	public JButton getBcomedian() {
		return bcomedian;
	}


	public void setBcomedian(JButton bcomedian) {
		this.bcomedian = bcomedian;
	}


	public JButton getBall() {
		return ball;
	}


	public void setBall(JButton ball) {
		this.ball = ball;
	}


	public PanelImage getPfondo() {
		return pfondo;
	}


	public void setPfondo(PanelImage pfondo) {
		this.pfondo = pfondo;
	}
	
}
