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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class crime_main {

	private JFrame frame;
	private JTextField txt_period;

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
	public crime_main(VO vo) {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 110, 359, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbll_악유아이콘 = new JLabel("");
		lbll_악유아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC545\uC720.png"));
		lbll_악유아이콘.setBounds(285, 310, 25, 23);
		panel.add(lbll_악유아이콘);
		
		JLabel lbl_상폭아이콘 = new JLabel("");
		lbl_상폭아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uD3ED\uC0C1.png"));
		lbl_상폭아이콘.setBounds(113, 396, 25, 29);
		panel.add(lbl_상폭아이콘);
		
		JLabel lbll_납치아이콘 = new JLabel("");
		lbll_납치아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uB0A9\uCE582.png"));
		lbll_납치아이콘.setBounds(99, 306, 25, 23);
		panel.add(lbll_납치아이콘);
		
		JLabel lbl_절강아이콘 = new JLabel("");
		lbl_절강아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC808\uAC15.png"));
		lbl_절강아이콘.setBounds(285, 349, 25, 23);
		panel.add(lbl_절강아이콘);
		
		JLabel lbl_살인아이콘 = new JLabel("");
		lbl_살인아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC0B42.png"));
		lbl_살인아이콘.setBounds(266, 396, 44, 29);
		panel.add(lbl_살인아이콘);
		
		JLabel lbl_강추아이콘 = new JLabel("");
		lbl_강추아이콘.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uAC15\uCD942.png"));
		lbl_강추아이콘.setBounds(113, 349, 25, 23);
		panel.add(lbl_강추아이콘);
		
		JLabel lbl_mypage = new JLabel("MY PAGE");
		lbl_mypage.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbl_mypage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				myPage.main(null);
				myPage myPage = new myPage(vo);
			}
		});
		lbl_mypage.setBounds(257, 38, 81, 15);
		frame.getContentPane().add(lbl_mypage);
		
		JLabel lbl_signout = new JLabel("SIGN OUT");
		lbl_signout.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbl_signout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
//				login.main(null);
				login login = new login();
				
			}
		});
		lbl_signout.setBounds(257, 20, 81, 15);
		frame.getContentPane().add(lbl_signout);
		
		JCheckBox check_상해폭행 = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
		check_상해폭행.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		check_상해폭행.setBackground(new Color(230, 230, 250));
		check_상해폭행.setBounds(42, 396, 73, 23);
		panel.add(check_상해폭행);
		
		JCheckBox check_강간추행 = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
		check_강간추행.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		check_강간추행.setBackground(new Color(230, 230, 250));
		check_강간추행.setBounds(42, 349, 73, 23);
		panel.add(check_강간추행);
		
		JCheckBox check_절도강간 = new JCheckBox("\uC808\uB3C4\uAC15\uAC04");
		check_절도강간.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		check_절도강간.setBackground(new Color(230, 230, 250));
		check_절도강간.setBounds(204, 349, 81, 23);
		panel.add(check_절도강간);
		
		JCheckBox check_납치 = new JCheckBox("\uB0A9\uCE58");
		check_납치.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		check_납치.setBackground(new Color(230, 230, 250));
		check_납치.setBounds(42, 306, 57, 23);
		panel.add(check_납치);
		
		JCheckBox check_악취유인 = new JCheckBox("\uC545\uCDE8\uC720\uC778");
		check_악취유인.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		check_악취유인.setBackground(new Color(230, 230, 250));
		check_악취유인.setBounds(204, 306, 81, 23);
		panel.add(check_악취유인);
		
		JCheckBox check_살인 = new JCheckBox("\uC0B4\uC778");
		check_살인.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		check_살인.setBackground(new Color(230, 230, 250));
		check_살인.setBounds(204, 396, 49, 23);
		panel.add(check_살인);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740\uB85C\uACE0.png"));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(12, 20, 89, 49);
		frame.getContentPane().add(lbl_title);
		
		JComboBox combo_city = new JComboBox();
		combo_city.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		combo_city.setEditable(true);
		combo_city.setBackground(new Color(204, 204, 255));
		combo_city.setBounds(134, 102, 151, 18);
		panel.add(combo_city);
		
		JComboBox combo_gu = new JComboBox();
		combo_gu.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		combo_gu.setEditable(true);
		combo_gu.setBackground(new Color(204, 204, 255));
		combo_gu.setBounds(134, 130, 151, 19);
		panel.add(combo_gu);
		
		JComboBox combo_street = new JComboBox();
		combo_street.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		combo_street.setEditable(true);
		combo_street.setBackground(new Color(204, 204, 255));
		combo_street.setBounds(134, 159, 151, 19);
		panel.add(combo_street);
		
		txt_period = new JTextField();
		txt_period.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		txt_period.setColumns(10);
		txt_period.setBackground(new Color(248, 248, 255));
		txt_period.setBounds(113, 223, 226, 21);
		panel.add(txt_period);
		
		JLabel lbl_crimeinfo = new JLabel("\uBC94\uC8C4 \uC815\uBCF4 \uC870\uD68C");
		lbl_crimeinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_crimeinfo.setFont(new Font("함초롬돋움", Font.BOLD, 24));
		lbl_crimeinfo.setBounds(62, 5, 234, 54);
		panel.add(lbl_crimeinfo);
		
		JLabel lbl_location = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uC704\uCE58");
		lbl_location.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lbl_location.setBounds(12, 96, 122, 28);
		panel.add(lbl_location);
		
		JLabel lbl_date = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD\uC77C");
		lbl_date.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lbl_date.setBounds(12, 219, 97, 28);
		panel.add(lbl_date);
		
		JLabel lbl_sort = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lbl_sort.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lbl_sort.setBounds(12, 267, 97, 29);
		panel.add(lbl_sort);
		
		JLabel lbl_tipoff = new JLabel("\uC81C\uBCF4\uD558\uAE30");
		lbl_tipoff.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbl_tipoff.setBounds(257, 56, 81, 15);
		frame.getContentPane().add(lbl_tipoff);
		
		JButton btn_search = new JButton("SEARCH");
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setBounds(0, 106, 1, 1);
			}
		});
		btn_search.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		btn_search.setBackground(new Color(204, 204, 255));
		btn_search.setBounds(12, 435, 324, 23);
		panel.add(btn_search);
		
		JLabel lbl_reset = new JLabel("");
		lbl_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				panel.setBounds(0, 110, 359, 663);
			}
		});
		lbl_reset.setBounds(12, 79, 25, 29);
		frame.getContentPane().add(lbl_reset);
		lbl_reset.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\small.png"));
		
	}
}
