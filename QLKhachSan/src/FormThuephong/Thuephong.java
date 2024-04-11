package FormThuephong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Tuoi;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
public class Thuephong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblTui;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JFormattedTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thuephong frame = new Thuephong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Thuephong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 457);
		setSize(400, 550);
		setLocationRelativeTo(contentPane);;		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Họ Tên");
		lblNewLabel.setBounds(25, 46, 108, 36);
		
		textField = new JTextField();
		textField.setBounds(143, 54, 194, 20);
		textField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		
		lblTui = new JLabel("Tuổi");
		lblTui.setBounds(25, 84, 108, 36);
		contentPane.add(lblTui);
		
		lblNewLabel_2 = new JLabel("Giới Tính");
		lblNewLabel_2.setBounds(25, 129, 108, 36);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(143, 136, 78, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nu");
		rdbtnNewRadioButton_1.setBounds(241, 136, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup btn_GioiTinh = new ButtonGroup();
		btn_GioiTinh.add(rdbtnNewRadioButton);
		btn_GioiTinh.add(rdbtnNewRadioButton_1);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại");
		lblSinThoi.setBounds(25, 176, 108, 36);
		contentPane.add(lblSinThoi);
		
		JLabel lblCnCcCng = new JLabel("Căn Cước Công Dân");
		lblCnCcCng.setBounds(25, 223, 108, 36);
		contentPane.add(lblCnCcCng);
		
		JLabel lblNgyBtu = new JLabel("Ngày Bắt Đầu thuê");
		lblNgyBtu.setBounds(25, 270, 108, 36);
		contentPane.add(lblNgyBtu);
		
	
		JLabel lblNgyDKin = new JLabel("Ngày Dự Kiến Trả");
		lblNgyDKin.setBounds(25, 317, 108, 36);
		contentPane.add(lblNgyDKin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 42, 334, 9);
		contentPane.add(separator);
		
		
		JComboBox comboBox = new JComboBox();
		ArrayList<Tuoi> listTuoi = Tuoi.getDSTuoi();
		comboBox.addItem("");

		for (Tuoi tuoi : listTuoi) {
			comboBox.addItem(tuoi.getSoTuoi());

		}
		

		
		comboBox.setBounds(143, 91, 78, 22);
		contentPane.add(comboBox);
		
		JLabel lblSNgi = new JLabel("Số Người");
		lblSNgi.setBounds(25, 366, 108, 36);
		contentPane.add(lblSNgi);
		
		JLabel lblTintCc = new JLabel("Tiền Đặt Cọc");
		lblTintCc.setBounds(25, 419, 108, 36);
		contentPane.add(lblTintCc);
		
		JButton btnNewButton = new JButton("Check In");
		btnNewButton.setBounds(248, 477, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 184, 194, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JFormattedTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 231, 194, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 427, 194, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(143, 278, 194, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(143, 325, 194, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(143, 374, 194, 20);
		contentPane.add(textField_6);
	}
}
