import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class myPage {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JTextField txt_newpw;
	private JTextField txt_newemail;
	String click = "";

	DAO dao = new DAO();
	private JTextField occur_cnt;
	
	int cnt;
	int cnt2;
	int cnt3;

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
	 * 
	 * @param vo
	 */
	public myPage(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO vo) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 375, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 타이틀 누르면 범죄조회 페이지로
		JLabel lbl_title = new JLabel("\uB178(Know) \uD06C\uB77C\uC784");
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
//				crime_main.main(null);
				crime_main crime = new crime_main(vo);
			}
		});
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 23));
		lbl_title.setBounds(28, 9, 217, 32);
		frame.getContentPane().add(lbl_title);

		JLabel lbl_setAlarm = new JLabel("\uC54C\uB78C \uC124\uC815");
		lbl_setAlarm.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		lbl_setAlarm.setBackground(Color.WHITE);
		lbl_setAlarm.setBounds(28, 150, 189, 26);
		frame.getContentPane().add(lbl_setAlarm);

		JLabel lbl_editid = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		lbl_editid.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		lbl_editid.setBounds(28, 358, 217, 42);
		frame.getContentPane().add(lbl_editid);

		JLabel lbl_deleteid = new JLabel("\uD68C\uC6D0 \uD0C8\uD1F4");
		lbl_deleteid.setBackground(Color.WHITE);
		lbl_deleteid.setForeground(Color.BLACK);
		lbl_deleteid.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_deleteid.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		lbl_deleteid.setBounds(28, 617, 217, 32);
		frame.getContentPane().add(lbl_deleteid);

		JLabel lbl_logout = new JLabel("\uB85C\uADF8\uC544\uC6C3");

		// 로그아웃버튼 클릭시 로그인&회원가입 페이지로
		lbl_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
