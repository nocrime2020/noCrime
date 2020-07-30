import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class login {

	private JFrame frame;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JLabel lbl_signup;
	private JLabel lbl_name;
	private JLabel lbl_newid;
	private JLabel lbl_newpw;
	private JLabel lbl_email;
	private JTextField txt_name;
	private JTextField txt_newid;
	private JTextField txt_newpw;
	private JTextField txt_newemail;
	private JButton btn_signup;
	private JLabel lbl_title;

	DAO dao = new DAO();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					login window = new login();
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
	public login() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(100, 100, 1127, 777);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_id = new JLabel("\uC544\uC774\uB514");
		lbl_id.setBounds(646, 28, 57, 15);
		frame.getContentPane().add(lbl_id);
		
		JLabel lbl_pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_pw.setBounds(816, 28, 57, 15);
		frame.getContentPane().add(lbl_pw);
		
		txt_id = new JTextField();
		txt_id.setBounds(646, 53, 155, 21);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setBounds(816, 53, 155, 21);
		txt_pw.setColumns(10);
		frame.getContentPane().add(txt_pw);
		
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				
				VO vo = new VO(id, pw);
				VO result = dao.login(vo);
				
				if(result != null) {
					if (vo.getId().equals("admin")) {	//관리자는 관리자페이지
						frame.dispose();
						admin_select asel = new admin_select();
					} else {
						frame.dispose();
						crime_main crime = new crime_main();
					}
				} else {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 다시 확인하세요", "로그인 실패", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btn_login.setBounds(990, 52, 97, 23);
		frame.getContentPane().add(btn_login);
		
		lbl_signup = new JLabel("\uAC00\uC785\uD558\uAE30");
		lbl_signup.setBounds(580, 141, 97, 30);
		lbl_signup.setFont(new Font("굴림", Font.PLAIN, 20));
		frame.getContentPane().add(lbl_signup);
		
		lbl_name = new JLabel("\uC774\uB984");
		lbl_name.setBounds(580, 198, 57, 15);
		frame.getContentPane().add(lbl_name);
		
		lbl_newid = new JLabel("\uC544\uC774\uB514");
		lbl_newid.setBounds(580, 239, 57, 15);
		frame.getContentPane().add(lbl_newid);
		
		lbl_newpw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_newpw.setBounds(580, 284, 57, 15);
		frame.getContentPane().add(lbl_newpw);
		
		lbl_email = new JLabel("\uC774\uBA54\uC77C");
		lbl_email.setBounds(580, 329, 57, 15);
		frame.getContentPane().add(lbl_email);
		
		txt_name = new JTextField();
		txt_name.setBounds(661, 195, 155, 21);
		txt_name.setColumns(10);
		frame.getContentPane().add(txt_name);
		
		txt_newid = new JTextField();
		txt_newid.setBounds(661, 236, 155, 21);
		txt_newid.setColumns(10);
		frame.getContentPane().add(txt_newid);
		
		txt_newpw = new JTextField();
		txt_newpw.setBounds(661, 281, 155, 21);
		txt_newpw.setColumns(10);
		frame.getContentPane().add(txt_newpw);
		
		txt_newemail = new JTextField();
		txt_newemail.setBounds(661, 326, 155, 21);
		txt_newemail.setColumns(10);
		frame.getContentPane().add(txt_newemail);
		
		btn_signup = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_signup.setBounds(580, 376, 97, 23);
		frame.getContentPane().add(btn_signup);
		
		lbl_title = new JLabel("");
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				login.main(null);
				login login = new login();
			}
		});
		lbl_title.setIcon(new ImageIcon("C:\\Users\\SMT031\\Desktop\\KakaoTalk_20200729_190949189.jpg"));
		lbl_title.setBounds(65, 28, 223, 208);
		frame.getContentPane().add(lbl_title);
	}
}
