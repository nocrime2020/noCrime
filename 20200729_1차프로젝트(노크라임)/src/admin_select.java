import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_select {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					A_select window = new A_select();
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
	public admin_select() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 375, 812);
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setIcon(new ImageIcon("C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\\uC791\uC740 \uD22C\uBA85.png"));
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				admin_select.main(null);
				admin_select admin_select = new admin_select();
			}
		});
		lbl_title.setFont(new Font("±º∏≤", Font.PLAIN, 23));
		lbl_title.setBounds(12, 10, 103, 56);
		frame.getContentPane().add(lbl_title);
		
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\off_logout_17916.png"));
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();
				
			}
		});
		lblNewLabel_2_1.setBounds(307, 10, 40, 29);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("\uAD00\uB9AC\uC790 \uBA54\uB274");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 24));
		lblNewLabel_4.setBounds(89, 100, 180, 60);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\uC81C\uBCF4\uAD00\uB9AC \uD398\uC774\uC9C0");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 16));
		btnNewButton.setBounds(50, 219, 253, 75);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				admin_tipoff.main(null);
				admin_tipoff admin_tipoff = new admin_tipoff();
			
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("\uD68C\uC6D0\uAD00\uB9AC \uD398\uC774\uC9C0");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton1.setBackground(SystemColor.activeCaption);
		btnNewButton1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 16));
		btnNewButton1.setBounds(50, 349, 253, 75);
		btnNewButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				admin_member.main(null);
				admin_member admin_member = new admin_member();
			}
		});
		frame.getContentPane().add(btnNewButton1);
		
		JButton btnNewButton2 = new JButton("\uBC94\uC8C4\uC815\uBCF4 \uD398\uC774\uC9C0");
		btnNewButton2.setBackground(SystemColor.activeCaption);
		btnNewButton2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 16));
		btnNewButton2.setBounds(50, 480, 253, 75);
		btnNewButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				crime_main.main(null);
				crime_main crime = new crime_main();
			}
		});
		frame.getContentPane().add(btnNewButton2);
	}

}
