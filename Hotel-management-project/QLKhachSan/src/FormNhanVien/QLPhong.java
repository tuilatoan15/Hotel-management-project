package FormNhanVien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Data.DBConnection;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import model.Phong;
import model.PhongModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.PhongController;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class QLPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public PhongModel model;
	public JTextField textField;
	public JTable table;
	public JTextField textField_SoPhong;
	public JTextField textField_TenPhong;
	public JTextField textField_Gia;

	public QLPhong() {
		setTitle("Quản Lý Phòng Khách Sạn");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 497);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		
		this.model = new PhongModel();
		ActionListener action3 = new PhongController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_KhachSan = new JLabel("Khách Sạn 2TL");
		lbl_KhachSan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_KhachSan.setBounds(335, 11, 238, 35);
		contentPane.add(lbl_KhachSan);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 915, 2);
		contentPane.add(separator);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SoPhong", "TenPhong", "Gia"
			}
		));
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 93, 508, 354);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setColumnHeaderView(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Các chức năng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(713, 62, 137, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_SoPhong = new JLabel("Số Phòng");
		lbl_SoPhong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_SoPhong.setBounds(552, 119, 72, 23);
		contentPane.add(lbl_SoPhong);
		
		textField_SoPhong = new JTextField();
		textField_SoPhong.setBounds(629, 117, 265, 26);
		contentPane.add(textField_SoPhong);
		textField_SoPhong.setColumns(10);
		
		JLabel lbl_TenPhong = new JLabel("Tên Phòng");
		lbl_TenPhong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_TenPhong.setBounds(552, 199, 72, 23);
		contentPane.add(lbl_TenPhong);
		
		textField_TenPhong = new JTextField();
		textField_TenPhong.setColumns(10);
		textField_TenPhong.setBounds(629, 199, 265, 26);
		contentPane.add(textField_TenPhong);
		
		JLabel lbl_Gia = new JLabel("Giá Phòng");
		lbl_Gia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Gia.setBounds(552, 280, 72, 24);
		contentPane.add(lbl_Gia);
		
		textField_Gia = new JTextField();
		textField_Gia.setColumns(10);
		textField_Gia.setBounds(629, 278, 265, 26);
		contentPane.add(textField_Gia);
		
		JButton btn_ThemPhong = new JButton("Thêm Phòng");
		btn_ThemPhong.setForeground(new Color(0, 0, 0));
		btn_ThemPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_ThemPhong.addActionListener(action3);
		btn_ThemPhong.setBounds(552, 355, 113, 23);
		contentPane.add(btn_ThemPhong);
		
		JButton btn_SuaPhong = new JButton("Sửa Phòng");
		btn_SuaPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_SuaPhong.addActionListener(action3);
		btn_SuaPhong.setBounds(675, 355, 113, 23);
		contentPane.add(btn_SuaPhong);
		
		JButton btn_XoaPhong = new JButton("Xoá Phòng");
		btn_XoaPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_XoaPhong.addActionListener(action3);
		btn_XoaPhong.setBounds(798, 355, 113, 23);
		contentPane.add(btn_XoaPhong);
		
		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.setBackground(new Color(255, 255, 255));
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_Thoat.setForeground(new Color(255, 0, 0));
		btn_Thoat.addActionListener(action3);
		btn_Thoat.setBounds(756, 397, 113, 23);
		contentPane.add(btn_Thoat);
		
		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_Luu.addActionListener(action3);
		btn_Luu.setBounds(613, 397, 113, 23);
		contentPane.add(btn_Luu);
		
		JLabel lbl_ThongTinPhong = new JLabel("Thông tin Phòng");
		lbl_ThongTinPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_ThongTinPhong.setBounds(186, 59, 160, 24);
		contentPane.add(lbl_ThongTinPhong);
		
		loadPhongData();
		setVisible(true);
	}
	
	private void loadPhongData() {
	    DefaultTableModel model = new DefaultTableModel(new String[]{"Số Phòng", "Tên Phòng", "Giá Phòng"}, 0);
	    Connection connection = DBConnection.getConnection();
	    if (connection != null) {
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery("SELECT * FROM Phong");
	            while (resultSet.next()) {
	                String soPhong = resultSet.getString("SoPhong");
	                String tenPhong = resultSet.getString("TenPhong");
	                float gia = resultSet.getFloat("Gia");
	                model.addRow(new Object[]{soPhong, tenPhong, gia});
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (resultSet != null) resultSet.close();
	                if (statement != null) statement.close();
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    table.setModel(model);
	}

	public void xoaForm() {
	    textField_SoPhong.setText("");
	    textField_TenPhong.setText("");
	    textField_Gia.setText("");
	}

	public void themHoacCapNhatPhong(Phong phong) {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    if (!this.model.kiemTraTonTai(phong)){
	        this.model.insert(phong);
	        model_table.addRow(
	            new Object[] {
	                phong.getSoPhong(),
	                phong.getTenPhong(),
	                phong.getGia(),
	                phong.getTrangThai()
	            }
	        );        
	    } else {
	        this.model.update(phong);
	        int soLuongDong = model_table.getRowCount();
	        for (int i = 0; i < soLuongDong; i++) {
	            String id = model_table.getValueAt(i, 0).toString();
	            if(id.equals(String.valueOf(phong.getSoPhong()))) {
	                model_table.setValueAt(phong.getSoPhong(), i, 0);
	                model_table.setValueAt(phong.getTenPhong(), i, 1);
	                model_table.setValueAt(phong.getGia(), i, 2);
	                model_table.setValueAt(phong.getTrangThai(), i, 3);
	            }
	        }
	    }
	}

	public Phong getPhongDangChon() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();

	    if (i_row >= 0) {
	        int soPhong = 0;
	        String tenPhong = "";
	        float gia = 0.0f;
	        int trangThai = 0;

	        Object soPhongObj = model_table.getValueAt(i_row, 0);
	        Object tenPhongObj = model_table.getValueAt(i_row, 1);
	        Object giaObj = model_table.getValueAt(i_row, 2);

	        if (soPhongObj != null) {
	            soPhong = Integer.parseInt(soPhongObj.toString());
	        }
	        if (tenPhongObj != null) {
	            tenPhong = tenPhongObj.toString();
	        }
	        if (giaObj != null) {
	            gia = Float.parseFloat(giaObj.toString());
	        }

	        Phong phong = new Phong(soPhong, tenPhong, gia, trangThai);
	        return phong;
	    }
	    return null;
	}

	public void hienThiPhongDangChon() {
	    Phong phong = getPhongDangChon();
	    if (phong != null) {
	        this.textField_SoPhong.setText(String.valueOf(phong.getSoPhong()));
	        this.textField_TenPhong.setText(phong.getTenPhong());
	        this.textField_Gia.setText(String.valueOf(phong.getGia()));
	    } else {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một phòng từ bảng.");
	    }
	}

	public void thucHienXoa() {
	    int i_row = table.getSelectedRow();
	    
	    if (i_row == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();    
	    int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn?");    
	    if (luaChon == JOptionPane.YES_OPTION) {
	        Phong phong = getPhongDangChon();
	        // Xóa dòng khỏi JTable
	        model_table.removeRow(i_row);

	        // Xóa dữ liệu từ cơ sở dữ liệu
	        try {
	            Connection connection = DBConnection.getConnection();
	            String deleteSQL = "DELETE FROM Phong WHERE SoPhong = ?";
	            PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
	            deleteStatement.setInt(1, phong.getSoPhong());
	            deleteStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu từ cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
	public void thucHienThemPhong() {
	    String soPhongStr = this.textField_SoPhong.getText().trim();
	    String tenPhong = this.textField_TenPhong.getText().trim();
	    String giaStr = this.textField_Gia.getText().trim();

	    if (soPhongStr.isEmpty() || tenPhong.isEmpty() || giaStr.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    int soPhong;
	    try {
	        soPhong = Integer.parseInt(soPhongStr);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Số phòng phải là một số nguyên.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    float gia;
	    try {
	        gia = Float.parseFloat(giaStr);
	        if (gia <= 0) {
	            throw new NumberFormatException();
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Giá phòng phải là một số dương.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    int trangThai = 0;

	    // Kiểm tra tên phòng
	    if (!(tenPhong.equals("Cao Cấp") || tenPhong.equals("Thương Gia") || tenPhong.equals("Bình Dân"))) {
	        JOptionPane.showMessageDialog(this, "Tên phòng phải là 'Cao Cấp', 'Thương Gia' hoặc 'Bình Dân'.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    // Sử dụng thông tin đã thu thập để tạo một đối tượng Phong mới
	    Phong phong = new Phong(soPhong, tenPhong, gia, trangThai);
	    
	    // Gọi phương thức để thêm hoặc cập nhật phòng
	    this.themHoacCapNhatPhong(phong);
	    
	    // Lưu dữ liệu vào cơ sở dữ liệu
	    this.luuDuLieuVaoSQL();
	    
	    // Tải lại dữ liệu phòng
	    loadPhongData();
	}

	
	public void ThoatVaLuuDuLieu() {
	    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu lại các tiến trình đã thực hiện?", "Xác nhận", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        luuDuLieuVaoSQL();
	    }
	}
	
	private void luuDuLieuVaoSQL() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    int rowCount = model.getRowCount();

	    try {
	        Connection connection = DBConnection.getConnection();
	        String insertSQL = "INSERT INTO Phong (SoPhong, TenPhong, Gia) VALUES (?, ?, ?)";
	        String updateSQL = "UPDATE Phong SET TenPhong = ?, Gia = ? WHERE SoPhong = ?";
	        PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
	        PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

	        for (int i = 0; i < rowCount; i++) {
	            Object soPhongObj = model.getValueAt(i, 0);
	            Object tenPhongObj = model.getValueAt(i, 1);
	            Object giaObj = model.getValueAt(i, 2);

	            // Kiểm tra null trước khi chuyển đổi kiểu
	            if (soPhongObj != null && tenPhongObj != null && giaObj != null) {
	                int soPhong = Integer.parseInt(soPhongObj.toString());
	                String tenPhong = tenPhongObj.toString();
	                float gia = Float.parseFloat(giaObj.toString());

	                // Kiểm tra nếu dữ liệu đã tồn tại
	                if (kiemTraTonTai(soPhong)) {
	                    // Update dữ liệu
	                    updateStatement.setString(1, tenPhong);
	                    updateStatement.setFloat(2, gia);
	                    updateStatement.setInt(3, soPhong);
	                    updateStatement.executeUpdate();
	                } else {
	                    // Thêm mới dữ liệu
	                    insertStatement.setInt(1, soPhong);
	                    insertStatement.setString(2, tenPhong);
	                    insertStatement.setFloat(3, gia);
	                    insertStatement.executeUpdate();
	                }
	            } else {
	                // Xử lý trường hợp giá trị null
	                System.err.println("Dòng " + (i + 1) + " chứa giá trị null.");
	            }
	        }
	        
	        JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu vào cơ sở dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu vào cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}

	private boolean kiemTraTonTai(int soPhong) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    boolean tonTai = false;

	    try {
	        connection = DBConnection.getConnection();
	        String query = "SELECT * FROM Phong WHERE SoPhong = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, soPhong);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            // Nếu có bản ghi phù hợp, đặt cờ tồn tại thành true
	            tonTai = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng các tài nguyên
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return tonTai;
	}
}
