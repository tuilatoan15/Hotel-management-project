package FormUser;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.QLKSController_FormDk;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class FormDk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFild_tenDangNhap;
	public JTextField textField_hoTen;
	public JPasswordField textField_matKhau;
	public Object btnCancel;
	public Object btnDK;
	private JPasswordField textField_xacNhanMatKhau;
	private JTextField textField_sdt;

	public FormDk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ActionListener action = new QLKSController_FormDk(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 434, 278);
		contentPane.add(contentPane_1);

		JLabel lblSignUp = new JLabel("Đăng kí");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSignUp.setBounds(182, 11, 128, 22);
		contentPane_1.add(lblSignUp);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 414, 2);
		contentPane_1.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_1.setBounds(28, 57, 79, 30);
		contentPane_1.add(lblNewLabel_1);

		textFild_tenDangNhap = new JTextField();
		textFild_tenDangNhap.setColumns(10);
		textFild_tenDangNhap.setBounds(117, 62, 252, 20);
		contentPane_1.add(textFild_tenDangNhap);

		JLabel lblNewLabel_2 = new JLabel("STĐ");
		lblNewLabel_2.setBounds(26, 127, 67, 14);
		contentPane_1.add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 220, 414, 2);
		contentPane_1.add(separator_1);

		JButton btnDK = new JButton("Đăng kí");

		btnDK.addActionListener(action);
		btnDK.setBounds(50, 227, 89, 23);
		contentPane_1.add(btnDK);

		JButton btnCancel = new JButton("Thoát");
		btnCancel.addActionListener(action);
		btnCancel.setBounds(309, 227, 89, 23);
		contentPane_1.add(btnCancel);

		JLabel lblNewLabel_3 = new JLabel("Họ Tên");
		lblNewLabel_3.setBounds(27, 98, 54, 14);
		contentPane_1.add(lblNewLabel_3);

		textField_hoTen = new JTextField();
		textField_hoTen.setBounds(117, 93, 252, 20);
		contentPane_1.add(textField_hoTen);
		textField_hoTen.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Mật Khẩu");
		lblNewLabel_2_1.setBounds(28, 161, 67, 14);
		contentPane_1.add(lblNewLabel_2_1);

		textField_matKhau = new JPasswordField();
		textField_matKhau.setBounds(117, 158, 254, 20);
		contentPane_1.add(textField_matKhau);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(action);
		btnLogin.setBounds(182, 227, 89, 23);
		contentPane_1.add(btnLogin);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Xác Nhận");
		lblNewLabel_2_1_1.setBounds(28, 195, 79, 14);
		contentPane_1.add(lblNewLabel_2_1_1);
		
		textField_xacNhanMatKhau = new JPasswordField();
		textField_xacNhanMatKhau.setBounds(117, 192, 254, 20);
		contentPane_1.add(textField_xacNhanMatKhau);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(117, 124, 252, 20);
		contentPane_1.add(textField_sdt);
		this.setVisible(true);
	}

	public JTextField getTextFild_tenDangNhap() {
		return textFild_tenDangNhap;
	}

	

	public JTextField getTextField_sdt() {
		return textField_sdt;
	}

	public JTextField getTextField_hoTen() {
		return textField_hoTen;
	}

	public JPasswordField getTextField_matKhau() {
		return textField_matKhau;
	}

	public JPasswordField getTextField_xacNhanMatKhau() {
		return textField_xacNhanMatKhau;
	}
}
