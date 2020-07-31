
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class login_test {

   public static void main(String[] args) {

      
      Scanner sc=new Scanner(System.in);
      Connection conn = null;// ���������� �⺻�� �ΰ���!!
      PreparedStatement psmt = null;
      // 1.�����ͺ��̽� ����
      // ����̹��� �����ε�
      // jdbc:oracle:thin->>JDBC ����̹�Ÿ��
      // localhost-->ip�ּ��̴�.
      // 1521-->port��ȣ
      // xe-->DB�̸�(�ĺ���)
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "hr";// �����ͺ��̽��� �����ϱ� ���� ���̵�� �н�����
      String password = "hr";

      // ����̹��� �����ε�
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Connection����--interface
         // Connection�̶�?
         // �����ͺ��̽��� �����ϱ� ���� �޼��带 ������ �ִ� �������̽�
         conn = DriverManager.getConnection(url, user, password);
         
         
         System.out.print("���̵��Է�>>");
         String id=sc.next();
         System.out.println("�н����� �Է�>>");
         String pw=sc.next();
         System.out.println("�̸��Է�>>");
         String name=sc.next();
         System.out.println("�����Է�");
         int age=sc.nextInt();
         
         // SQL���� �ۼ�
         // members���̺� dubu,1234,��κ�,7
         String sql = "insert into members values(?,?,?,?)";

         // PreParedStatement---->connection �������̽����� ������ �ü��ִ�.//����ǥ�� �����ִ�.
         // psmt�� sql���� �������ִ� ����
         psmt = conn.prepareStatement(sql);
         //? ������ �־��ٰԿ�
         psmt.setString(1, id);
         psmt.setString(2, pw);
         psmt.setString(3, name);
         psmt.setInt(4, age);
         
         // cnt==������ ���� ���� ������ 0���� ũ�� �����. ������ ���� ���� �ſ���!
         // SQLSyntaxError:��������!!
         int cnt = psmt.executeUpdate();
         if (cnt > 0) {
            System.out.println("����!");
         } else {
            System.out.println("����!");
         }
      } catch (ClassNotFoundException e) {// ������ �߻������� �Ͼ�� ������ֱ�
         // classNotFoundException�� ��ٴ°�?
         // 1.class.forName(�ּҰ� ��Ÿ�� ���� ���ɼ�)
         // 2.url�ּҰ� ��Ÿ�� ���� ���ɼ�!
         // 3.ojdbc6.jar������ �ִ��� Ȯ���ϱ�!
         System.out.println("Ŭ���������� ã�� �� ����.");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("SQL���� ����");
         e.printStackTrace();
      } finally {
         // conn,psmt�� �ݾ������!!
         try {
            //�ݴ� ������ ���� ������ �������� �ݾ��ش�.
            //psmt ���� �ݰ�-->conn�� ����.
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