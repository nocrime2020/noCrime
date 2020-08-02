import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class tipoff {

	private JFrame frame;
	private JTextField txt_date;

	DAO dao = new DAO();
	
	JFileChooser chooser;
	ImageIcon ImageIcon;
	String eviPath = "";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					tipoff window = new tipoff();
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
	public tipoff(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO vo) {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 128));
		frame.getContentPane().setFont(new Font("함초롬돋움", Font.BOLD, 12));
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 375,812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_tipoff = new JLabel("\uBC1C\uC0DD \uBC94\uC8C4 \uC81C\uBCF4");
		lbl_tipoff.setForeground(new Color(0, 0, 128));
		lbl_tipoff.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tipoff.setFont(new Font("함초롬돋움", Font.BOLD, 24));
		lbl_tipoff.setBounds(60, 87, 234, 54);
		frame.getContentPane().add(lbl_tipoff);
		

		
		JButton btn_evidence = new JButton("CHOOSE PHOTO");
		
		
		JLabel lbl_photo = new JLabel("");
		lbl_photo.setBounds(97, 586, 151, 109);
		frame.getContentPane().add(lbl_photo);

		chooser = new JFileChooser();	//파일 다이얼로그 생성
		chooser.setCurrentDirectory(new File("C:\\"));
		
		
		btn_evidence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG & JPG Images", "png", "jpg");
				chooser.setFileFilter(filter); 		//파일 다이얼로그에 파일필터 설정
				
				//파일 다이얼로그 출력
				int ret = chooser.showOpenDialog(null);	//열기창 정의
				if(ret == JFileChooser.APPROVE_OPTION) { //디렉토리를 선택했으면  //사용자가 파일 선택 후 "열기" 버튼 누름
					String filePath = chooser.getSelectedFile().getPath();	//파일경로를 가져옴
//					System.out.println(filePath);
					eviPath = filePath;
					Image temp = new ImageIcon(filePath).getImage();
					lbl_photo.setIcon(new ImageIcon(temp.getScaledInstance(151, 109, Image.SCALE_SMOOTH)));
					
				} else { 													//사용자가 창을 강제로 닫거나 취소 버튼을 누름
					JOptionPane.showMessageDialog(null, "파일 선택 취소", "범죄 제보", JOptionPane.WARNING_MESSAGE );
					return;
				}
				
			}
		});
		
		
		btn_evidence.setBackground(new Color(204, 204, 255));
		btn_evidence.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		btn_evidence.setBounds(12, 553, 317, 23);
		frame.getContentPane().add(btn_evidence);
		
		JLabel lbl_sort = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lbl_sort.setForeground(new Color(0, 0, 128));
		lbl_sort.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lbl_sort.setBounds(12, 324, 97, 29);
		frame.getContentPane().add(lbl_sort);
		
		JLabel lbl_date = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD\uC77C");
		lbl_date.setForeground(new Color(0, 0, 128));
		lbl_date.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lbl_date.setBounds(12, 259, 97, 28);
		frame.getContentPane().add(lbl_date);
		
		JLabel lbl_location = new JLabel("\uBC94\uC8C4 \uC7A5\uC18C");
		lbl_location.setForeground(new Color(0, 0, 128));
		lbl_location.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lbl_location.setBounds(12, 152, 81, 28);
		frame.getContentPane().add(lbl_location);
		
		txt_date = new JTextField();
		txt_date.setBackground(new Color(248, 248, 255));
		txt_date.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		txt_date.setBounds(110, 263, 219, 21);
		frame.getContentPane().add(txt_date);
		txt_date.setColumns(10);
		
		JButton btn_send = new JButton("SEND");
		btn_send.setBackground(new Color(204, 204, 255));
		
		btn_send.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		btn_send.setBounds(12, 711, 324, 23);
		frame.getContentPane().add(btn_send);
		
		JLabel txt_notice = new JLabel("* \uBAA8\uB4E0 \uC81C\uBCF4\uB294 \uC775\uBA85 \uBCF4\uC7A5\uB429\uB2C8\uB2E4 *");
		txt_notice.setForeground(new Color(0, 0, 128));
		txt_notice.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		txt_notice.setBounds(90, 744, 184, 15);
		frame.getContentPane().add(txt_notice);
		
		JLabel lbl_evidence = new JLabel("\uC99D\uAC70 \uC790\uB8CC");
		lbl_evidence.setForeground(new Color(0, 0, 128));
		lbl_evidence.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		lbl_evidence.setBounds(12, 512, 97, 43);
		frame.getContentPane().add(lbl_evidence);
		
