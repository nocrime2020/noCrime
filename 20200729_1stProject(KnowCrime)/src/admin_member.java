
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class admin_member {

	private JFrame frame;
	private JTable table_member;

	DAO dao = new DAO();
	
	int cnt;
	int chkalrm;

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					A_member window = new A_member();
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
	public admin_member(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VO vo) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(772, 134, 375, 812);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); //��ġ������(setLayout) ����  & ���� �������� ��ġ�� ������Ʈ ����

		JLabel lbl_title = new JLabel("");
		lbl_title.setIcon(new ImageIcon(admin_member.class.getResource("/res/\uC791\uC740 \uD22C\uBA85.png")));
		//Ÿ��Ʋ�ΰ� Ŭ��
		lbl_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//				crime_main.main(null);
				admin_select admin_select = new admin_select(vo);
			}
		});
		lbl_title.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbl_title.setBounds(131, 9, 97, 55);
		frame.getContentPane().add(lbl_title);
		
		JLabel lbl_signout = new JLabel("");
		lbl_signout.setIcon(new ImageIcon(admin_member.class.getResource("/res/logout2.png")));
		//�α׾ƿ� 
		lbl_signout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
//	            login.main(null);
				login login = new login();
			}
		});
		lbl_signout.setBounds(307, 10, 40, 29);
		frame.getContentPane().add(lbl_signout);

		JLabel lbl_member = new JLabel("\uD68C\uC6D0 \uAD00\uB9AC");
		lbl_member.setForeground(new Color(0, 0, 128));
		lbl_member.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_member.setFont(new Font("���ʷҵ���", Font.BOLD, 24));
		lbl_member.setBounds(90, 76, 180, 60);
		frame.getContentPane().add(lbl_member);

		ArrayList<VO> memberList = dao.allSelect();				//ȸ���� �𸣱⶧���� ArrayList�� ����
		String[] column = { "���̵�", "��й�ȣ", "�̸�", "�̸���" };	//�÷���! �������
		Object[][] data = new Object[memberList.size()][column.length];	//��ũ��=ȸ����, ��ũ��=�ٷ����ٱ��̸�ŭ(4)
		for (int i = 0; i < memberList.size(); i++) {	//�����ϴ� ȸ������ŭ �ݺ���
			data[i][0] = memberList.get(i).getId();
			data[i][1] = memberList.get(i).getPw();
			data[i][2] = memberList.get(i).getName();
			data[i][3] = memberList.get(i).getEmail();
		}
		DefaultTableModel model = new DefaultTableModel(data, column); // DefaultTableModel ���� �� ������ ���
		table_member = new JTable(model); // JTable�� DefaultTableModel�� ���
		table_member.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		table_member.setBounds(37, 146, 287, 493);

		JScrollPane scrollPane = new JScrollPane(table_member);	//�����ʹþ�� ��ũ�� �Ἥ �����鼭 ������ ���� ����
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(37, 146, 287, 493);
		frame.getContentPane().add(scrollPane);

		JButton btn_deletemember = new JButton("\uAC15\uC81C \uD0C8\uD1F4");
		btn_deletemember.setBackground(new Color(204, 204, 255));
		//�������� ȸ�� ����Ż��(�ܼ�,�������� ����)
		btn_deletemember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_member.getSelectedRow();
				// int col = table_member.getSelectedColumn();
//      		Object value = table_member.getValueAt(row, 0);
//      		System.out.println(value);
//      		
//      		String idid = (String) value;
//
//           	int cnt = dao.deleteMember(idid);

				int result = JOptionPane.showConfirmDialog(null, "������ ȸ���� Ż���Ű�ڽ��ϱ�?", "ȸ�� ����", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) { // �����ڰ� ����ȸ���� ����Ż�� ��Ű�� ���� ���
					if (row != 0) { // ��Ͽ��� �ϳ��̻��� ȸ���� ������ ����
						row = table_member.getSelectedRow(); // ������ ���� ����
						int[] rows = (table_member.getSelectedRows());
						for (int i = 0; i < rows.length; i++) {
							Object value = table_member.getValueAt(rows[i], 0);
							String idid = (String) value;
							chkalrm = dao.check_alarm(new VO(idid,null,null,null));
							if (chkalrm>0) {
								dao.delete_alarm(new VO(idid,null,null,null));
							}
							cnt += dao.deleteMember(idid);
						}
						
						if (cnt > 0) {
							JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
							model.fireTableDataChanged();
							admin_member admin_member = new admin_member(vo);
						} else { // ��ϼ����� ���ϰ� ������û�ϴ� ����
							JOptionPane.showMessageDialog(null, "���õ� ����� �����ϴ�.", "ȸ�� ����", JOptionPane.INFORMATION_MESSAGE);
						}
					}
			
				} else if((result==JOptionPane.CLOSED_OPTION)||(result==JOptionPane.NO_OPTION)) {
//					DefaultTableModel model = (DefaultTableModel) table_member.getModel();
					JOptionPane.showMessageDialog(null, "���� ȸ�� Ż�� ���", "ȸ�� ����", JOptionPane.WARNING_MESSAGE );
					model.fireTableDataChanged();
					admin_member admin_member = new admin_member(vo);
					return; // �����ڰ� ��ҹ�ư || â�ݱ� ��ư�� ���� ���
				}
			
//						table_member()
//						DefaultTableModel model = (DefaultTableModel)table_member.getModel();
//						table_member = new JTable(model); // JTable�� DefaultTableModel�� ���
//						table_member.setBounds(37, 146, 287, 493);
				
//						DefaultTableModel model = (DefaultTableModel)table_member.getModel();
//						model.setValueAt(null, 0, 0);
				
//						DefaultTableModel model = (DefaultTableModel)table_member.getModel();
//						model.setRowCount(0);
				
//						DefaultTableModel model = (DefaultTableModel)table_member.getModel();
//						model.setNumRows(0);
			}
		});

		btn_deletemember.setFont(new Font("���ʷҵ���",Font.BOLD,14));btn_deletemember.setBounds(37,666,287,43);frame.getContentPane().add(btn_deletemember);

	}
}