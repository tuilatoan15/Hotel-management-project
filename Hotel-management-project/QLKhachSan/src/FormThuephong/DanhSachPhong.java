package FormThuephong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Controller.*;
import Data.DBConnection;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class DanhSachPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnNewButton_1;

	public JRadioButton rdbtnNewRadioButton_2;
	public JRadioButton rdbtnNewRadioButton_1;
	public JRadioButton rdbtnNewRadioButton_0;
	private JComboBox<Integer> comboBox;
	private JComboBox<String> comboBox_1;
	private String comboBoxString;
	private Integer comboBoxSoNguoi;
	private JDateChooser dateChooserNgayTra;
	private SpinnerDateModel modelGioTra;
	private JSpinner spinnerGioTra;
	private JPanel panel;
	private MouseListener ml;
	private JScrollPane scrollPane1;
	private String filterLoaiPhong = " ";
	public ButtonGroup btn_giaLoc;
	protected int maxPrice;
	protected int minPrice;
	private boolean isSearchClicked = false;
	private java.sql.Timestamp ngayTra;
	private java.sql.Timestamp ngayTraPhong;
	private int trangThai;

	public DanhSachPhong() {
		this.panel = new JPanel();
		setTitle("Chương Trình Quản Lí Khách Sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		MouseListener ml = new Controller_DSPhong_ml(this);
		 ActionListener ac = (ActionListener) new Controller_DSPhong_ac(this);
		ActionListener action = new Controller_ChuyenMan(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(action);
		btnNewButton.setBounds(27, 436, 89, 23);
		contentPane.add(btnNewButton);

		JSeparator separator_2_1_2_1 = new JSeparator();
		separator_2_1_2_1.setBounds(-2, 342, 140, 0);
		contentPane.add(separator_2_1_2_1);

		JLabel lblNewLabel = new JLabel("Khách Sạn 2TL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(375, 16, 282, 30);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(-2, 56, 776, 0);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator(JSeparator.VERTICAL);
		separator_1.setBounds(140, 54, 2, 405);
		contentPane.add(separator_1);

		JLabel lblNewLabel_4 = new JLabel("50.000-100.000");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(800, 229, 99, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("100.000-200.000");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(800, 270, 99, 14);
		contentPane.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("200.000 trở lên");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(800, 306, 99, 14);
		contentPane.add(lblNewLabel_4_2);

		rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(903, 300, 21, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(ac);

		rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(903, 265, 21, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(ac);

		rdbtnNewRadioButton_0 = new JRadioButton("");
		rdbtnNewRadioButton_0.setBounds(903, 225, 21, 23);
		contentPane.add(rdbtnNewRadioButton_0);
		rdbtnNewRadioButton_0.addActionListener(ac);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_0);

		// Lắng nghe sự kiện khi nút radio 1 được chọn

		JLabel lblNewLabel_3_1_1 = new JLabel("Loại Phòng");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1_1.setBounds(830, 350, 69, 22);
		contentPane.add(lblNewLabel_3_1_1);

		comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(818, 383, 81, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addItem(" ");
		comboBox_1.addItem("Thương Gia");
		comboBox_1.addItem("Cao Cấp");
		comboBox_1.addItem("Bình Dân");

		btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(818, 436, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(ac);
		

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3, 7, 7));

		scrollPane1 = new JScrollPane(panel);
		scrollPane1.setBounds(140, 54, 650, 405);
		contentPane.add(scrollPane1);

		JLabel lblNewLabel_13 = new JLabel("Lọc Theo");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(816, 55, 89, 30);
		contentPane.add(lblNewLabel_13);

		JSeparator separator_23 = new JSeparator();
		separator_23.setBounds(140, 117, 2, 1);
		contentPane.add(separator_23);

		JLabel lblNewLabel_2 = new JLabel("Giá");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(830, 192, 54, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Thời Gian ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(794, 99, 70, 30);
		contentPane.add(lblNewLabel_3);

		dateChooserNgayTra = new JDateChooser();
		dateChooserNgayTra.setBounds(800, 140, 127, 23);
		contentPane.add(dateChooserNgayTra);

		modelGioTra = new SpinnerDateModel();
		spinnerGioTra = new JSpinner(modelGioTra);
		JSpinner.DateEditor editorGioTra = new JSpinner.DateEditor(spinnerGioTra, "HH:mm");
		spinnerGioTra.setEditor(editorGioTra);
		spinnerGioTra.setBounds(854, 103, 80, 23);
		contentPane.add(spinnerGioTra);

		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(784, 96, 156, 2);
		contentPane.add(separator_2_2);

		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setBounds(784, 174, 156, 7);
		contentPane.add(separator_2_3);

		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setBounds(784, 340, 156, 2);
		contentPane.add(separator_2_4);

		JSeparator separator_2_5 = new JSeparator();
		separator_2_5.setBounds(784, 423, 140, 2);
		contentPane.add(separator_2_5);

		JSeparator separator_2_6 = new JSeparator();
		separator_2_6.setBounds(784, 54, 156, 2);
		contentPane.add(separator_2_6);
		
		vePhong(panel, new Controller_DSPhong_ml(DanhSachPhong.this), filterLoaiPhong, 0, 0);

		JButton btnNewButton_2 = new JButton("Phòng");
		btnNewButton_2.addActionListener(action);
		btnNewButton_2.setBounds(-2, 54, 140, 76);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Loại Phòng");
		btnNewButton_3.addActionListener(action);
		btnNewButton_3.setBounds(-2, 129, 140, 76);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("Thống Kê Khách Hàng");

		btnNewButton_5.addActionListener(action);

		btnNewButton_5.setBounds(-2, 279, 140, 76);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Thống Kê Chi Tiết");
		btnNewButton_6.addActionListener(action);
		btnNewButton_6.setBounds(-2, 354, 140, 76);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Dịch Vụ");
		btnNewButton_7.addActionListener(action);
		btnNewButton_7.setBounds(-2, 204, 140, 76);
		contentPane.add(btnNewButton_7);
		
	}
// het view
	private void vePhong(JPanel panel, MouseListener ml, String filterLoaiPhong, double minPrice,
			double maxPrice) {
		try (Connection connection = DBConnection.getConnection()) {
			// Bắt đầu xây dựng câu truy vấn SQL
			String sql = "SELECT * FROM Phong";
			String priceCondition = locGia(minPrice, maxPrice); // Điều kiện lọc giá phòng
			if (!filterLoaiPhong.trim().isEmpty() && !filterLoaiPhong.equals(" ")) {
				// Nếu có lọc theo tên phòng, thêm điều kiện vào câu truy vấn
				sql += " WHERE TenPhong = ?";
				if (!priceCondition.isEmpty()) {
					// Nếu có điều kiện lọc giá phòng, thêm vào câu truy vấn với AND
					sql += " AND " + priceCondition;
				}
			} else if (!priceCondition.isEmpty()) {
				// Nếu chỉ có điều kiện lọc giá phòng mà không có lọc theo tên phòng
				sql += " WHERE " + priceCondition;
			}

			// Tiếp tục xử lý câu truy vấn và hiển thị dữ liệu tương tự như trước đó
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				int paramIndex = 1;
				if (!filterLoaiPhong.trim().isEmpty() && !filterLoaiPhong.equals(" ")) {
					preparedStatement.setString(paramIndex++, filterLoaiPhong);
				}
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.isBeforeFirst()) {
						panel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 cột với khoảng cách ngang và dọc là 10px
						while (resultSet.next()) {
							String soPhong = resultSet.getString("SoPhong");
							String tenPhong = resultSet.getString("TenPhong");
							double gia = resultSet.getDouble("Gia");
							int trangThai = resultSet.getInt("Trangthai");
							ngayTraPhong = resultSet.getTimestamp("NgayTra");
							if (trangThai == 1) {
								JPanel wrapperPanel = new JPanel();
								wrapperPanel.setLayout(new GridLayout(4, 1)); // 4 hàng, 1 cột
								wrapperPanel.setPreferredSize(new Dimension(100, 100)); // Điều chỉnh kích thước nếu cần

								JLabel label = new JLabel("Phòng " + soPhong);
								JLabel giaLabel = new JLabel("Giá: " + gia);
								JLabel tenPhongLabel = new JLabel("Tên phòng: " + tenPhong);
								JLabel ngayTraPhongLabel = new JLabel("Ngày Trả: " + ngayTraPhong);

								label.setHorizontalAlignment(SwingConstants.CENTER);
								giaLabel.setHorizontalAlignment(SwingConstants.CENTER);
								tenPhongLabel.setHorizontalAlignment(SwingConstants.CENTER);
								ngayTraPhongLabel.setHorizontalAlignment(SwingConstants.CENTER);

								wrapperPanel.add(label);
								wrapperPanel.add(giaLabel);
								wrapperPanel.add(tenPhongLabel);
								wrapperPanel.add(ngayTraPhongLabel);

								// Xác định màu nền dựa trên trạng thái phòng
								if (trangThai == 0) {
									wrapperPanel.setBackground(new Color(5, 254, 42));
								} else if (trangThai == 1) {
									wrapperPanel.setBackground(new Color(255, 49, 85));
								} else if (trangThai == 2) {
									wrapperPanel.setBackground(new Color(187, 246, 103));
								}
								wrapperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

								panel.add(wrapperPanel);
								wrapperPanel.addMouseListener(ml);
								wrapperPanel.setName(String.valueOf(soPhong));

								
							} else {
								JPanel wrapperPanel = new JPanel();
								wrapperPanel.setLayout(new BorderLayout());
								wrapperPanel.setPreferredSize(new Dimension(100, 70)); // Kích thước ưu tiên
								wrapperPanel.setMaximumSize(new Dimension(100, 70)); // Kích thước tối đa
								wrapperPanel.setMinimumSize(new Dimension(100, 70)); // Kích thước tối thiểu

								JLabel label = new JLabel("Phòng " + soPhong);
								JLabel giaLabel = new JLabel("Giá: " + gia);
								JLabel tenPhongLabel = new JLabel("Tên phòng: " + tenPhong);

								label.setHorizontalAlignment(SwingConstants.CENTER);
								giaLabel.setHorizontalAlignment(SwingConstants.CENTER);
								tenPhongLabel.setHorizontalAlignment(SwingConstants.CENTER);

								wrapperPanel.add(label, BorderLayout.NORTH);
								wrapperPanel.add(giaLabel, BorderLayout.CENTER);
								wrapperPanel.add(tenPhongLabel, BorderLayout.SOUTH);

								// Xác định màu nền dựa trên trạng thái phòng
								if (trangThai == 0) {
									wrapperPanel.setBackground(new Color(5, 254, 42));
								} else if (trangThai == 1) {
									wrapperPanel.setBackground(new Color(255, 49, 85));
								} else if (trangThai == 2) {
									wrapperPanel.setBackground(Color.blue);
								}
								wrapperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

								panel.add(wrapperPanel);
								wrapperPanel.addMouseListener(ml);
								wrapperPanel.setName(String.valueOf(soPhong));
							}
						}
						setVisible(true);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		panel.revalidate();
		panel.repaint();
	}

	private String locGia(double minPrice, double maxPrice) {
		String condition = "";
		if (minPrice > 0 && maxPrice > 0) {
			condition = "Gia BETWEEN " + minPrice + " AND " + maxPrice;
		} else if (minPrice > 0) {
			condition = "Gia >= " + minPrice;
		} else if (maxPrice > 0) {
			condition = "Gia <= " + maxPrice;
		}
		return condition;
	}

	// lọc phòng
	private void locPhong(JPanel panel, MouseListener ml, String filterLoaiPhong, double minPrice,
			double maxPrice, java.sql.Timestamp selectedDate) {

		panel.removeAll(); // Xóa các panel phòng trước đó
		panel.revalidate();
		panel.repaint();

		try (Connection connection = DBConnection.getConnection()) {
			// Bắt đầu xây dựng câu truy vấn SQL
			StringBuilder sql = new StringBuilder("SELECT * FROM Phong WHERE ");
			List<String> conditions = new ArrayList<>();
			List<Object> parameters = new ArrayList<>();

			// Điều kiện lọc ngày trả
			conditions.add("(NgayTra < ? OR Trangthai = 0)");
			parameters.add(selectedDate);

			// Điều kiện lọc tên phòng
			if (!filterLoaiPhong.trim().isEmpty() && !filterLoaiPhong.equals(" ")) {
				conditions.add("TenPhong = ?");
				parameters.add(filterLoaiPhong);
			}

			// Điều kiện lọc giá phòng
			String priceCondition = locGia(minPrice, maxPrice);
			if (!priceCondition.isEmpty()) {
				conditions.add(priceCondition);
			}

			// Kết hợp các điều kiện vào câu truy vấn
			sql.append(String.join(" AND ", conditions));

			// Chuẩn bị câu truy vấn SQL
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
				for (int i = 0; i < parameters.size(); i++) {
					preparedStatement.setObject(i + 1, parameters.get(i));
				}

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.isBeforeFirst()) {
						panel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 cột với khoảng cách ngang và dọc là 10px
						while (resultSet.next()) {
							String soPhong = resultSet.getString("SoPhong");
							String tenPhong = resultSet.getString("TenPhong");
							double gia = resultSet.getDouble("Gia");
							int trangThai = resultSet.getInt("Trangthai");
							java.sql.Timestamp ngayTraPhong = resultSet.getTimestamp("NgayTra");

							if (trangThai == 1) {
								JPanel wrapperPanel = new JPanel();
								wrapperPanel.setLayout(new GridLayout(4, 1)); // 4 hàng, 1 cột
								wrapperPanel.setPreferredSize(new Dimension(100, 100)); // Điều chỉnh kích thước nếu cần

								JLabel label = new JLabel("Phòng " + soPhong);
								JLabel giaLabel = new JLabel("Giá: " + gia);
								JLabel tenPhongLabel = new JLabel("Tên phòng: " + tenPhong);
								JLabel ngayTraPhongLabel = new JLabel("Ngày Trả: " + ngayTraPhong);

								label.setHorizontalAlignment(SwingConstants.CENTER);
								giaLabel.setHorizontalAlignment(SwingConstants.CENTER);
								tenPhongLabel.setHorizontalAlignment(SwingConstants.CENTER);
								ngayTraPhongLabel.setHorizontalAlignment(SwingConstants.CENTER);

								wrapperPanel.add(label);
								wrapperPanel.add(giaLabel);
								wrapperPanel.add(tenPhongLabel);
								wrapperPanel.add(ngayTraPhongLabel);

								// Xác định màu nền dựa trên trạng thái phòng
								if (trangThai == 0) {
									wrapperPanel.setBackground(new Color(5, 254, 42));
								} else if (trangThai == 1) {
									wrapperPanel.setBackground(new Color(255, 49, 85));
								} else if (trangThai == 2) {
									wrapperPanel.setBackground(new Color(187, 246, 103));
								}
								wrapperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

								panel.add(wrapperPanel);
								wrapperPanel.addMouseListener(ml);
								wrapperPanel.setName(String.valueOf(soPhong));

								// Xác định màu nền dựa trên trạng thái phòng
								if (trangThai == 0) {
									wrapperPanel.setBackground(new Color(5, 254, 42));
								} else if (trangThai == 1) {
									wrapperPanel.setBackground(new Color(255, 49, 85));
								} else if (trangThai == 2) {
									wrapperPanel.setBackground(new Color(187, 246, 103));
								}
								wrapperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

								panel.add(wrapperPanel);
								wrapperPanel.addMouseListener(ml);
								wrapperPanel.setName(String.valueOf(soPhong));

							} else {
								JPanel wrapperPanel = new JPanel();
								wrapperPanel.setLayout(new BorderLayout());
								wrapperPanel.setPreferredSize(new Dimension(100, 70)); // Kích thước ưu tiên
								wrapperPanel.setMaximumSize(new Dimension(100, 70)); // Kích thước tối đa
								wrapperPanel.setMinimumSize(new Dimension(100, 70)); // Kích thước tối thiểu

								JLabel label = new JLabel("Phòng " + soPhong);
								JLabel giaLabel = new JLabel("Giá: " + gia);
								JLabel tenPhongLabel = new JLabel("Tên phòng: " + tenPhong);

								label.setHorizontalAlignment(SwingConstants.CENTER);
								giaLabel.setHorizontalAlignment(SwingConstants.CENTER);
								tenPhongLabel.setHorizontalAlignment(SwingConstants.CENTER);

								wrapperPanel.add(label, BorderLayout.NORTH);
								wrapperPanel.add(giaLabel, BorderLayout.CENTER);
								wrapperPanel.add(tenPhongLabel, BorderLayout.SOUTH);

								// Xác định màu nền dựa trên trạng thái phòng
								if (trangThai == 0) {
									wrapperPanel.setBackground(new Color(5, 254, 42));
								} else if (trangThai == 1) {
									wrapperPanel.setBackground(new Color(255, 49, 85));
								} else if (trangThai == 2) {
									wrapperPanel.setBackground(Color.blue);
								}
								wrapperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

								panel.add(wrapperPanel);
								wrapperPanel.addMouseListener(ml);
								wrapperPanel.setName(String.valueOf(soPhong));
							}
						}

						setVisible(true);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		panel.revalidate();
		panel.repaint();
	}

// lấy ngày trả sql
	public void locNgay(String soPhong) {
		String sql = "SELECT NgayTra, TrangThai FROM Phong WHERE SoPhong = ?";
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, soPhong);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					java.sql.Timestamp ngayTra = resultSet.getTimestamp("NgayTra");
					int trangThai = resultSet.getInt("TrangThai");
					System.out.println("Ngày trả các phòng: " + ngayTra);
					System.out.println("Trạng Thái: " + trangThai);
				} else {
					System.out.println("Không tìm thấy thông tin cho phòng " + soPhong);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xuLySuKienSearch() {
	    filterLoaiPhong = (String) comboBox_1.getSelectedItem();
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(0, 3, 7, 7));
	    scrollPane1.setViewportView(panel);

	    Date selectedDate = dateChooserNgayTra.getDate();
	    if (selectedDate != null) {
	        Date selectedTime = (Date) spinnerGioTra.getValue();
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(selectedDate);
	        calendar.set(Calendar.HOUR_OF_DAY, selectedTime.getHours());
	        calendar.set(Calendar.MINUTE, selectedTime.getMinutes());
	        java.sql.Timestamp timestampSelected = new java.sql.Timestamp(calendar.getTimeInMillis());

	        locPhong(panel, ml, filterLoaiPhong, minPrice, maxPrice, timestampSelected);
	    } else {
	    	vePhong(panel, ml, filterLoaiPhong, minPrice, maxPrice);
	    }
	}

	public void xuLySuKienRadioButton_0(int min, int max) {
	    isSearchClicked = true;

	    if (rdbtnNewRadioButton_0.isSelected()) {
	        minPrice = min;
	        maxPrice = max;
	    } else {
	    	vePhong(panel, ml, filterLoaiPhong, 0, 0);
	    }
	}
	
	public void xuLySuKienRadioButton_1(int min, int max) {
	    isSearchClicked = true;

	    if (rdbtnNewRadioButton_1.isSelected()) {
	        minPrice = min;
	        maxPrice = max;
	    } else {
	    	vePhong(panel, ml, filterLoaiPhong, 0, 0);
	    }
	}
	
	public void xuLySuKienRadioButton_2(int min, int max) {
	    isSearchClicked = true;

	    if (rdbtnNewRadioButton_2.isSelected()) {
	        minPrice = min;
	        maxPrice = max;
	    } else {
	    	vePhong(panel, ml, filterLoaiPhong, 0, 0);
	    }
	}

}