package FormThuephong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTietHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHoaDon frame = new ChiTietHoaDon();
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
	public ChiTietHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 784, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Họ Tên");
		lblNewLabel.setBounds(20, 60, 102, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNgyTr = new JLabel("Ngày Trả");
		lblNgyTr.setBounds(375, 60, 102, 24);
		contentPane.add(lblNgyTr);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setBounds(204, 60, 102, 24);
		contentPane.add(lblTui);
		
		JLabel lblGiPhngTheo = new JLabel("GIá Phòng Theo Giờ");
		lblGiPhngTheo.setBounds(568, 65, 146, 24);
		contentPane.add(lblGiPhngTheo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 95, 784, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hoá Đơn Chi Tiết");
		lblNewLabel_1.setBounds(20, 105, 92, 24);
		contentPane.add(lblNewLabel_1);
		// tạo table trong jcrollpane
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"S\u1ED1 H\u0110", "Ph\u00F2ng", "Ng\u00E0y Thu\u00EA", "Ng\u00E0y Tr\u1EA3", "T\u1ED5ng Th\u1EDDi Gian", "Ti\u1EC1n Ph\u00F2ng"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 140, 777, 150);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 308, 784, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chi Tiết Dịch vụ");
		lblNewLabel_1_1.setBounds(10, 321, 92, 24);
		contentPane.add(lblNewLabel_1_1);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"DV", "Ph\u00F2ng", "D\u1ECBch V\u1EE5", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Tu"
			}
		));
		
		
		JScrollPane scrollPane_1 = new JScrollPane(table_4);
		scrollPane_1.setBounds(10, 351, 440, 118);
		contentPane.add(scrollPane_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Thêm Dịch vụ");
		lblNewLabel_1_1_1.setBounds(460, 321, 92, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Dịch Vụ Cần Tìm");
		lblNewLabel_1_1_2.setBounds(460, 351, 92, 24);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setBounds(565, 355, 222, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(460, 386, 350, 140);
		contentPane.add(scrollPane_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.activeCaptionBorder);
		textPane.setBounds(10, 490, 442, 35);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Thanh Toán");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(347, 529, 103, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng Tiền Thanh Toán");
		lblNewLabel_2.setBounds(10, 536, 130, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ghi Chú");
		lblNewLabel_3.setBounds(10, 472, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		
		
		this.setVisible(true);
	}
}
