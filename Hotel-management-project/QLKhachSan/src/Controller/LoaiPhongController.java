package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FormNhanVien.LoaiPhong;
import FormThuephong.DanhSachPhong;

public class LoaiPhongController implements ActionListener{
	LoaiPhong viewLoaiPhong;
	
	public LoaiPhongController() {
		this.viewLoaiPhong = new LoaiPhong();
	}

	public LoaiPhongController(LoaiPhong viewLoaiPhong) {
		this.viewLoaiPhong = viewLoaiPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
        if ("Thoát".equals(cm)) {
            viewLoaiPhong.setVisible(false);
            new DanhSachPhong();
        }
		
	}

}
