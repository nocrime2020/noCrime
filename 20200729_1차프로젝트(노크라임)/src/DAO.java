

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	// �ʵ� ---> DAOŬ���� ������ ���� �� �ְ� ����
	private Connection conn = null;
	private PreparedStatement psmt = null;
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
	//�α���
	public VO login(String id, String pw) {
//		String result = "";
		VO vo = null;
		
		try {
			getConnection();

			String sql = "select pw from member where id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
//			psmt.setNString(2, pw);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				String dbpw = rs.getString("pw");
				if(dbpw.equals(pw)) {
					vo = new VO(id, pw); //��������
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// ȸ������ �޼ҵ�
	public int insert(String id, String pw, String name, String email) {
		int cnt = 0;
		try {
			getConnection();
			String sql = "insert into member values(?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, email);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// ȸ������ ���� �޼ҵ�
	public int update(String id, String pw, String newPw) {

		int cnt = 0;
		try {
			getConnection();
			String sql = "update member set pw = ? where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, newPw);
			psmt.setString(2, id);
			psmt.setString(3, pw);

			cnt = psmt.executeUpdate(); // cnt ===> '������ ���� ���� ����'

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// ȸ������ Ż�� �޼ҵ�
	public int delete(String id, String pw) {

		int cnt = 0;
		try {
			getConnection();

			String sql = "DELETE FROM member WHERE id = ? and pw = ?"; // ?�ڸ��� id��pw ������ id,pw��� ���ڿ��� ���� ��

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

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
			int num = 1;
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				VO vo = new VO(id, pw, name, email);	//1~4�����ͼ� vo�� ����
				list.add(vo);	//����Ʈ�� vo ��Ƽ�
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;	//��ȯ����
	}

	
	
	
	
}
