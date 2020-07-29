import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class admin_tipoff {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					A_tipoff window = new A_tipoff();
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
	public admin_tipoff() {
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
//				admin_select.main(null);
				admin_select admin_select = new admin_select();
//				login login = new login();
				
			}
		});
		lbl_title.setFont(new Font("±¼¸²", Font.PLAIN, 23));
		lbl_title.setBounds(12, 10, 174, 39);
		frame.getContentPane().add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("\uBC94\uC8C4 \uC81C\uBCF4 \uAD00\uB9AC ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(300, 50, 474, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\uAD00\uB9AC\uC790\uB2D8 \uC548\uB155\uD558\uC138\uC694!");
		lblNewLabel_3.setBounds(960, 26, 128, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();
			}
		});
		lblNewLabel_2_1.setBounds(1030, 50, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
	}

}
