package FormThuephong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class DanhSachPhong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhSachPhong frame = new DanhSachPhong();
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
	public DanhSachPhong() {
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
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(4, 54, 153, 77);
        contentPane.add(scrollPane);
        
        JLabel lblNewLabel_1 = new JLabel("Tìm kiếm ");
        scrollPane.setRowHeaderView(lblNewLabel_1);
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true); // Set JTextArea để tự động xuống dòng
        scrollPane.setViewportView(textArea);
        
        JLabel lblNewLabel_2 = new JLabel("Lọc Theo :");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(48, 129, 79, 30);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Giá : ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(10, 174, 69, 22);
        contentPane.add(lblNewLabel_3);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(6, 157, 144, 2);
        contentPane.add(separator_2);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("");
        rdbtnNewRadioButton.setBounds(130, 206, 21, 23);
        contentPane.add(rdbtnNewRadioButton);
        
        JLabel lblNewLabel_4 = new JLabel("50.000-100.000");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(10, 207, 99, 14);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("100.000-200.000");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4_1.setBounds(10, 232, 99, 14);
        contentPane.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_4_2 = new JLabel("200.000 trở lên");
        lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4_2.setBounds(10, 259, 99, 14);
        contentPane.add(lblNewLabel_4_2);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
        rdbtnNewRadioButton_1.setBounds(130, 232, 21, 23);
        contentPane.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
        rdbtnNewRadioButton_2.setBounds(130, 256, 21, 23);
        contentPane.add(rdbtnNewRadioButton_2);
        
        JComboBox<Integer> comboBox = new JComboBox<>();
        comboBox.setBounds(81, 309, 69, 22);
        contentPane.add(comboBox);

        // Thêm các số từ 1 đến 4 vào JComboBox
        for (int i = 1; i <= 4; i++) {
            comboBox.addItem(i);
        }

        
        JSeparator separator_2_1 = new JSeparator();
        separator_2_1.setBounds(10, 296, 144, 2);
        contentPane.add(separator_2_1);
        
        JLabel lblNewLabel_3_1 = new JLabel("Số Người");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1.setBounds(10, 308, 69, 22);
        contentPane.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Loại Phòng");
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1_1.setBounds(10, 361, 69, 22);
        contentPane.add(lblNewLabel_3_1_1);    
        
        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(81, 362, 81, 22); // Điều chỉnh kích thước của JComboBox để hiển thị đủ văn bản
        contentPane.add(comboBox_1);

        // Thêm các tên vào JComboBox
        comboBox_1.addItem("Thương Gia");
        comboBox_1.addItem("Cao Cấp");
        comboBox_1.addItem("Trung Cấp");
        comboBox_1.addItem("Bình Dân");
        

        
        JButton btnNewButton_1 = new JButton("Search");
        btnNewButton_1.setBounds(38, 402, 89, 23);
        contentPane.add(btnNewButton_1);
        
        JSeparator separator_2_1_1 = new JSeparator();
        separator_2_1_1.setBounds(10, 342, 144, 2);
        contentPane.add(separator_2_1_1);
        setVisible(true);
    }
}
