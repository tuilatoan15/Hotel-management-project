package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Data.DBConnection;
import FormUser.FormDk;
import FormUser.FormDn;

public class QLKSController_FormDk implements ActionListener {
	public FormDk dk;

	public QLKSController_FormDk(FormDk dk) {
		this.dk = dk;
	}

	@Override
	// Hàm sử lý sk hiện thị hộp thoại thông báo
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac == "Đăng kí") { // Nếu nút "Sign Up" được nhấn

			String tenDangNhap = dk.getTextFild_tenDangNhap().getText();
			String hoTen = dk.getTextField_hoTen().getText();
			String sdt = dk.getTextField_sdt().getText();
			String matKhau = new String(dk.getTextField_matKhau().getPassword());
			String matKhauXacNhan = new String(dk.getTextField_xacNhanMatKhau().getPassword());

			if (tenDangNhap.equals("") || sdt.equals("") || matKhau.equals("") || matKhauXacNhan.equals("")) {
				JOptionPane.showMessageDialog(dk, "Vui lòng điền đầy đủ thông tin.");
			} else if (matKhau.length() < 8) {
				JOptionPane.showMessageDialog(dk, "Vui lòng điền PassWord lớn hơn 8 kí tự");
			} else if ( !sdt.matches("0\\d{9}")) {
				JOptionPane.showMessageDialog(dk, "Vui lòng nhập số điện thoại gồm 10 số và bắt đầu bằng số 0");
			} else if (!matKhau.equals(matKhauXacNhan)) {
				JOptionPane.showMessageDialog(dk, "Mật khẩu và xác nhận mật khẩu không khớp.");
			} else {
				JOptionPane.showMessageDialog(dk, "Bạn đã đăng kí thành công");

				try (Connection connection = DBConnection.getConnection()) {

					String query = "INSERT INTO NguoiDung (TenDangNhap, HoTen, SDT, MatKhau) VALUES (?, ?, ?, ?)";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, tenDangNhap);
					preparedStatement.setString(2, hoTen);
					preparedStatement.setString(3, sdt);
					preparedStatement.setString(4, matKhau);
					preparedStatement.executeUpdate();
					JOptionPane.showMessageDialog(dk, "Đăng ký thành công!");
					connection.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(dk, "Đã xảy ra lỗi khi thực hiện đăng ký.");
					e1.printStackTrace();
				}
				// chạy màn mới
				FormDn dn = new FormDn(); // Tạo một JFrame mới
				dn.setVisible(true); // Hiển thị JFrame mới
				dk.dispose(); // Đóng JFrame hiện tại	
			}
//				// chạy màn mới
//				FormDn dn = new FormDn(); // Tạo một JFrame mới
//				dn.setVisible(true); // Hiển thị JFrame mới
//				dk.dispose(); // Đóng JFrame hiện tại
		}

		else if (ac == "Đăng nhập") {
			FormDn dn = new FormDn(); // Tạo một JFrame mới
			dn.setVisible(true); // Hiển thị JFrame mới
			dk.dispose();
		}

		else {
			dk.dispose();
		}
	}

}
