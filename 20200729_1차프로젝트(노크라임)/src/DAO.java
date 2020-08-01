
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	// 필드 ---> DAO클래스 전역에 닿을 수 있게 생성
	private Connection conn = null;
	private PreparedStatement psmt = null;	//Statement 클래스 => SQL구문 실행, 스스로 sql구문 이해는 못함=전달역할)
	private ResultSet rs = null;

	// 데이터베이스와 연결하는 메소드 생성
	private void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kc";
		String password = "kc";

		try {
			// 1.드라이버 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 자원을 반납하는 닫기 메소드
	private void close() {
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

	// Database Access Object
	// 로그인 메소드
	public VO login(VO vo) {

		try {
			getConnection();

			String sql = "select pw from member where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				String dbpw = rs.getString(1);
				if (dbpw.equals(vo.getPw())) {
				} else {
					vo = null; // 잘못된 비번
				}
			} else { // 미등록 아이디
				vo = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 회원가입 메소드
	public int insert(VO vo) {
		int cnt = 0;
		try {
			getConnection();
			String sql = "insert into member values(?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// 회원정보 수정 메소드 (비밀번호or이메일)
	public int update(updateVO updatevo) {
		int cnt = 0;
		try {
			getConnection();
			if (updatevo.getclick().equals("password")) {
				String sql = "update member set pw = ? where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, updatevo.getNewPwEmail());
				psmt.setString(2, updatevo.getId());
				psmt.setString(3, updatevo.getPw());
			} else if (updatevo.getclick().equals("email")) {
				String sql = "update member set email = ? where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, updatevo.getNewPwEmail());
				psmt.setString(2, updatevo.getId());
				psmt.setString(3, updatevo.getPw());
			} else if(updatevo.getclick().equals("passwordemail")) {
				String sql = "update member set pw = ?, email = ? where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, updatevo.getNewPw());
				psmt.setString(2, updatevo.getNewEmail());
				psmt.setString(3, updatevo.getId());
				psmt.setString(4, updatevo.getPw());
			}

			cnt = psmt.executeUpdate(); // cnt ===> '영향을 받은 행의 개수'

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}


	
	
	// 회원정보 탈퇴 메소드
	public int delete(VO vo) {

		int cnt = 0;
		try {
			getConnection();

			String sql = "DELETE FROM member WHERE id = ? and pw = ?"; // 각각의 ?자리에 id와 pw를 적으면 id, pw라는 문자열이 들어가는 것

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 메소드명 -> allSelect()
	// 리턴타입은 여러분들이 생각해보세요!
	// 내부에서 출력 x
	public ArrayList<VO> allSelect() {
		ArrayList<VO> list = new ArrayList<VO>();
		try {
			getConnection();

			String sql = "SELECT * FROM member";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				VO vo = new VO(id, pw, name, email); // 1~4가져와서 vo로 묶음
				list.add(vo); // 리스트에 vo 담아서
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
//		System.out.println(list.get(0).getId());
		return list; // 반환해줌
	}
	
	//제보테이블용
	public ArrayList<tipoff_VO> allSelect1() {
		ArrayList<tipoff_VO> list = new ArrayList<tipoff_VO>();
		try {
			getConnection();

			String sql = "SELECT tip_info_id,cr_loc_id, to_date(cr_date, 'YYYY-MM-DD'),"
					+"cr_type_id,evidence,cr_name FROM tip_info";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String tip_info_id = rs.getString(1);
				String cr_loc_id = rs.getString(2);
				String cr_date = rs.getString(3);
				String cr_type_id = rs.getString(4);
				String evidence = rs.getString(5);
				String cr_name = rs.getString(6);
				tipoff_VO vo = new tipoff_VO(tip_info_id, cr_loc_id, cr_date, cr_type_id, evidence, cr_name); // 1~4가져와서 vo로 묶음
				list.add(vo); // 리스트에 vo 담아서
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list; // 반환해줌
	}

	//관리자의 회원강제탈퇴용
	public int deleteMember(String id) {

		int cnt = 0;
		try {
			getConnection(); 	//드라이버 로딩

			String sql = "DELETE FROM member WHERE id = ?"; // ?자리에 id나pw 적으면 id,pw라는 문자열이 들어가는 것

			psmt = conn.prepareStatement(sql);	//

			psmt.setString(1, id);		//아이디만 가져와서 비교하면 되기때문)

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
//제보전송하기용
	public int sending_tipoff(String tip_info_id, String cr_type_id, String cr_date,String cr_loc_id, String evidence,String cr_name) {

		int cnt = 0;
		try {
			getConnection(); 	//드라이버 로딩

			String sql = "INSERT INTO crime VALUES(?,TO_date(?,'YYYY-MM-DD') ,?,?,?,?)"; // ?자리에 TIPOFF 테이블에 들어갈 제보정보 삽입 

			psmt = conn.prepareStatement(sql);	//

			psmt.setString(1, cr_loc_id);
			psmt.setString(2, cr_date);
			psmt.setString(3, cr_type_id);
			psmt.setString(4, tip_info_id);
			psmt.setString(5, evidence);
			psmt.setString(6, cr_name);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public int sending_alarm(VO vo, int set_start, int set_end, int cr_cnt) {

		int cnt = 0;
		try {
			getConnection(); 	//드라이버 로딩

			String sql = "INSERT INTO alarm VALUES(?,?,?,?)"; // ?자리에 TIPOFF 테이블에 들어갈 제보정보 삽입 

			psmt = conn.prepareStatement(sql);	//
			
			psmt.setString(1, vo.getId());
			psmt.setInt(2, set_start);
			psmt.setInt(3, set_end);
			psmt.setInt(4, cr_cnt);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}



