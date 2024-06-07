package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JOptionPane;

import FormNhanVien.*;
import FormThuephong.DanhSachPhong;


public class Controller_ChuyenMan implements ActionListener {
	public DanhSachPhong ds;

	
	public Controller_ChuyenMan(DanhSachPhong ds) {
		this.ds = ds;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		//String checkBoxText = dn.btnRemember.getText();

		if (ac == "Loại Phòng") {
//			 Điền phần loại phòng vào
			System.out.println(" Chuyển màn Loại Phòng");
			LoaiPhong LP = new LoaiPhong();
			LP.setVisible(true);
			ds.dispose(); 
//				JOptionPane.showMessageDialog(ds, "Bạn chưa Nhập tài khoảng:");

			}else if (ac == "Dịch Vụ") {
				System.out.println(" CHuyển màn vào dịch vụ");
				QLDichVu QLDV = new QLDichVu(); // Tạo một JFrame mới
				QLDV.setVisible(true); // Hiển thị JFrame mới
				ds.dispose(); 
			}else if (ac == "Thống Kê Khách Hàng") {
				System.out.println(" Thống Kê Khách Hàng 2");
				ThongKeKhachHang TKKH = new ThongKeKhachHang(); // Tạo một JFrame mới
				TKKH.setVisible(true); // Hiển thị JFrame mới
				ds.dispose(); 
				//JOptionPane.showMessageDialog(dn, "Bạn chưa Nhập mk:");
			}else if (ac == "Thống Kê Chi Tiết") {
				System.out.println(" Thống Kê CHi Tiết");
				ThongKeChiTiet TKCT = new ThongKeChiTiet();

				TKCT.setVisible(true); // Hiển thị JFrame mới
				ds.dispose(); 
				//JOptionPane.showMessageDialog(dn, "Bạn chưa Nhập mk:");
			}else if (ac == "Thoát") {
				System.out.println("Thoát Chương Trình");
				ds.dispose(); 
				//JOptionPane.showMessageDialog(dn, "Bạn chưa Nhập mk:");
			} else if (ac == "Phòng") {
				System.out.println("Chuyển màn Phòng");
				new QLPhong();
				ds.dispose();
			}
		
	}

}
