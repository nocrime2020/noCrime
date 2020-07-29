import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class myPage {

	private JFrame frame;

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
		lbl_title.setBounds(12, 22, 189, 32);
		frame.getContentPane().add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("\uC54C\uB78C \uC124\uC815");
		lblNewLabel.setBounds(144, 101, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		lblNewLabel_1.setBounds(144, 221, 97, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbl_delectid = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
		lbl_delectid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				login.main(null);
//				login login = new login();
				
				
			}
		});
		lbl_delectid.setBounds(144, 361, 57, 15);
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
	}

}
