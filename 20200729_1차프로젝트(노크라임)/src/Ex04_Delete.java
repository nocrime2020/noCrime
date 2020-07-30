

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex04_Delete {
	public static void main(String[] args) {
		
		//����θ� ��������!
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		//ȸ������Ż��ý���
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			//1.����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.connection��ü ������ �����ϱ�
			conn = DriverManager.getConnection(url, user, password);
			
			//3.Sql�� �ۼ�
//			���̵�� ��й�ȣ�� �Է¹޾Ƽ�
			System.out.print("���̵� �Է��ϼ��� >> ");
			String id = sc.next();
			System.out.print("��й�ȣ�� �Է��ϼ��� >> ");
			String pw = sc.next();
			
//			�ΰ� �� ��ġ���� �� ���� �����ϴ� ���α׷��� ������ּ���.
//			DELETE FROM ���̺�� WHERE ������
			String sql = "DELETE FROM members WHERE id = ? and pw = ?";	//?�ڸ��� id��pw ������ id,pw��� ���ڿ��� ���� ��
			//4. PreparedStatement��ü ����
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			//5. ����
			//executeUpdate
			//cnt�� ���ϴ� �ٴ�? ������ ���� ���� ����
//			������ �����ߴٸ� "Ż�𼺰�!"�̶�� �޼���
//			���н� "Ż�����!"��� �޼���
//			�࿡ ������ ��ġ�� �۾�! -----> executeUpdate()
			int cnt = psmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println("Ż�𼺰�!");
			} else {
				System.out.println("Ż�����!");
			}

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			//6.�ݱ�
			//�������� ����!
				try {
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
