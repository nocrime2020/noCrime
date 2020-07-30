

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex01_Update {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		//1. ����̹� �ε�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			//1. ����̹� �����ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection ��ü�� ����
			conn = DriverManager.getConnection(url, user, password);
		
			//3. SQL�� �ۼ�
			// ���̵��� ��й�ȣ�� �Է� ��������.
			// �����ϰ� ���� ���̵� �Է� ��������.

			
			System.out.print("���̵� �Է� >> ");
			String id = sc.next();
			System.out.print("��й�ȣ �Է� >> ");
			String pw = sc.next();
			System.out.print("������ ���̵� �Է� >>");
			String newId = sc.next();

			// sql������ �ۼ��غ�����.   ---> ������ ���ٰſ���.
			// ������ �ִ� ���̵� �����ϰ� ���� ���̵�� ����
			// (���� : ���̵�� ��й�ȣ�� ������ �ִ� ���̵�� ��й�ȣ�� ��ġ)
			// UPDATE ���̺�� SET �÷� = �ٲܰ� WHERE ����
			String sql = "update members set id = ? where id = ? and pw = ?";
			
			// 4.PreparedStatement
			psmt = conn.prepareStatement(sql);
			//�����մ� ����ǥ ���� ä���ּ���!
			
			psmt.setString(1, newId);
			psmt.setString(2, id);
			psmt.setString(3, pw);
			
			//����! --> executeUpdate
			int cnt = psmt.executeUpdate(); 	//cnt ===> '������ ���� ���� ����'
			if (cnt > 0) {
				System.out.println("ȸ���������� ����!");
			} else {
				System.out.println("ȸ���������� ����!");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//�ݴ� ������ ����
			try {
				if (psmt != null) {	//���� ������ �ݾƶ�
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
