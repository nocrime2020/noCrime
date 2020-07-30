import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import au.com.bytecode.opencsv.CSVReader;

public class testcsvtype {

   public static void main(String[] args) {

      Connection conn = null;
      PreparedStatement psmt = null;
      // <1.�����ͺ��̽� ����>
      // ����̹��� �������� �ε�
      // jdbc:oracle:thin -> JDBC����̹� Ÿ��
      // localhost -> ip�ּ�
      // 1521 -> port��ȣ
      // xe -> DB�̸�(=�ĺ���)
      String url = "jdbc:oracle:thin:@210.105.224.131:1521:xe";
      String user = "kc"; // DataBase�� �����ϱ� ���� ID�� PW
      String password = "kc";

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
         FileReader file;

         try {
            file = new FileReader("C:\\Users\\SMT053\\Desktop\\�⺻������Ʈ���⹰\\��ũ����\\backdata_�������.csv");
            CSVReader reader = new CSVReader(file);
            String[] array;
            int ch = 0;
            while ((array = reader.readNext()) != null) {
               ch++;
               if (ch > 1) {
                  String sql = "insert into crime values(?,?,?,?,?,?)";
                  psmt = conn.prepareStatement(sql);

                  // ?������ �־��ٰԿ�
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
         System.out.println("Ŭ���������� ã�� �� ����");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("SQL���� ����");
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
