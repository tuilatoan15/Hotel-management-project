package FormNhanVien;

import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.TKCTController;
import Data.DBConnection;
import model.ThongTinThuePhong;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class ThongKeChiTiet extends JFrame {

	private static final long serialVersionUID = 1L;
	ActionListener action1 = new TKCTController(this);
    private JComboBox comboBox_Thang;
    private JComboBox comboBox_Nam; 
	
	/**
	 * Launch the application.
	 */

	private JPanel contentPane;
	private JTable table_ThongKeChiTiet;
	private JTextField lbl_TongDoanhThu;

	/**
	 * Create the frame.
	 */
	public ThongKeChiTiet() {
		setTitle("Thống Kê Chi Tiết");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 514);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
//		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống Kê Chi Tiết");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(384, 1, 169, 35);
		contentPane.add(lblNewLabel);

		JLabel lbl_ThongKeTheo = new JLabel("Thống Kê Theo");
		lbl_ThongKeTheo.setBounds(10, 54, 89, 14);
		contentPane.add(lbl_ThongKeTheo);
		
		
		
		JButton btn_XacNhan = new JButton("Xác Nhận");
		btn_XacNhan.addActionListener(action1);
		btn_XacNhan.setBounds(10, 92, 89, 23);
		contentPane.add(btn_XacNhan);
		table_ThongKeChiTiet = new JTable();
		table_ThongKeChiTiet.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn Kh\u00E1ch H\u00E0ng", "Ph\u00F2ng Thu\u00EA", "Gi\u00E1 Ph\u00F2ng",
				"T\u1ED5ng Ti\u1EC1n Ph\u00F2ng", "T\u1ED5ng Ti\u1EC1n D\u1ECBch V\u1EE5", "Tổng Bill"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table_ThongKeChiTiet);
		scrollPane.setBounds(10, 125, 897, 293);
		contentPane.add(scrollPane);
		
		JButton btn_TongDanhThu = new JButton("Tổng Doanh Thu:");
		btn_TongDanhThu.addActionListener(action1);
		btn_TongDanhThu.setBounds(10, 444, 134, 23);
		contentPane.add(btn_TongDanhThu);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 34, 897, 2);
		contentPane.add(separator_1);
		
		JLabel lbl_Thang = new JLabel("Tháng:");
		lbl_Thang.setBounds(109, 55, 50, 14);
		contentPane.add(lbl_Thang);
		
		comboBox_Thang = new JComboBox();
		comboBox_Thang.setBounds(157, 50, 62, 22);
		contentPane.add(comboBox_Thang);
		
        for (int i = 1; i <= 12; i++) {
            comboBox_Thang.addItem(i);
        }
		
		JLabel lbl_Nam = new JLabel("Năm:");
		lbl_Nam.setBounds(240, 55, 50, 14);
		contentPane.add(lbl_Nam);
		
		comboBox_Nam = new JComboBox();
		comboBox_Nam.setBounds(288, 50, 62, 22);
		contentPane.add(comboBox_Nam);
		
		lbl_TongDoanhThu = new JTextField();
		lbl_TongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_TongDoanhThu.setBounds(154, 444, 161, 23);
		contentPane.add(lbl_TongDoanhThu);
		lbl_TongDoanhThu.setColumns(10);
		
		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.addActionListener(action1);
		btn_Thoat.setForeground(new Color(255, 0, 0));
		btn_Thoat.setBackground(new Color(255, 255, 255));
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_Thoat.setBounds(805, 445, 102, 23);
		contentPane.add(btn_Thoat);
		
		JButton btnNewButton = new JButton("Xuất File");
		btnNewButton.addActionListener(action1);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(672, 445, 102, 23);
		contentPane.add(btnNewButton);
		
        // Lấy năm hiện tại
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Điền dữ liệu từ năm 2000 đến năm hiện tại vào JComboBox
        for (int i = 2000; i <= currentYear; i++) {
            comboBox_Nam.addItem(i);
        }
	
		setVisible(true);
		loadThongTinThuePhong();
	}
	
	public void loadThongTinThuePhong() {
	    ArrayList<ThongTinThuePhong> list = getThongTinThuePhong();
	    DefaultTableModel model = (DefaultTableModel) table_ThongKeChiTiet.getModel();
	    model.setRowCount(0); // Xóa tất cả các dòng cũ

	    for (ThongTinThuePhong thongTin : list) {
	        // Sử dụng DecimalFormat để hiển thị số float mà không sử dụng dạng E
	    	DecimalFormat df = new DecimalFormat("#,##0.##");
	    	String giaPhong = df.format(thongTin.getGiaPhong());
	        String tongTienPhong = df.format(thongTin.getTongTienPhong());
	        String tongTienDichVu = df.format(thongTin.getTongTienDichVu());
	        String tongBill = df.format(thongTin.getTongBuill());
	        
	        model.addRow(new Object[]{
	            thongTin.getHoTen(),
	            thongTin.getPhong(),
	            giaPhong,
	            tongTienPhong,
	            tongTienDichVu,
	            tongBill
	        });
	    }
	}

    
	private ArrayList<ThongTinThuePhong> getThongTinThuePhong() {
	    ArrayList<ThongTinThuePhong> list = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBConnection.getConnection();
	        String query = "SELECT HoTen, Phong, GiaPhong, TongTienPhong, TongTienDichVu, SUM(TongBuill) AS TongBuill "
	                + "FROM ThongTinThuePhong GROUP BY HoTen, Phong, GiaPhong, TongTienPhong, TongTienDichVu";
	        stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            ThongTinThuePhong info = new ThongTinThuePhong();
	            info.setHoTen(rs.getString("HoTen"));
	            info.setPhong(rs.getString("Phong"));
	            info.setGiaPhong(rs.getInt("GiaPhong"));
	            info.setTongTienPhong(rs.getFloat("TongTienPhong"));
	            info.setTongTienDichVu(rs.getFloat("TongTienDichVu"));
	            info.setTongBuill(rs.getFloat("TongBuill"));

	            list.add(info);
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

	    return list;
	}


    public void layThongTinKhiClickXacNhan() {
        loadThongTinThuePhong();
        locThongTin();
    }
    
    public void locThongTin() {
        // Lấy thông tin tháng và năm từ JComboBox
        int thang = (int) comboBox_Thang.getSelectedItem();
        int nam = (int) comboBox_Nam.getSelectedItem();

        // Xóa dữ liệu trong JTable hiện tại
        DefaultTableModel model = (DefaultTableModel) table_ThongKeChiTiet.getModel();
        model.setRowCount(0);

        // Lấy thông tin từ cơ sở dữ liệu và so sánh với thông tin từ JComboBox
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            String query = "SELECT * FROM ThongTinThuePhong WHERE MONTH(NgayThue) = ? AND YEAR(NgayThue) = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, thang);
            stmt.setInt(2, nam);
            rs = stmt.executeQuery();

            // Sử dụng DecimalFormat để định dạng số tiền
            DecimalFormat df = new DecimalFormat("#,##0.##");

            while (rs.next()) {
                // Lấy thông tin từ ResultSet
                String hoTen = rs.getString("HoTen");
                String phong = rs.getString("Phong");
                int giaPhong = rs.getInt("GiaPhong");
                float tongTienPhong = rs.getFloat("TongTienPhong");
                float tongTienDichVu = rs.getFloat("TongTienDichVu");
                float tongBuill = rs.getFloat("TongBuill");

                // Định dạng số tiền
                String formattedGiaPhong = df.format(giaPhong);
                String formattedTongTienPhong = df.format(tongTienPhong);
                String formattedTongTienDichVu = df.format(tongTienDichVu);
                String formattedTongBuill = df.format(tongBuill);

                // Thêm dòng vào JTable
                model.addRow(new Object[]{
                    hoTen,
                    phong,
                    formattedGiaPhong,
                    formattedTongTienPhong,
                    formattedTongTienDichVu,
                    formattedTongBuill
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
    
    public float TinhTongDoanhThu() {
        float tongDoanhThu = 0.0f;

        // Lấy dữ liệu từ bảng và tính tổng doanh thu
        DefaultTableModel model = (DefaultTableModel) table_ThongKeChiTiet.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            // Lấy giá trị từ cột "Tổng Bill" dưới dạng String
            String tongBillStr = (String) model.getValueAt(i, 5);

            // Loại bỏ dấu chấm phân tách hàng ngàn từ chuỗi
            tongBillStr = tongBillStr.replace(".", "");

            // Chuyển đổi giá trị từ String sang float và cộng vào tổng doanh thu
            try {
                float tongBill = Float.parseFloat(tongBillStr);
                tongDoanhThu += tongBill;
//                System.out.println("Tong: " + tongDoanhThu);
            } catch (NumberFormatException e) {
                // Xử lý khi không thể chuyển đổi thành công
                System.out.println("Giá trị không hợp lệ: " + tongBillStr);
            }
        }
        // Khởi tạo DecimalFormat
        DecimalFormat df = new DecimalFormat("#,##0.##");

        // Chuyển đổi giá trị số thành chuỗi đã được định dạng
        String formattedValue = df.format(tongDoanhThu);

        // In ra màn hình console
//        System.out.println("Tổng doanh thu: " + formattedValue);
        
     // Đặt giá trị đã định dạng vào JTextField lbl_TongDoanhThu
        lbl_TongDoanhThu.setText(formattedValue+" VND");

        return tongDoanhThu;
    }

	public void inDanhSach() {
		String thongtin;
        int thang = (int) comboBox_Thang.getSelectedItem();
        int nam = (int) comboBox_Nam.getSelectedItem();
		if(table_ThongKeChiTiet.getRowCount()== 0) {
			
		}else {
			thongtin = "Thống Kê Hóa Đơn Tháng "+ thang + " Năm " + nam;
			MessageFormat header = new MessageFormat(thongtin);
			MessageFormat footer = new MessageFormat("Tổng Doanh Thu: " + lbl_TongDoanhThu.getText());
			
			try {
				table_ThongKeChiTiet.print(JTable.PrintMode.FIT_WIDTH, header, footer);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
