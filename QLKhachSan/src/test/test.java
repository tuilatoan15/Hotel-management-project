package test;

import javax.swing.UIManager;
import FormUser.*;

public class test {
	public static void main(String[] args) {

		try {
			// nen dung 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 //new FormDk ();
			new FormDn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
