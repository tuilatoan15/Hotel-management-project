package FormThuephong;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.awt.event.ActionListener;

public class ChiTietHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_dichVu;
	public JTable table_bangDichVu;

	private JTextField textField;
	private String giaPhong;
	private String hoTen;
	private String tuoi;
	protected String soPhong;
	private java.sql.Timestamp ngayDat;
	private java.sql.Timestamp ngayTra;
	private float tongTienPhongValue;
	private String tongTienPhongValue_String;
	private float tongGioThueValue;
	private String tongGioThueValue_String;
	private float tongTien;
	private float tongBill;
	private float tienCoc;
	private DanhSachPhong ds;
	private String soHoaDon;
	private short maKhach;
	private String test;
	private String gioiTinh;
	private String SDT;
	private String CCCD;
	private String test1;
	private String cccd;

	public ChiTietHoaDon(String soPhong ,String cccd) {
		setTitle("Chi Tiết Hóa Đơn");
		this.soPhong = soPhong;
		this.cccd = cccd;
		ActionListener ac = new Controller_ChiTietHoaDon_ac(this);
		MouseListener ml = new Controller_ChiTietHoaDon_ml(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		loadDataFromDatabase();

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 784, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_4 = new JLabel("Phòng " + soPhong);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(251, 8, 169, 27);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Họ Tên: " + hoTen);
		lblNewLabel.setBounds(10, 60, 130, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNgyTr = new JLabel("Ngày Trả: " + ngayTra);
		lblNgyTr.setBounds(293, 60, 205, 24);
		contentPane.add(lblNgyTr);

		JLabel lblTui = new JLabel("Tuổi: " + tuoi);
		lblTui.setBounds(164, 60, 102, 24);
		contentPane.add(lblTui);

		table_bangDichVu = new JTable();
		table_bangDichVu.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Loại Dịch Vụ", "Tên Dịch Vu", "Giá" }));
		JScrollPane scrollPane_2 = new JScrollPane(table_bangDichVu);
		scrollPane_2.setBounds(10, 158, 777, 188);
		contentPane.add(scrollPane_2);
		loadDataToTable();

		table_bangDichVu.addMouseListener(ml);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 109, 784, 2);
		contentPane.add(separator_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Chi Tiết Dịch vụ");
		lblNewLabel_1_1.setBounds(10, 375, 92, 24);
		contentPane.add(lblNewLabel_1_1);

		table_dichVu = new JTable();
		table_dichVu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Số Hoá Đơn", "Phòng", "Tên Dịch Vụ", "Đơn Giá", "Số Lượng", "Thành Tiền" }));
		JScrollPane scrollPane_1 = new JScrollPane(table_dichVu);
		scrollPane_1.setBounds(10, 408, 777, 118);
		contentPane.add(scrollPane_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Dịch Vụ Cần Tìm");
		lblNewLabel_1_1_2.setBounds(10, 122, 92, 24);
		contentPane.add(lblNewLabel_1_1_2);

		textField = new JTextField();
		textField.setBounds(112, 124, 222, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchQuery = textField.getText();
				loadDataToTable(searchQuery);
			}
		});

		JButton btnNewButton = new JButton("Thanh Toán");
		btnNewButton.setBounds(520, 537, 103, 23);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(ac);

		JLabel lblNewLabel_2 = new JLabel("Tổng giờ thuê " + tinhTongGioThuePhong(ngayDat, ngayTra));
		lblNewLabel_2.setBounds(508, 63, 124, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tổng tiền phòng " + tinhTongTienThuePhong(ngayDat, ngayTra, giaPhong));
		lblNewLabel_3.setBounds(642, 65, 170, 14);
		contentPane.add(lblNewLabel_3);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 362, 784, 2);
		contentPane.add(separator_1_1_1);

		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setBounds(189, 537, 89, 23);
		// btnNewButton_1.addActionListener(ac);
		contentPane.add(btnNewButton_1);

		tongTienPhongValue_String = tinhTongTienThuePhong(ngayDat, ngayTra, giaPhong);
		tongGioThueValue_String = tinhTongGioThuePhong(ngayDat, ngayTra);
		// Loại bỏ " VND" khỏi chuỗi tongTienPhongValue
		String cleanedTongGioThuePhongValue = tongGioThueValue_String.replaceAll("[^\\d.]", "");

		// Chuyển đổi chuỗi đã được làm sạch sang float
		tongGioThueValue = Float.parseFloat(cleanedTongGioThuePhongValue);

		tongTienPhongValue = Float.parseFloat(tongTienPhongValue_String);

		String sql3 = "UPDATE ThongTinThuePhong SET TongTienPhong = ?, TongGioThue = ?, TongTienDichVu = ?, TongBuill = ? WHERE Phong = ?";
		try {
			Connection connection = Data.DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql3);
			preparedStatement.setFloat(1, tongTienPhongValue);
			preparedStatement.setFloat(2, tongGioThueValue);
			preparedStatement.setFloat(3, tongTien);
			preparedStatement.setFloat(4, tongBill);
			preparedStatement.setString(5, soPhong);
			// Kiểm tra giá trị của tongTien và tongBill trước khi thực hiện truy vấn
			System.out.println("Tổng tiền dịch vụ: " + tongTien);
			System.out.println("Tổng bill: " + tongBill);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Dữ liệu đã được cập nhật thành công vào bảng ThongTinThuePhong!");
			} else {
				System.out.println("Không tìm thấy dữ liệu để cập nhật trong bảng ThongTinThuePhong!");
			}

			connection.close();
		} catch (SQLException e1) {
			System.out.println("Cập nhật thông tin tiền phòng và giờ thất bại");
			e1.printStackTrace();
		}
		System.out.println("2 dữ liệu tượng ứng: " + tongTienPhongValue + " " + tongGioThueValue);
		updateNgayTra(soPhong, ngayTra);
		setVisible(true);
	}

	private void loadDataFromDatabase() {
		String selectSql = "SELECT * FROM Phong WHERE SoPhong = ?";
		String updateSql = "UPDATE Phong SET TrangThai = 1 WHERE SoPhong = ?";
		String sql1 = "SELECT * FROM ThongTinThuePhong WHERE Phong = ? AND CCCD = ?";

		try (Connection connection = Data.DBConnection.getConnection()) {
			// Thực hiện truy vấn SELECT để lấy thông tin phòng
			try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
				selectStatement.setString(1, soPhong);
				try (ResultSet resultSet = selectStatement.executeQuery()) {
					if (resultSet.next()) {
						giaPhong = resultSet.getString("Gia");
					}
				}
			}

			// Thực hiện truy vấn UPDATE để cập nhật trạng thái phòng
			try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
				updateStatement.setString(1, soPhong);
				int rowsUpdated = updateStatement.executeUpdate();
				if (rowsUpdated > 0) {
					System.out.println("Cập nhật trạng thái phòng thành công.");
				}
			}

			// Thực hiện truy vấn SELECT để lấy thông tin thuê phòng
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
				preparedStatement.setString(1, soPhong);
				preparedStatement.setString(2, cccd);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						hoTen = resultSet.getString("HoTen");
						tuoi = resultSet.getString("Tuoi");
						ngayDat = resultSet.getTimestamp("NgayThue");
						ngayTra = resultSet.getTimestamp("NgayTra");
						tienCoc = resultSet.getFloat("TienDatCoc");
						soHoaDon = resultSet.getString("SoHD");
					//	maKhach = resultSet.getShort("MaKhach");
						gioiTinh = resultSet.getString("GioiTinh");
						SDT = resultSet.getString("SDT");
						CCCD = resultSet.getString("CCCD");

						// In ra hoặc xử lý giá trị lấy được
						System.out.println("Họ tên: " + hoTen);
						System.out.println("Tuổi: " + tuoi);
						System.out.println("Ngày đặt: " + ngayDat);
						System.out.println("Ngày trả: " + ngayTra);
						System.out.println("Số hd: " + soHoaDon);
						//System.out.println("Mã Khách: " + maKhach);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateNgayTra(String soPhong, Date ngayTra) {

		String sql3 = "UPDATE Phong SET NgayTra = ? WHERE SoPhong = ?";

		try (Connection connection = Data.DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql3)) {

			preparedStatement.setTimestamp(1, ngayTra != null ? new Timestamp(ngayTra.getTime()) : null);
			preparedStatement.setString(2, soPhong);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Dữ liệu NgayTra đã được cập nhật thành công vào bảng Phong!");
			} else {
				System.out.println("Không tìm thấy dữ liệu để cập nhật trong bảng Phong!");
			}
		} catch (SQLException e) {
			System.out.println("Cập nhật thông tin NgayTra thất bại");
			e.printStackTrace();
		}
	}

	private void loadDataToTable() {
		loadDataToTable(""); // Gọi phương thức với chuỗi trống để tải tất cả dữ liệu ban đầu
	}

	private void loadDataToTable(String searchQuery) {
		DefaultTableModel model = (DefaultTableModel) table_bangDichVu.getModel();

		// Tạo danh sách để lưu trữ kết quả từ cơ sở dữ liệu
		ArrayList<Object[]> dataList = new ArrayList<>();

		try (Connection connection = Data.DBConnection.getConnection()) {
			String sql = "SELECT * FROM DichVu WHERE TenDichVu LIKE ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, "%" + searchQuery + "%");
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						String dichVu = resultSet.getString("TenLoaiDichVu");
						String tenDichVu = resultSet.getString("TenDichVu");
						float gia = resultSet.getFloat("DonGia");
						dataList.add(new Object[] { dichVu, tenDichVu, gia });
					}
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// Sắp xếp danh sách theo "DichVu"
		dataList.sort((o1, o2) -> ((String) o1[0]).compareTo((String) o2[0]));

		// Xóa các hàng cũ trong mô hình bảng
		model.setRowCount(0);

		// Thêm các hàng đã sắp xếp vào mô hình bảng
		for (Object[] row : dataList) {
			model.addRow(row);
		}
	}

