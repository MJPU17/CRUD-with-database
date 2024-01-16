package co.edu.unbosque.view;

import java.text.NumberFormat;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PopUpMessages {
	
	public PopUpMessages() {}
	
	public static String readOptions (String message,Object option[]) {
		Object dato=JOptionPane.showInputDialog(null,message,"Vehicle CRUD",JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
		return dato.toString();
	}
	
	public static void errorMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void informationMessage(JFrame view,String message) {
		JOptionPane.showMessageDialog(view, message, "Save", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int confirmMessage(String mensaje,JFrame vista) {
		return JOptionPane.showConfirmDialog(vista, mensaje);
	}
	
	public static boolean isInt(String num,JFrame view,String message) {
		try {
			Integer.parseInt(num);
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean isLong(String num,JFrame view,String message) {
		try {
			Long.parseLong(num);
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
