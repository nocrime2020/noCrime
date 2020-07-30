import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class tipoff {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					tipoff window = new tipoff();
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
	public tipoff(VO vo) {
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
		
		JLabel lblNewLabel = new JLabel("\uBC1C\uC0DD \uBC94\uC8C4 \uC81C\uBCF4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 24));
		lblNewLabel.setBounds(78, 56, 234, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CHOOSE PHOTO");
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		btnNewButton.setBounds(12, 553, 317, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 317, 97, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD\uC77C");
		lblNewLabel_1_1.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 257, 97, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBC94\uC8C4 \uC7A5\uC18C");
		lblNewLabel_1_2.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(12, 151, 97, 28);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(248, 248, 255));
		textField.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		textField.setBounds(110, 263, 226, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SEND");
		btnNewButton_1.setBackground(new Color(204, 204, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		
//					나중에 팝업창 넣기	(e.g., 제보완료!)
//			}
//		});
		btnNewButton_1.setBounds(12, 711, 324, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("* \uBAA8\uB4E0 \uC81C\uBCF4\uB294 \uC775\uBA85 \uBCF4\uC7A5\uB429\uB2C8\uB2E4 *");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lblNewLabel_2.setBounds(90, 744, 184, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC99D\uAC70 \uC790\uB8CC");
		lblNewLabel_1_1_1.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(12, 512, 97, 43);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
		chckbxNewCheckBox_2.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2.setBounds(31, 457, 73, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
		chckbxNewCheckBox_2_1.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_1.setBounds(31, 410, 73, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("\uC808\uB3C4\uAC15\uAC04");
		chckbxNewCheckBox_2_2.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_2.setBounds(193, 410, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uB0A9\uCE58");
		chckbxNewCheckBox_1.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_1.setBounds(31, 367, 57, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2_2_1 = new JCheckBox("\uC545\uCDE8\uC720\uC778");
		chckbxNewCheckBox_2_2_1.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_2_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_2_1.setBounds(193, 367, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 255));
		comboBox.setEditable(true);
		comboBox.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		comboBox.setBounds(110, 159, 151, 18);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(new Color(204, 204, 255));
		comboBox_3.setEditable(true);
		comboBox_3.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\uAD11\uC0B0\uAD6C", "\uB3D9\uAD6C", "\uC11C\uAD6C", "\uB0A8\uAD6C", "\uBD81\uAD6C"}));
		comboBox_3.setBounds(110, 187, 151, 19);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBackground(new Color(204, 204, 255));
		comboBox_4.setEditable(true);
		comboBox_4.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		comboBox_4.setBounds(110, 216, 151, 19);
		frame.getContentPane().add(comboBox_4);
		
		JLabel lblNewLabel_노크라임아이콘 = new JLabel("New label");
		lblNewLabel_노크라임아이콘.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_노크라임아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\\uC791\uC740\uB85C\uACE0.png"));
		lblNewLabel_노크라임아이콘.setBounds(12, 10, 89, 49);
		frame.getContentPane().add(lblNewLabel_노크라임아이콘);
		
		JCheckBox chckbxNewCheckBox_2_2_2 = new JCheckBox("\uC0B4\uC778");
		chckbxNewCheckBox_2_2_2.setBackground(new Color(230, 230, 250));
		chckbxNewCheckBox_2_2_2.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		chckbxNewCheckBox_2_2_2.setBounds(193, 457, 49, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2_2);
		
		JLabel lblNewLabel_초기화아이콘 = new JLabel("");
		lblNewLabel_초기화아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\small.png"));
		lblNewLabel_초기화아이콘.setBounds(287, 206, 25, 29);
		frame.getContentPane().add(lblNewLabel_초기화아이콘);
		
		JLabel lblNewLabel_강추아이콘 = new JLabel("");
		lblNewLabel_강추아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uAC15\uCD942.png"));
		lblNewLabel_강추아이콘.setBounds(110, 410, 25, 23);
		frame.getContentPane().add(lblNewLabel_강추아이콘);
		
		JLabel lblNewLabel_납치아이콘 = new JLabel("");
		lblNewLabel_납치아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uB0A9\uCE58.png"));
		lblNewLabel_납치아이콘.setBounds(96, 367, 25, 23);
		frame.getContentPane().add(lblNewLabel_납치아이콘);
		
		JLabel lblNewLabel_상폭아이콘 = new JLabel("");
		lblNewLabel_상폭아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uD3ED\uC0C1.png"));
		lblNewLabel_상폭아이콘.setBounds(110, 457, 25, 29);
		frame.getContentPane().add(lblNewLabel_상폭아이콘);
		
		JLabel lblNewLabel_절강아이콘 = new JLabel("");
		lblNewLabel_절강아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC808\uAC15.png"));
		lblNewLabel_절강아이콘.setBounds(282, 410, 25, 23);
		frame.getContentPane().add(lblNewLabel_절강아이콘);
		
		JLabel lblNewLabel_살인아이콘 = new JLabel("");
		lblNewLabel_살인아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC0B42.png"));
		lblNewLabel_살인아이콘.setBounds(250, 457, 44, 29);
		frame.getContentPane().add(lblNewLabel_살인아이콘);
		
		JLabel lblNewLabel_악유아이콘 = new JLabel("");
		lblNewLabel_악유아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC545\uC720.png"));
		lblNewLabel_악유아이콘.setBounds(282, 371, 25, 23);
		frame.getContentPane().add(lblNewLabel_악유아이콘);
	}
}
