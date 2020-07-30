import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class myPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					myPage window = new myPage();
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
	public myPage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 375, 812);
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
		lbl_title.setFont(new Font("±º∏≤", Font.PLAIN, 23));
		lbl_title.setBounds(28, 9, 217, 32);
		frame.getContentPane().add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("\uC54C\uB78C \uC124\uC815");
		lblNewLabel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(28, 150, 189, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		lblNewLabel_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 18));
		lblNewLabel_1.setBounds(28, 358, 217, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbl_delectid = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
		lbl_delectid.setBackground(Color.WHITE);
		lbl_delectid.setForeground(Color.BLACK);
		lbl_delectid.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_delectid.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 18));
		lbl_delectid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();
				
				
			}
		});
		lbl_delectid.setBounds(28, 617, 217, 32);
		frame.getContentPane().add(lbl_delectid);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();
				
			}
		});
		lblNewLabel_2_1.setBounds(1018, 22, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC54C\uB78C \uC2DC\uC791\uC2DC\uAC04 \uC124\uC815");
		lblNewLabel_2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(29, 216, 178, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("\uC54C\uB78C \uC885\uB8CC\uC2DC\uAC04 \uC124\uC815");
		lblNewLabel_2_2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(29, 255, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uD69F\uC218 \uC124\uC815");
		lblNewLabel_2_2_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		lblNewLabel_2_2_1.setBounds(29, 290, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 213, 189, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(158, 252, 189, 21);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(158, 287, 189, 21);
		frame.getContentPane().add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("\uC815\uB9D0 \uD0C8\uD1F4 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C ?");
		btnNewButton.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(28, 675, 318, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_3 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_2_3.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(28, 426, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2_3_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		lblNewLabel_2_3_1.setBounds(28, 465, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_3_1);
		
		textField = new JTextField();
		textField.setBounds(158, 423, 189, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 462, 189, 21);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		btnNewButton_1.setBounds(250, 325, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uD655\uC778");
		btnNewButton_1_1.setBounds(365, 496, 97, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("My Page");
		lblNewLabel_3.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 20));
		lblNewLabel_3.setBounds(65, 64, 98, 60);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\information_info_1565 (1).png"));
		lblNewLabel_4.setBounds(27, 74, 26, 42);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC218\uC815");
		lblNewLabel_2_3_1_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		lblNewLabel_2_3_1_1.setBounds(28, 500, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_3_1_1);
		
		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("\uC774\uBA54\uC77C \uC218\uC815");
		lblNewLabel_2_3_1_1_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		lblNewLabel_2_3_1_1_1.setBounds(28, 536, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_3_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 497, 189, 21);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 533, 189, 21);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton_1_2 = new JButton("\uD655\uC778");
		btnNewButton_1_2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		btnNewButton_1_2.setBounds(250, 574, 97, 23);
		frame.getContentPane().add(btnNewButton_1_2);
	}
}
