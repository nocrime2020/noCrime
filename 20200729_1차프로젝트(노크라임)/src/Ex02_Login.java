

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
		
		//1. 드라이버 로딩
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Connection 객체 생성
			conn = DriverManager.getConnection(url, user, password);
		
			System.out.print("아이디 입력 >> ");
			String id = sc.next();
			System.out.print("비밀번호 입력 >> ");
			String pw = sc.next();
			
			String sql = "select name, age from members where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setNString(2, pw);
		
			//select 행에 영향을 끼치지 않는다.
			// executeQuery();
			// ResultSet -> select문을 실행한 후에 '테이블과 같은 형태'를 담고있는 객체
			//	cursor가 존재
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				//rs.nest()의 리턴타입은 값이 있을때 true, 없을때는 false
				String name = rs.getString(1);
				int age = rs.getInt(2);
				System.out.println("이름은: " + name + "  나이는 : " + age + "입니다.");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//rs -> psmt -> conn 순서로 닫음
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
