package FormNhanVien;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PhongCho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhongCho frame = new PhongCho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhongCho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Khách Sạn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(268, 22, 282, 30);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 764, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator(JSeparator.VERTICAL); // Đặt separator_1 là dọc
        separator_1.setBounds(160, 54, 2, 405); // Đặt chiều cao của separator_1 là 409
        contentPane.add(separator_1);
        
        JButton btnNewButton = new JButton("Thoát");
        btnNewButton.setBounds(38, 436, 89, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Phong");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(31, 54, 119, 64);
        contentPane.add(lblNewLabel_1);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 117, 152, 2);
        contentPane.add(separator_2);
        
        JLabel lblNewLabel_1_1 = new JLabel("Loại Phòng");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(31, 117, 119, 64);
        contentPane.add(lblNewLabel_1_1);
        
        JSeparator separator_2_1 = new JSeparator();
        separator_2_1.setBounds(-2, 192, 152, 2);
        contentPane.add(separator_2_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Dịch Vụ");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1_1.setBounds(31, 192, 119, 64);
        contentPane.add(lblNewLabel_1_1_1);
        
        JSeparator separator_2_1_1 = new JSeparator();
        separator_2_1_1.setBounds(-2, 256, 152, 2);
        contentPane.add(separator_2_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Thống Kê");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1_1_1.setBounds(31, 261, 119, 64);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        JLabel lblNewLabel_1_1_1_2 = new JLabel("Thông Tin Khách Hàng");
        lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1_1_2.setBounds(8, 336, 142, 64);
        contentPane.add(lblNewLabel_1_1_1_2);
        
        JSeparator separator_2_1_2 = new JSeparator();
        separator_2_1_2.setBounds(-2, 411, 152, 2);
        contentPane.add(separator_2_1_2);
        
        JSeparator separator_2_1_2_1 = new JSeparator();
        separator_2_1_2_1.setBounds(-2, 336, 152, 2);
        contentPane.add(separator_2_1_2_1);

       
	}	
}
