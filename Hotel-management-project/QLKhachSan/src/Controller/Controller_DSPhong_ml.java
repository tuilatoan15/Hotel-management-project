package Controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Data.DBConnection;
import FormThuephong.DanhSachPhong;
import FormThuephong.ThuePhong;

public class Controller_DSPhong_ml implements MouseListener {
    private DanhSachPhong danhSachPhong;
    private String soPhong;
   

    public Controller_DSPhong_ml(DanhSachPhong danhSachPhong) {
        this.danhSachPhong = danhSachPhong;
    }
  


    @Override
    public void mouseClicked(MouseEvent e) {
        Component component = e.getComponent();
        if (component instanceof JPanel) {
            JPanel panel = (JPanel) component;
            soPhong = panel.getName();
            System.out.println("Số phòng: " + soPhong);

            if (!soPhong.equals("NULL") && e.getButton() == MouseEvent.BUTTON1) {
                // Hiển thị hộp thoại lựa chọn tùy chọn
                String[] options = {"Đặt phòng", "Dọn phòng", "Xác nhận đã dọn phòng"};
                int choice = JOptionPane.showOptionDialog(danhSachPhong, "Hãy Chọn Chức Năng:", "Chức Năng",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                // Xử lý tùy chọn được chọn
                switch (choice) {
                    case 0: // Đặt phòng
                        handleDatPhong();
                        break;
                    case 1: // Dọn phòng
                        handleDonPhong();
                        break;
                    case 2: // Xác nhận dọn phòng
                        handleXacNhanDonPhong();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void handleDatPhong() {
        int confirm1 = JOptionPane.showConfirmDialog(danhSachPhong, "Bạn có muốn đặt phòng này?",
                "Xác nhận đặt phòng", JOptionPane.YES_NO_OPTION);
        if (confirm1 == JOptionPane.YES_OPTION) {
            ThuePhong Thuephong = new ThuePhong(soPhong, danhSachPhong); // Tạo một JFrame mới
            Thuephong.setVisible(true); // Hiển thị JFrame mới
        }
    }
// Dọn phòng
    private void handleDonPhong() {
        int confirm = JOptionPane.showConfirmDialog(danhSachPhong, "Bạn có muốn dọn phòng này?",
                "Xác nhận dọn phòng", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            updatePhong(2); // Cập nhật trạng thái phòng là đã dọn
        	danhSachPhong.dispose();
			new DanhSachPhong();
            
        }
    }
// Dọn xg
    private void handleXacNhanDonPhong() {
        int confirm = JOptionPane.showConfirmDialog(danhSachPhong, "Xác nhận phòng đã dọn xong", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            updatePhong(0); // Cập nhật trạng thái phòng là sẵn sàng
        	danhSachPhong.dispose();
			new DanhSachPhong();
        }
    }

    private void updatePhong(int trangThai) {
        String updateSql = "UPDATE Phong SET TrangThai = ? WHERE SoPhong = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
            updateStatement.setInt(1, trangThai);
            //updateStatement.setTimestamp(2, ngayTra);
            updateStatement.setString(2, soPhong);
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật trạng thái phòng thành công.");
            } else {
                System.out.println("Không tìm thấy phòng cần cập nhật.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}
