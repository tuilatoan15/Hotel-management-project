package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Data.DBConnection;
import FormThuephong.DanhSachPhong;
import FormThuephong.ThuePhong;

public class Controller_DSPhong_ac implements ActionListener {
    private DanhSachPhong danhSachPhong;
    private int min_0 = 50000;
    private int min_1 = 100000;
    private int min_2 = 100000;
    private int min_3 = 500000;
   

    public Controller_DSPhong_ac(DanhSachPhong danhSachPhong) {
        this.danhSachPhong = danhSachPhong;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == danhSachPhong.btnNewButton_1) {
        	danhSachPhong.xuLySuKienSearch();
             // Gọi phương thức xử lý sự kiện từ DanhSachPhong
        } else if (e.getSource() == danhSachPhong.rdbtnNewRadioButton_0) {
        	danhSachPhong.xuLySuKienRadioButton_0(min_0, min_1);
            // Xử lý sự kiện của rdbtnNewRadioButton_0
        } else if (e.getSource() == danhSachPhong.rdbtnNewRadioButton_1) {
        	danhSachPhong.xuLySuKienRadioButton_1(min_1, min_2);
            // Xử lý sự kiện của rdbtnNewRadioButton_1
        } else if (e.getSource() == danhSachPhong.rdbtnNewRadioButton_2) {
        	danhSachPhong.xuLySuKienRadioButton_2(min_2, min_3);
            // Xử lý sự kiện của rdbtnNewRadioButton_2
        }
    }
}