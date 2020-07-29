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

public class myPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myPage window = new myPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public myPage() {
		initialize();
//		frame.setVisible(true);
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
				crime_main.main(null);
//				crime_main crime = new crime_main();
			}
		});
		lbl_title.setFont(new Font("±¼¸²", Font.PLAIN, 23));
		lbl_title.setBounds(48, 22, 189, 32);
		frame.getContentPane().add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("\uC54C\uB78C \uC124\uC815");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(143, 150, 189, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblNewLabel_1.setBounds(144, 344, 217, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbl_delectid = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
		lbl_delectid.setBackground(Color.WHITE);
		lbl_delectid.setForeground(Color.BLACK);
		lbl_delectid.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_delectid.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lbl_delectid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				login.main(null);
//				login login = new login();
				
				
			}
		});
		lbl_delectid.setBounds(144, 545, 217, 32);
		frame.getContentPane().add(lbl_delectid);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				login.main(null);
//				login login = new login();
				
			}
		});
		lblNewLabel_2_1.setBounds(1018, 22, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC54C\uB78C \uC2DC\uC791\uC2DC\uAC04 \uC124\uC815");
		lblNewLabel_2.setBounds(144, 216, 178, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("\uC54C\uB78C \uC885\uB8CC\uC2DC\uAC04 \uC124\uC815");
		lblNewLabel_2_2.setBounds(144, 255, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uD69F\uC218 \uC124\uC815");
		lblNewLabel_2_2_1.setBounds(144, 290, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(273, 213, 189, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(273, 252, 189, 21);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(273, 287, 189, 21);
		frame.getContentPane().add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("\uC815\uB9D0 \uD0C8\uD1F4 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C ?");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(144, 603, 318, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_3 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_3.setBounds(143, 410, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2_3_1.setBounds(143, 449, 178, 15);
		frame.getContentPane().add(lblNewLabel_2_3_1);
		
		textField = new JTextField();
		textField.setBounds(273, 407, 189, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(273, 446, 189, 21);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.setBounds(367, 318, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uD655\uC778");
		btnNewButton_1_1.setBounds(365, 496, 97, 23);
		frame.getContentPane().add(btnNewButton_1_1);
	}
}
