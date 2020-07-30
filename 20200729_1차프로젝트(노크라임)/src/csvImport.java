
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import au.com.bytecode.opencsv.CSVReader;

public class csvImport {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement psmt = null;
		// <1.데이터베이스 연결>
		// 드라이버를 동적으로 로딩
		// jdbc:oracle:thin -> JDBC드라이버 타입
		// localhost -> ip주소
		// 1521 -> port번호
		// xe -> DB이름(=식별자)
		String url = "jdbc:oracle:thin:@210.105.224.131:1521:xe";
		String user = "kc"; // DataBase에 접근하기 위한 ID와 PW
		String password = "kc";                                                                                                            

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			FileReader file;

			try {
				file = new FileReader("C:\\Users\\SMT044\\Desktop\\노크라임\\backdata_만드는중.csv");
				CSVReader reader = new CSVReader(file);
				String[] array;
				int ch = 0;
				while ((array = reader.readNext()) != null) {
					ch++;
					if (ch > 2) {
						String sql = "insert into crime values(?,?,to_date(?,'yyyy-MM-dd'),?,?,?)";
						psmt = conn.prepareStatement(sql);
//						SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//						Date date = (Date) transFormat.parse(array[7]);
						// ?값들을 넣어줄게요
						psmt.setString(1, array[0]);
						psmt.setString(2, array[1]);
						psmt.setString(3, array[7]);
						psmt.setString(4, array[6]);
						psmt.setString(5, array[9]);
						psmt.setString(6, array[8]);
						int cnt = psmt.executeUpdate();
						System.out.println(cnt);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("클래스파일을 찾을 수 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL관련 오류");
			e.printStackTrace();
		} finally {
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