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
	public tipoff() {
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
		lbl_title.setBounds(12, 25, 175, 39);
		frame.getContentPane().add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("\uBC1C\uC0DD \uBC94\uC8C4 \uC81C\uBCF4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 23));
		lblNewLabel.setBounds(346, 56, 363, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC0AC\uC9C4 \uC120\uD0DD");
		btnNewButton.setBounds(446, 309, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lblNewLabel_1.setBounds(268, 232, 67, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD\uC77C");
		lblNewLabel_1_1.setBounds(268, 271, 81, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBC94\uC8C4 \uC7A5\uC18C");
		lblNewLabel_1_2.setBounds(268, 194, 67, 15);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(446, 268, 251, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uC81C\uBCF4 \uC644\uB8CC");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		
//					³ªÁß¿¡ ÆË¾÷Ã¢ ³Ö±â	(e.g., Á¦º¸¿Ï·á!)
//			}
//		});
		btnNewButton_1.setBounds(433, 400, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("* \uBAA8\uB4E0 \uC81C\uBCF4\uB294 \uC775\uBA85 \uBCF4\uC7A5\uB429\uB2C8\uB2E4 *");
		lblNewLabel_2.setBounds(682, 154, 184, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC99D\uAC70 \uC790\uB8CC");
		lblNewLabel_1_1_1.setBounds(268, 309, 67, 15);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();

				
			}
		});
		lblNewLabel_2_1.setBounds(1018, 23, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uC0B4\uC778");
		chckbxNewCheckBox.setBounds(446, 228, 57, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
		chckbxNewCheckBox_2.setBounds(513, 228, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
		chckbxNewCheckBox_2_1.setBounds(598, 228, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("\uC808\uB3C4\uAC15\uAC04");
		chckbxNewCheckBox_2_2.setBounds(674, 228, 81, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uB0A9\uCE58");
		chckbxNewCheckBox_1.setBounds(759, 228, 57, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2_2_1 = new JCheckBox("\uC545\uCDE8\uC720\uC778");
		chckbxNewCheckBox_2_2_1.setBounds(821, 228, 89, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(447, 190, 128, 18);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\uAD11\uC0B0\uAD6C", "\uB3D9\uAD6C", "\uC11C\uAD6C", "\uB0A8\uAD6C", "\uBD81\uAD6C"}));
		comboBox_3.setBounds(599, 190, 101, 19);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(724, 190, 142, 19);
		frame.getContentPane().add(comboBox_4);
	}

}