// tính giờ
	private String tinhTongGioThuePhong(Timestamp start, Timestamp end) {
		if (start == null || end == null) {
			return "N/A";
		}

		LocalDateTime startDateTime = start.toLocalDateTime();
		LocalDateTime endDateTime = end.toLocalDateTime();
		Duration duration = Duration.between(startDateTime, endDateTime);

		long hours = duration.toHours() + 1;
		return hours + " giờ";
	}

	// tính tiền
	private String tinhTongTienThuePhong(Timestamp start, Timestamp end, String giaPhongStr) {
		if (start == null || end == null || giaPhongStr == null || giaPhongStr.isEmpty()) {
			return "N/A";
		}

		try {
			// Chuyển đổi giaPhong từ String sang float
			float giaPhong = Float.parseFloat(giaPhongStr);

			LocalDateTime startDateTime = start.toLocalDateTime();
			LocalDateTime endDateTime = end.toLocalDateTime();
			Duration duration = Duration.between(startDateTime, endDateTime);

			long hours = duration.toHours() + 1;
			float totalCost = hours * giaPhong;

			return String.format("%.0f", totalCost);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "N/A";
		}
	}
// 
	public void actionPerformed() {
	    // Gọi phương thức tính tổng tiền và hiển thị kết quả
	    tongTien = tinhTongTien();

	    // Loại bỏ " VND" khỏi chuỗi tongTienPhongValue
	    String cleanedTongTienPhongValue = tongTienPhongValue_String.replaceAll("[^\\d.]", "");

	    // Chuyển đổi chuỗi đã được làm sạch sang float
	    float tongTienPhong = Float.parseFloat(cleanedTongTienPhongValue);
	    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
	    tongBill = tongTienPhong + tongTien - tienCoc;
	    String formattedTienCoc = decimalFormat.format(tienCoc);
	    String formattedTongTienPhong = decimalFormat.format(tongTienPhongValue);
	    String formattedTongTien = decimalFormat.format(tongTien);
	    String formattedTongBill = decimalFormat.format(tongBill);

	    int result = JOptionPane.showConfirmDialog(contentPane,
	            "Tổng tiền cần thanh toán:\n Tiền Cọc: " + formattedTienCoc
	                    + "\nGiá Phòng: " + formattedTongTienPhong + "\n Tiền Dịch Vụ: " + formattedTongTien + "\n = " + formattedTongBill,
	            "Xác nhận thanh toán",
	            JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	        pushDataToDatabase();
	        upTongTien();
	        setKhach();
	        ds = new DanhSachPhong(); // Khởi tạo đối tượng DanhSachPhong
	        // Bạn có thể thêm các logic khác ở đây nếu cần
	        System.out.println("DanhSachPhong đã được khởi tạo.");
	        dispose();
	        System.out.println("chi tiếthoá đơn đã đóng.");
	    }
	}

	public float tinhTongTien() {
	    float tongTien = 0;
	    DefaultTableModel model = (DefaultTableModel) table_dichVu.getModel();
	    for (int i = 0; i < model.getRowCount(); i++) {
	        Object value = model.getValueAt(i, 5); // Lấy giá trị thành tiền dưới dạng Object
	        if (value instanceof Float) {
	            float thanhTien = (Float) value; // Ép kiểu thành Float nếu có thể
	            tongTien += thanhTien;
	        }
	    }
	    return tongTien;
	}

	public void pushDataToDatabase() {
	    try {
	        Connection connection = Data.DBConnection.getConnection();
	        String sql = "INSERT INTO ThongTinSuDungDichVu (Phong, SoHD, TenLoaiDichVu, SoLuong, NgaySuDung) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);

	        DefaultTableModel model = (DefaultTableModel) table_dichVu.getModel();
	        for (int i = 0; i < model.getRowCount(); i++) {
	            String phong = (String) model.getValueAt(i, 1);
	            int soHD = Integer.parseInt((String) model.getValueAt(i, 0)); // Chuyển đổi từ String sang int
	            String tenDichVu = (String) model.getValueAt(i, 2);
	            int soLuong = (int) model.getValueAt(i, 4);
	            Timestamp ngaySuDung = new Timestamp(System.currentTimeMillis());

	            preparedStatement.setString(1, phong);
	            preparedStatement.setInt(2, soHD);
	            preparedStatement.setString(3, tenDichVu);
	            preparedStatement.setInt(4, soLuong);
	            preparedStatement.setTimestamp(5, ngaySuDung);

	            preparedStatement.addBatch(); // Thêm vào batch
	        }

	        int[] rowsAffected = preparedStatement.executeBatch(); // Thực thi batch

	        System.out.println("Rows inserted: " + rowsAffected.length);

	        preparedStatement.close();
	        connection.close();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	//
	private void upTongTien() {
		String sql3 = "UPDATE ThongTinThuePhong SET MaKhach =? ,TongTienDichVu = ?, TongBuill = ? WHERE Phong = ?";

		try (Connection connection = Data.DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql3)) {
			 test = "KH0" + soHoaDon ;
			System.out.println("Mã Khách" + test);
			preparedStatement.setString(1, test);
			preparedStatement.setFloat(2, tongTien);
			preparedStatement.setFloat(3, tongBill);
			preparedStatement.setString(4, soPhong);

			// Kiểm tra giá trị của tongTien và tongBill trước khi thực hiện truy vấn
			System.out.println("Tổng tiền dịch vụ: " + tongTien);
			System.out.println("Tổng bill: " + tongBill);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Dữ liệu đã được cập nhật thành công vào bảng ThongTinThuePhong!");
			} else {
				System.out.println("Không tìm thấy dữ liệu để cập nhật trong bảng ThongTinThuePhong!");
			}

		} catch (SQLException e1) {
			System.out.println("Cập nhật thông tin tiền tổng thất bại");
			e1.printStackTrace();
		}
	}

	public void xuLyMouseClicked() {
		int selectedRow = table_bangDichVu.getSelectedRow();
		if (selectedRow != -1) {
			String tenDichVu = (String) table_bangDichVu.getValueAt(selectedRow, 1);
			String giaStr = String.valueOf(table_bangDichVu.getValueAt(selectedRow, 2));

			DefaultTableModel model = (DefaultTableModel) table_dichVu.getModel();
			boolean found = false;
			for (int i = 0; i < model.getRowCount(); i++) {
				if (model.getValueAt(i, 2).equals(tenDichVu)) {
					int soLuong = (int) model.getValueAt(i, 4) + 1;
					Float gia = Float.parseFloat((String) model.getValueAt(i, 3));
					Float thanhTien = gia * soLuong;

					// Cập nhật số lượng và thành tiền
					model.setValueAt(soLuong, i, 4);
					model.setValueAt(thanhTien, i, 5);
					found = true;
					break;
				}
			}
			if (!found) {
				float giaFloat = Float.parseFloat(giaStr);
				model.addRow(new Object[] { soHoaDon, soPhong, tenDichVu, giaStr, 1, giaFloat });
			}
		}
	}
	
	private void setKhach() {

		String sql = "INSERT INTO Khach (MaKhach, HoTen, Tuoi, GioiTinh, SDT, CCCD) VALUES (?, ?, ?, ?, ?, ?)";
		 test1 = "KH0" + soHoaDon ;
		try (Connection connection = Data.DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, test1);
			preparedStatement.setString(2, hoTen);
			preparedStatement.setInt(3, Integer.parseInt(tuoi));
			preparedStatement.setString(4, gioiTinh);
			preparedStatement.setString(5, SDT);
			preparedStatement.setString(6, CCCD);
			
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Dữ liệu Khach đã được cập nhật thành công vào bảng Phong!");
			} else {
				System.out.println("Không tìm thấy dữ liệu để cập nhật trong bảng Khach!");
			}
		} catch (SQLException e) {
			System.out.println("Cập nhật bang khach thất bại");
			e.printStackTrace();
		}
	}
	

	public JTable getTable_bangDichVu() {
		return table_bangDichVu;
	}

	public String getSoPhong() {
		return soPhong;
	}
	
}
