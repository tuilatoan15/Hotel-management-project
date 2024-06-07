package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FormNhanVien.QLDichVu;
import FormThuephong.DanhSachPhong;

public class QLDichVuController implements ActionListener{
	public QLDichVu viewDichVu;
	String luaChon;
	
	public QLDichVuController() {
		this.viewDichVu = new QLDichVu();
		this.luaChon = "";
	}

	public QLDichVuController(QLDichVu viewDichVu) {
		this.viewDichVu = viewDichVu;
		this.luaChon = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(viewDichVu, "Ban vua nhan vao: "+cm);
		
		if (cm.equals("Thêm Dịch Vụ")) {
			this.viewDichVu.xoaForm();
			this.viewDichVu.model.setLuaChon("Thêm Dịch Vụ");
		} else if(cm.equals("Lưu")) {
			try {
				this.viewDichVu.thucHienThemDichVu();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(cm.equals("Sửa Dịch Vụ")) {
			this.viewDichVu.hienThiThongTinDaChon();
		} else if(cm.equals("Xoá Dịch Vụ")) {
			this.viewDichVu.thucHienXoa();
		} else if(cm.equals("Thoát")) {
			this.viewDichVu.ThoatVaLuuDuLieu();
			viewDichVu.setVisible(false);
			new DanhSachPhong();		
		} 
	}

}
