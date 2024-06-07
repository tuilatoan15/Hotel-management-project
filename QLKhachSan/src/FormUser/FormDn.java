package FormUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.QLKSController_FormDn;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class FormDn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtUsername;
	public JPasswordField txtPassWord;
	public Object btnSignUp;
	public Object btnLogin;
	public JCheckBox btnRemember;

	public FormDn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ActionListener action = new QLKSController_FormDn(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login to System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(142, 11, 168, 22);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 414, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(28, 57, 65, 30);
		contentPane.add(lblNewLabel_1);

		txtUsername = new JTextField();
		txtUsername.setBounds(117, 62, 252, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setBounds(26, 114, 67, 14);
		contentPane.add(lblNewLabel_2);

		txtPassWord = new JPasswordField();
		txtPassWord.setBounds(117, 111, 252, 20);
		contentPane.add(txtPassWord);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 161, 414, 2);
		contentPane.add(separator_1);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(action);
		btnLogin.setBounds(83, 190, 89, 23);
		contentPane.add(btnLogin);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(action);

		btnSignUp.setBounds(256, 190, 89, 23);
		contentPane.add(btnSignUp);
		this.setVisible(true);
	}
}
