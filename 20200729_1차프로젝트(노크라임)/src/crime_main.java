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

public class crime_main {

	private JFrame frame;

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
	public crime_main() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1127, 777);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("\uB178(Know) \uD06C\uB77C\uC784");
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				crime_main.main(null);
				crime_main crime = new crime_main();
			}
		});
		lbl_title.setFont(new Font("±¼¸²", Font.PLAIN, 23));
		lbl_title.setBounds(12, 21, 180, 37);
		frame.getContentPane().add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("\uC704\uCE58");
		lblNewLabel.setBounds(31, 112, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lblNewLabel_1.setBounds(31, 152, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uAE30\uAC04");
		lblNewLabel_1_1.setBounds(31, 193, 57, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 109, 128, 18);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(112, 190, 204, 18);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setBounds(340, 191, 204, 18);
		frame.getContentPane().add(comboBox_2_1);
		
		JButton btn_reset = new JButton("\uCD08\uAE30\uD654");
		btn_reset.setBounds(99, 236, 81, 23);
		frame.getContentPane().add(btn_reset);
		
		JLabel lblNewLabel_2 = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				myPage.main(null);
				myPage myPage = new myPage();
			}
		});
		lblNewLabel_2.setBounds(925, 43, 81, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();
				
			}
		});
		lblNewLabel_2_1.setBounds(1018, 43, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("\uBC1C\uC0DD \uBC94\uC8C4 \uC81C\uBCF4");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				tipoff.main(null);
				tipoff tipoff = new tipoff();
				
				
			}
		});
		lblNewLabel_3.setBounds(925, 74, 101, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\uAD11\uC0B0\uAD6C", "\uB3D9\uAD6C", "\uC11C\uAD6C", "\uB0A8\uAD6C", "\uBD81\uAD6C"}));
		comboBox_3.setBounds(264, 109, 101, 19);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(389, 109, 142, 19);
		frame.getContentPane().add(comboBox_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uC0B4\uC778");
		chckbxNewCheckBox.setBounds(112, 148, 57, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uB0A9\uCE58");
		chckbxNewCheckBox_1.setBounds(425, 148, 57, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
		chckbxNewCheckBox_2.setBounds(173, 148, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
		chckbxNewCheckBox_2_1.setBounds(264, 148, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("\uC808\uB3C4\uAC15\uAC04");
		chckbxNewCheckBox_2_2.setBounds(340, 148, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2);
		
		JCheckBox chckbxNewCheckBox_2_2_1 = new JCheckBox("\uC545\uCDE8\uC720\uC778");
		chckbxNewCheckBox_2_2_1.setBounds(486, 148, 89, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\reset.png"));
		lblNewLabel_4.setBounds(72, 236, 853,418);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
