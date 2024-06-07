package FormNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.LoaiPhongController;
import Data.DBConnection;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Color;
import java.text.NumberFormat;

public class LoaiPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_LP1;
	private JTextField textField_LP2;
	private JTextField textField_LP3;
	private JTextField textField_LP4;
	private JTextField textField_P1;
	private JTextField textField_P2;
	private JTextField textField_P3;
	private JTextField textField_P4;


	public LoaiPhong() {
		setTitle("Thống Kê Phòng, Loại Phòng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 495);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
//		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_ThongkePhong = new JLabel("Thống Kê Phòng");
		lblNewLabel_ThongkePhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_ThongkePhong.setBounds(392, 10, 149, 25);
		contentPane.add(lblNewLabel_ThongkePhong);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lo\u1EA1i Ph\u00F2ng", "SL Ph\u00F2ng", "SL Ph\u00F2ng \u0110ang Thu\u00EA", "Gi\u00E1 Trung B\u00ECnh"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 60, 897, 71);
		contentPane.add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 48, 897, 2);
		contentPane.add(separator_1);
		
		JButton btn_Thoat = new JButton("Thoát");
        ActionListener action2 = new LoaiPhongController(this);
		btn_Thoat.addActionListener(action2);
		btn_Thoat.setForeground(new Color(255, 0, 0));
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Thoat.setBounds(816, 423, 91, 25);
		contentPane.add(btn_Thoat);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 141, 897, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_LP1 = new JLabel("Loại Phòng Được Thuê Nhiều Nhất:");
		lblNewLabel_LP1.setForeground(new Color(0, 0, 0));
		lblNewLabel_LP1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_LP1.setBounds(10, 172, 220, 25);
		contentPane.add(lblNewLabel_LP1);
		
		JLabel lblNewLabel_P1 = new JLabel("Phòng Được Thuê Nhiều Nhất:");
		lblNewLabel_P1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_P1.setBounds(458, 172, 192, 25);
		contentPane.add(lblNewLabel_P1);
		
		JLabel lblNewLabel_LP2 = new JLabel("Loại Phòng Được Thuê Ít Nhất:");
		lblNewLabel_LP2.setBackground(new Color(135, 206, 250));
		lblNewLabel_LP2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_LP2.setBounds(10, 238, 220, 25);
		contentPane.add(lblNewLabel_LP2);
		
		JLabel lblNewLabel_P2 = new JLabel("Phòng Được Thuê Ít Nhất:");
		lblNewLabel_P2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_P2.setBounds(458, 238, 192, 25);
		contentPane.add(lblNewLabel_P2);
		
		JLabel lblNewLabel_LP3 = new JLabel("Loại Phòng Có Doanh Thu Cao Nhất:");
		lblNewLabel_LP3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_LP3.setBounds(10, 304, 220, 25);
		contentPane.add(lblNewLabel_LP3);
		
		JLabel lblNewLabel_LP4 = new JLabel("Loại Phòng Có Doanh Thu Thấp Nhất:");
		lblNewLabel_LP4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_LP4.setBounds(10, 378, 220, 25);
		contentPane.add(lblNewLabel_LP4);
		
		JLabel lblNewLabel_P3 = new JLabel("Phòng Có Doanh Thu Cao Nhất:");
		lblNewLabel_P3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_P3.setBounds(458, 304, 192, 25);
		contentPane.add(lblNewLabel_P3);
		
		JLabel lblNewLabel_P4 = new JLabel("Phòng Có Doanh Thu Thấp Nhất:");
		lblNewLabel_P4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_P4.setBounds(458, 378, 192, 25);
		contentPane.add(lblNewLabel_P4);
		
		textField_LP1 = new JTextField();
		textField_LP1.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_LP1.setBounds(241, 176, 160, 19);
		contentPane.add(textField_LP1);
		textField_LP1.setColumns(10);
		
		textField_LP2 = new JTextField();
		textField_LP2.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_LP2.setColumns(10);
		textField_LP2.setBounds(241, 242, 160, 19);
		contentPane.add(textField_LP2);
		
		textField_LP3 = new JTextField();
		textField_LP3.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_LP3.setColumns(10);
		textField_LP3.setBounds(241, 308, 160, 19);
		contentPane.add(textField_LP3);
		
		textField_LP4 = new JTextField();
		textField_LP4.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_LP4.setColumns(10);
		textField_LP4.setBounds(241, 382, 160, 19);
		contentPane.add(textField_LP4);
		
		textField_P1 = new JTextField();
		textField_P1.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_P1.setColumns(10);
		textField_P1.setBounds(660, 176, 160, 19);
		contentPane.add(textField_P1);
		
		textField_P2 = new JTextField();
		textField_P2.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_P2.setColumns(10);
		textField_P2.setBounds(660, 242, 160, 19);
		contentPane.add(textField_P2);
		
		textField_P3 = new JTextField();
		textField_P3.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_P3.setColumns(10);
		textField_P3.setBounds(660, 308, 160, 19);
		contentPane.add(textField_P3);
		
		textField_P4 = new JTextField();
		textField_P4.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_P4.setColumns(10);
		textField_P4.setBounds(660, 382, 160, 19);
		contentPane.add(textField_P4);
		
		KetNoiDatabase();
		LayDuLieuPhong();
		LayDuLieuLoaiPhong();
		setVisible(true);
	}
	
    // Phương thức để kết nối cơ sở dữ liệu và tải dữ liệu vào bảng
    public void KetNoiDatabase() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String query = "SELECT TenPhong AS LoaiPhong, " +
                           "COUNT(*) AS SLPhong, " +
                           "SUM(CASE WHEN Trangthai = 1 THEN 1 ELSE 0 END) AS SLPhongDangThue, " +
                           "AVG(Gia) AS GiaTrungBinh " +
                           "FROM Phong " +
                           "GROUP BY TenPhong";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Xóa tất cả các dòng cũ

            while (rs.next()) {
                String loaiPhong = rs.getString("LoaiPhong");
                int slPhong = rs.getInt("SLPhong");
                int slPhongDangThue = rs.getInt("SLPhongDangThue");
                
                DecimalFormat df = new DecimalFormat("#,##0"); 
                float giaTrungBinh = rs.getFloat("GiaTrungBinh");
                String GiaTB = df.format(Math.round(giaTrungBinh)).replace(".", " ");

                model.addRow(new Object[]{
                    loaiPhong,
                    slPhong,
                    slPhongDangThue,
                    GiaTB,
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void LayDuLieuPhong() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();

            // Phòng Được Thuê Nhiều Nhất
            String query1 = "SELECT TOP 1 Phong, COUNT(*) AS TotalRentals " +
                            "FROM ThongTinThuePhong " +
                            "GROUP BY Phong " +
                            "ORDER BY TotalRentals DESC";
            stmt = conn.prepareStatement(query1);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String phongNhieuNhat = rs.getString("Phong");
                int totalRentals = rs.getInt("TotalRentals");
                if (phongNhieuNhat != null) {
                    textField_P1.setText(phongNhieuNhat + " (Số lần: " + totalRentals + ")");
                } else {
                    textField_P1.setText("Không có dữ liệu");
                }
            } else {
                textField_P1.setText("Không tìm thấy dữ liệu");
            }

            // Phòng Được Thuê Ít Nhất
            String query2 = "SELECT TOP 1 Phong, COUNT(*) AS TotalRentals " +
                            "FROM ThongTinThuePhong " +
                            "GROUP BY Phong " +
                            "ORDER BY TotalRentals ASC";
            stmt = conn.prepareStatement(query2);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String phongItNhat = rs.getString("Phong");
                int totalRentals = rs.getInt("TotalRentals");
                if (phongItNhat != null) {
                    textField_P2.setText(phongItNhat + " (Số lần: " + totalRentals + ")");
                } else {
                    textField_P2.setText("Không có dữ liệu");
                }
            } else {
                textField_P2.setText("Không tìm thấy dữ liệu");
            }

            // Phòng Có Doanh Thu Cao Nhất
            String query3 = "SELECT TOP 1 Phong, SUM(TongTienPhong) AS TotalRevenue " +
                            "FROM ThongTinThuePhong " +
                            "GROUP BY Phong " +
                            "ORDER BY TotalRevenue DESC";
            stmt = conn.prepareStatement(query3);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String phongCaoNhat = rs.getString("Phong");
                double totalRevenue = rs.getDouble("TotalRevenue");
                if (phongCaoNhat != null) {
                    textField_P3.setText(phongCaoNhat + " (" + formatCurrency(totalRevenue) + ")");
                } else {
                    textField_P3.setText("Không có dữ liệu");
                }
            } else {
                textField_P3.setText("Không tìm thấy dữ liệu");
            }

            // Phòng Có Doanh Thu Thấp Nhất
            String query4 = "SELECT TOP 1 Phong, SUM(TongTienPhong) AS TotalRevenue " +
                            "FROM ThongTinThuePhong " +
                            "GROUP BY Phong " +
                            "ORDER BY TotalRevenue ASC";
            stmt = conn.prepareStatement(query4);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String phongThapNhat = rs.getString("Phong");
                double totalRevenue = rs.getDouble("TotalRevenue");
                if (phongThapNhat != null) {
                    textField_P4.setText(phongThapNhat + " (" + formatCurrency(totalRevenue) + ")");
                } else {
                    textField_P4.setText("Không có dữ liệu");
                }
            } else {
                textField_P4.setText("Không tìm thấy dữ liệu");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private String formatCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        return currencyFormat.format(amount) + " VND";
    }

    public void LayDuLieuLoaiPhong() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Kết nối cơ sở dữ liệu
            conn = DBConnection.getConnection();

            // Loại Phòng Được Thuê Nhiều Nhất
            String query1 = "SELECT TOP 1 p.TenPhong, COUNT(*) AS TotalRentals " +
                            "FROM Phong p " +
                            "JOIN ThongTinThuePhong t ON p.SoPhong = t.Phong " +
                            "GROUP BY p.TenPhong " +
                            "ORDER BY TotalRentals DESC";
            stmt = conn.prepareStatement(query1);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String loaiPhongNhieuNhat = rs.getString("TenPhong");
                int totalRentals = rs.getInt("TotalRentals");
                textField_LP1.setText(loaiPhongNhieuNhat + " (Số lần: " + totalRentals + ")");
            } else {
                textField_LP1.setText("Không tìm thấy dữ liệu");
            }

            // Loại Phòng Được Thuê Ít Nhất
            String query2 = "SELECT TOP 1 p.TenPhong, COUNT(*) AS TotalRentals " +
                            "FROM Phong p " +
                            "JOIN ThongTinThuePhong t ON p.SoPhong = t.Phong " +
                            "GROUP BY p.TenPhong " +
                            "ORDER BY TotalRentals ASC";
            stmt = conn.prepareStatement(query2);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String loaiPhongItNhat = rs.getString("TenPhong");
                int totalRentals = rs.getInt("TotalRentals");
                textField_LP2.setText(loaiPhongItNhat + " (Số lần: " + totalRentals + ")");
            } else {
                textField_LP2.setText("Không tìm thấy dữ liệu");
            }

            // Loại Phòng Có Doanh Thu Cao Nhất
            String query3 = "SELECT TOP 1 p.TenPhong, SUM(t.TongTienPhong) AS TotalRevenue " +
                            "FROM Phong p " +
                            "JOIN ThongTinThuePhong t ON p.SoPhong = t.Phong " +
                            "GROUP BY p.TenPhong " +
                            "ORDER BY TotalRevenue DESC";
            stmt = conn.prepareStatement(query3);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String loaiPhongCaoNhat = rs.getString("TenPhong");
                double totalRevenue = rs.getDouble("TotalRevenue");
                textField_LP3.setText(loaiPhongCaoNhat + " (" + formatCurrency(totalRevenue) + ")");
            } else {
                textField_LP3.setText("Không tìm thấy dữ liệu");
            }

            // Loại Phòng Có Doanh Thu Thấp Nhất
            String query4 = "SELECT TOP 1 p.TenPhong, SUM(t.TongTienPhong) AS TotalRevenue " +
                            "FROM Phong p " +
                            "JOIN ThongTinThuePhong t ON p.SoPhong = t.Phong " +
                            "GROUP BY p.TenPhong " +
                            "ORDER BY TotalRevenue ASC";
            stmt = conn.prepareStatement(query4);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String loaiPhongThapNhat = rs.getString("TenPhong");
                double totalRevenue = rs.getDouble("TotalRevenue");
                textField_LP4.setText(loaiPhongThapNhat + " (" + formatCurrency(totalRevenue) + ")");
            } else {
                textField_LP4.setText("Không tìm thấy dữ liệu");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
