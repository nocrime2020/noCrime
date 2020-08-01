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
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class crime_main {

	private JFrame frame;
	private int kidnap;
	private int rape;
	private int violence;
	private int theft;
	private int murder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crime_main window = new crime_main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 110, 359, 663);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(0, 110, 359, 663);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(0, 110, 359, 663);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);

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
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (vo.getId().equals("admin")) { // �����ڴ� �������������� ���ƿ���
					frame.dispose();
					admin_select asel = new admin_select(vo);
				} else { // ȸ���� ���������� ���� ��ħ
					frame.dispose();
					crime_main crime = new crime_main(vo);
				}

			}
		});
		lbl_title.setIcon(new ImageIcon(
				"C:\\Users\\SMT044\\Desktop\\\uB178\uD06C\uB77C\uC784\\crimeicon\\\uC791\uC740icon\\\uC791\uC740\uB85C\uACE0.png"));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(12, 20, 89, 49);
		frame.getContentPane().add(lbl_title);

		JLabel lbl_tipoff = new JLabel("\uC81C\uBCF4\uD558\uAE30");
		lbl_tipoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				tipoff tippoff = new tipoff(vo); // �����ϱ� ��ư Ȱ��ȭ

			}
		});
		lbl_tipoff.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbl_tipoff.setBounds(257, 56, 81, 15);
		frame.getContentPane().add(lbl_tipoff);

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

		JLabel lbl_crimeinfo = new JLabel("\uBC94\uC8C4 \uC815\uBCF4 \uC870\uD68C");
		lbl_crimeinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_crimeinfo.setFont(new Font("���ʷҵ���", Font.BOLD, 24));
		lbl_crimeinfo.setBounds(61, 25, 234, 54);
		panel.add(lbl_crimeinfo);

		JLabel lbl_fold = new JLabel("\uD3BC\uCE58\uAE30");
		lbl_fold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panel.getHeight() < 200) {
					panel.setBounds(0, 110, 375, 702);
				} else
					panel.setBounds(0, 110, 5, 5);
			}
		});
		lbl_fold.setBounds(12, 79, 25, 29);
		frame.getContentPane().add(lbl_fold);

		JLabel lbl_location = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD \uC704\uCE58");
		lbl_location.setBounds(12, 105, 122, 28);
		panel.add(lbl_location);
		lbl_location.setFont(new Font("���ʷҵ���", Font.BOLD, 15));

		JComboBox combo_city = new JComboBox();
		combo_city.setBounds(134, 111, 151, 18);
		panel.add(combo_city);
		combo_city.setModel(new DefaultComboBoxModel(
				new String[] { "", "\uAD11\uC8FC\uAD11\uC5ED\uC2DC", "\uC11C\uC6B8\uD2B9\uBCC4\uC2DC" }));
		combo_city.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		combo_city.setBackground(new Color(204, 204, 255));

		JComboBox combo_gu = new JComboBox();
		combo_gu.setBounds(134, 139, 151, 19);
		panel.add(combo_gu);
		combo_gu.setModel(new DefaultComboBoxModel(new String[] { "", "\uC11C\uAD6C", "\uB0A8\uAD6C", "\uB3D9\uAD6C",
				"\uBD81\uAD6C", "\uAD11\uC0B0\uAD6C" }));
		combo_gu.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		combo_gu.setBackground(new Color(204, 204, 255));

		JComboBox combo_street = new JComboBox();
		combo_street.setBounds(134, 168, 151, 19);
		panel.add(combo_street);
		combo_street.setModel(new DefaultComboBoxModel(
				new String[] { "", "\uC1A1\uC554\uB85C58\uBC88\uAE38", "\uC1A1\uC554\uB85C76\uBC88\uAE38" }));
		combo_street.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		combo_street.setBackground(new Color(204, 204, 255));

		JLabel lbl_date = new JLabel("\uBC94\uC8C4 \uBC1C\uC0DD\uC77C");
		lbl_date.setBounds(12, 228, 97, 28);
		panel.add(lbl_date);
		lbl_date.setFont(new Font("���ʷҵ���", Font.BOLD, 15));

		JComboBox combo_fromYear = new JComboBox();
		combo_fromYear.setBounds(134, 233, 65, 18);
		panel.add(combo_fromYear);
		combo_fromYear.setModel(new DefaultComboBoxModel(
				new String[] { "", "1980", "1990", "2000", "2010", "2015", "2018", "2019", "2020" }));

		JComboBox combo_toYear = new JComboBox();
		combo_toYear.setBounds(134, 261, 65, 18);
		panel.add(combo_toYear);
		combo_toYear.setModel(new DefaultComboBoxModel(
				new String[] { "", "1980", "1990", "2000", "2010", "2015", "2018", "2019", "2020" }));

		JComboBox combo_toMon = new JComboBox();
		combo_toMon.setBounds(204, 261, 50, 18);
		panel.add(combo_toMon);
		combo_toMon.setModel(new DefaultComboBoxModel(
				new String[] { "", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

		JComboBox combo_fromMon = new JComboBox();
		combo_fromMon.setBounds(204, 233, 50, 18);
		panel.add(combo_fromMon);
		combo_fromMon.setModel(new DefaultComboBoxModel(
				new String[] { "", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

		JComboBox combo_fromDay = new JComboBox();
		combo_fromDay.setBounds(260, 233, 50, 18);
		panel.add(combo_fromDay);
		combo_fromDay.setModel(new DefaultComboBoxModel(new String[] { "", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" }));

		JComboBox combo_toDay = new JComboBox();
		combo_toDay.setBounds(260, 261, 50, 18);
		panel.add(combo_toDay);
		combo_toDay.setModel(new DefaultComboBoxModel(new String[] { "", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31" }));

		JLabel lbl_from = new JLabel("\uBD80\uD130");
		lbl_from.setBounds(314, 233, 33, 20);
		panel.add(lbl_from);

		JLabel lbl_to = new JLabel("\uAE4C\uC9C0");
		lbl_to.setBounds(314, 261, 33, 20);
		panel.add(lbl_to);

		JLabel lbl_sort = new JLabel("\uBC94\uC8C4 \uC885\uB958");
		lbl_sort.setBounds(12, 276, 97, 29);
		panel.add(lbl_sort);
		lbl_sort.setFont(new Font("���ʷҵ���", Font.BOLD, 15));

		JCheckBox check_�������� = new JCheckBox("\uC808\uB3C4\uAC15\uB3C4");
		check_��������.setBounds(42, 319, 81, 23);
		panel.add(check_��������);
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

		JCheckBox check_���� = new JCheckBox("\uC0B4\uC778");
		check_����.setBounds(42, 358, 49, 23);
		panel.add(check_����);
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

		JCheckBox check_�������� = new JCheckBox("\uC0C1\uD574\uD3ED\uD589");
		check_��������.setBounds(42, 394, 73, 23);
		panel.add(check_��������);
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

		JCheckBox check_�������� = new JCheckBox("\uC545\uCDE8\uC720\uC778");
		check_��������.setBounds(204, 319, 81, 23);
		panel.add(check_��������);
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

		JCheckBox check_�������� = new JCheckBox("\uAC15\uAC04\uCD94\uD589");
		check_��������.setBounds(204, 358, 73, 23);
		panel.add(check_��������);
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

		JTextArea textArea_�� = new JTextArea();
		textArea_��.setEditable(false);
		textArea_��.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC57D\uCDE8 \uBC0F \uC720\uC778\r\n2017-02-01");
		textArea_��.setBounds(170, 375, 177, 99);
		panel_1.add(textArea_��);
		textArea_��.setVisible(false);

		JTextArea textArea_��2 = new JTextArea();
		textArea_��2.setEditable(false);
		textArea_��2.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC57D\uCDE8 \uBC0F \uC720\uC778\r\n2020-05-28");
		textArea_��2.setBounds(0, 375, 177, 99);
		panel_1.add(textArea_��2);
		textArea_��2.setVisible(false);

		JTextArea textArea_�� = new JTextArea();
		textArea_��.setEditable(false);
		textArea_��.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC0C1\uD574 \uBC0F \uD3ED\uD589\r\n2020-06-01");
		textArea_��.setBounds(112, 206, 177, 99);
		panel_1.add(textArea_��);
		textArea_��.setVisible(false);

		JTextArea textArea_�� = new JTextArea();
		textArea_��.setEditable(false);
		textArea_��.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C58\uBC88\uAE38\r\n\uC808\uB3C4 \uBC0F \uAC15\uB3C4\r\n2019-05-18");
		textArea_��.setBounds(98, 561, 177, 99);
		panel_1.add(textArea_��);
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
		panel_1.add(lbl_��_1030);
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
		panel_1.add(lbl_��2_1047);
		lbl_��2_1047.setVisible(false);

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
		panel_1.add(lbl_��_1001);
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
		panel_1.add(lbl_��_1018);

		JLabel lbl_58 = new JLabel("");
		lbl_58.setIcon(new ImageIcon("C:\\pro_image\\58.png"));
		lbl_58.setBounds(0, 0, 359, 663);
		panel_1.add(lbl_58);
		lbl_58.setVisible(false);

		JTextArea textArea_��2 = new JTextArea();
		textArea_��2.setEditable(false);
		textArea_��2.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uAC15\uAC04 \uBC0F \uCD94\uD589\r\n2017-11-18\r\n");
		textArea_��2.setBounds(182, 85, 177, 99);
		panel_2.add(textArea_��2);
		textArea_��2.setVisible(false);

		JTextArea textArea_��1 = new JTextArea();
		textArea_��1.setEditable(false);
		textArea_��1.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uAC15\uAC04 \uBC0F \uCD94\uD589\r\n2017-12-26");
		textArea_��1.setBounds(85, 92, 177, 99);
		panel_2.add(textArea_��1);
		textArea_��1.setVisible(false);

		JTextArea textArea_��3 = new JTextArea();
		textArea_��3.setEditable(false);
		textArea_��3.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uAC15\uAC04 \uBC0F \uCD94\uD589\r\n2005-11-29");
		textArea_��3.setBounds(170, 87, 177, 99);
		panel_2.add(textArea_��3);
		textArea_��3.setVisible(false);

		JTextArea textArea_��3 = new JTextArea();
		textArea_��3.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC0C1\uD574 \uBC0F \uD3ED\uD589\r\n2009-01-31");
		textArea_��3.setEditable(false);
		textArea_��3.setBounds(34, 142, 177, 99);
		panel_2.add(textArea_��3);
		textArea_��3.setVisible(false);

		JTextArea textArea_��4 = new JTextArea();
		textArea_��4.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC0C1\uD574 \uBC0F \uD3ED\uD589\r\n2019-08-14");
		textArea_��4.setEditable(false);
		textArea_��4.setBounds(0, 198, 177, 99);
		panel_2.add(textArea_��4);
		textArea_��4.setVisible(false);

		JTextArea textArea_��2 = new JTextArea();
		textArea_��2.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC808\uB3C4 \uBC0F \uAC15\uB3C4\r\n2010-02-01");
		textArea_��2.setEditable(false);
		textArea_��2.setBounds(177, 178, 177, 99);
		panel_2.add(textArea_��2);
		textArea_��2.setVisible(false);

		JTextArea textArea_��1 = new JTextArea();
		textArea_��1.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC0C1\uD574 \uBC0F \uD3ED\uD589\r\n2019-06-13\r\n");
		textArea_��1.setEditable(false);
		textArea_��1.setBounds(0, 397, 177, 99);
		panel_2.add(textArea_��1);
		textArea_��1.setVisible(false);

		JTextArea textArea_��4 = new JTextArea();
		textArea_��4.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC0C1\uD574 \uBC0F \uD3ED\uD589\r\n2020-05-08\r\n");
		textArea_��4.setEditable(false);
		textArea_��4.setBounds(182, 434, 177, 99);
		panel_2.add(textArea_��4);
		textArea_��4.setVisible(false);

		JTextArea textArea_��1 = new JTextArea();
		textArea_��1.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC808\uB3C4 \uBC0F \uAC15\uB3C4\r\n2020-05-29");
		textArea_��1.setEditable(false);
		textArea_��1.setBounds(170, 152, 177, 99);
		panel_2.add(textArea_��1);
		textArea_��1.setVisible(false);

		JTextArea textArea_��2 = new JTextArea();
		textArea_��2.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC0C1\uD574 \uBC0F \uD3ED\uD589\r\n2007-02-24");
		textArea_��2.setEditable(false);
		textArea_��2.setBounds(0, 154, 177, 99);
		panel_2.add(textArea_��2);
		textArea_��2.setVisible(false);

		JTextArea textArea_��3 = new JTextArea();
		textArea_��3.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC808\uB3C4 \uBC0F \uAC15\uB3C4\r\n2019-08-05");
		textArea_��3.setEditable(false);
		textArea_��3.setBounds(129, 178, 177, 99);
		panel_2.add(textArea_��3);
		textArea_��3.setVisible(false);

		JTextArea textArea_��4 = new JTextArea();
		textArea_��4.setText(
				"\r\n\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uB0A8\uAD6C \uC1A1\uC554\uB85C76\uBC88\uAE38\r\n\uC808\uB3C4 \uBC0F \uAC15\uB3C4\r\n2020-05-20");
		textArea_��4.setEditable(false);
		textArea_��4.setBounds(64, 336, 177, 99);
		panel_2.add(textArea_��4);
		textArea_��4.setVisible(false);

		JLabel lbl_��2_1280 = new JLabel("\uAC15");
		lbl_��2_1280.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��2.isVisible()) {
					textArea_��2.setVisible(false);
				} else {
					textArea_��2.setVisible(true);
				}
			}
		});
		lbl_��2_1280.setBounds(273, 184, 23, 26);
		panel_2.add(lbl_��2_1280);
		lbl_��2_1280.setVisible(false);

		JLabel lbl_��1_1338 = new JLabel("\uAC15");
		lbl_��1_1338.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��1.isVisible()) {
					textArea_��1.setVisible(false);
				} else {
					textArea_��1.setVisible(true);
				}
			}
		});
		lbl_��1_1338.setBounds(248, 184, 23, 26);
		panel_2.add(lbl_��1_1338);
		lbl_��1_1338.setVisible(false);

		JLabel lbl_��3_1251 = new JLabel("\uAC15");
		lbl_��3_1251.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��3.isVisible()) {
					textArea_��3.setVisible(false);
				} else {
					textArea_��3.setVisible(true);
				}
			}
		});
		lbl_��3_1251.setBounds(283, 196, 23, 26);
		panel_2.add(lbl_��3_1251);
		lbl_��3_1251.setVisible(false);

		JLabel lbl_��2_1048 = new JLabel("\uC808");
		lbl_��2_1048.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��2.isVisible()) {
					textArea_��2.setVisible(false);
				} else {
					textArea_��2.setVisible(true);
				}
			}
		});
		lbl_��2_1048.setBounds(324, 270, 23, 26);
		panel_2.add(lbl_��2_1048);
		lbl_��2_1048.setVisible(false);

		JLabel lbl_��1_1135 = new JLabel("\uC0C1");
		lbl_��1_1135.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��1.isVisible()) {
					textArea_��1.setVisible(false);
				} else {
					textArea_��1.setVisible(true);
				}
			}
		});
		lbl_��1_1135.setBounds(125, 376, 23, 26);
		panel_2.add(lbl_��1_1135);
		lbl_��1_1135.setVisible(false);

		JLabel lbl_��4_1106 = new JLabel("\uC808");
		lbl_��4_1106.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��4.isVisible()) {
					textArea_��4.setVisible(false);
				} else {
					textArea_��4.setVisible(true);
				}
			}
		});
		lbl_��4_1106.setBounds(188, 432, 23, 26);
		panel_2.add(lbl_��4_1106);
		lbl_��4_1106.setVisible(false);

		JLabel lbl_��4_1222 = new JLabel("\uC0C1");
		lbl_��4_1222.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��4.isVisible()) {
					textArea_��4.setVisible(false);
				} else {
					textArea_��4.setVisible(true);
				}
			}
		});
		lbl_��4_1222.setBounds(227, 406, 23, 26);
		panel_2.add(lbl_��4_1222);
		lbl_��4_1222.setVisible(false);

		JLabel lbl_��4_1309 = new JLabel("\uAC15");
		lbl_��4_1309.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��4.isVisible()) {
					textArea_��4.setVisible(false);
				} else {
					textArea_��4.setVisible(true);
				}
			}
		});
		lbl_��4_1309.setBounds(54, 300, 23, 26);
		panel_2.add(lbl_��4_1309);
		lbl_��4_1309.setVisible(false);

		JLabel lbl_��2_1164 = new JLabel("\uC0C1");
		lbl_��2_1164.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��2.isVisible()) {
					textArea_��2.setVisible(false);
				} else {
					textArea_��2.setVisible(true);
				}
			}
		});
		lbl_��2_1164.setBounds(125, 251, 23, 26);
		panel_2.add(lbl_��2_1164);
		lbl_��2_1164.setVisible(false);

		JLabel lbl_��3_1193 = new JLabel("\uC0C1");
		lbl_��3_1193.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��3.isVisible()) {
					textArea_��3.setVisible(false);
				} else {
					textArea_��3.setVisible(true);
				}
			}
		});
		lbl_��3_1193.setBounds(167, 238, 23, 26);
		panel_2.add(lbl_��3_1193);
		lbl_��3_1193.setVisible(false);

		JLabel lbl_��3_1077 = new JLabel("\uC808");
		lbl_��3_1077.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��3.isVisible()) {
					textArea_��3.setVisible(false);
				} else {
					textArea_��3.setVisible(true);
				}
			}
		});
		lbl_��3_1077.setBounds(244, 270, 23, 26);
		panel_2.add(lbl_��3_1077);
		lbl_��3_1077.setVisible(false);

		JLabel lbl_��1_1019 = new JLabel("\uC808");
		lbl_��1_1019.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea_��1.isVisible()) {
					textArea_��1.setVisible(false);
				} else {
					textArea_��1.setVisible(true);
				}
			}
		});
		lbl_��1_1019.setBounds(308, 251, 23, 26);
		panel_2.add(lbl_��1_1019);
		lbl_��1_1019.setVisible(false);

		JLabel lbl_76 = new JLabel("");
		lbl_76.setIcon(new ImageIcon("C:\\pro_image\\76.png"));
		lbl_76.setBounds(0, 0, 359, 663);
		panel_2.add(lbl_76);
		lbl_76.setVisible(false);

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
				lbl_��2_1047.setVisible(false);
				lbl_��_1018.setVisible(false);
				lbl_��_1001.setVisible(false);
				lbl_��_1030.setVisible(false);
				textArea_��.setVisible(false);
				textArea_��.setVisible(false);
				textArea_��2.setVisible(false);
				textArea_��.setVisible(false);
				lbl_��1_1338.setVisible(false);
				lbl_��2_1280.setVisible(false);
				lbl_��3_1251.setVisible(false);
				lbl_��4_1309.setVisible(false);
				lbl_��1_1135.setVisible(false);
				lbl_��2_1164.setVisible(false);
				lbl_��3_1193.setVisible(false);
				lbl_��4_1222.setVisible(false);
				lbl_��1_1019.setVisible(false);
				lbl_��2_1048.setVisible(false);
				lbl_��3_1077.setVisible(false);
				lbl_��4_1106.setVisible(false);
				textArea_��1.setVisible(false);
				textArea_��2.setVisible(false);
				textArea_��3.setVisible(false);
				textArea_��4.setVisible(false);
				textArea_��1.setVisible(false);
				textArea_��2.setVisible(false);
				textArea_��3.setVisible(false);
				textArea_��4.setVisible(false);
				textArea_��1.setVisible(false);
				textArea_��2.setVisible(false);
				textArea_��3.setVisible(false);
				textArea_��4.setVisible(false);

				if (panel.getHeight() < 100) {
					panel.setBounds(0, 110, 359, 663);
				}
			}
		});
		lbl_reset.setBounds(73, 71, 97, 29);
		frame.getContentPane().add(lbl_reset);

		JButton btn_search = new JButton("SEARCH");
		btn_search.setBounds(12, 444, 324, 23);
		panel.add(btn_search);
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setBounds(0, 106, 1, 1);
//				if (Integer.parseInt((String)combo_fromYear.getSelectedItem())>2015)
				if ((combo_fromYear.getSelectedIndex() == 0
						|| Integer.parseInt((String) combo_fromYear.getSelectedItem()) >= 2005)
						&& (combo_toYear.getSelectedIndex() == 0
								|| Integer.parseInt((String) combo_fromYear.getSelectedItem()) >= 2020)) {
					if (combo_street.getSelectedIndex() == 1) {
						panel_2.setVisible(false);
						lbl_76.setVisible(false);
						panel_1.setVisible(true);
						lbl_58.setVisible(true);
						if (kidnap == 1) {
							lbl_��2_1047.setVisible(true);
							lbl_��_1018.setVisible(true);
						} else {
							lbl_��2_1047.setVisible(false);
							lbl_��_1018.setVisible(false);
						}
						if (violence == 1) {
							lbl_��_1030.setVisible(true);
						} else {
							lbl_��_1030.setVisible(false);
						}
						if (theft == 1) {
							lbl_��_1001.setVisible(true);
						} else {
							lbl_��_1001.setVisible(false);
						}
					} else if (combo_street.getSelectedIndex() == 2) {
						panel_1.setVisible(false);
						lbl_58.setVisible(false);
						panel_2.setVisible(true);
						lbl_76.setVisible(true);
					}
					if (kidnap == 1) {
					} else {
					}
					if (violence == 1) {
						lbl_��1_1135.setVisible(true);
						lbl_��2_1164.setVisible(true);
						lbl_��3_1193.setVisible(true);
						lbl_��4_1222.setVisible(true);
					} else {
						lbl_��1_1135.setVisible(false);
						lbl_��2_1164.setVisible(false);
						lbl_��3_1193.setVisible(false);
						lbl_��4_1222.setVisible(false);
					}
					if (theft == 1) {
						lbl_��1_1019.setVisible(true);
						lbl_��2_1048.setVisible(true);
						lbl_��3_1077.setVisible(true);
						lbl_��4_1106.setVisible(true);
					} else {
						lbl_��1_1019.setVisible(false);
						lbl_��2_1048.setVisible(false);
						lbl_��3_1077.setVisible(false);
						lbl_��4_1106.setVisible(false);
					}
					if (rape == 1) {
						lbl_��1_1338.setVisible(true);
						lbl_��2_1280.setVisible(true);
						lbl_��3_1251.setVisible(true);
						lbl_��4_1309.setVisible(true);
					} else {
						lbl_��1_1338.setVisible(false);
						lbl_��2_1280.setVisible(false);
						lbl_��3_1251.setVisible(false);
						lbl_��4_1309.setVisible(false);
					}
				} else if (Integer.parseInt((String) combo_fromYear.getSelectedItem()) > 2010) {
					if (combo_street.getSelectedIndex() == 1) {
						panel_2.setVisible(false);
						lbl_76.setVisible(false);
						panel_1.setVisible(true);
						lbl_58.setVisible(true);
						if (kidnap == 1) {
							lbl_��2_1047.setVisible(true);
							lbl_��_1018.setVisible(true);
						} else {
							lbl_��2_1047.setVisible(false);
							lbl_��_1018.setVisible(false);
						}
						if (violence == 1) {
							lbl_��_1030.setVisible(true);
						} else {
							lbl_��_1030.setVisible(false);
						}
						if (theft == 1) {
							lbl_��_1001.setVisible(true);
						} else {
							lbl_��_1001.setVisible(false);
						}
					} else if (combo_street.getSelectedIndex() == 2) {
						panel_1.setVisible(false);
						lbl_58.setVisible(false);
						panel_2.setVisible(true);
						lbl_76.setVisible(true);
					}
					if (kidnap == 1) {
					} else {
					}
					if (violence == 1) {
						lbl_��1_1135.setVisible(true);
						lbl_��4_1222.setVisible(true);
					} else {
						lbl_��1_1135.setVisible(false);
						lbl_��4_1222.setVisible(false);
					}
					if (theft == 1) {
						lbl_��1_1019.setVisible(true);
						lbl_��3_1077.setVisible(true);
						lbl_��4_1106.setVisible(true);
					} else {
						lbl_��1_1019.setVisible(false);
						lbl_��3_1077.setVisible(false);
						lbl_��4_1106.setVisible(false);
					}
					if (rape == 1) {
						lbl_��1_1338.setVisible(true);
						lbl_��2_1280.setVisible(true);
						lbl_��4_1309.setVisible(true);
					} else {
						lbl_��1_1338.setVisible(false);
						lbl_��2_1280.setVisible(false);
						lbl_��4_1309.setVisible(false);
					}
				}else {
					if (combo_street.getSelectedIndex() == 1) {
						panel_2.setVisible(false);
						lbl_76.setVisible(false);
						panel_1.setVisible(true);
						lbl_58.setVisible(true);
						if (kidnap == 1) {
						} else {
						}
						if (violence == 1) {
						} else {
						}
						if (theft == 1) {
						} else {
						}
					} else if (combo_street.getSelectedIndex() == 2) {
						panel_1.setVisible(false);
						lbl_58.setVisible(false);
						panel_2.setVisible(true);
						lbl_76.setVisible(true);
					}
					if (kidnap == 1) {
					} else {
					}
					if (violence == 1) {
						lbl_��2_1164.setVisible(true);
						lbl_��3_1193.setVisible(true);
					} else {
						lbl_��2_1164.setVisible(false);
						lbl_��3_1193.setVisible(false);
					}
					if (theft == 1) {
						lbl_��2_1048.setVisible(true);
					} else {
						lbl_��2_1048.setVisible(false);
					}
					if (rape == 1) {
						lbl_��3_1251.setVisible(true);
					} else {
						lbl_��3_1251.setVisible(false);
					}
				}

				// System.out.println(Integer.parseInt(((String)combo_fromYear.getSelectedItem()+(String)combo_fromMon.getSelectedItem()+(String)combo_fromDay.getSelectedItem())));
			}
		});
		btn_search.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		btn_search.setBackground(new Color(204, 204, 255));

	}
}
