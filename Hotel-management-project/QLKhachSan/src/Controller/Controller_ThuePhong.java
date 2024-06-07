package Controller;

import java.awt.event.ActionEvent;
import FormThuephong.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import Data.DBConnection;

public class Controller_ThuePhong implements ActionListener {
	private ThuePhong thuePhong;
	private int giaPhong;
	private DanhSachPhong danhSachPhong;
	private Date ngayDat_check;
	private Date ngayTra_check;

	public Controller_ThuePhong(ThuePhong thuePhong ) {
		this.thuePhong = thuePhong;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();

		if (ac.equals("Đặt Phòng")) {
			handleCheckIn();
			
		} else if (ac.equals("Thoát")) {
			thuePhong.dispose();

		}
	}

	private void handleCheckIn() {
		try {
			String hoTen = thuePhong.getTextField_hoTen().getText().trim();
			String tuoi = thuePhong.getTextField_tuoi().getText().trim();
			String soDienThoai = thuePhong.getTextField_soDienThoai().getText().trim();
			String cccd = thuePhong.getTextField_CCCD().getText().trim();
			String tienDatCocStr = thuePhong.getTextField_tien().getText().trim();
			String soPhong = thuePhong.getSoPhong().trim();
//			giaPhong = ghiGiaPhong_user(soPhong); // Ví dụ gán giá trị cho giaPhong, bạn cần lấy giá trị thực tế từ nơi khác

			String gioiTinh = getSelectedButtonText(thuePhong.getBtn_GioiTinh());
			Date ngayDat = thuePhong.getNgayDat();
			Date ngayTra = thuePhong.getNgayTra();
			System.out.println(" ngày đặt là: " + ngayDat);
			System.out.println(" ngày trả là: " + ngayTra);
			 ngayDat_check = new Timestamp(ngayDat.getTime());
			 ngayTra_check = new Timestamp(ngayTra.getTime());
			System.out.println(" ngày đặt đã chuyển đổi là: " + ngayDat_check);
			ghiGiaPhong_user(soPhong);

			// Validate inputs
			if (!validateInputs(hoTen, tuoi, soDienThoai, cccd, tienDatCocStr, gioiTinh, ngayDat, ngayTra)) {
				return;
			}

			// Convert and calculate
			int tuoiInt = Integer.parseInt(tuoi);
			float tienDatCoc = Float.parseFloat(tienDatCocStr);

			// Insert into database
			insertThongTinThuePhong(soPhong, hoTen, tuoiInt, gioiTinh, soDienThoai, cccd, tienDatCoc, ngayDat, ngayTra,
					giaPhong);
			// updateNgayTra(soPhong, ngayTra);

			// Display ChiTietHoaDon
			ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(soPhong, cccd);
			chiTietHoaDon.setVisible(true);
			// danhSachPhong.pause();
			thuePhong.dispose();
			// thuePhong.getDanhSachPhong().pause();
			

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(thuePhong, "Đã xảy ra lỗi: " + ex.getMessage());
		}
	}

	private boolean validateInputs(String hoTen, String tuoi, String soDienThoai, String cccd, String tienDatCoc,
			String gioiTinh, Date ngayDat, Date ngayTra) {
		if (hoTen.isEmpty() || tuoi.isEmpty() || soDienThoai.isEmpty() || cccd.isEmpty() || tienDatCoc.isEmpty()
				|| gioiTinh == null) {
			JOptionPane.showMessageDialog(thuePhong, "Bạn chưa nhập đủ dữ liệu!");
			return false;
		}

		if (!isValidName(hoTen)) {
			JOptionPane.showMessageDialog(thuePhong, "Tên không hợp lệ!");
			return false;
		}

		if (!isValidAge(tuoi)) {
			JOptionPane.showMessageDialog(thuePhong, "Tuổi không hợp lệ!");
			return false;
		}

		if (!Validator.isValidPhoneNumber(soDienThoai)) {
			JOptionPane.showMessageDialog(thuePhong, "Số điện thoại không hợp lệ!");
			return false;
		}

		if (!Validator.isValidCCCD(cccd)) {
			JOptionPane.showMessageDialog(thuePhong, "CCCD không hợp lệ!");
			return false;
		}

		if (!isValidTien(tienDatCoc)) {
			JOptionPane.showMessageDialog(thuePhong, "Nhập số tiền lớn hơn 50.000 VND!");
			return false;
		}

		if (!isValidDateRange(ngayDat_check, ngayTra_check)) {
			JOptionPane.showMessageDialog(thuePhong, "Ngày trả không phù hợp !");
			return false;
		}

		return true;
	}

