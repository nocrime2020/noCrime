

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex05_Select {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		//��üȸ���������� �ý���
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			//1.����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection��ü ����
			conn = DriverManager.getConnection(url, user, password);
		
			//3.SQL�� �ۼ�
//			sql���� SELECT * FROM ���̺��
//			���̵� ��й�ȣ �̸� ����
//			���������� �޿�- ������!
			String sql = "SELECT * FROM members";
			
			//4.PreparedStatement��ü ����
			psmt = conn.prepareStatement(sql);
			
			//5.����
			//select�� �࿡ ������ ��ġ�� �ʽ��ϴ�.
			rs = psmt.executeQuery();
			// \t�� tab�� �����Ŷ� ���� ���
			System.out.println("��ȣ\t���̵�\t��й�ȣ\t�̸�\t����" );
			int num = 1;	//�տ� ��ȣ �ٿ��ֱ� ���� ����
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				System.out.println(num++ + "\t" + id + "\t" + pw + "\t" + name + "\t" + age);
			}
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// rs -> psmt -> conn
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
