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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class crime_main {

	private JFrame frame;
	private int kidnap;
	private int rape;
	private int violence;
	private int theft;
	private int murder;
	private JTable table;

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
		frame.setBounds(100, 100, 375, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_mypage = new JLabel("MY PAGE");
		lbl_mypage.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbl_mypage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
//				myPage.main(null);
				myPage myPage = new myPage(vo);
			}
		});
		// lbl_1047.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 110, 359, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbll_���������� = new JLabel("");
		lbll_����������.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uC545\uC720\uC2A4\uBAB0.png"));
		lbll_����������.setBounds(285, 310, 25, 23);
		panel.add(lbll_����������);

		JLabel lbl_���������� = new JLabel("");
		lbl_����������.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uD3ED\uC0C1\uC2A4\uBAB0.png"));
		lbl_����������.setBounds(113, 396, 25, 29);
		panel.add(lbl_����������);

		JLabel lbll_��ġ������ = new JLabel("");
		lbll_��ġ������.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uB0A9\uCE58\uC2A4\uBAB0.png"));
		lbll_��ġ������.setBounds(99, 306, 25, 23);
		panel.add(lbll_��ġ������);

		JLabel lbl_���������� = new JLabel("");
		lbl_����������.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uC808\uAC15\uC2A4\uBAB0.png"));
		lbl_����������.setBounds(285, 349, 25, 23);
		panel.add(lbl_����������);

		JLabel lbl_���ξ����� = new JLabel("");
		lbl_���ξ�����.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uC0B4\uC778\uC2A4\uBAB0.png"));
		lbl_���ξ�����.setBounds(266, 396, 44, 29);
		panel.add(lbl_���ξ�����);

		JLabel lbl_���߾����� = new JLabel("");
		lbl_���߾�����.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uAC15\uCD94\uC2A4\uBAB0.png"));
		lbl_���߾�����.setBounds(113, 349, 25, 23);
		panel.add(lbl_���߾�����);

		JCheckBox check_�������� = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
		check_��������.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					violence = 1;
				} else {
					violence = 0;
				}
			}
		});
		check_��������.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		check_��������.setBackground(new Color(230, 230, 250));
		check_��������.setBounds(42, 385, 73, 23);
		panel.add(check_��������);

		JCheckBox check_�������� = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
		check_��������.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					rape = 1;
				} else {
					rape = 0;
				}
			}
		});
		check_��������.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		check_��������.setBackground(new Color(230, 230, 250));
		check_��������.setBounds(204, 349, 73, 23);
		panel.add(check_��������);

		JCheckBox check_�������� = new JCheckBox("\uC808\uB3C4\uAC15\uB3C4");
		check_��������.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					theft = 1;
				} else {
					theft = 0;
				}
			}
		});
		check_��������.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		check_��������.setBackground(new Color(230, 230, 250));
		check_��������.setBounds(42, 310, 81, 23);
		panel.add(check_��������);

		JCheckBox check_�������� = new JCheckBox("\uC545\uCDE8\uC720\uC778");
		check_��������.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					kidnap = 1;
				} else {
					kidnap = 0;
				}
			}
		});
		check_��������.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		check_��������.setBackground(new Color(230, 230, 250));
		check_��������.setBounds(204, 310, 81, 23);
		panel.add(check_��������);

		JCheckBox check_���� = new JCheckBox("\uC0B4\uC778");
		check_����.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					murder = 1;
				} else {
					murder = 0;
				}
			}
		});
		check_����.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		check_����.setBackground(new Color(230, 230, 250));
		check_����.setBounds(42, 349, 49, 23);
		panel.add(check_����);

		JComboBox combo_city = new JComboBox();
		combo_city.setModel(new DefaultComboBoxModel(
				new String[] { "", "\uAD11\uC8FC\uAD11\uC5ED\uC2DC", "\uC11C\uC6B8\uD2B9\uBCC4\uC2DC" }));
		combo_city.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		combo_city.setBackground(new Color(204, 204, 255));
		combo_city.setBounds(134, 102, 151, 18);
		panel.add(combo_city);

		JComboBox combo_gu = new JComboBox();
		combo_gu.setModel(new DefaultComboBoxModel(new String[] { "", "\uC11C\uAD6C", "\uB0A8\uAD6C", "\uB3D9\uAD6C",
				"\uBD81\uAD6C", "\uAD11\uC0B0\uAD6C" }));
		combo_gu.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		combo_gu.setBackground(new Color(204, 204, 255));
		combo_gu.setBounds(134, 130, 151, 19);
		panel.add(combo_gu);

		JComboBox combo_street = new JComboBox();
		combo_street.setModel(new DefaultComboBoxModel(
				new String[] { "", "\uC1A1\uC554\uB85C58\uBC88\uAE38", "\uC1A1\uC554\uB85C76\uBC88\uAE38" }));
		combo_street.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		combo_street.setBackground(new Color(204, 204, 255));
		combo_street.setBounds(134, 159, 151, 19);
		panel.add(combo_street);

		JLabel lbl_crimeinfo = new JLabel("\uBC94\uC8C4 \uC815\uBCF4 \uC870\uD68C");
		lbl_crimeinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_crimeinfo.setFont(new Font("���ʷҵ���", Font.BOLD, 24));
		lbl_crimeinfo.setBounds(62, 5, 234, 54);
		panel.add(lbl_crimeinfo);

		JLabel lbl_location = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uC704\uCE58");
		lbl_location.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		lbl_location.setBounds(12, 96, 122, 28);
		panel.add(lbl_location);

		JLabel lbl_date = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD\uC77C");
		lbl_date.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		lbl_date.setBounds(12, 219, 97, 28);
		panel.add(lbl_date);

		JLabel lbl_sort = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lbl_sort.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		lbl_sort.setBounds(12, 267, 97, 29);
		panel.add(lbl_sort);

		JComboBox combo_fromYear = new JComboBox();
		combo_fromYear.setModel(new DefaultComboBoxModel(
				new String[] { "", "1980", "1990", "2000", "2010", "2015", "2018", "2019", "2020" }));
		combo_fromYear.setBounds(134, 224, 65, 18);
		panel.add(combo_fromYear);

		JComboBox combo_fromMon = new JComboBox();
		combo_fromMon.setModel(new DefaultComboBoxModel(
				new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		combo_fromMon.setBounds(204, 224, 50, 18);
		panel.add(combo_fromMon);

		JComboBox combo_fromDay = new JComboBox();
		combo_fromDay.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		combo_fromDay.setBounds(260, 224, 50, 18);
		panel.add(combo_fromDay);

		JComboBox combo_toYear = new JComboBox();
		combo_toYear.setModel(new DefaultComboBoxModel(
				new String[] { "", "1980", "1990", "2000", "2010", "2015", "2018", "2019", "2020" }));
		combo_toYear.setBounds(134, 252, 65, 18);
		panel.add(combo_toYear);

		JComboBox combo_toMon = new JComboBox();
		combo_toMon.setModel(new DefaultComboBoxModel(
				new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		combo_toMon.setBounds(204, 252, 50, 18);
		panel.add(combo_toMon);

		JComboBox combo_toDay = new JComboBox();
		combo_toDay.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		combo_toDay.setBounds(260, 252, 50, 18);
		panel.add(combo_toDay);

		JLabel lbl_from = new JLabel("\uBD80\uD130");
		lbl_from.setBounds(314, 224, 33, 20);
		panel.add(lbl_from);

		JLabel lbl_to = new JLabel("\uAE4C\uC9C0");
		lbl_to.setBounds(314, 252, 33, 20);
		panel.add(lbl_to);

		table = new JTable();
		table.setBounds(234, 353, 1, 1);
		panel.add(table);

		JTextArea textArea_�� = new JTextArea();
		textArea_��.setEditable(false);
		textArea_��.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC57D\uCDE8 \uBC0F \uC720\uC778\r\n2017-02-01");
		textArea_��.setBounds(170, 375, 177, 99);
		frame.getContentPane().add(textArea_��);
		textArea_��.setVisible(false);

		JTextArea textArea_��2 = new JTextArea();
		textArea_��2.setEditable(false);
		textArea_��2.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC57D\uCDE8 \uBC0F \uC720\uC778\r\n2020-05-28");
		textArea_��2.setBounds(0, 375, 177, 99);
		frame.getContentPane().add(textArea_��2);
		textArea_��2.setVisible(false);

		JTextArea textArea_�� = new JTextArea();
		textArea_��.setEditable(false);
		textArea_��.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC0C1\uD574 \uBC0F \uD3ED\uD589\r\n2020-06-01");
		textArea_��.setBounds(112, 206, 177, 99);
		frame.getContentPane().add(textArea_��);
		textArea_��.setVisible(false);

		JTextArea textArea_�� = new JTextArea();
		textArea_��.setEditable(false);
		textArea_��.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC808\uB3C4 \uBC0F \uAC15\uB3C4\r\n2019-05-18");
		textArea_��.setBounds(98, 561, 177, 99);
		frame.getContentPane().add(textArea_��);
		textArea_��.setVisible(false);

		JLabel lbl_��_1030 = new JLabel("\uC0C1");
		lbl_��_1030.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��.isVisible()) {
					textArea_��.setVisible(false);
				} else {
					textArea_��.setVisible(true);
				}
			}
		});
		lbl_��_1030.setBounds(192, 306, 22, 29);
		frame.getContentPane().add(lbl_��_1030);
		lbl_��_1030.setVisible(false);

		JLabel lbl_��2_1047 = new JLabel("\uC57D2");
		lbl_��2_1047.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��2.isVisible()) {
					textArea_��2.setVisible(false);
				} else {
					textArea_��2.setVisible(true);
				}
			}
		});
		lbl_��2_1047.setBounds(106, 484, 25, 29);
		frame.getContentPane().add(lbl_��2_1047);
		lbl_��2_1047.setVisible(false);

		lbl_mypage.setBounds(257, 38, 81, 15);
		frame.getContentPane().add(lbl_mypage);

		JLabel lbl_signout = new JLabel("SIGN OUT");
		lbl_signout.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
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

		JLabel lbl_title = new JLabel("");
		lbl_title.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uC791\uC740\uB85C\uACE0.png"));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(12, 20, 89, 49);
		frame.getContentPane().add(lbl_title);

		JLabel lbl_tipoff = new JLabel("\uC81C\uBCF4\uD558\uAE30");
		lbl_tipoff.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbl_tipoff.setBounds(257, 56, 81, 15);
		frame.getContentPane().add(lbl_tipoff);

		JLabel lbl_reset = new JLabel("\uB9AC\uC14B");
		lbl_reset.setFont(new Font("����", Font.PLAIN, 14));
		lbl_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				kidnap = 0;
				murder = 0;
				rape = 0;
				theft = 0;
				violence = 0;
				check_��������.setSelected(false);
				check_����.setSelected(false);
				check_��������.setSelected(false);
				check_��������.setSelected(false);
				check_��������.setSelected(false);
				combo_city.setSelectedIndex(0);
				combo_gu.setSelectedIndex(0);
				combo_street.setSelectedIndex(0);
				combo_fromYear.setSelectedIndex(0);
				combo_fromMon.setSelectedIndex(0);
				combo_fromDay.setSelectedIndex(0);
				combo_toYear.setSelectedIndex(0);
				combo_toMon.setSelectedIndex(0);
				combo_toDay.setSelectedIndex(0);
				if (panel.getHeight() < 100) {
					panel.setBounds(0, 110, 359, 663);
				}
			}
		});
		lbl_reset.setBounds(73, 71, 97, 29);
		frame.getContentPane().add(lbl_reset);

		JLabel lbl_fold = new JLabel("\uD3BC\uCE58\uAE30");
		lbl_fold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panel.getHeight() < 100) {
					panel.setBounds(0, 110, 359, 663);
				} else
					panel.setBounds(0, 110, 10, 10);
			}
		});
		lbl_fold.setBounds(12, 79, 25, 29);
		frame.getContentPane().add(lbl_fold);

		JLabel lbl_��_1001 = new JLabel("\uC808");
		lbl_��_1001.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��.isVisible()) {
					textArea_��.setVisible(false);
				} else {
					textArea_��.setVisible(true);
				}
			}
		});
		lbl_��_1001.setBounds(176, 532, 25, 29);
		frame.getContentPane().add(lbl_��_1001);
		lbl_��_1001.setVisible(false);

		JLabel lbl_��_1018 = new JLabel("\uC57D");
		lbl_��_1018.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��.isVisible()) {
					textArea_��.setVisible(false);
				} else {
					textArea_��.setVisible(true);
				}
			}
		});
		lbl_��_1018.setBounds(292, 484, 25, 29);
		frame.getContentPane().add(lbl_��_1018);
		lbl_��_1018.setVisible(false);

		JLabel lbl_58 = new JLabel("");
		lbl_58.setIcon(new ImageIcon("C:\\pro_image\\58.png"));
		lbl_58.setBounds(0, 110, 359, 663);
		frame.getContentPane().add(lbl_58);
		
		JButton btn_search = new JButton("SEARCH");
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setBounds(0, 106, 1, 1);
				if (kidnap == 1) {
					lbl_��2_1047.setVisible(true);
					lbl_��_1018.setVisible(true);
				}
			}
		});
		btn_search.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		btn_search.setBackground(new Color(204, 204, 255));
		btn_search.setBounds(12, 435, 324, 23);
		panel.add(btn_search);

	}
}
