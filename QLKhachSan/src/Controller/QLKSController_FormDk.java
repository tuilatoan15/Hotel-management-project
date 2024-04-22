package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		if (ac.equals("Sign Up")) { // Nếu nút "Sign Up" được nhấn
			// Lấy thông tin từ các trường nhập liệu
			String userName = dk.txtUser.getText();
			String email = dk.textField_email.getText();
			String password = new String(dk.textPass.getPassword());
			String confirmPassword = new String(dk.txtPassComfirm.getPassword());

			if (userName.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("")) {
				JOptionPane.showMessageDialog(dk, "Vui lòng điền đầy đủ thông tin.");
			} else if (password.length() < 8) {
				JOptionPane.showMessageDialog(dk, "Vui lòng điền PassWord lớn hơn 8 kí tự");
			} else if (email.equals("") || !email.endsWith("@gmail.com")) {
				JOptionPane.showMessageDialog(dk, "Vui lòng nhập địa chỉ email hợp lệ (ví dụ: example@gmail.com).");
			}else if (!password.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(dk, "Mật khẩu và xác nhận mật khẩu không khớp.");
			}else {
				JOptionPane.showMessageDialog(dk, "Bạn đã đăng kí thành công");
				// điền thông tin vô file
				
				// chạy màn mới
				FormDn formDn = new FormDn(); // Tạo một JFrame mới
				formDn.setVisible(true); // Hiển thị JFrame mới
				dk.dispose(); // Đóng JFrame hiện tại
			}

		} else if(ac.equals("Login")) {
			FormDn formDn = new FormDn(); // Tạo một JFrame mới
			formDn.setVisible(true); // Hiển thị JFrame mới
			dk.dispose();
		}
		
		else {
			dk.dispose();
		}
	}

}
