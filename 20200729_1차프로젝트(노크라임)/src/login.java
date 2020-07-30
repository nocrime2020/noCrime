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
import java.awt.Color;
import javax.swing.SwingConstants;

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
	private JTextField txt_email;
	private JButton btn_signup;
	private JLabel lbl_title;

	DAO dao = new DAO();
	private JButton btn_signup_2;
	
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
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 375, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setBounds(65, 194, 57, 15);
		lbl_id.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		frame.getContentPane().add(lbl_id);
		
		JLabel lbl_pw = new JLabel("PASSWORD");
		lbl_pw.setBounds(65, 237, 97, 15);
		lbl_pw.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		frame.getContentPane().add(lbl_pw);
		
		txt_id = new JTextField();
		txt_id.setBounds(146, 234, 155, 21);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setBounds(146, 191, 155, 21);
		txt_pw.setColumns(10);
		frame.getContentPane().add(txt_pw);
		
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.setBounds(990, 52, 97, 23);
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = txt_id.getText();
				String pw = txt_pw.getText();
				
				VO vo = new VO(id, pw);
				VO result = dao.login(vo);
				
				if(result != null) {
					if (vo.getId().equals("admin")) {	//�����ڴ� ������������
						frame.dispose();
						admin_select asel = new admin_select();
					} else {
						frame.dispose();
						crime_main crime = new crime_main(vo);
					}
				} else {
					JOptionPane.showMessageDialog(null, "���̵� Ȥ�� ��й�ȣ�� �ٽ� Ȯ���ϼ���", "�α��� ����", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		frame.getContentPane().add(btn_login);
		
		lbl_signup = new JLabel("SIGN UP");
		lbl_signup.setForeground(new Color(0, 0, 128));
		lbl_signup.setBounds(65, 405, 97, 30);
		lbl_signup.setFont(new Font("���ʷҵ���", Font.BOLD, 24));
		frame.getContentPane().add(lbl_signup);
		
		lbl_name = new JLabel("NAME");
		lbl_name.setBounds(65, 459, 57, 15);
		lbl_name.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		frame.getContentPane().add(lbl_name);
		
		lbl_newid = new JLabel("ID");
		lbl_newid.setBounds(65, 500, 57, 15);
		lbl_newid.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		frame.getContentPane().add(lbl_newid);
		
		lbl_newpw = new JLabel("PASSWORD");
		lbl_newpw.setBounds(65, 545, 65, 15);
		lbl_newpw.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		frame.getContentPane().add(lbl_newpw);
		
		lbl_email = new JLabel("EMAIL");
		lbl_email.setBounds(65, 590, 57, 15);
		lbl_email.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		frame.getContentPane().add(lbl_email);
		
		txt_name = new JTextField();
		txt_name.setBounds(146, 456, 155, 21);
		txt_name.setColumns(10);
		frame.getContentPane().add(txt_name);
		
		txt_newid = new JTextField();
		txt_newid.setBounds(146, 497, 155, 21);
		txt_newid.setColumns(10);
		frame.getContentPane().add(txt_newid);
		
		txt_newpw = new JTextField();
		txt_newpw.setBounds(146, 542, 155, 21);
		txt_newpw.setColumns(10);
		frame.getContentPane().add(txt_newpw);
		
		txt_email = new JTextField();
		txt_email.setBounds(146, 587, 155, 21);
		txt_email.setColumns(10);
		frame.getContentPane().add(txt_email);
		
		btn_signup = new JButton("SIGN IN");
		btn_signup.setBounds(65, 304, 97, 23);
		btn_signup.setBackground(new Color(204, 204, 255));
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_signup.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btn_signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//textField�� �ִ� ������ ������ ���ּ���.
				String id = txt_newid.getText();
				String pw = txt_newpw.getText();
				String name = txt_name.getText();
				String email = txt_email.getText();
				
				//�Ű������� VO�� �ٲ��ຸ����!
				VO vo = new VO(id, pw, name, email);
				int cnt = dao.insert(vo);
				if(cnt > 0) {
					//�˾�â�� ������ƿ�!
					//�θ�������Ʈ, �޼���, ����, �����ܸ��
					JOptionPane.showMessageDialog(null, "ȸ������ �Ϸ�. �α��� �ϼ���.", "ȸ������", JOptionPane.INFORMATION_MESSAGE);
					txt_newid.setText("");
					txt_newpw.setText("");
					txt_name.setText("");
					txt_email.setText("");
				} else {
					//ȸ������ �������� �� �˾�â ����!
					JOptionPane.showMessageDialog(null, "����� �� ���� ���̵� �Ǵ� �̸����Դϴ�.", "ȸ������", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		frame.getContentPane().add(btn_signup);
		
		lbl_title = new JLabel("");
		lbl_title.setBounds(39, -16, 282, 212);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				login.main(null);
				login login = new login();
			}
		});
		lbl_title.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\knowcrimelogo.png"));
		frame.getContentPane().add(lbl_title);
		
		JButton btn_signup_1 = new JButton("SIGN UP");
		btn_signup_1.setBounds(65, 640, 236, 23);
		btn_signup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_signup_1.setBackground(new Color(204, 204, 255));
		btn_signup_1.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		frame.getContentPane().add(btn_signup_1);
		
		btn_signup_2 = new JButton("SIGN UP");
		btn_signup_2.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btn_signup_2.setBackground(new Color(204, 204, 255));
		btn_signup_2.setBounds(204, 304, 97, 23);
		frame.getContentPane().add(btn_signup_2);
	}
}
