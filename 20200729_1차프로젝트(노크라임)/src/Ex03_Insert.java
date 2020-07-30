
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex03_Insert {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		//<1.데이터베이스 연결>
		//드라이버를 동적으로 로딩
		// jdbc:oracle:thin -> JDBC드라이버 타입
		// localhost -> ip주소
		// 1521 -> port번호
		// xe -> DB이름(=식별자)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";		//DataBase에 접근하기 위한 ID와 PW
		String password = "kc";
		
		try {
			//<드라이버를 동적으로 로딩하기!> _Class.forName에서 + jar파일필요
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connection연결
			//Connection이란?
			//데이터베이스에 접근하기 위한 메서드를 가지고 있는 (하나의) 인터페이스
			conn = DriverManager.getConnection(url, user, password);
			
			
			System.out.print("아이디 입력 >> ");
			String id = sc.next();
			System.out.print("패스워드 입력 >> ");
			String pw = sc.next();
			System.out.print("이름 입력 >>");
			String name = sc.next();
			System.out.print("나이 입력 >> ");
			int age = sc.nextInt();
					
			//SQL문을 작성
			//members테이블에 dubu, 1234, 흑두부, 7
			String sql = "insert into members values(?,?,?,?)";
			//PrearedStatement ----> Connection 인터페이스에서 가지고 올 수 있다.
			//psmt는 sql문을 실행해주는 역할
			psmt = conn.prepareStatement(sql);
			
			//?값들을 넣어줄게요
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setInt(4, age);
			
			
//			cnt가 0보다 크면 실행이 됨. 실행이 되지 않은거에요!
//			실행이 되었다면 실행완료. 안되었다면 실패.
			
			//SQLSyntaxError --> 구문 오류
			int cnt = psmt.executeUpdate();
			if (cnt>0) {
				System.out.println("성공!");
			} else {
				System.out.println("실패!");
			}

		} catch (ClassNotFoundException e) {
			//ClassNotFound Exception이 뜬다ㄴ는건?
			//1.Class.forName(주소가 오타가 났을 가능성)
			//2.url 주소가 오타가 났을 가능성
			//3.자바프로젝트 폴더에 ojdbc6.jar파일이 있는지 확인하기
			System.out.println("클래스파일을 찾을 수 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL관련 오류");
			e.printStackTrace();
		}finally {	//예외발생과 관계없이 무조건 실행됨
			try {
				//닫는 순서는 열린 순서의 역순으로 닫아준다.
				//psmt 먼저 닫고 -> conn을 닫음.
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}

}
