package FormNhanVien;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Tuoi;
import java.awt.Font;



public class ThongKeKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldMa;
	private JTextField textFieldMon1;
	private JTextField textFieldMon2;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldMon3;
	private ButtonGroup btn_GioiTinh;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeKhachHang frame = new ThongKeKhachHang();
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
	public ThongKeKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 526);
		// gọi Action để xử lý

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuFile.add(menuOpen);

		JMenuItem menuClose = new JMenuItem("Close");
		menuFile.add(menuClose);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuEdit = new JMenuItem("Edit");
		menuFile.add(menuEdit);

		JMenu menuAbout = new JMenu("About");
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About me...");
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 39, 564, 2);
		contentPane.add(separator_1);

		JLabel lblDanhSanhSv = new JLabel("Danh Sanh Khach Hang");
		lblDanhSanhSv.setBounds(10, 41, 132, 31);
		contentPane.add(lblDanhSanhSv);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "Họ tên", "Tuổi", "Giới tính", "STD", "SDT", "Ngày Thuê ", "Ngày Trả",
						"Tổng tiền sử dụng" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(2, 67, 564, 362);
		contentPane.add(scrollPane);

		JLabel lblMaSinhVien_1 = new JLabel("Họ tên");
		lblMaSinhVien_1.setBounds(576, 85, 71, 31);
		contentPane.add(lblMaSinhVien_1);

		textFieldMa = new JTextField();
		textFieldMa.setBounds(652, 88, 148, 25);
		textFieldMa.setColumns(10);
		contentPane.add(textFieldMa);

		JLabel lblMaSinhVien_2 = new JLabel("Tuoi");
		lblMaSinhVien_2.setBounds(576, 160, 71, 31);
		contentPane.add(lblMaSinhVien_2);

		JLabel lblMaSinhVien_3 = new JLabel("Số Điện Thoại");
		lblMaSinhVien_3.setBounds(576, 202, 71, 31);
		contentPane.add(lblMaSinhVien_3);

		JLabel lblMaSinhVien_4 = new JLabel("Gioi Tinh");
		lblMaSinhVien_4.setBounds(576, 127, 71, 31);
		contentPane.add(lblMaSinhVien_4);

		JLabel lblMaSinhVien_5 = new JLabel("Ngày Thuê");
		lblMaSinhVien_5.setBounds(576, 298, 71, 31);
		contentPane.add(lblMaSinhVien_5);

		textFieldMon1 = new JTextField();
		textFieldMon1.setBounds(652, 301, 148, 25);
		textFieldMon1.setColumns(10);
		contentPane.add(textFieldMon1);

		JLabel lblMaSinhVien_6 = new JLabel("Ngày Trả");
		lblMaSinhVien_6.setBounds(576, 340, 71, 31);
		contentPane.add(lblMaSinhVien_6);

		textFieldMon2 = new JTextField();
		textFieldMon2.setBounds(652, 353, 148, 25);
		textFieldMon2.setColumns(10);
		contentPane.add(textFieldMon2);

		Label label = new Label("Thong tin Khach Hang");
		label.setBounds(609, 53, 62, 15);
		contentPane.add(label);

		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setBounds(652, 253, 148, 25);
		textFieldNgaySinh.setColumns(10);
		contentPane.add(textFieldNgaySinh);

		JLabel lblNgaySinh = new JLabel("Căn Cước Công Dân");
		lblNgaySinh.setBounds(576, 250, 71, 31);
		contentPane.add(lblNgaySinh);

		textFieldMon3 = new JTextField();
		textFieldMon3.setBounds(652, 404, 148, 25);
		textFieldMon3.setColumns(10);
		contentPane.add(textFieldMon3);

		JLabel lblMaSinhVien_8 = new JLabel("Số Người");
		lblMaSinhVien_8.setBounds(576, 401, 71, 31);
		contentPane.add(lblMaSinhVien_8);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(652, 131, 62, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Nu");
		rdbtnNewRadioButton_2.setBounds(712, 131, 96, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		// click giới tính đc 1 lần
		 btn_GioiTinh = new ButtonGroup();
		btn_GioiTinh.add(rdbtnNewRadioButton);
		btn_GioiTinh.add(rdbtnNewRadioButton_2);

		JButton btnThem = new JButton("them");
		btnThem.setBounds(829, 45, 74, 23);
		contentPane.add(btnThem);

		
		JButton btnSua = new JButton("Sua");
		btnSua.setBounds(829, 131, 74, 23);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xoa");
		btnXoa.setBounds(829, 206, 74, 23);
		contentPane.add(btnXoa);

		JButton btnLuu = new JButton("Luu");
		btnLuu.setBounds(829, 287, 74, 23);
		contentPane.add(btnLuu);

		JButton btnOk = new JButton("Thoát");
		btnOk.setBounds(829, 379, 74, 23);
		contentPane.add(btnOk);
		
		JComboBox comboBox = new JComboBox();
		
	
		ArrayList<Tuoi> listTuoi = Tuoi.getDSTuoi();
		comboBox.addItem("");

		for (Tuoi tuoi : listTuoi) {
			comboBox.addItem(tuoi.getSoTuoi());

		}
		comboBox.setBounds(662, 164, 70, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(652, 205, 148, 25);
		contentPane.add(textField);
		
		JSeparator separator_2 = new JSeparator(JSeparator.VERTICAL);
		separator_2.setBounds(819, 11, 1, 443);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Tên Khách Sạn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(246, 0, 224, 41);
		contentPane.add(lblNewLabel);
;

		
		this.setVisible(true);
	}
}
