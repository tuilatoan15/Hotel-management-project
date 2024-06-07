package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Data.DBConnection;
import FormThuephong.DanhSachPhong;
import FormUser.FormDk;
import FormUser.FormDn;

public class QLKSController_FormDn implements ActionListener {
    public FormDn dn;
    private String tenDangNhap;
    private String matKhau;

    public QLKSController_FormDn(FormDn dn) {
        this.dn = dn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = dn.txtUsername.getText();
        String password = new String(dn.txtPassWord.getPassword());
        String ac = e.getActionCommand();

        if (ac.equals("Đăng Nhập")) {
            if (username.equals("")) {
                JOptionPane.showMessageDialog(dn, "Bạn chưa Nhập tài khoản:");
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(dn, "Bạn chưa Nhập mật khẩu:");
            } else {
                if (check(username, password)) {
                    JOptionPane.showMessageDialog(dn, "Bạn đã đăng nhập thành công!");
                    DanhSachPhong Ds = new DanhSachPhong(); // Tạo một JFrame mới
                    Ds.setVisible(true); // Hiển thị JFrame mới
                    dn.dispose(); // Đóng JFrame hiện tại
                } else {
                    JOptionPane.showMessageDialog(dn, "Tên Đăng nhập hoặc mật khẩu bị sai:");
                }
            }
        }

        if (ac.equals("Đăng Kí")) {
            FormDk formDk = new FormDk(); // Tạo một JFrame mới
            formDk.setVisible(true); // Hiển thị JFrame mới
            dn.dispose(); // Đóng JFrame hiện tại
        }
    }

    private boolean check(String username, String password) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT TenDangNhap, MatKhau FROM NguoiDung WHERE TenDangNhap = ? AND MatKhau = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        tenDangNhap = resultSet.getString("TenDangNhap");
                        matKhau = resultSet.getString("MatKhau");

                        // In ra hoặc xử lý giá trị lấy được
                        System.out.println("Tên đăng nhập từ sql: " + tenDangNhap);
                        System.out.println("Mật khẩu từ sql: " + matKhau);
                        return true; // Nếu tìm thấy bản ghi trùng khớp, trả về true
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(dn, "Có lỗi xảy ra khi kết nối đến cơ sở dữ liệu:");
        }
        return false; // Nếu không tìm thấy bản ghi trùng khớp, trả về false
    }
}
