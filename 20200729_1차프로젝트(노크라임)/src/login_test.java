
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class login_test {

   public static void main(String[] args) {

      
      Scanner sc=new Scanner(System.in);
      Connection conn = null;// 참조변수의 기본은 널값임!!
      PreparedStatement psmt = null;
      // 1.데이터베이스 연결
      // 드라이버를 동적로딩
      // jdbc:oracle:thin->>JDBC 드라이버타입
      // localhost-->ip주소이다.
      // 1521-->port번호
      // xe-->DB이름(식별자)
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "hr";// 데이터베이스에 접근하기 위한 아이디와 패스워드
      String password = "hr";

      // 드라이버를 동적로딩
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Connection연결--interface
         // Connection이란?
         // 데이터베이스에 접근하기 위한 메서드를 가지고 있는 인터페이스
         conn = DriverManager.getConnection(url, user, password);
         
         
         System.out.print("아이디입력>>");
         String id=sc.next();
         System.out.println("패스워드 입력>>");
         String pw=sc.next();
         System.out.println("이름입력>>");
         String name=sc.next();
         System.out.println("나이입력");
         int age=sc.nextInt();
         
         // SQL문을 작성
         // members테이블에 dubu,1234,흑두부,7
         String sql = "insert into members values(?,?,?,?)";

         // PreParedStatement---->connection 인터페이스에서 가지고 올수있다.//물음표를 쓸수있다.
         // psmt는 sql문을 실행해주는 역할
         psmt = conn.prepareStatement(sql);
         //? 값들을 넣어줄게요
         psmt.setString(1, id);
         psmt.setString(2, pw);
         psmt.setString(3, name);
         psmt.setInt(4, age);
         
         // cnt==영향을 받은 행의 갯수가 0보다 크면 실행됨. 실행이 되지 않은 거에요!
         // SQLSyntaxError:구문오류!!
         int cnt = psmt.executeUpdate();
         if (cnt > 0) {
            System.out.println("성공!");
         } else {
            System.out.println("실패!");
         }
      } catch (ClassNotFoundException e) {// 에러가 발생했을때 일어나는 내용써주기
         // classNotFoundException이 뜬다는건?
         // 1.class.forName(주소가 오타가 났을 가능성)
         // 2.url주소가 오타가 났을 가능성!
         // 3.ojdbc6.jar파일이 있는지 확인하기!
         System.out.println("클래스파일을 찾을 수 없음.");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("SQL관련 오류");
         e.printStackTrace();
      } finally {
         // conn,psmt를 닫아줘야함!!
         try {
            //닫는 순서는 열린 순서의 역순으로 닫아준다.
            //psmt 먼저 닫고-->conn을 닫음.
            if(psmt!=null) {
               psmt.close();
            }
            if(conn!=null) {
               conn.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
            }
            
            if(conn!=null) {
               conn.close();
            }
            psmt.close();
   

         }
      
      }
   }
}