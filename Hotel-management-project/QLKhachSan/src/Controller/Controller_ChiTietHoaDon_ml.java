package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import FormThuephong.ChiTietHoaDon;
import FormThuephong.DanhSachPhong;

public class Controller_ChiTietHoaDon_ml implements MouseListener {
	private ChiTietHoaDon chiTietHoaDon;
	private DanhSachPhong ds;

	public Controller_ChiTietHoaDon_ml(ChiTietHoaDon chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
		this.ds= ds;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 if (e.getSource() == chiTietHoaDon.table_bangDichVu) {
			 chiTietHoaDon.xuLyMouseClicked();
		 }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}