
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class myPage {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JTextField txt_newpw;
	private JTextField txt_newemail;
	private JTextField occur_cnt;

	DAO dao = new DAO();

	String click = "";	//회원정보수정시  <비밀번호수정 || 이메일수정 || (비밀번호&&이메일)수정> 구분하기 위함
	int cnt;
	int cnt2;
	int cnt3;
	int cnt4;

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

	public myPage(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	private void initialize(VO vo) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(772, 134, 375, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_title = new JLabel("");
		lbl_title.setIcon(new ImageIcon(myPage.class.getResource("/res/\uC791\uC740 \uD22C\uBA85.png")));
		// 타이틀 누르면 범죄조회 페이지로 이동
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				crime_main.main(null);
				crime_main crime = new crime_main(dao.check_alarm2(vo));
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(myPage.class.getResource("/res/check.png")));
		lblNewLabel_1.setBounds(29, 358, 47, 47);
		frame.getContentPane().add(lblNewLabel_1);
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 23));
		lbl_title.setBounds(131, 9, 97, 55);
		frame.getContentPane().add(lbl_title);

		JLabel lbl_setAlarm = new JLabel("\uC54C\uB78C \uC124\uC815");
		lbl_setAlarm.setForeground(new Color(0, 0, 128));
		lbl_setAlarm.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_setAlarm.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_setAlarm.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		lbl_setAlarm.setBackground(Color.WHITE);
		lbl_setAlarm.setBounds(71, 150, 275, 26);
		frame.getContentPane().add(lbl_setAlarm);

		JLabel lbl_editid = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		lbl_editid.setForeground(new Color(0, 0, 128));
		lbl_editid.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_editid.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_editid.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		lbl_editid.setBounds(71, 352, 275, 42);
		frame.getContentPane().add(lbl_editid);

		JLabel lbl_deleteid = new JLabel("\uD68C\uC6D0 \uD0C8\uD1F4");
		lbl_deleteid.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_deleteid.setBackground(Color.WHITE);
		lbl_deleteid.setForeground(new Color(0, 0, 128));
		lbl_deleteid.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_deleteid.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		lbl_deleteid.setBounds(71, 607, 275, 32);
		frame.getContentPane().add(lbl_deleteid);

		JLabel lbl_logout = new JLabel("");
		lbl_logout.setIcon(new ImageIcon(myPage.class.getResource("/res/logout2.png")));
		// 로그아웃버튼 클릭시 로그인&회원가입 페이지로
		lbl_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				login.main(null);
				login login = new login();
			}
		});
		lbl_logout.setBounds(307, 9, 40, 32);
		frame.getContentPane().add(lbl_logout);

		JLabel lbl_startalarm = new JLabel("\uC54C\uB78C \uC2DC\uC791\uC2DC\uAC04 \uC124\uC815");
		lbl_startalarm.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lbl_startalarm.setBounds(29, 216, 178, 15);
		frame.getContentPane().add(lbl_startalarm);

		JLabel lbl_endalarm = new JLabel("\uC54C\uB78C \uC885\uB8CC\uC2DC\uAC04 \uC124\uC815");
		lbl_endalarm.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lbl_endalarm.setBounds(29, 255, 178, 15);
		frame.getContentPane().add(lbl_endalarm);

		JLabel lbl_cnt = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uD69F\uC218 \uC124\uC815");
		lbl_cnt.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lbl_cnt.setBounds(29, 290, 178, 15);
		frame.getContentPane().add(lbl_cnt);

	
		//알람, 시작시간콤보박스 설정
		JComboBox combo_startalarm = new JComboBox();
		combo_startalarm.setBounds(158, 213, 189, 21);
