package FormNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;

public class ThongKeChiTiet extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeChiTiet frame = new ThongKeChiTiet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel contentPane;
	private JTable table;

	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public ThongKeChiTiet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		
		 JSeparator separator = new JSeparator(JSeparator.VERTICAL);
	        separator.setBounds(466, 0, 2, 514); // X: 466, Y: 0, Width: 2, Height: 514
	        contentPane.add(separator);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống Kê Phòng");
		lblNewLabel.setBounds(135, 11, 123, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblThngKDch = new JLabel("Thống Kê Dịch Vụ");
		lblThngKDch.setBounds(638, 11, 123, 24);
		contentPane.add(lblThngKDch);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(117, 50, 57, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Ngày");
		comboBox.addItem("Tháng");
		comboBox.addItem("Năm");

		
		
		JLabel lblNewLabel_1 = new JLabel("Thống Kê Theo");
		lblNewLabel_1.setBounds(10, 54, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("Xác Nhận");
		btnNewButton.setBounds(35, 91, 89, 23);
		contentPane.add(btnNewButton);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SL Phòng",  "Tổng Tiền","Số Tiền Trung Bình",  "Thời Gian"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 125, 456, 293);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thống Kê Theo");
		lblNewLabel_1_1.setBounds(493, 54, 97, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(599, 50, 57, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("Ngày");
		comboBox_1.addItem("Tháng");
		comboBox_1.addItem("Năm");
		
		JButton btnNewButton_1 = new JButton("Xác Nhận");
		btnNewButton_1.setBounds(521, 91, 89, 23);
		contentPane.add(btnNewButton_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SL Dịch Vụ", "Tổng Tiền","Số Tiền Trung Bình", "Thời Gian"
			}
		));
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(466, 125, 456, 293);
		contentPane.add(scrollPane_1);
		
		JButton btnNewButton_2 = new JButton("Tổng Tiền Phòng");
		btnNewButton_2.setBounds(72, 441, 134, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Tổng Tiền Dịch Vụ");
		btnNewButton_2_1.setBounds(565, 441, 142, 23);
		contentPane.add(btnNewButton_2_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 34, 897, 2);
		contentPane.add(separator_1);
		
	
	
		setVisible(true);
	}
}
