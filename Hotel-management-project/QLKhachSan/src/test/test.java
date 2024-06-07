package test;

import javax.swing.UIManager;

import FormThuephong.ChiTietHoaDon;
import FormThuephong.DanhSachPhong;
import FormThuephong.ThuePhong;
import FormUser.*;

public class test {
	public static void main(String[] args) {

		try {
			// nen dung 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 new FormDk ();
			//new FormDn();
//		new DanhSachPhong();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