//
		cnt2 = dao.check_alarm(vo);		//알람이 기존에 있는 회원인가? 확인!
		VO_alarm al_vo = dao.check_alarm2(vo);	//알람있는 회원의 알람시작시간을 --> 콤보박스 기본값으로 설정 위함
		frame.getContentPane().add(combo_startalarm);
		if (cnt2 > 0) { 
			//기존 알람 존재 ==> 회원정보에 따라 combo box 인덱스0값에 저장된 기존 알람시작시간 불러옴(al_vo.getSet_start()+":00")
			combo_startalarm.setModel(new DefaultComboBoxModel(new String[] { al_vo.getSet_start() + ":00", "12:00 AM",
					"1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM",
					"10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM",
					"6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM" }));
		} else {
			//기존 알람 미존재 ==> 인덱스0값에 아무것도 나오지 않게 함
			combo_startalarm.setModel(new DefaultComboBoxModel(new String[] { "", "12:00 AM", "1:00 AM", "2:00 AM",
					"3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM",
					"12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM",
					"9:00 PM", "10:00 PM", "11:00 PM" }));
		}
		combo_startalarm.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		combo_startalarm.setBackground(new Color(204, 204, 255));

		
		//알람, 종료시간콤보박스 설정
		JComboBox combo_endalarm = new JComboBox();
		combo_endalarm.setBounds(158, 252, 189, 21);
		frame.getContentPane().add(combo_endalarm);
//
		cnt2 = dao.check_alarm(vo);		//알람이 기존에 있는 회원인가? 확인!
		VO_alarm al_vo1 = dao.check_alarm2(vo);	//알람있는 회원의 알람종료시간을 --> 콤보박스 기본값으로 설정 위함
		if (cnt2 > 0) { 
			//기존 알람 존재 ==> 회원정보에 따라 combo box 인덱스0값에 저장된 기존 알람시종료시간 불러옴(al_vo1.getSet_end()+":00")
			combo_endalarm.setModel(new DefaultComboBoxModel(new String[] { al_vo1.getSet_end() + ":00", "12:00 AM",
					"1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM",
					"10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM",
					"6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM", "12:00 AM" }));
		} else {
			//기존 알람 미존재 ==> 인덱스0값에 아무것도 나오지 않게 함
			combo_endalarm.setModel(new DefaultComboBoxModel(new String[] { "", "12:00 AM", "1:00 AM", "2:00 AM",
					"3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM",
					"12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM",
					"9:00 PM", "10:00 PM", "11:00 PM", "12:00 AM" }));
		}
		combo_endalarm.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		combo_endalarm.setBackground(new Color(204, 204, 255));

		
		//알람, 범죄발생횟수 설정
		occur_cnt = new JTextField();
		occur_cnt.setBackground(new Color(255, 250, 250));
		occur_cnt.setFont(new Font("함초롬돋움", Font.BOLD, 12));

		cnt2 = dao.check_alarm(vo);	//알람이 기존에 있는 회원인가? 확인!
		if (cnt2 > 0) {
			//기존 알람 존재 ==> 회원정보에 따라 Jtxtfield에 저장된 기존 횟수 불러옴
			VO_alarm al_vo2 = dao.check_alarm2(vo);
			occur_cnt.setText(al_vo2.getCr_cnt());
		} else {
			//기존 알람 미존재 ==> 로그인페이지에서 넘어온 로그인 정보를 받아와 그 로그인 정보만 가져옴
			VO_alarm al_vo2 = new VO_alarm(vo.getId(),null,null,null);
		}
		occur_cnt.setBounds(158, 290, 189, 21);
		frame.getContentPane().add(occur_cnt);
		occur_cnt.setColumns(10);
		
		
		JButton btn_okalarm = new JButton("\uD655\uC778");
		btn_okalarm.setBackground(new Color(204, 204, 255));
		//알람 설정하기
		btn_okalarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int combo_startalarm1 = combo_startalarm.getSelectedIndex() - 1;	//인덱스1값이 문자열 12:00AM! 즉 인덱스-1로 인덱스번호와 시간을 동일하게 사용할 수 있게 설정
				int combo_endalarm1 = combo_endalarm.getSelectedIndex() - 1;
				int occur_cnt1 = Integer.parseInt(occur_cnt.getText());	//텍스트필드에 String으로 들어가게 설정해놓았기때문에 casting
				
				int result = JOptionPane.showConfirmDialog(null, "변경하신 내용으로 알람을 설정하시겠습니까?", "알람 설정", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					
					if (((combo_startalarm1 == -1&&combo_startalarm.getSelectedItem().equals("")) || (combo_endalarm1 == -1&&combo_endalarm.getSelectedItem().equals("")) || occur_cnt1 == 0)) {
						JOptionPane.showMessageDialog(null, "설정하지 않은 값이 존재합니다.", "알람 설정", JOptionPane.WARNING_MESSAGE);
					} else if ((combo_startalarm1 != -1 && combo_endalarm1 != -1 && occur_cnt1 != 0)) {	//시작,종료시간 및 횟수설정 빼놓지 않고 설정한 경우
						cnt2 = dao.check_alarm(vo);
						
						if (cnt2 > 0) {	//기존 알람 존재하는 회원(갱신)
							cnt = dao.sending_alarm(vo, combo_startalarm1, combo_endalarm1, occur_cnt1);
						} else {		//기존 알람 없는 회원(새로운 값 삽입)
							cnt = dao.sending_alarm2(vo, combo_startalarm1, combo_endalarm1, occur_cnt1);
						}

						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "알람이 설정 되었습니다.", "알람 설정", JOptionPane.INFORMATION_MESSAGE);
						} 
