package FormThuephong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JDateChooser;

import Controller.Controller_ThuePhong;
import Controller.QLKSController_FormDn;
import model.Tuoi;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ThuePhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_hoTen;
	private JLabel lblTui;
	private JLabel lblNewLabel_2;
	private JTextField textField_soDienThoai;
	private JFormattedTextField textField_CCCD;
	private JTextField textField_tien;
	private JTextField textField_ngayThue;
	private JTextField textField_ngayTra;
	private String soPhong;
	public ButtonGroup btn_GioiTinh;
	private JTextField textField_tuoi;
	private JDateChooser dateChooserNgayDat;
	private JDateChooser dateChooserNgayTra;
	private SpinnerDateModel modelGioDat;
	private SpinnerDateModel modelGioTra;
	private Date ngayTra;
	private DanhSachPhong danhSachPhong;
	private ThuePhong thuePhong;

	public ThuePhong(String soPhong, DanhSachPhong danhSachPhong) {
		this.soPhong = soPhong;
		setTitle("Thuê Phòng");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 457);
		setSize(400, 550);
		setLocationRelativeTo(contentPane);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ActionListener action = new Controller_ThuePhong(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_phong = new JLabel("Phòng " + soPhong);
		lblNewLabel_phong.setBounds(143, 11, 138, 20);
		lblNewLabel_phong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel_phong);

		JLabel lblNewLabel = new JLabel("Họ Tên");
		lblNewLabel.setBounds(25, 46, 108, 36);

		textField_hoTen = new JTextField();
		textField_hoTen.setBounds(143, 54, 194, 20);
		textField_hoTen.setColumns(10);
		contentPane.add(lblNewLabel);
		contentPane.add(textField_hoTen);

		lblTui = new JLabel("Tuổi");
		lblTui.setBounds(25, 84, 108, 36);
		contentPane.add(lblTui);

		lblNewLabel_2 = new JLabel("Giới Tính");
		lblNewLabel_2.setBounds(25, 129, 108, 36);
		contentPane.add(lblNewLabel_2);

		JRadioButton rdbtnNewRadioButton_nam = new JRadioButton("Nam");
		rdbtnNewRadioButton_nam.setBounds(143, 136, 78, 23);
		rdbtnNewRadioButton_nam.addActionListener(action);
		contentPane.add(rdbtnNewRadioButton_nam);

		JRadioButton rdbtnNewRadioButton_nu = new JRadioButton("Nữ");
		rdbtnNewRadioButton_nu.setBounds(241, 136, 109, 23);
		rdbtnNewRadioButton_nu.addActionListener(action);
		contentPane.add(rdbtnNewRadioButton_nu);

		btn_GioiTinh = new ButtonGroup();

		btn_GioiTinh.add(rdbtnNewRadioButton_nam);
		btn_GioiTinh.add(rdbtnNewRadioButton_nu);

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

		JLabel lblTintCc = new JLabel("Tiền Đặt Cọc");
		lblTintCc.setBounds(25, 364, 108, 36);
		contentPane.add(lblTintCc);

	
			

		textField_soDienThoai = new JTextField();
		textField_soDienThoai.setBounds(143, 184, 194, 20);
		textField_soDienThoai.setColumns(10);
		contentPane.add(textField_soDienThoai);

		textField_CCCD = new JFormattedTextField();
		textField_CCCD.setBounds(143, 231, 194, 20);
		textField_CCCD.setColumns(10);
		contentPane.add(textField_CCCD);

		textField_tien = new JTextField();
		textField_tien.setBounds(143, 374, 194, 20);
		textField_tien.setColumns(10);
		contentPane.add(textField_tien);

		dateChooserNgayDat = new JDateChooser();
		dateChooserNgayDat.setBounds(229, 278, 108, 20);
		contentPane.add(dateChooserNgayDat);
		Calendar ngayHienTai = Calendar.getInstance();

		// Đặt ngày hiện tại cho JDateChooser
		dateChooserNgayDat.setDate(ngayHienTai.getTime());

		modelGioDat = new SpinnerDateModel();
		JSpinner spinnerGioDat = new JSpinner(modelGioDat);
		spinnerGioDat.setBounds(143, 278, 80, 20);
		JSpinner.DateEditor editorGioDat = new JSpinner.DateEditor(spinnerGioDat, "HH:mm");
		spinnerGioDat.setEditor(editorGioDat);
		contentPane.add(spinnerGioDat); // Thêm spinnerGioDat vào contentPane

		dateChooserNgayTra = new JDateChooser();
		dateChooserNgayTra.setBounds(229, 325, 108, 20);
		contentPane.add(dateChooserNgayTra);


		// Khởi tạo SpinnerDateModel cho giờ dự kiến trả
		modelGioTra = new SpinnerDateModel();
		JSpinner spinnerGioTra = new JSpinner(modelGioTra);
		spinnerGioTra.setBounds(143, 325, 80, 20);
		JSpinner.DateEditor editorGioTra = new JSpinner.DateEditor(spinnerGioTra, "HH:mm");
		spinnerGioTra.setEditor(editorGioTra);
		