//		JCheckBox ck_assault = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
//		ck_assault.setBackground(new Color(230, 230, 250));
//		ck_assault.setFont(new Font("함초롬돋움", Font.BOLD, 12));
//		ck_assault.setBounds(263, 633, 73, 23);
//		frame.getContentPane().add(ck_assault);
//		
//		JCheckBox ck_rape = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
//		ck_rape.setBackground(new Color(230, 230, 250));
//		ck_rape.setFont(new Font("함초롬돋움", Font.BOLD, 12));
//		ck_rape.setBounds(256, 682, 73, 23);
//		frame.getContentPane().add(ck_rape);
//		
//		JCheckBox ck_burglary = new JCheckBox("\uC808\uB3C4\uAC15\uB3C4");
//		ck_burglary.setBackground(new Color(230, 230, 250));
//		ck_burglary.setFont(new Font("함초롬돋움", Font.BOLD, 12));
//		ck_burglary.setBounds(270, 586, 81, 23);
//		frame.getContentPane().add(ck_burglary);
//		
//		JCheckBox ck_kidnap = new JCheckBox("\uC57D\uCDE8\uC720\uC778");
//		ck_kidnap.setBackground(new Color(230, 230, 250));
//		ck_kidnap.setFont(new Font("함초롬돋움", Font.BOLD, 12));
//		ck_kidnap.setBounds(256, 658, 81, 23);
//		frame.getContentPane().add(ck_kidnap);
//		
//		JCheckBox ck_murder = new JCheckBox("\uC0B4\uC778");
//		ck_murder.setBackground(new Color(230, 230, 250));
//		ck_murder.setFont(new Font("함초롬돋움", Font.BOLD, 12));
//		ck_murder.setBounds(280, 611, 49, 23);
//		frame.getContentPane().add(ck_murder);
		
		JRadioButton rd_burglary = new JRadioButton("\uC808\uB3C4\uAC15\uB3C4");
		rd_burglary.setBackground(new Color(230, 230, 250));
		rd_burglary.setForeground(new Color(0, 0, 128));
		rd_burglary.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		buttonGroup.add(rd_burglary);
		rd_burglary.setBounds(31, 367, 81, 23);
		frame.getContentPane().add(rd_burglary);
		
		JRadioButton rd_murder = new JRadioButton("\uC0B4\uC778");
		rd_murder.setBackground(new Color(230, 230, 250));
		rd_murder.setForeground(new Color(0, 0, 128));
		rd_murder.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		buttonGroup.add(rd_murder);
		rd_murder.setBounds(31, 410, 81, 23);
		frame.getContentPane().add(rd_murder);
		
		JRadioButton rd_assault = new JRadioButton("\uC0C1\uD574\uD3ED\uD589");
		rd_assault.setBackground(new Color(230, 230, 250));
		rd_assault.setForeground(new Color(0, 0, 128));
		rd_assault.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		buttonGroup.add(rd_assault);
		rd_assault.setBounds(31, 457, 81, 23);
		frame.getContentPane().add(rd_assault);
		
		JRadioButton rd_kidnap = new JRadioButton("\uC57D\uCDE8\uC720\uC778");
		rd_kidnap.setBackground(new Color(230, 230, 250));
		rd_kidnap.setForeground(new Color(0, 0, 128));
		rd_kidnap.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		buttonGroup.add(rd_kidnap);
		rd_kidnap.setBounds(193, 367, 81, 23);
		frame.getContentPane().add(rd_kidnap);
		
		JRadioButton rd_rape = new JRadioButton("\uAC15\uAC04\uCD94\uD589");
		rd_rape.setBackground(new Color(230, 230, 250));
		rd_rape.setForeground(new Color(0, 0, 128));
		rd_rape.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		buttonGroup.add(rd_rape);
		rd_rape.setBounds(193, 410, 81, 23);
		frame.getContentPane().add(rd_rape);
		
		JComboBox combo_city = new JComboBox();
		combo_city.setForeground(new Color(0, 0, 128));
		combo_city.setModel(new DefaultComboBoxModel(new String[] {"도시를 선택하세요", "서울특별시", "광주광역시"}));
		combo_city.setBackground(new Color(204, 204, 255));
		combo_city.setEditable(true);
		combo_city.setFont(new Font("함초롬돋움", Font.BOLD, 10));
		combo_city.setBounds(110, 159, 219, 18);
		frame.getContentPane().add(combo_city);
		
		JComboBox combo_gu = new JComboBox();
		combo_gu.setForeground(new Color(0, 0, 128));
		combo_gu.setBackground(new Color(204, 204, 255));
		combo_gu.setEditable(true);
		combo_gu.setFont(new Font("함초롬돋움", Font.BOLD, 10));
		combo_gu.setModel(new DefaultComboBoxModel(new String[] {"구를 선택하세요", "광산구", "동구", "서구", "남구", "북구"}));
		combo_gu.setBounds(110, 187, 219, 19);
		frame.getContentPane().add(combo_gu);
		
		JComboBox combo_street = new JComboBox();
		combo_street.setForeground(new Color(0, 0, 128));
		combo_street.setModel(new DefaultComboBoxModel(new String[] {"상세주소를 선택하세요", "2순환로","서문대로","서문대로402번길","서문대로473번길","서문대로499번길","서문대로517번길","서문대로556번길","서문대로627번길","송암로","송암로130번길","송암로24번길","송암로24번가길","송암로24번나길","송암로27번길","송암로42번길","송암로58번길","송암로76번길","송암로98번길","원효천길","원효천1길","원효천2길","입하길","입하1길","입하2길","입하2안길","효덕로","효덕로303번길","효천길","효천3로"}));
		combo_street.setBackground(new Color(204, 204, 255));
		combo_street.setEditable(true);
		combo_street.setFont(new Font("함초롬돋움", Font.BOLD, 10));
		combo_street.setBounds(110, 216, 219, 19);
		frame.getContentPane().add(combo_street);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				crime_main crime = new crime_main(dao.check_alarm2(vo));
				
			}
		});
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 23));
		lbl_title.setIcon(new ImageIcon("C:\\icon\\\uC791\uC740icon\\\uC791\uC740\uB85C\uACE0.png"));
		lbl_title.setBounds(127, 10, 105, 54);
		frame.getContentPane().add(lbl_title);
		
		
		
		JLabel lbl_resetICON = new JLabel("");

		//reset아이콘 클릭시 선택&&입력 정보 초기화 버튼
		lbl_resetICON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				combo_city.setSelectedIndex(0);
				combo_gu.setSelectedIndex(0);
				combo_street.setSelectedIndex(0);
				txt_date.setText("");
