package FormUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.QLKSController_FormDk;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class FormDk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtUser;
	public JPasswordField textPass;
	public JTextField textField_email;
	public JPasswordField txtPassComfirm;
	public Object btnCancel;
	public Object btnDK;

	public FormDk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ActionListener action = new QLKSController_FormDk(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_1);

		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSignUp.setBounds(182, 11, 128, 22);
		contentPane_1.add(lblSignUp);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 414, 2);
		contentPane_1.add(separator);

		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(28, 57, 65, 30);
		contentPane_1.add(lblNewLabel_1);

		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(117, 62, 252, 20);
		contentPane_1.add(txtUser);

		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setBounds(26, 127, 67, 14);
		contentPane_1.add(lblNewLabel_2);

		textPass = new JPasswordField();
		textPass.setBounds(117, 124, 252, 20);
		contentPane_1.add(textPass);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 189, 414, 2);
		contentPane_1.add(separator_1);

		JButton btnDK = new JButton("Sign Up");

		btnDK.addActionListener(action);
		btnDK.setBounds(58, 212, 89, 23);
		contentPane_1.add(btnDK);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(action);
		btnCancel.setBounds(311, 212, 89, 23);
		contentPane_1.add(btnCancel);

		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(27, 98, 54, 14);
		contentPane_1.add(lblNewLabel_3);

		textField_email = new JTextField();
		textField_email.setBounds(117, 93, 252, 20);
		contentPane_1.add(textField_email);
		textField_email.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Comfirm");
		lblNewLabel_2_1.setBounds(28, 161, 67, 14);
		contentPane_1.add(lblNewLabel_2_1);

		txtPassComfirm = new JPasswordField();
		txtPassComfirm.setBounds(117, 158, 254, 20);
		contentPane_1.add(txtPassComfirm);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(action);
		btnLogin.setBounds(190, 212, 89, 23);
		contentPane_1.add(btnLogin);
		this.setVisible(true);
	}
}
