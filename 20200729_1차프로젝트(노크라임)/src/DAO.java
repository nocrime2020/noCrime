
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	// �ʵ� ---> DAOŬ���� ������ ���� �� �ְ� ����
	private Connection conn = null;
	private PreparedStatement psmt = null;	//Statement Ŭ���� => SQL���� ����, ������ sql���� ���ش� ����=���޿���)
	private ResultSet rs = null;

	// �����ͺ��̽��� �����ϴ� �޼ҵ� ����
	private void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";

		try {
			// 1.����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �����ͺ��̽� �ڿ��� �ݳ��ϴ� �ݱ� �޼ҵ�
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Database Access Object
	// �α��� �޼ҵ�
	public VO login(VO vo) {

		try {
			getConnection();

			String sql = "select pw from member where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				String dbpw = rs.getString(1);
				if (dbpw.equals(vo.getPw())) {
				} else {
					vo = null; // �߸��� ���
				}
			} else { // �̵�� ���̵�
				vo = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// ȸ������ �޼ҵ�
	public int insert(VO vo) {
		int cnt = 0;
		try {
			getConnection();
			String sql = "insert into member values(?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// ȸ������ ���� �޼ҵ� (��й�ȣor�̸���)
	public int update(updateVO updatevo) {
		int cnt = 0;
		try {
			getConnection();
			if (updatevo.getclick().equals("password")) {
				String sql = "update member set pw = ? where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, updatevo.getNewPwEmail());
				psmt.setString(2, updatevo.getId());
				psmt.setString(3, updatevo.getPw());
			} else if (updatevo.getclick().equals("email")) {
				String sql = "update member set email = ? where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, updatevo.getNewPwEmail());
				psmt.setString(2, updatevo.getId());
				psmt.setString(3, updatevo.getPw());
			} else if(updatevo.getclick().equals("passwordemail")) {
				String sql = "update member set pw = ?, email = ? where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, updatevo.getNewPw());
				psmt.setString(2, updatevo.getNewEmail());
				psmt.setString(3, updatevo.getId());
				psmt.setString(4, updatevo.getPw());
			}

			cnt = psmt.executeUpdate(); // cnt ===> '������ ���� ���� ����'

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}


	
	
	// ȸ������ Ż�� �޼ҵ�
	public int delete(VO vo) {

		int cnt = 0;
		try {
			getConnection();

			String sql = "DELETE FROM member WHERE id = ? and pw = ?"; // ������ ?�ڸ��� id�� pw�� ������ id, pw��� ���ڿ��� ���� ��

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// �޼ҵ�� -> allSelect()
	// ����Ÿ���� �����е��� �����غ�����!
	// ���ο��� ��� x
	public ArrayList<VO> allSelect() {
		ArrayList<VO> list = new ArrayList<VO>();
		try {
			getConnection();

			String sql = "SELECT * FROM member";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				VO vo = new VO(id, pw, name, email); // 1~4�����ͼ� vo�� ����
				list.add(vo); // ����Ʈ�� vo ��Ƽ�
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
//		System.out.println(list.get(0).getId());
		return list; // ��ȯ����
	}
	
	//�������̺��
	public ArrayList<tipoff_VO> allSelect1() {
		ArrayList<tipoff_VO> list = new ArrayList<tipoff_VO>();
		try {
			getConnection();

			String sql = "SELECT tip_info_id,cr_loc_id, to_date(cr_date, 'YYYY-MM-DD'),"
					+"cr_type_id,evidence,cr_name FROM tip_info";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String tip_info_id = rs.getString(1);
				String cr_loc_id = rs.getString(2);
				String cr_date = rs.getString(3);
				String cr_type_id = rs.getString(4);
				String evidence = rs.getString(5);
				String cr_name = rs.getString(6);
				tipoff_VO vo = new tipoff_VO(tip_info_id, cr_loc_id, cr_date, cr_type_id, evidence, cr_name); // 1~4�����ͼ� vo�� ����
				list.add(vo); // ����Ʈ�� vo ��Ƽ�
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list; // ��ȯ����
	}

	//�������� ȸ������Ż���
	public int deleteMember(String id) {

		int cnt = 0;
		try {
			getConnection(); 	//����̹� �ε�

			String sql = "DELETE FROM member WHERE id = ?"; // ?�ڸ��� id��pw ������ id,pw��� ���ڿ��� ���� ��

			psmt = conn.prepareStatement(sql);	//

			psmt.setString(1, id);		//���̵� �����ͼ� ���ϸ� �Ǳ⶧��)

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
//���������ϱ��
	public int sending_tipoff(String tip_info_id, String cr_type_id, String cr_date,String cr_loc_id, String evidence,String cr_name) {

		int cnt = 0;
		try {
			getConnection(); 	//����̹� �ε�

			String sql = "INSERT INTO crime VALUES(?,TO_date(?,'YYYY-MM-DD') ,?,?,?,?)"; // ?�ڸ��� TIPOFF ���̺� �� �������� ���� 

			psmt = conn.prepareStatement(sql);	//

			psmt.setString(1, cr_loc_id);
			psmt.setString(2, cr_date);
			psmt.setString(3, cr_type_id);
			psmt.setString(4, tip_info_id);
			psmt.setString(5, evidence);
			psmt.setString(6, cr_name);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public int sending_alarm(VO vo, int set_start, int set_end, int cr_cnt) {

		int cnt = 0;
		try {
			getConnection(); 	//����̹� �ε�

			String sql = "INSERT INTO alarm VALUES(?,?,?,?)"; // ?�ڸ��� TIPOFF ���̺� �� �������� ���� 

			psmt = conn.prepareStatement(sql);	//
			
			psmt.setString(1, vo.getId());
			psmt.setInt(2, set_start);
			psmt.setInt(3, set_end);
			psmt.setInt(4, cr_cnt);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}



