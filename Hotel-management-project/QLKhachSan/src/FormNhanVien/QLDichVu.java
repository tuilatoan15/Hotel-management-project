package FormNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Data.DBConnection;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.QLDichVuController;
import model.DichVu;
import model.QLDVModel;

import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QLDichVu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QLDVModel model;
	public JTextField textField;
	public JTable table;
	public JTextField textField_MaDichVu;
	public JTextField textField_TenLoaiDichVu;
	public JTextField textField_TenDichVu;
	public JTextField textField_DonGia;


	public QLDichVu() {
		setTitle("Quản Lý Dịch Vụ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 497);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		
		this.model = new QLDVModel();
		ActionListener action = new QLDichVuController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Dịch Vụ", "Tên Loại Dịch Vụ", "Tên Dịch Vụ", "Đơn giá"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 72, 508, 375);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setColumnHeaderView(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Thông Tin Dịch Vụ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(696, 48, 160, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã Dịch Vụ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(538, 100, 113, 24);
		contentPane.add(lblNewLabel_3);
		
		textField_MaDichVu = new JTextField();
		textField_MaDichVu.setBounds(650, 99, 244, 24);
		contentPane.add(textField_MaDichVu);
		textField_MaDichVu.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên Loại Dịch Vụ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(538, 159, 113, 24);
		contentPane.add(lblNewLabel_3_1);
		
		textField_TenLoaiDichVu = new JTextField();
		textField_TenLoaiDichVu.setColumns(10);
		textField_TenLoaiDichVu.setBounds(650, 158, 244, 24);
		contentPane.add(textField_TenLoaiDichVu);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Tên Dịch Vụ");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(538, 225, 84, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Đơn Giá");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_2.setBounds(538, 293, 84, 24);
		contentPane.add(lblNewLabel_3_1_2);
		
		textField_TenDichVu = new JTextField();
		textField_TenDichVu.setColumns(10);
		textField_TenDichVu.setBounds(650, 227, 244, 24);
		contentPane.add(textField_TenDichVu);
		
		textField_DonGia = new JTextField();
		textField_DonGia.setColumns(10);
		textField_DonGia.setBounds(650, 295, 244, 24);
		contentPane.add(textField_DonGia);
		
		JButton btn_ThemDichVu = new JButton("Thêm Dịch Vụ");
		btn_ThemDichVu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_ThemDichVu.addActionListener(action);
		btn_ThemDichVu.setBounds(552, 360, 113, 24);
		contentPane.add(btn_ThemDichVu);
		
		JButton btn_SuaDichVu = new JButton("Sửa Dịch Vụ");
		btn_SuaDichVu.addActionListener(action);
		btn_SuaDichVu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_SuaDichVu.addActionListener(action);
		btn_SuaDichVu.setBounds(675, 360, 113, 24);
		contentPane.add(btn_SuaDichVu);
		
		JButton btn_XoaDichVu = new JButton("Xoá Dịch Vụ");
		btn_XoaDichVu.addActionListener(action);
		btn_XoaDichVu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_XoaDichVu.addActionListener(action);
		btn_XoaDichVu.setBounds(796, 360, 113, 24);
		contentPane.add(btn_XoaDichVu);
		
		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.addActionListener(action);
		btn_Thoat.addActionListener(action);
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_Thoat.setForeground(new Color(255, 0, 0));
		btn_Thoat.addActionListener(action);
		btn_Thoat.setBounds(737, 394, 113, 24);
		contentPane.add(btn_Thoat);
		
		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.addActionListener(action);
		btn_Luu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_Luu.addActionListener(action);
		btn_Luu.setBounds(614, 394, 113, 24);
		contentPane.add(btn_Luu);
		
		JLabel lblNewLabel_3_2 = new JLabel("Các Loại Dịch Vụ");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(193, 23, 160, 30);
		contentPane.add(lblNewLabel_3_2);
		
		loadDichVuData();
		setVisible(true);
	}
	
    private void loadDichVuData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Mã Dịch Vụ", "Tên Loại Dịch Vụ", "Tên Dịch Vụ", "Đơn Giá"}, 0);
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM DichVu");
                while (resultSet.next()) {
                    String maDichVu = resultSet.getString("MaDichVu");
                    String tenLoaiDichVu = resultSet.getString("TenLoaiDichVu");
                    String tenDichVu = resultSet.getString("TenDichVu");
                    float donGia = resultSet.getFloat("DonGia");
                    model.addRow(new Object[]{maDichVu, tenLoaiDichVu, tenDichVu, donGia});
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
		textField_MaDichVu.setText("");
		textField_TenLoaiDichVu.setText("");
		textField_TenDichVu.setText("");
		textField_DonGia.setText("");
	}

	public void themHoacCapNhatDichVu(DichVu dv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(dv)){
			this.model.insert(dv);
			model_table.addRow(
				new Object[] {
						dv.getMaDichVu(),
						dv.getTenLoaiDichVu(),
						dv.getTenDichVu(),
						dv.getDonGia()+""});		
		} else {
			this.model.update(dv);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(dv.getMaDichVu()+"")) {
					model_table.setValueAt(dv.getMaDichVu()+"",i,0);
					model_table.setValueAt(dv.getTenLoaiDichVu()+"",i,1);
					model_table.setValueAt(dv.getTenDichVu()+"",i,2);
					model_table.setValueAt(dv.getDonGia()+"",i,3);
				}
			}
		}
	}
		
	public DichVu getDichVuDangChon() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    
	    if (i_row >= 0) { // Kiểm tra xem có hàng nào được chọn hay không
	        String maDichVu = model_table.getValueAt(i_row, 0) + "";
	        String tenLoaiDichVu = model_table.getValueAt(i_row, 1) + "";
	        String tenDichVu = model_table.getValueAt(i_row, 2) + "";
	        float donGia = Float.valueOf(model_table.getValueAt(i_row, 3) + "");
	        
	        DichVu dv = new DichVu(maDichVu, tenLoaiDichVu, tenDichVu, donGia);
	        return dv;
	    }
	    return null; // Trả về null nếu không có hàng nào được chọn
	}

	public void hienThiThongTinDaChon() {
	    DichVu dv = getDichVuDangChon();
	    if (dv != null) {
	        this.textField_MaDichVu.setText(dv.getMaDichVu());
	        this.textField_TenLoaiDichVu.setText(dv.getTenLoaiDichVu());
	        this.textField_TenDichVu.setText(dv.getTenDichVu());
	        this.textField_DonGia.setText(dv.getDonGia() + "");
	    } else {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dịch vụ từ bảng.");
	    }
	}

	public void thucHienXoa() {
	    int i_row = table.getSelectedRow();
	    
	    if (i_row == -1) {
//	        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();    
	    int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn?");    
	    if (luaChon == JOptionPane.YES_OPTION) {
	        DichVu dv = getDichVuDangChon();
	        // Xóa dòng khỏi JTable
	        model_table.removeRow(i_row);

	        // Xóa dữ liệu từ cơ sở dữ liệu
	        try {
	            Connection connection = DBConnection.getConnection();
	            String deleteSQL = "DELETE FROM DichVu WHERE MaDichVu = ?";
	            PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
	            deleteStatement.setString(1, dv.getMaDichVu());
	            deleteStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu từ cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

	
	public void thucHienThemDichVu() {
	    String maDichVu = this.textField_MaDichVu.getText().trim();
	    String tenLoaiDichVu = this.textField_TenLoaiDichVu.getText().trim();
	    String tenDichVu = this.textField_TenDichVu.getText().trim();
	    String donGiaStr = this.textField_DonGia.getText().trim();

	    if (maDichVu.isEmpty() || tenLoaiDichVu.isEmpty() || tenDichVu.isEmpty() || donGiaStr.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    float donGia;
	    try {
	        donGia = Float.parseFloat(donGiaStr);
	        if (donGia <= 0) {
	            throw new NumberFormatException();
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Đơn giá phải là một số dương.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    DichVu dv = new DichVu(maDichVu, tenLoaiDichVu, tenDichVu, donGia);
	    this.themHoacCapNhatDichVu(dv);
	    this.luuDuLieuVaoSQL();
	    loadDichVuData();
	}
	
	public void ThoatVaLuuDuLieu() {
//	    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu lại các tiến trình đã thực hiện?", "Xác nhận", JOptionPane.YES_NO_OPTION);
//	    if (confirm == JOptionPane.YES_OPTION) {
	        luuDuLieuVaoSQL();
//	    }
	}
	
    private void luuDuLieuVaoSQL() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        try {
            Connection connection = DBConnection.getConnection();
            String insertSQL = "INSERT INTO DichVu (MaDichVu, TenLoaiDichVu, TenDichVu, DonGia) VALUES (?, ?, ?, ?)";
            String updateSQL = "UPDATE DichVu SET TenLoaiDichVu = ?, TenDichVu = ?, DonGia = ? WHERE MaDichVu = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            for (int i = 0; i < rowCount; i++) {
                String maDichVu = (String) model.getValueAt(i, 0);
                String tenLoaiDichVu = (String) model.getValueAt(i, 1);
                String tenDichVu = (String) model.getValueAt(i, 2);
                Object donGiaObj = model.getValueAt(i, 3); // Lấy giá trị từ JTable

                // Kiểm tra nếu giá trị không phải là null và là một số
                if (donGiaObj != null && donGiaObj instanceof String) {
                    try {
                        float donGia = Float.parseFloat((String) donGiaObj);
                        // Kiểm tra nếu dữ liệu đã tồn tại
                        if (kiemTraTonTai(maDichVu)) {
                            // Update dữ liệu
                            updateStatement.setString(1, tenLoaiDichVu);
                            updateStatement.setString(2, tenDichVu);
                            updateStatement.setFloat(3, donGia);
                            updateStatement.setString(4, maDichVu);
                            updateStatement.executeUpdate();
                        } else {
                            // Thêm mới dữ liệu
                            insertStatement.setString(1, maDichVu);
                            insertStatement.setString(2, tenLoaiDichVu);
                            insertStatement.setString(3, tenDichVu);
                            insertStatement.setFloat(4, donGia);
                            insertStatement.executeUpdate();
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ: Dòng " + (i + 1) + ", Đơn giá phải là một số dương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return; // Kết thúc phương thức nếu giá trị không hợp lệ
                    }
                }
            }
//            JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu vào cơ sở dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu vào cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	private boolean kiemTraTonTai(String maDichVu) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    boolean tonTai = false;

	    try {
	        connection = DBConnection.getConnection();
	        String query = "SELECT * FROM DichVu WHERE MaDichVu = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, maDichVu);
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