//				login.main(null);
				login login = new login();

			}
		});
		lbl_logout.setBounds(294, 9, 81, 15);
		frame.getContentPane().add(lbl_logout);

		JLabel lbl_startalarm = new JLabel("\uC54C\uB78C \uC2DC\uC791\uC2DC\uAC04 \uC124\uC815");
		lbl_startalarm.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbl_startalarm.setBounds(29, 216, 178, 15);
		frame.getContentPane().add(lbl_startalarm);

		JLabel lbl_endalarm = new JLabel("\uC54C\uB78C \uC885\uB8CC\uC2DC\uAC04 \uC124\uC815");
		lbl_endalarm.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbl_endalarm.setBounds(29, 255, 178, 15);
		frame.getContentPane().add(lbl_endalarm);

		JLabel lbl_cnt = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uD69F\uC218 \uC124\uC815");
		lbl_cnt.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbl_cnt.setBounds(29, 290, 178, 15);
		frame.getContentPane().add(lbl_cnt);

		JComboBox combo_startalarm = new JComboBox();
		
		cnt2 = dao.check_alarm(vo);
			if (cnt2 > 0) {
				//String combo_startalarm1 = combo_startalarm.setSelectedIndex(vo);
				combo_startalarm.setModel(new DefaultComboBoxModel(new String[] { "", "12:00 AM", "1:00 AM", "2:00 AM",
						"3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM",
						"12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM",
						"9:00 PM", "10:00 PM", "11:00 PM" }));
			}
		
		combo_startalarm.setModel(new DefaultComboBoxModel(new String[] { "", "12:00 AM", "1:00 AM", "2:00 AM",
				"3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM",
				"12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM",
				"9:00 PM", "10:00 PM", "11:00 PM" }));
		combo_startalarm.setBounds(158, 213, 189, 21);
		frame.getContentPane().add(combo_startalarm);

	
		combo_startalarm.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		combo_startalarm.setBackground(new Color(204, 204, 255));

		JComboBox combo_endalarm = new JComboBox();
		combo_endalarm.setBounds(158, 252, 189, 21);
		frame.getContentPane().add(combo_endalarm);
		combo_endalarm.setModel(new DefaultComboBoxModel(new String[] { "", "12:00 AM", "1:00 AM", "2:00 AM",
				"3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM",
				"12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM",
				"9:00 PM", "10:00 PM", "11:00 PM" }));
		combo_endalarm.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		combo_endalarm.setBackground(new Color(204, 204, 255));

		
		occur_cnt = new JTextField();
		occur_cnt.setBounds(158, 290, 189, 21);
		frame.getContentPane().add(occur_cnt);
		occur_cnt.setColumns(10);

		JButton btn_deleteid = new JButton("\uC815\uB9D0 \uD0C8\uD1F4 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C ?");
		// 회원탈퇴 구현
		btn_deleteid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "계속하시겠습니까?", "회원 탈퇴", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { // 사용자가 탈퇴를 원하는 경우
					dao.delete(vo);
					frame.dispose();
					login login = new login();
				} else if ((result == JOptionPane.CLOSED_OPTION) || (result == JOptionPane.NO_OPTION)) {
					return; // 사용자가 탈퇴취소 혹은 창닫기 버튼을 누른 경우
				}

			}
		});
		btn_deleteid.setBounds(28, 675, 318, 32);
		frame.getContentPane().add(btn_deleteid);

		JLabel lbl_id = new JLabel("\uC544\uC774\uB514");
		lbl_id.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbl_id.setBounds(28, 426, 178, 15);
		frame.getContentPane().add(lbl_id);

		JLabel lbl_pw = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		lbl_pw.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbl_pw.setBounds(28, 465, 178, 15);
		frame.getContentPane().add(lbl_pw);

		txt_id = new JTextField();
		txt_id.setBounds(158, 423, 189, 21);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		txt_pw = new JTextField();
		txt_pw.setColumns(10);
		txt_pw.setBounds(158, 462, 189, 21);
		frame.getContentPane().add(txt_pw);

		JButton btn_okalarm = new JButton("\uD655\uC778");
		btn_okalarm.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			int combo_startalarm1 = combo_startalarm.getSelectedIndex()-1;
			int combo_endalarm1 = combo_endalarm.getSelectedIndex()-1;
			int occur_cnt1 = Integer.parseInt(occur_cnt.getText().toString());
			int result = JOptionPane.showConfirmDialog(null, "확인", "알람", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				if ((combo_startalarm1 !=-1 && combo_endalarm1 != -1 && occur_cnt1 != 0)) {
					
					cnt2 = dao.check_alarm(vo);
					if (cnt2 > 0) {
						
						
						
						cnt = dao.sending_alarm( vo , combo_startalarm1, combo_endalarm1, occur_cnt1);
					}else {
						cnt = dao.sending_alarm2( vo , combo_startalarm1, combo_endalarm1, occur_cnt1);
					}
					
					
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "알람이 설정 되었습니다.");
					} else {
						JOptionPane.showMessageDialog(null, "내용을 입력해주세요.", "알람",
								JOptionPane.INFORMATION_MESSAGE);
					
					}
				}
			}

			 else if ((result == JOptionPane.CLOSED_OPTION) || (result == JOptionPane.NO_OPTION)) {
				return;
			}

		}
		});
		
		btn_okalarm.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btn_okalarm.setBounds(250, 325, 97, 23);
		frame.getContentPane().add(btn_okalarm);
		
		

		JLabel lbl_mypage = new JLabel("My Page");
		lbl_mypage.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lbl_mypage.setBounds(65, 64, 98, 60);
		frame.getContentPane().add(lbl_mypage);

		JLabel lbl_iconmypage = new JLabel("");
		lbl_iconmypage.setIcon(new ImageIcon(
				"C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\information_info_1565 (1).png"));
		lbl_iconmypage.setBounds(27, 74, 26, 42);
		frame.getContentPane().add(lbl_iconmypage);

		JLabel lbl_newpw = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC218\uC815");
		lbl_newpw.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbl_newpw.setBounds(28, 500, 178, 15);
		frame.getContentPane().add(lbl_newpw);

		JLabel lbl_newemail = new JLabel("\uC774\uBA54\uC77C \uC218\uC815");
		lbl_newemail.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbl_newemail.setBounds(28, 536, 178, 15);
		frame.getContentPane().add(lbl_newemail);

		txt_newpw = new JTextField();
		// 회원정보 수정시 pw란 클릭했는지? email란 클릭했는지? 구분하기 위함 (주의! 클릭말고 tap으로 하면 에러 발생)
		txt_newpw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click += "password";
			}
		});
		txt_newpw.setColumns(10);
		txt_newpw.setBounds(158, 497, 189, 21);
		frame.getContentPane().add(txt_newpw);

		txt_newemail = new JTextField();
		// 회원정보 수정시 pw란 클릭했는지? email란 클릭했는지? 구분하기 위함 (주의! 클릭말고 tap으로 하면 에러 발생)
		txt_newemail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click += "email";
			}
		});
		txt_newemail.setColumns(10);
		txt_newemail.setBounds(158, 533, 189, 21);
		frame.getContentPane().add(txt_newemail);

		JButton btn_okedit = new JButton("\uD655\uC778");

		btn_okedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = txt_id.getText();
				String pw = txt_pw.getText();
				String newPw = txt_newpw.getText();
				String newEmail = txt_newemail.getText();

				// 2. DAO update문을 수정한다! 매개변수를 vo만 받게!
				// 3. vo.getId()
				if (click.equals("password")) {
					updateVO updatevo = new updateVO(id, pw, newPw, click);
					int cnt = dao.update(updatevo);
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "비밀번호 수정 완료", "회원 정보 수정", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						login login = new login();
					} else {
						JOptionPane.showMessageDialog(null, "정보 수정 실패", "회원 정보 수정", JOptionPane.ERROR_MESSAGE);
//						txt_newpw.setText("");
//						txt_newemail.setText("");
						myPage myPage = new myPage(vo);
					}
				} else if (click.equals("email")) {
					updateVO updatevo = new updateVO(id, pw, newEmail, click);
					int cnt = dao.update(updatevo);
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "이메일 수정 완료", "회원 정보 수정", JOptionPane.INFORMATION_MESSAGE);
//						frame.dispose();
//						login login = new login();
//						txt_newemail.setText("");
						myPage myPage = new myPage(vo); // 이메일만 수정시 굳이 로그인을 다시 할 필요는 없음

					} else {
						JOptionPane.showMessageDialog(null, "정보 수정 실패", "회원 정보 수정", JOptionPane.ERROR_MESSAGE);
//						txt_newpw.setText("");
//						txt_newemail.setText("");
						myPage myPage = new myPage(vo);
					}
				} else {
					updateVO updatevo = new updateVO(id, pw, newPw, newEmail, click);
					int cnt = dao.update(updatevo);
					if (cnt > 0) {
						JOptionPane.showMessageDialog(null, "회원 정보 수정 완료", "회원 정보 수정", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						login login = new login();
					} else {
						JOptionPane.showMessageDialog(null, "정보 수정 실패", "회원 정보 수정", JOptionPane.ERROR_MESSAGE);
//						txt_newpw.setText("");
//						txt_newemail.setText("");
						myPage myPage = new myPage(vo);
					}
				}

			}
		});
		btn_okedit.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btn_okedit.setBounds(250, 574, 97, 23);
		frame.getContentPane().add(btn_okedit);
		
		}
}
