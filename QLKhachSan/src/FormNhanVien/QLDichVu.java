package FormNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

public class QLDichVu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDichVu frame = new QLDichVu();
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
	public QLDichVu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 497);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khach San");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(335, 11, 238, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 915, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm Theo Tên");
		lblNewLabel_1.setBounds(23, 74, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(117, 71, 171, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm Kiếm");
		btnNewButton.setBounds(298, 70, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Loại Dịch Vụ", "Tên Dịch Vụ", "Đơn Giá"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 99, 508, 348);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Chỉnh Sửa Dịch Vụ");
		lblNewLabel_2.setBounds(674, 74, 179, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã Dịch Vụ");
		lblNewLabel_3.setBounds(552, 106, 87, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(649, 103, 245, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên Loại Dịch Vụ");
		lblNewLabel_3_1.setBounds(552, 161, 87, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(649, 158, 245, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Tên Dịch Vụ");
		lblNewLabel_3_1_1.setBounds(552, 213, 87, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Đơn Giá");
		lblNewLabel_3_1_2.setBounds(552, 266, 87, 14);
		contentPane.add(lblNewLabel_3_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(649, 210, 245, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(649, 263, 245, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("Thêm Dịch Vụ");
		btnNewButton_1.setBounds(552, 336, 128, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sửa Dịch Vụ");
		btnNewButton_1_1.setBounds(690, 336, 122, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Xoá Dịch Vụ");
		btnNewButton_1_2.setBounds(822, 336, 113, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_2 = new JButton("Thoát");
		btnNewButton_2.setBounds(704, 395, 89, 23);
		contentPane.add(btnNewButton_2);
		
	
		setVisible(true);
	}
}
