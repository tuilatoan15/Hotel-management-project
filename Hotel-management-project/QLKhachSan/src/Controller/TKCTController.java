package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import FormNhanVien.ThongKeChiTiet;
import FormThuephong.DanhSachPhong;

public class TKCTController implements ActionListener {
    public ThongKeChiTiet viewThongKe;

    public TKCTController() {
        this.viewThongKe = new ThongKeChiTiet();
    }

    public TKCTController(ThongKeChiTiet viewThongKe) {
        this.viewThongKe = viewThongKe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
//        JOptionPane.showMessageDialog(viewThongKe, "Bạn vừa nhấn vào: " + cm);

        if ("Xác Nhận".equals(cm)) {
            this.viewThongKe.layThongTinKhiClickXacNhan();
        }
        
        else if ("Tổng Doanh Thu:".equals(cm)) {
        	this.viewThongKe.TinhTongDoanhThu();
        }
        
        else if("Thoát".equals(cm)) {
//        	JOptionPane.showMessageDialog(viewThongKe, "Bạn vừa nhấn vào: " + cm);
			this.viewThongKe.setVisible(false);
			new DanhSachPhong();
			
        }
        
        else if("Xuất File".equals(cm)) {
        	this.viewThongKe.inDanhSach();
        }
        
    }
}
