package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import FormNhanVien.QLPhong;
import FormThuephong.DanhSachPhong;

public class PhongController implements ActionListener{
	public QLPhong viewQLPhong;
	
	public PhongController() {
		this.viewQLPhong = new QLPhong();
	}

	public PhongController(QLPhong viewQLPhong) {
		this.viewQLPhong = viewQLPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(viewQLPhong, "Ban vua nhan vao: "+cm);
		if (cm.equals("Thêm Phòng")) {
			this.viewQLPhong.xoaForm();
		} else if(cm.equals("Lưu")) {
			try {
				this.viewQLPhong.thucHienThemPhong();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(cm.equals("Sửa Phòng")) {
			this.viewQLPhong.hienThiPhongDangChon();
		} else if(cm.equals("Xoá Phòng")) {
			this.viewQLPhong.thucHienXoa();
		} else if(cm.equals("Thoát")) {
//			this.viewQLPhong.ThoatVaLuuDuLieu();
			viewQLPhong.setVisible(false);
			new DanhSachPhong();	
		} 
	}
	
}
