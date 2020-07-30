

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex04_Delete {
	public static void main(String[] args) {
		
		//선언부만 위쪽으로!
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		//회원정보탈퇴시스템
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			//1.드라이버 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.connection객체 실제로 생성하기
			conn = DriverManager.getConnection(url, user, password);
			
			//3.Sql문 작성
//			아이디랑 비밀번호를 입력받아서
			System.out.print("아이디를 입력하세요 >> ");
			String id = sc.next();
			System.out.print("비밀번호를 입력하세요 >> ");
			String pw = sc.next();
			
//			두개 다 일치했을 때 행을 삭제하는 프로그램을 만들어주세요.
//			DELETE FROM 테이블명 WHERE 조건절
			String sql = "DELETE FROM members WHERE id = ? and pw = ?";	//?자리에 id나pw 적으면 id,pw라는 문자열이 들어가는 것
			//4. PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			//5. 실행
			//executeUpdate
			//cnt가 뜻하는 바는? 영향은 받은 행의 개수
//			삭제가 성공했다면 "탈퇴성공!"이라는 메세지
//			실패시 "탈퇴실패!"라는 메세지
//			행에 영향을 끼치는 작업! -----> executeUpdate()
			int cnt = psmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println("탈퇴성공!");
			} else {
				System.out.println("탈퇴실패!");
			}

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			//6.닫기
			//닫을때는 역순!
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
