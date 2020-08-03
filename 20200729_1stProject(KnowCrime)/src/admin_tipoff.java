
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JButton;


public class admin_tipoff {

	private JFrame frame;
	private JTable table_tipoffmanage;

	DAO dao = new DAO();

	int cnt;
//	private JTable table;
//	private JTable table_1;
	
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
	public admin_tipoff(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO vo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 375, 812);
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(128, 10, 103, 56);
		lbl_title.setIcon(new ImageIcon(admin_tipoff.class.getResource("/res/\uC791\uC740 \uD22C\uBA85.png")));
		//타이틀로고 클릭시
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				admin_select.main(null);
				admin_select admin_select = new admin_select(vo);
			}
		});
		frame.getContentPane().setLayout(null);
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 23));
		frame.getContentPane().add(lbl_title);

		JLabel lbl_signout = new JLabel("");
		lbl_signout.setBounds(307, 10, 40, 29);
		lbl_signout.setIcon(new ImageIcon(admin_tipoff.class.getResource("/res/logout2.png")));
		//로그아웃
		lbl_signout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				login.main(null);
				login login = new login();
			}
		});
		frame.getContentPane().add(lbl_signout);

		JLabel lbl_tipoffmanage = new JLabel("\uC81C\uBCF4 \uAD00\uB9AC");
		lbl_tipoffmanage.setForeground(new Color(0, 0, 128));
		lbl_tipoffmanage.setBounds(90, 76, 180, 60);
		lbl_tipoffmanage.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tipoffmanage.setFont(new Font("함초롬돋움", Font.BOLD, 24));
		frame.getContentPane().add(lbl_tipoffmanage);

		//회원에게 제보받은 목록 테이블에 불러오기
		ArrayList<tipoff_VO> tipoffList = dao.allSelect1();
		String[] column = { "제보정보코드", "범죄종류", "범죄발생일", "범죄장소코드", "증거자료","범죄 세부명"};
		Object[][] data = new Object[tipoffList.size()][column.length];
		for (int i = 0; i < tipoffList.size(); i++) {
			data[i][0] = tipoffList.get(i).getTip_info_id();
			data[i][1] = tipoffList.get(i).getCr_type_id();
			data[i][2] = tipoffList.get(i).getCr_date();
			data[i][3] = tipoffList.get(i).getCr_loc_id();
			data[i][4] = tipoffList.get(i).getEvidence();
			data[i][5] = tipoffList.get(i).getCr_name();
		}
		DefaultTableModel model = new DefaultTableModel(data, column); // DefaultTableModel 선언 후 데이터 담기
		table_tipoffmanage = new JTable(model); // JTable에 DefaultTableModel을 담기
		table_tipoffmanage.setBounds(37, 146, 287, 493);

		JScrollPane scrollPane = new JScrollPane(table_tipoffmanage);	//스크롤
		scrollPane.setBounds(36, 146, 287, 493);
		frame.getContentPane().add(scrollPane);

		table_tipoffmanage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//사이즈조절 자동으로 

		JButton btn_upload = new JButton("\uC804\uC1A1 \uD558\uAE30");
		btn_upload.setBackground(new Color(204, 204, 255));
		//회원에게 제보받은 제보를 검토 후 관리자가 범죄정보조회에 업로드
		btn_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_tipoffmanage.getSelectedRow();
				int result = JOptionPane.showConfirmDialog(null, "전송 하기", "제보 관리", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (row != 0) {
						row = table_tipoffmanage.getSelectedRow();
						String[] toto = new String[6];
						for (int i = 0; i < 6; i++) {
							Object value = table_tipoffmanage.getValueAt(row, i);
							toto[i] = (String)value;
						}
						cnt = dao.sending_tipoff(toto[0], toto[1], toto[2], toto[3],toto[4],toto[5]);
						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "전송이 완료되었습니다.");
						} else {
							JOptionPane.showMessageDialog(null, "선택된 목록이 없습니다.", "제보 관리",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

				} else if ((result == JOptionPane.CLOSED_OPTION) || (result == JOptionPane.NO_OPTION)) {
					JOptionPane.showMessageDialog(null, "선택 제보 업로드를 취소합니다.", "제보 관리", JOptionPane.WARNING_MESSAGE );
					return;
				}

			}
		});

		btn_upload.setBounds(36, 682, 287, 43);
		btn_upload.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		frame.getContentPane().add(btn_upload);

	}
}