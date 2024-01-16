package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImage extends JPanel{
	
	private BufferedImage image;
	
	public PanelImage(String imagepath) {
		try {
			image=ImageIO.read(new File(imagepath));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(),getHeight(),this);
	}

}