//				ck_assault.setSelected(false);
//				ck_rape.setSelected(false);
//				ck_burglary.setSelected(false);
//				ck_kidnap.setSelected(false);
//				ck_murder.setSelected(false);
			}
		});
		
		btn_send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "입력한 정보로 제보 하시겠습니까?", "범죄 제보", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {		// 사용자가 제보를 원하는 경우
					
					if ((combo_city.getSelectedIndex()!=0) && 
						(combo_gu.getSelectedIndex()!=0) &&
						(combo_street.getSelectedIndex()!=0) && 
//						!txt_date.getText().equals("") && 
						(rd_assault.isSelected() || 
						 rd_rape.isSelected() || 
						 rd_burglary.isSelected() || 
						 rd_kidnap.isSelected() || 
						 rd_murder.isSelected())
						)	{	//안넣은 값 없이 다 쓴 경우
						
						String crtyId = "";
						if (rd_burglary.isSelected()==true) {
							crtyId = "1";
						} else if (rd_murder.isSelected()==true) {
							crtyId = "2";
						} else if (rd_rape.isSelected()==true) {
							crtyId = "3";
						} else if (rd_kidnap.isSelected()==true) {
							crtyId = "4";
						} else if (rd_assault.isSelected()==true) {
							crtyId = "5";
						}
						
						String loc = "";
						if (combo_city.getSelectedIndex()==2 && combo_gu.getSelectedIndex()==4 && combo_street.getSelectedIndex()==16) {
							loc = "118";
						} else if (combo_city.getSelectedIndex()==2 && combo_gu.getSelectedIndex()==4 && combo_street.getSelectedIndex()==17) {
							loc = "119";
						}
						
//						String date = null;
//						if (txt_date == null || txt_date.equals("")) {
//							return;
//						}
							
						
						String cr_type_id = crtyId;
						String cr_date = txt_date.getText();
						String cr_loc_id = loc;
						String evidence = eviPath;
						
						
						tipoff_VO tipoff_vo = new tipoff_VO(cr_type_id, cr_date, cr_loc_id, evidence);
						int cnt = dao.tipoff_insert(tipoff_vo);
						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "제보 완료.\n 영업일 1일이내 검토 후 범죄 정보에 조회됩니다.", "범죄 제보", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
							tipoff tipoff = new tipoff(vo);
							
						}
						
						
						
						
					} else { //정보 입력 중 빠진 입력값이 있는 경우
						JOptionPane.showMessageDialog(null, "입력되지 않은 정보가 존재합니다.", "범죄 제보", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} else if ((result == JOptionPane.CLOSED_OPTION) || (result == JOptionPane.NO_OPTION)) {
					JOptionPane.showMessageDialog(null, "제보 취소", "범죄 제보", JOptionPane.WARNING_MESSAGE );
					return; // 사용자가 전송취소 혹은 창닫기 버튼을 누른 경우
				}
				
			}
		});
		
	
		lbl_resetICON.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\small.png"));
		lbl_resetICON.setBounds(290, 206, 25, 29);
		frame.getContentPane().add(lbl_resetICON);
		
		JLabel lbl_rapeICON = new JLabel("");
		lbl_rapeICON.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uAC15\uCD942.png"));
		lbl_rapeICON.setBounds(269, 410, 25, 23);
		frame.getContentPane().add(lbl_rapeICON);
		
		JLabel lbl_assultICON = new JLabel("");
		lbl_assultICON.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uD3ED\uC0C1.png"));
		lbl_assultICON.setBounds(110, 451, 25, 29);
		frame.getContentPane().add(lbl_assultICON);
		
		JLabel lbl_burglaryICON = new JLabel("");
		lbl_burglaryICON.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC808\uAC15.png"));
		lbl_burglaryICON.setBounds(110, 367, 25, 23);
		frame.getContentPane().add(lbl_burglaryICON);
		
		JLabel lbl_murderICON = new JLabel("");
		lbl_murderICON.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC0B42.png"));
		lbl_murderICON.setBounds(110, 404, 44, 29);
		frame.getContentPane().add(lbl_murderICON);
		
		JLabel lbl_kidnapICON = new JLabel("");
		lbl_kidnapICON.setIcon(new ImageIcon("C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC545\uC720.png"));
		lbl_kidnapICON.setBounds(269, 367, 25, 23);
		frame.getContentPane().add(lbl_kidnapICON);
		
		JLabel lbl_logout = new JLabel("");
		lbl_logout.setIcon(new ImageIcon("C:\\icon\\icon\\logout2.png"));
		lbl_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				login login = new login();
				
			}
		});
		lbl_logout.setBounds(290, 10, 81, 38);
		frame.getContentPane().add(lbl_logout);
		
		JLabel lblNewLabel = new JLabel("YYYYMMDD (\uC22B\uC790\uB9CC \uC785\uB825\uD574\uC8FC\uC138\uC694) ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lblNewLabel.setBounds(110, 288, 219, 15);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
}