//						else {
//							
//						}
						
					} else if(!combo_startalarm.getSelectedItem().equals("")&&!combo_endalarm.getSelectedItem().equals("")&& occur_cnt1 != 0) { //기존에 설정된 알람이 있고, 횟수설정만 변경하려는 경우
						cnt2 = dao.check_alarm(vo);
						
						if (cnt2 > 0) {
							cnt = dao.sending_alarm(vo, Integer.parseInt(dao.check_alarm2(vo).getSet_start()),
									Integer.parseInt(dao.check_alarm2(vo).getSet_end()), occur_cnt1);
						} else {
							cnt = dao.sending_alarm2(vo, Integer.parseInt(dao.check_alarm2(vo).getSet_start()), 
									Integer.parseInt(dao.check_alarm2(vo).getSet_end()), occur_cnt1);
						}

						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "알람이 설정 되었습니다.", "알람 설정", JOptionPane.INFORMATION_MESSAGE);
						}
						//else {
//							JOptionPane.showMessageDialog(null, "설정하지 않은 값이 존재합니다22.", "알람 설정", JOptionPane.WARNING_MESSAGE);
//						}
					}
				} 
				else if ((result == JOptionPane.CLOSED_OPTION) || (result == JOptionPane.NO_OPTION)) {
					JOptionPane.showMessageDialog(null, "알람 설정 취소", "알람 설정", JOptionPane.WARNING_MESSAGE );
					return;
				}
			}
		});
		btn_okalarm.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		btn_okalarm.setBounds(250, 325, 97, 23);
		frame.getContentPane().add(btn_okalarm);

		
		JButton btn_deleteid = new JButton("\uC815\uB9D0 \uD0C8\uD1F4 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C ?");
		btn_deleteid.setBackground(new Color(204, 204, 255));
		btn_deleteid.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		// 회원탈퇴 구현
		btn_deleteid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "계속하시겠습니까?", "회원 탈퇴", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { // 사용자가 탈퇴를 원하는 경우

					if (cnt2 > 0) {	//알람이 있는 회원이라면
						JOptionPane.showMessageDialog(null, "회원 탈퇴 완료", "회원 탈퇴", JOptionPane.INFORMATION_MESSAGE);
						cnt4 = dao.delete_alarm(vo);	//알람을 먼저 삭제하고
						dao.delete(vo);					//회원 탈퇴
						frame.dispose();
						login login = new login();
					} else {		//설정된 알람이 없는 회원이라면
						JOptionPane.showMessageDialog(null, "회원 탈퇴 완료", "회원 탈퇴", JOptionPane.INFORMATION_MESSAGE);
						dao.delete(vo);					//바로 회원 탈퇴
						frame.dispose();
						login login = new login();
					}

				} else if ((result == JOptionPane.CLOSED_OPTION) || (result == JOptionPane.NO_OPTION)) {
					JOptionPane.showMessageDialog(null, "회원 탈퇴 취소", "회원 탈퇴", JOptionPane.WARNING_MESSAGE );
					return; // 사용자가 탈퇴취소 혹은 창닫기 버튼을 누른 경우
				}
			}
		});
		btn_deleteid.setBounds(28, 659, 318, 32);
		frame.getContentPane().add(btn_deleteid);

		JLabel lbl_id = new JLabel("\uC544\uC774\uB514");
		lbl_id.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lbl_id.setBounds(28, 426, 178, 15);
		frame.getContentPane().add(lbl_id);

		JLabel lbl_pw = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		lbl_pw.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lbl_pw.setBounds(28, 465, 178, 15);
		frame.getContentPane().add(lbl_pw);

		txt_id = new JTextField();
		txt_id.setBackground(new Color(255, 250, 250));
		txt_id.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		txt_id.setBounds(158, 423, 189, 21);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		txt_pw = new JTextField();
		txt_pw.setBackground(new Color(255, 250, 250));
		txt_pw.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		txt_pw.setBounds(158, 460, 189, 21);
		txt_pw.setColumns(10);
		frame.getContentPane().add(txt_pw);

		JLabel lbl_mypage = new JLabel("MY PAGE");
		lbl_mypage.setForeground(new Color(0, 0, 128));
		lbl_mypage.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mypage.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lbl_mypage.setBounds(126, 74, 106, 60);
		frame.getContentPane().add(lbl_mypage);

		JLabel lbl_newpw = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC218\uC815");
		lbl_newpw.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lbl_newpw.setBounds(28, 500, 178, 15);
		frame.getContentPane().add(lbl_newpw);

		JLabel lbl_newemail = new JLabel("\uC774\uBA54\uC77C \uC218\uC815");
		lbl_newemail.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lbl_newemail.setBounds(28, 536, 178, 15);
		frame.getContentPane().add(lbl_newemail);

		txt_newpw = new JTextField();
		txt_newpw.setBackground(new Color(255, 250, 250));
		txt_newpw.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		// 회원정보 수정시 pw란 클릭했는지? email란 클릭했는지? 구분하기 위함 (주의! 클릭말고 tap으로 필드 이동시 에러 발생)
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
		txt_newemail.setBackground(new Color(255, 250, 250));
		txt_newemail.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		// 회원정보 수정시 pw란 클릭했는지? email란 클릭했는지? 구분하기 위함 (주의! 클릭말고 tap으로 필드 이동시 에러 발생)
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
		btn_okedit.setBackground(new Color(204, 204, 255));
		//회원 정보 수정
		btn_okedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = txt_id.getText();			//필드에 받은 값을 가져와 변수에 저장
				String pw = txt_pw.getText();
				String newPw = txt_newpw.getText();
				String newEmail = txt_newemail.getText();

				if (click.equals("password")) {			//비밀번호 수정을 원하는 경우
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
				} else if (click.equals("email")) {		//이메일 수정을 원하는 경우
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
		btn_okedit.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		btn_okedit.setBounds(250, 574, 97, 23);
		frame.getContentPane().add(btn_okedit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(myPage.class.getResource("/res/check.png")));
		lblNewLabel.setBounds(28, 139, 47, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(myPage.class.getResource("/res/check.png")));
		lblNewLabel_1_1.setBounds(29, 602, 47, 47);
		frame.getContentPane().add(lblNewLabel_1_1);
	}
}