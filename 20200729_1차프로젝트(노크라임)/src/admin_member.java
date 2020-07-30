import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class admin_member {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					A_member window = new A_member();
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
	public admin_member() {
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
//				admin_select.main(null);
				admin_select admin_select = new admin_select();
				
			}
		});
		lbl_title.setFont(new Font("±º∏≤", Font.PLAIN, 23));
		lbl_title.setBounds(12, 10, 194, 27);
		frame.getContentPane().add(lbl_title);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				frame.dispose();
//				login.main(null);
				login login = new login();
			}
		});
		lblNewLabel_2_1.setBounds(278, 10, 81, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("\uD68C\uC6D0 \uAD00\uB9AC");
		lblNewLabel_3.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 24));
		lblNewLabel_3.setBounds(50, 59, 180, 60);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
