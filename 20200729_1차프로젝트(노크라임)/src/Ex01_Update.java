

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
		
		//1. 드라이버 로딩
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";
		
		try {
			//1. 드라이버 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 객체를 생성
			conn = DriverManager.getConnection(url, user, password);
		
			//3. SQL문 작성
			// 아이딩랑 비밀번호를 입력 받으세요.
			// 변경하고 싶은 아이디를 입력 받으세요.

			
			System.out.print("아이디 입력 >> ");
			String id = sc.next();
			System.out.print("비밀번호 입력 >> ");
			String pw = sc.next();
			System.out.print("변경할 아이디 입력 >>");
			String newId = sc.next();

			// sql문장을 작성해보세요.   ---> 수정을 해줄거에요.
			// 기존에 있던 아이디를 변경하고 싶은 아이디로 수정
			// (조건 : 아이디랑 비밀번호가 기존에 있던 아이디랑 비밀번호와 일치)
			// UPDATE 테이블명 SET 컬럼 = 바꿀값 WHERE 조건
			String sql = "update members set id = ? where id = ? and pw = ?";
			
			// 4.PreparedStatement
			psmt = conn.prepareStatement(sql);
			//위에잇는 물음표 값을 채워주세요!
			
			psmt.setString(1, newId);
			psmt.setString(2, id);
			psmt.setString(3, pw);
			
			//실행! --> executeUpdate
			int cnt = psmt.executeUpdate(); 	//cnt ===> '영향을 받은 행의 개수'
			if (cnt > 0) {
				System.out.println("회원정보수정 성공!");
			} else {
				System.out.println("회원정보수정 실패!");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//닫는 순서는 역순
			try {
				if (psmt != null) {	//값이 있으면 닫아라
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
