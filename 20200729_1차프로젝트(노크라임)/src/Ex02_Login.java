

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex02_Login {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		//1. ����̹� �ε�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Connection ��ü ����
			conn = DriverManager.getConnection(url, user, password);
		
			System.out.print("���̵� �Է� >> ");
			String id = sc.next();
			System.out.print("��й�ȣ �Է� >> ");
			String pw = sc.next();
			
			String sql = "select name, age from members where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setNString(2, pw);
		
			//select �࿡ ������ ��ġ�� �ʴ´�.
			// executeQuery();
			// ResultSet -> select���� ������ �Ŀ� '���̺�� ���� ����'�� ����ִ� ��ü
			//	cursor�� ����
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				//rs.nest()�� ����Ÿ���� ���� ������ true, �������� false
				String name = rs.getString(1);
				int age = rs.getInt(2);
				System.out.println("�̸���: " + name + "  ���̴� : " + age + "�Դϴ�.");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//rs -> psmt -> conn ������ ����
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
	
	
	
	
	
	}
}
