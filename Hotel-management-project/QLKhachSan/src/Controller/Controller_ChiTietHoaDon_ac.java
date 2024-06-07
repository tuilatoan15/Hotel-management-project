package Controller;

import java.awt.event.ActionEvent;
import FormThuephong.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import Data.DBConnection;


// Lớp Controller_ChiTietHoaDon_ac kế thừa từ lớp BaseClass và triển khai ActionListener
public class Controller_ChiTietHoaDon_ac  implements ActionListener {
  
	private ChiTietHoaDon chiTietHoaDon;
 
   
    public Controller_ChiTietHoaDon_ac(ChiTietHoaDon chiTietHoaDon) {
    	
        this.chiTietHoaDon = chiTietHoaDon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        if (ac.equals("Thoát")) {
            chiTietHoaDon.dispose();
            new DanhSachPhong();
        } else if (ac.equals("Thanh Toán")) {
            // Gọi các phương thức đã được kế thừa từ lớp cha
        	chiTietHoaDon.actionPerformed();
        	chiTietHoaDon.tinhTongTien();
        	chiTietHoaDon.pushDataToDatabase();
            JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
        }
    }
}