	private String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}

	private void ghiGiaPhong_user(String soPhong) {

		String selectSql = "SELECT * FROM Phong WHERE SoPhong = ?";
		String updateSql = "UPDATE Phong SET TrangThai = 1 WHERE SoPhong = ?";
		

		try {
			// Kết nối đến cơ sở dữ liệu
			Connection connection = DBConnection.getConnection();
			// Thực hiện truy vấn SELECT để lấy thông tin phòng
			PreparedStatement selectStatement = connection.prepareStatement(selectSql);
			selectStatement.setString(1, soPhong);
			ResultSet resultSet = selectStatement.executeQuery();
			if (resultSet.next()) {
				giaPhong = resultSet.getInt("Gia");
			}
			resultSet.close();
			selectStatement.close();

			// Thực hiện truy vấn UPDATE để cập nhật trạng thái phòng
			PreparedStatement updateStatement = connection.prepareStatement(updateSql);
			updateStatement.setString(1, soPhong);
			int rowsUpdated = updateStatement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Cập nhật trạng thái phòng thành công.");
			}
			updateStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void insertThongTinThuePhong(String soPhong, String hoTen, int tuoi, String gioiTinh, String soDienThoai,
			String cccd, float tienDatCoc, Date ngayDat, Date ngayTra, int giaPhong) throws SQLException {

		String sql = "INSERT INTO ThongTinThuePhong (Phong, HoTen, Tuoi, GioiTinh, SDT, CCCD, TienDatCoc, NgayThue, NgayTra, GiaPhong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, soPhong);
			preparedStatement.setString(2, hoTen);
			preparedStatement.setInt(3, tuoi);
			preparedStatement.setString(4, gioiTinh);
			preparedStatement.setString(5, soDienThoai);
			preparedStatement.setString(6, cccd);
			preparedStatement.setFloat(7, tienDatCoc);
			preparedStatement.setTimestamp(8, new Timestamp(ngayDat.getTime()));
			preparedStatement.setTimestamp(9, new Timestamp(ngayTra.getTime()));
			preparedStatement.setInt(10, giaPhong);
			System.out.println("Giá phòng tương ứng: " + giaPhong);
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Dữ liệu đã được chèn thành công vào bảng ThongTinThuePhong!");
			} else {
				System.out.println("Không thể chèn dữ liệu vào bảng ThongTinThuePhong!");
			}
		}

	}

	private boolean isValidDateRange(Date ngayDat, Date ngayTra) {
		return !ngayDat.after(ngayTra);
	}

	public boolean isValidName(String name) {
		String regex = "^[\\p{L}]+( [\\p{L}]+)*$";
		return name.matches(regex);
	}

	public boolean isValidAge(String ageStr) {
		String regex = "^[0-9]+$";
		if (!ageStr.matches(regex)) {
			return false;
		}
		int age = Integer.parseInt(ageStr);
		return age > 18;
	}

	public static boolean isValidTien(String input) {
		try {
			float amount = Float.parseFloat(input);
			return amount >= 50000;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static class Validator {
		public static boolean isValidPhoneNumber(String phoneNumber) {
			return phoneNumber.matches("\\d{10}");
		}

		public static boolean isValidCCCD(String cccd) {
			return cccd.matches("\\d{12}");
		}
	}

}
