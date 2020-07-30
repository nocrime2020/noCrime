

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
		
		//전체회원정보보기 시스템
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			//1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection객체 생성
			conn = DriverManager.getConnection(url, user, password);
		
			//3.SQL문 작성
//			sql문에 SELECT * FROM 테이블명
//			아이디 비밀번호 이름 나이
//			실제정보가 쭈욱- 나오게!
			String sql = "SELECT * FROM members";
			
			//4.PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			
			//5.실행
			//select는 행에 영향을 끼치지 않습니다.
			rs = psmt.executeQuery();
			// \t는 tab을 누른거랑 같은 기능
			System.out.println("번호\t아이디\t비밀번호\t이름\t나이" );
			int num = 1;	//앞에 번호 붙여주기 위한 변수
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
