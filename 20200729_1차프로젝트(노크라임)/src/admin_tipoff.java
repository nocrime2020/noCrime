import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;

public class admin_tipoff {

	private JFrame frame;
	private JTable table_tipoffmanage;

	DAO dao = new DAO();
	private JTable table;
	private JTable table_1;
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
		lbl_title.setBounds(12, 10, 103, 56);
		lbl_title.setIcon(new ImageIcon(
				"C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\\uC791\uC740 \uD22C\uBA85.png"));
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
//				admin_select.main(null);
				admin_select admin_select = new admin_select(vo);
//				login login = new login();

			}
		});
		frame.getContentPane().setLayout(null);
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 23));
		frame.getContentPane().add(lbl_title);

		JLabel lbl_signout = new JLabel("");
		lbl_signout.setBounds(307, 10, 40, 29);
		lbl_signout.setIcon(new ImageIcon(
				"C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\off_logout_17916.png"));
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
		lbl_tipoffmanage.setBounds(90, 76, 180, 60);
		lbl_tipoffmanage.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tipoffmanage.setFont(new Font("함초롬돋움", Font.BOLD, 24));
		frame.getContentPane().add(lbl_tipoffmanage);

		ArrayList<tipoff_VO> tipoffList = dao.allSelect1();
		String[] column = { "", "범죄코드", "범죄장소", "발생일", "범죄종류", "제보코드", "범죄 세부명" };
		Object[][] data = new Object[tipoffList.size()][column.length];
		for (int i = 0; i < tipoffList.size(); i++) {
			data[i][0] = tipoffList.get(i).getCheck_tipoff();
			data[i][1] = tipoffList.get(i).getCr_id();
			data[i][2] = tipoffList.get(i).getCr_loc_id();
			data[i][3] = tipoffList.get(i).getCr_date();
			data[i][4] = tipoffList.get(i).getCr_type_id();
			data[i][5] = tipoffList.get(i).getTip_id();
			data[i][6] = tipoffList.get(i).getCr_name();
		}
		
		DefaultTableModel model = new DefaultTableModel(data, column); // DefaultTableModel 선언 후 데이터 담기
		table_tipoffmanage = new JTable(model); // JTable에 DefaultTableModel을 담기
		table_tipoffmanage.setBounds(37, 146, 287, 493);

		JScrollPane scrollPane = new JScrollPane(table_tipoffmanage);
		scrollPane.setBounds(36, 146, 287, 493);
		frame.getContentPane().add(scrollPane);

		table_tipoffmanage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JCheckBox checkBox = new JCheckBox();
		

		DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer() {
			public void getTableCellRendererComponent
			(JTable table, Object value, boolean hasFocus, int row, int column) {
				JCheckBox checkBox = new JCheckBox();
				checkBox.setSelected(((Boolean)value).booleanValue());
				
				checkBox.setHorizontalAlignment(JLabel.CENTER);
			}
		};
		
		table_tipoffmanage.getColumn("").setCellRenderer(dtcr1);
		

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel panel = new JPanel(new BorderLayout());
//		DefaultTableModel dtm = new DefaultTableModel(data, column);
//		JTable table = new JTable(dtm);
//
//		table_tipoffmanage.getColumn("").setCellRenderer(dcr);
//		JCheckBox box = new JCheckBox();
//		box.setHorizontalAlignment(JLabel.CENTER);
//		table_tipoffmanage.getColumn("ChkBox").setCellEditor(new DefaultCellEditor(box));
//		JScrollPane jsp = new JScrollPane(table);
//		panel.add(jsp, "Center");
//		setContentPane(panel);
//		pack();
//		setVisible(true);
//
//		DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
//			public Component getTableCellRendererComponent // 셀렌더러
//			(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//				JCheckBox box = new JCheckBox();
//				box.setSelected(((Boolean) value).booleanValue());
//				box.setHorizontalAlignment(JLabel.CENTER);
//				return box;
//			}
//		};

		JButton btn_upload = new JButton("\uC804\uC1A1 \uD558\uAE30");
		btn_upload.setBounds(36, 682, 287, 43);
		btn_upload.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		frame.getContentPane().add(btn_upload);

	}
}