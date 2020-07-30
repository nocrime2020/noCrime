import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class crime_main {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					crime_main window = new crime_main();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public crime_main(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO vo) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 375,812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_악유아이콘 = new JLabel("");
		lblNewLabel_악유아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC545\uC720.png"));
		lblNewLabel_악유아이콘.setBounds(285, 420, 25, 23);
		frame.getContentPane().add(lblNewLabel_악유아이콘);
		
		JLabel lblNewLabel_상폭아이콘 = new JLabel("");
		lblNewLabel_상폭아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uD3ED\uC0C1.png"));
		lblNewLabel_상폭아이콘.setBounds(113, 506, 25, 29);
		frame.getContentPane().add(lblNewLabel_상폭아이콘);
		
		JLabel lblNewLabel_납치아이콘 = new JLabel("");
		lblNewLabel_납치아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uB0A9\uCE582.png"));
		lblNewLabel_납치아이콘.setBounds(99, 416, 25, 23);
		frame.getContentPane().add(lblNewLabel_납치아이콘);
		
		JLabel lblNewLabel_절강아이콘 = new JLabel("");
		lblNewLabel_절강아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC808\uAC15.png"));
		lblNewLabel_절강아이콘.setBounds(285, 459, 25, 23);
		frame.getContentPane().add(lblNewLabel_절강아이콘);
		
		JLabel lblNewLabel_살인아이콘 = new JLabel("");
		lblNewLabel_살인아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC0B42.png"));
		lblNewLabel_살인아이콘.setBounds(266, 506, 44, 29);
		frame.getContentPane().add(lblNewLabel_살인아이콘);
		
		JLabel lblNewLabel_강추아이콘 = new JLabel("");
		lblNewLabel_강추아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uAC15\uCD942.png"));
		lblNewLabel_강추아이콘.setBounds(113, 459, 25, 23);
		frame.getContentPane().add(lblNewLabel_강추아이콘);
		
		JLabel lblNewLabel_2 = new JLabel("MY PAGE");
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				myPage.main(null);
				myPage myPage = new myPage(vo);
			}
		});
		lblNewLabel_2.setBounds(257, 38, 81, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("SIGN OUT");
		lblNewLabel_2_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();
				
			}
		});
		lblNewLabel_2_1.setBounds(257, 20, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
		chckbxNewCheckBox_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2.setBounds(42, 506, 73, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
		chckbxNewCheckBox_2_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_1.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_1.setBounds(42, 459, 73, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("\uC808\uB3C4\uAC15\uAC04");
		chckbxNewCheckBox_2_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_2.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_2.setBounds(204, 459, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uB0A9\uCE58");
		chckbxNewCheckBox_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_1.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_1.setBounds(42, 416, 57, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2_2_1 = new JCheckBox("\uC545\uCDE8\uC720\uC778");
		chckbxNewCheckBox_2_2_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_2_1.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_2_1.setBounds(204, 416, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2_1);
		
		JCheckBox chckbxNewCheckBox_2_2_2 = new JCheckBox("\uC0B4\uC778");
		chckbxNewCheckBox_2_2_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_2_2.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_2_2.setBounds(204, 506, 49, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2_2);
		
		JLabel lblNewLabel_노크라임아이콘 = new JLabel("");
		lblNewLabel_노크라임아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740\uB85C\uACE0.png"));
		lblNewLabel_노크라임아이콘.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_노크라임아이콘.setBounds(12, 20, 89, 49);
		frame.getContentPane().add(lblNewLabel_노크라임아이콘);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(204, 204, 255));
		comboBox.setBounds(134, 212, 151, 18);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		comboBox_3.setEditable(true);
		comboBox_3.setBackground(new Color(204, 204, 255));
		comboBox_3.setBounds(134, 240, 151, 19);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		comboBox_4.setEditable(true);
		comboBox_4.setBackground(new Color(204, 204, 255));
		comboBox_4.setBounds(134, 269, 151, 19);
		frame.getContentPane().add(comboBox_4);
		
		textField = new JTextField();
		textField.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBackground(new Color(248, 248, 255));
		textField.setBounds(113, 333, 226, 21);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_초기화아이콘 = new JLabel("");
		lblNewLabel_초기화아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\small.png"));
		lblNewLabel_초기화아이콘.setBounds(313, 294, 25, 29);
		frame.getContentPane().add(lblNewLabel_초기화아이콘);
		
		JLabel lblNewLabel_3 = new JLabel("\uBC94\uC8C4 \uC815\uBCF4 \uC870\uD68C");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("함초롬돋움", Font.BOLD, 24));
		lblNewLabel_3.setBounds(62, 115, 234, 54);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uC704\uCE58");
		lblNewLabel_1_2.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(12, 206, 122, 28);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD\uC77C");
		lblNewLabel_1_1.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 329, 97, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 377, 97, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\uC81C\uBCF4\uD558\uAE30");
		lblNewLabel_2_1_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(257, 56, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(204, 204, 255));
		btnNewButton_1.setBounds(12, 545, 324, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
