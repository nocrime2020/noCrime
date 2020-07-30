import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JButton;

public class admin_tipoff {

	private JFrame frame;
	private JTable table;

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
//				login login = new login();
				
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
		
		JLabel lblNewLabel_5 = new JLabel("\uC81C\uBCF4 \uAD00\uB9AC");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 24));
		lblNewLabel_5.setBounds(90, 76, 180, 60);
		frame.getContentPane().add(lblNewLabel_5);
		
		table = new JTable();
		table.setBounds(36, 169, 287, 493);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("\uC804\uC1A1 \uD558\uAE30");
		btnNewButton.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 14));
		btnNewButton.setBounds(36, 682, 287, 43);
		frame.getContentPane().add(btnNewButton);
	}
}
