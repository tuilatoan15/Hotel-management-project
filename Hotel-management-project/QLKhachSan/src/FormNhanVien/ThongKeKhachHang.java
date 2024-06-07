package FormNhanVien;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Controller.Controller_ThongKeKhachHang;
import Data.DBConnection;
import model.QLKHModel;
import model.Khach;

public class ThongKeKhachHang extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public QLKHModel model;
    public JTable table;
    public ButtonGroup btn_GioiTinh;
    public JRadioButton rdbtnNewRadioButton;
    public JRadioButton rdbtnNewRadioButton_2;
    private JTextField textField_MaKhach;
    private JTextField textField_HoTen;
    private JTextField textField_Tuoi;
    private JTextField textField_SDT;
    private JTextField textField_CCCD;

    
    public ThongKeKhachHang() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 929, 526);
        ActionListener action = new Controller_ThongKeKhachHang(this);

        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(contentPane);
        contentPane.setLayout(null);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 41, 513, 0);
        contentPane.add(separator_1);

        JLabel lblDanhSanhKH = new JLabel("Danh Sách Khách Hàng");
        lblDanhSanhKH.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblDanhSanhKH.setBounds(174, 11, 290, 30);
        contentPane.add(lblDanhSanhKH);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Mã Khách", "Họ Tên", "Tuổi", "Giới Tính", "SĐT", "CCCD"
            }
        ));

        // Set auto resize mode
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Create a DefaultTableCellRenderer and set its horizontal alignment to center
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Apply the center renderer to each column
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        	if (i == 2 || i == 4 || i == 5)
        		table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // Optionally, set preferred widths for the columns
        TableColumn column;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(75); // Họ Tên
                    break;
                case 1:
                    column.setPreferredWidth(150);  // Tuổi
                    break;
                case 2:
                    column.setPreferredWidth(50); // Giới Tính
                    break;
                case 3:
                    column.setPreferredWidth(75); // SĐT
                    break;
                case 4:
                    column.setPreferredWidth(100); // CCCD
                    break;
                case 5:
                	column.setPreferredWidth(150);
                	break;
                default:
                    column.setPreferredWidth(100);
            }
        }
        
     // Center align the table header
        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 51, 513, 402);
        contentPane.add(scrollPane);

        JLabel lblMaKhach = new JLabel("Mã khách");
        lblMaKhach.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMaKhach.setBounds(559, 71, 83, 30);
        contentPane.add(lblMaKhach);

        textField_MaKhach = new JTextField();
        textField_MaKhach.setBounds(652, 73, 230, 30);
        contentPane.add(textField_MaKhach);
        textField_MaKhach.setColumns(10);

        JLabel lblHoTen = new JLabel("Họ tên");
        lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHoTen.setBounds(559, 119, 83, 30);
        contentPane.add(lblHoTen);

        textField_HoTen = new JTextField();
        textField_HoTen.setBounds(652, 122, 230, 30);
        contentPane.add(textField_HoTen);
        textField_HoTen.setColumns(10);

        JLabel lblTuoi = new JLabel("Tuổi");
        lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTuoi.setBounds(559, 171, 83, 30);
        contentPane.add(lblTuoi);

        textField_Tuoi = new JTextField();
        textField_Tuoi.setBounds(652, 174, 230, 30);
        contentPane.add(textField_Tuoi);
        textField_Tuoi.setColumns(10);

        JLabel lblSDT = new JLabel("Số ĐT");
        lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSDT.setBounds(557, 274, 85, 30);
        contentPane.add(lblSDT);

        textField_SDT = new JTextField();
        textField_SDT.setBounds(652, 277, 230, 30);
        contentPane.add(textField_SDT);
        textField_SDT.setColumns(10);

        JLabel lblGioiTinh = new JLabel("Giới tính");
        lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGioiTinh.setBounds(559, 224, 83, 30);
        contentPane.add(lblGioiTinh);

        rdbtnNewRadioButton = new JRadioButton("Nam");
        rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnNewRadioButton.setBounds(658, 224, 90, 30);
        contentPane.add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_2 = new JRadioButton("Nữ");
        rdbtnNewRadioButton_2.setBackground(SystemColor.activeCaption);
        rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnNewRadioButton_2.setBounds(762, 224, 90, 30);
        contentPane.add(rdbtnNewRadioButton_2);

        btn_GioiTinh = new ButtonGroup();
        btn_GioiTinh.add(rdbtnNewRadioButton);
        btn_GioiTinh.add(rdbtnNewRadioButton_2);

        JLabel lblCCCD = new JLabel("CCCD");
        lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCCCD.setBounds(559, 329, 83, 30);
        contentPane.add(lblCCCD);

        textField_CCCD = new JTextField();
        textField_CCCD.setBounds(652, 332, 230, 30);
        contentPane.add(textField_CCCD);
        textField_CCCD.setColumns(10);

        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnThem.addActionListener(action);
        btnThem.setBounds(575, 383, 101, 30);
        contentPane.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSua.addActionListener(action);
        btnSua.setBounds(686, 383, 101, 30);
        contentPane.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnXoa.addActionListener(action);
        btnXoa.setBounds(797, 383, 101, 30);
        contentPane.add(btnXoa);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnLuu.addActionListener(action);
        btnLuu.setBounds(623, 423, 101, 30);
        contentPane.add(btnLuu);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnThoat.setForeground(Color.RED);
        btnThoat.addActionListener(action);
        btnThoat.setBounds(734, 423, 101, 30);
        contentPane.add(btnThoat);
        
        JLabel lblThngTinKhch = new JLabel("Thông Tin Khách Hàng");
        lblThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblThngTinKhch.setBounds(634, 11, 186, 30);
        contentPane.add(lblThngTinKhch);

        this.setVisible(true);
        loadKhachHangData();
    }
    
    private void loadKhachHangData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data from the table

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = DBConnection.getConnection();
            if (connection == null) {
                JOptionPane.showMessageDialog(this, "Cannot connect to the database!");
                return;
            }

            // Prepare SQL query
            String query = "SELECT * FROM Khach";
            statement = connection.prepareStatement(query);

            // Execute query
            resultSet = statement.executeQuery();

            // Process results and populate the table
            while (resultSet.next()) {
                String maKhach = resultSet.getString("MaKhach");
                String hoTen = resultSet.getString("HoTen");
                int tuoi = resultSet.getInt("Tuoi");
                String gioiTinh = resultSet.getString("GioiTinh");
                String sdt = resultSet.getString("SDT");
                String cccd = resultSet.getString("CCCD");

                // Add row to the table
                model.addRow(new Object[]{maKhach, hoTen, tuoi, gioiTinh, sdt, cccd});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void luuDuLieuKHVaoSQL() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        try {
            Connection connection = DBConnection.getConnection();
            String insertSQL = "INSERT INTO Khach (MaKhach, HoTen, Tuoi, GioiTinh, SDT, CCCD) VALUES (?, ?, ?, ?, ?, ?)";
            String updateSQL = "UPDATE Khach SET HoTen = ?, Tuoi = ?, GioiTinh = ?, SDT = ?, CCCD = ? WHERE MaKhach = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            for (int i = 0; i < rowCount; i++) {
                String maKhach = (String) model.getValueAt(i, 0);
                String hoTen = (String) model.getValueAt(i, 1);
                int tuoi = (int) model.getValueAt(i, 2);
                String gioiTinh = (String) model.getValueAt(i, 3);
                String sdt = (String) model.getValueAt(i, 4);
                String cccd = (String) model.getValueAt(i, 5);

                // Kiểm tra nếu dữ liệu đã tồn tại
                if (kiemTraTonTaiMaKhach(maKhach)) {
                    // Update dữ liệu
                    updateStatement.setString(1, hoTen);
                    updateStatement.setInt(2, tuoi);
                    updateStatement.setString(3, gioiTinh);
                    updateStatement.setString(4, sdt);
                    updateStatement.setString(5, cccd);
                    updateStatement.setString(6, maKhach);
                    updateStatement.executeUpdate();
                } else {
                    // Thêm mới dữ liệu
                    insertStatement.setString(1, maKhach);
                    insertStatement.setString(2, hoTen);
                    insertStatement.setInt(3, tuoi);
                    insertStatement.setString(4, gioiTinh);
                    insertStatement.setString(5, sdt);
                    insertStatement.setString(6, cccd);
                    insertStatement.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu vào cơ sở dữ liệu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu vào cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean kiemTraTonTaiMaKhach(String maKhach) {
        boolean exists = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            if (connection == null) {
                JOptionPane.showMessageDialog(this, "Cannot connect to the database!");
                return exists;
            }

            String query = "SELECT COUNT(*) FROM Khach WHERE MaKhach = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, maKhach);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                exists = (count > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return exists;
    }

    public void xoaForm() {
        textField_MaKhach.setText("");
        textField_HoTen.setText("");
        textField_Tuoi.setText("");
        textField_SDT.setText("");
        textField_CCCD.setText("");
        btn_GioiTinh.clearSelection();
    }

    public void themHoacSuaKhachHang(Khach kh) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();

        if (!this.model.kiemTraTonTai(kh)) {  // Đảm bảo rằng model là kiểu QLKHModel
            this.model.insert(kh);
            model_table.addRow(new Object[] {
                kh.getMaKhach(),
                kh.getHoTen(),
                kh.getTuoi(),
                (kh.isGioiTinh() ? "Nam" : "Nữ"),
                kh.getSDT(),
                kh.getCCCD()
            });
        } else {
            this.model.update(kh);
            for (int i = 0; i < model_table.getRowCount(); i++) {
                String makhach = model_table.getValueAt(i, 0) + "";
                if (makhach.equals(kh.getMaKhach())) {
                    model_table.setValueAt(kh.getMaKhach(), i, 0);
                    model_table.setValueAt(kh.getHoTen(), i, 1);
                    model_table.setValueAt(kh.getTuoi(), i, 2);
                    model_table.setValueAt((kh.isGioiTinh() ? "Nam" : "Nữ"), i, 3);
                    model_table.setValueAt(kh.getSDT(), i, 4);
                    model_table.setValueAt(kh.getCCCD(), i, 5);
                }
            }
        }
    }

    public Khach getKhachHangDangChon() {
        int i_row = table.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để hiển thị thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        String maKhach = model_table.getValueAt(i_row, 0) + "";
        String hoTen = model_table.getValueAt(i_row, 1) + "";
        int tuoi = Integer.parseInt(model_table.getValueAt(i_row, 2) + "");
        String gioiTinhStr = model_table.getValueAt(i_row, 3) + "";
        boolean gioiTinh = gioiTinhStr.equals("Nam");
        String sdt = model_table.getValueAt(i_row, 4) + "";
        String cccd = model_table.getValueAt(i_row, 5) + "";

        return new Khach(maKhach, hoTen, tuoi, gioiTinh, sdt, cccd);
    }

    public void hienThiThongTinKHdachon() {
        Khach kh = getKhachHangDangChon();
        if (kh != null) {
            this.textField_MaKhach.setText(kh.getMaKhach());
            this.textField_HoTen.setText(kh.getHoTen());
            this.textField_Tuoi.setText(String.valueOf(kh.getTuoi()));
            if (kh.isGioiTinh()) {
                rdbtnNewRadioButton.setSelected(true);
            } else {
                rdbtnNewRadioButton_2.setSelected(true);
            }
            this.textField_SDT.setText(kh.getSDT());
            this.textField_CCCD.setText(kh.getCCCD());
        } else {
            // Display a message if no Khach object is found
            JOptionPane.showMessageDialog(this, "Không có dữ liệu khách hàng được chọn.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }


    public void thucHienXoa() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            String maKhach = (String) model.getValueAt(selectedRow, 0); // Assuming the first column is the customer ID
            model.removeRow(selectedRow);

            try {
                Connection connection = DBConnection.getConnection();
                String deleteSQL = "DELETE FROM Khach WHERE MaKhach = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
                deleteStatement.setString(1, maKhach);
                deleteStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu từ cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    public boolean validateHoTen(String hoTen) {
        // Check if hoTen contains at least one space
        if (!hoTen.contains(" ")) {
            return false;
        }

        // Check if the first letter of each word is uppercase
        String[] words = hoTen.split("\\s+");
        for (String word : words) {
            if (!Character.isUpperCase(word.charAt(0))) {
                return false;
            }
        }

        return true;
    }

    public boolean validateTuoi(int tuoi) {
        // Check if tuoi is between 0 and 100
        return tuoi >= 0 && tuoi <= 100;
    }

    public boolean validateSDT(String sdt) {
        // Check if SDT contains exactly 10 digits
        return sdt.matches("\\d{10}");
    }

    public boolean validateCCCD(String cccd) {
        // Check if CCCD contains exactly 12 digits
        return cccd.matches("\\d{12}");
    }

	public void thucHienThemKhachHang() {
        String maKhach = this.textField_MaKhach.getText();
        String hoTen = this.textField_HoTen.getText();
        boolean gioiTinh = rdbtnNewRadioButton.isSelected();
        int tuoi = 0;
        if (!this.textField_Tuoi.getText().isEmpty()) {
            tuoi = Integer.parseInt(this.textField_Tuoi.getText());
        }
        String sdt = this.textField_SDT.getText();
        String cccd = this.textField_CCCD.getText();

        // Validate input fields
        if (!validateHoTen(hoTen)) {
            JOptionPane.showMessageDialog(this, "Họ tên không hợp lệ. Phải có ít nhất 1 khoảng trắng và ký tự đầu của mỗi từ viết hoa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validateTuoi(tuoi)) {
            JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ. Phải từ 0 đến 100.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validateSDT(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Phải có 10 chữ số và bắt đầu từ 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validateCCCD(cccd)) {
            JOptionPane.showMessageDialog(this, "Số CCCD không hợp lệ. Phải có 12 chữ số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Khach kh = new Khach(maKhach, hoTen, tuoi, gioiTinh, sdt, cccd);

        this.themHoacSuaKhachHang(kh);
        luuDuLieuKHVaoSQL();
        loadKhachHangData();
	}
}