//		});

		contentPane.add(spinnerGioTra); // Thêm spinnerGioTra vào contentPane

		textField_tuoi = new JTextField();
		textField_tuoi.setBounds(143, 92, 194, 20);
		textField_tuoi.setColumns(10);
		contentPane.add(textField_tuoi);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setBounds(35, 415, 89, 23);
		btnNewButton_1.addActionListener(action);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Đặt Phòng");
		btnNewButton.setBounds(250, 415, 89, 23);
		btnNewButton.addActionListener(action);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// dispose();
				updateNgayTra();
				 danhSachPhong.dispose();
			}
		});

	}
	private void updateNgayTra() {
	    // Cập nhật giá trị ngayDat từ dateChooserNgayDat và modelGioDat
	    Date dateDat = (Date) modelGioDat.getValue();
	    Calendar calendarDat = Calendar.getInstance();
	    calendarDat.setTime(dateDat);

	    Calendar ngayDatCalendar = dateChooserNgayDat.getCalendar();
	    ngayDatCalendar.set(Calendar.HOUR_OF_DAY, calendarDat.get(Calendar.HOUR_OF_DAY));
	    ngayDatCalendar.set(Calendar.MINUTE, calendarDat.get(Calendar.MINUTE));
	    ngayDatCalendar.set(Calendar.SECOND, calendarDat.get(Calendar.SECOND));

	    Date ngayDat = ngayDatCalendar.getTime();

	    // Cập nhật giá trị ngayTra từ dateChooserNgayTra và modelGioTra
	    Date dateTra = (Date) modelGioTra.getValue();
	    Calendar calendarTra = Calendar.getInstance();
	    calendarTra.setTime(dateTra);

	    Calendar ngayTraCalendar = dateChooserNgayTra.getCalendar();
	    ngayTraCalendar.set(Calendar.HOUR_OF_DAY, calendarTra.get(Calendar.HOUR_OF_DAY));
	    ngayTraCalendar.set(Calendar.MINUTE, calendarTra.get(Calendar.MINUTE));
	    ngayTraCalendar.set(Calendar.SECOND, calendarTra.get(Calendar.SECOND));

	    ngayTra = ngayTraCalendar.getTime();
	}


	public String getSoPhong() {
		return soPhong;
	}

	public JTextField getTextField_hoTen() {
		return textField_hoTen;
	}

	public JTextField getTextField_soDienThoai() {
		return textField_soDienThoai;
	}

	public JFormattedTextField getTextField_CCCD() {
		return textField_CCCD;
	}

	public JTextField getTextField_tien() {
		return textField_tien;
	}

	public ButtonGroup getBtn_GioiTinh() {
		return btn_GioiTinh;
	}

	public JTextField getTextField_tuoi() {
		return textField_tuoi;
	}

	public Date getNgayDat() {
		return dateChooserNgayDat.getDate();
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public ThuePhong(DanhSachPhong danhSachPhong) throws HeadlessException {
		this.danhSachPhong = danhSachPhong;
	}

	public DanhSachPhong getDanhSachPhong() {
		return danhSachPhong;
	}
}
