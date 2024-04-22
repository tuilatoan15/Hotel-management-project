package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import FormUser.FormDk;
import FormUser.FormDn;

public class QLKSController_FormDn implements ActionListener {
	public FormDn dn;

	public QLKSController_FormDn(FormDn dn) {
		this.dn = dn;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		String username = dn.txtUsername.getText();
		String password = new String(dn.txtPassWord.getPassword());
		String ac = e.getActionCommand();
		//String checkBoxText = dn.btnRemember.getText();

		if (ac == "Login") {
			if (username.equals("")) {
				JOptionPane.showMessageDialog(dn, "Bạn chưa Nhập tài khoảng:");

			} else if (password.equals("")) {
				JOptionPane.showMessageDialog(dn, "Bạn chưa Nhập mk:");
			}
			if (username.equals("admin") && password.equals("admin")) {
				JOptionPane.showMessageDialog(dn, "Bạn đã đăng nhập thành công!");
//				if (dn.btnRemember.isSelected()) {
//				    JOptionPane.showMessageDialog(dn, "Tôi đã lưu thông tin Tài Khoảng của bạn");
//				}

				// thay bằng tên map kế
				FormDk formDk = new FormDk(); // Tạo một JFrame mới
				formDk.setVisible(true); // Hiển thị JFrame mới
				dn.dispose(); // Đóng JFrame hiện tại
			}

			if (!(username.equals("admin") && password.equals("admin")) && !password.equals("")
					&& !username.equals("")) {
				JOptionPane.showMessageDialog(dn, "Tên Đăng nhập hoặc mật khẩu bị sai:");

			}
		}

		if (ac == "Sign Up") {
			FormDk formDk = new FormDk(); // Tạo một JFrame mới
			formDk.setVisible(true); // Hiển thị JFrame mới
			dn.dispose(); // Đóng JFrame hiện tại
		}

	}
}
