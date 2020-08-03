import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

//Database Access Object
public class DAO {

   // �ʵ� ---> DAOŬ���� ������ ���� �� �ְ� ����
   private Connection conn = null;
   private PreparedStatement psmt = null; // Statement Ŭ���� => SQL���� ����, ������ sql���� ���ش� ����=���޿���)
   private ResultSet rs = null;
   private MP3Player player = new MP3Player();

   // �����ͺ��̽��� �����ϴ� �޼ҵ� ����
   private void getConnection() {
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "kc";
      String password = "kc";

      try {
         // 1.����̹� �����ε�
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // �����ͺ��̽� �ڿ��� �ݳ��ϴ� �ݱ� �޼ҵ�
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

   // �α��� �޼ҵ�
   public VO login(VO vo) {

      try {
         getConnection();

         String sql = "select pw from member where id = ? and pw = ?";

         psmt = conn.prepareStatement(sql);
         
         psmt.setString(1, vo.getId()); //login���������� ����ڰ� txtfield�� ������ �����麸�� select�� ����Ͽ� pw������ ��
         psmt.setString(2, vo.getPw());
         
         rs = psmt.executeQuery();

         if (rs.next()) {   //Ŀ���� �Ʒ��� �̵��ϴ°�? (=�ҷ����� ������ �ִ�)
            String dbpw = rs.getString(1);   
            if (!dbpw.equals(vo.getPw())) {
               vo = null; // �߸��� ���
            }
         } else { // �̵�� ���̵�
            vo = null;
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return vo;
   }

   // ȸ������ �޼ҵ� (login.java)
   public int insert(VO vo) {
      int cnt = 0;
      try {
         getConnection();   //line19~33�� ����޼ҵ� 
         
         String sql = "insert into member values(?,?,?,?)";

         psmt = conn.prepareStatement(sql);

         psmt.setString(1, vo.getId());      //login���������� ����ڰ� txtfield�� ������ ������ DB�� insert
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

   // ȸ������ ���� �޼ҵ� (��й�ȣ || �̸��� || ��й�ȣ&&�̸��� )
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
         } else if (updatevo.getclick().equals("passwordemail")) {
            String sql = "update member set pw = ?, email = ? where id = ? and pw = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, updatevo.getNewPw());
            psmt.setString(2, updatevo.getNewEmail());
            psmt.setString(3, updatevo.getId());
            psmt.setString(4, updatevo.getPw());
         }

         cnt = psmt.executeUpdate(); // cnt ===> '������ ���� ���� ����'

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt;
   }

   // ȸ������ Ż�� �޼ҵ�
   public int delete(VO vo) {

      int cnt = 0;
      try {
         getConnection();

         String sql = "DELETE FROM member WHERE id = ? and pw = ?"; // ������ ?�ڸ��� id�� pw�� ������ id, pw��� ���ڿ��� ���� ��

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

   // �޼ҵ�� -> allSelect()
   // ����Ÿ���� �����е��� �����غ�����!
   // ���ο��� ��� x
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
            VO vo = new VO(id, pw, name, email); // 1~4�����ͼ� vo�� ����
            list.add(vo); // ����Ʈ�� vo ��Ƽ�
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
//      System.out.println(list.get(0).getId());
      return list; // ��ȯ����
   }

   // �������̺��
   public ArrayList<tipoff_VO> allSelect1() {
      ArrayList<tipoff_VO> list = new ArrayList<tipoff_VO>();
      try {
         getConnection();

         String sql = "SELECT tip_info_id,cr_loc_id, to_char(cr_date, 'YYYY-MM-DD'),"
               + "cr_type_id,evidence,cr_name FROM tip_info";

         psmt = conn.prepareStatement(sql);

         rs = psmt.executeQuery();
         while (rs.next()) {
            String tip_info_id = rs.getString(1);
            String cr_loc_id = rs.getString(2);
            String cr_date = rs.getString(3);
            String cr_type_id = rs.getString(4);
            String evidence = rs.getString(5);
            String cr_name = rs.getString(6);
            tipoff_VO vo = new tipoff_VO(tip_info_id, cr_type_id, cr_date, cr_loc_id, evidence, cr_name); // 1~4�����ͼ�
                                                                                    // vo��
                                                                                    // ����
            list.add(vo); // ����Ʈ�� vo ��Ƽ�
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return list; // ��ȯ����
   }

   // �������� ȸ������Ż���
   public int deleteMember(String id) {

      int cnt = 0;
      try {
         getConnection(); // ����̹� �ε�

         String sql = "DELETE FROM member WHERE id = ?"; // ?�ڸ��� id��pw ������ id,pw��� ���ڿ��� ���� ��

         psmt = conn.prepareStatement(sql); //

         psmt.setString(1, id); // ���̵� �����ͼ� ���ϸ� �Ǳ⶧��)

         cnt = psmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt;
   }

//�������� ���������ϱ��
   public int sending_tipoff(String tip_info_id, String cr_type_id, String cr_date, String cr_loc_id, String evidence,
         String cr_name) {

      int cnt = 0;
      try {
         getConnection(); // ����̹� �ε�

         String sql = "INSERT INTO crime Values (cr_id_seq.nextval,?, to_date(?, 'YYYY-MM-DD'), ?, ?,?)";
//               +"update crime(cr_id) set cr_id_seq.nextval where tip_info_id = ?;"; // ?�ڸ��� TIPOFF ���̺� �� �������� ���� 

         psmt = conn.prepareStatement(sql); //

         psmt.setString(1, cr_loc_id);
         psmt.setString(2, cr_date);
         psmt.setString(3, cr_type_id);
         psmt.setString(4, tip_info_id);
         psmt.setString(5, cr_name);

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
         getConnection(); // ����̹� �ε�

         String sql = "update alarm set set_start = ?, set_end = ?, cr_cnt = ? where id = ? "; // ?�ڸ��� TIPOFF ���̺�
                                                                           // �� �������� ����

         psmt = conn.prepareStatement(sql); //

         psmt.setInt(1, set_start);
         psmt.setInt(2, set_end);
         psmt.setInt(3, cr_cnt);
         psmt.setString(4, vo.getId());

         cnt = psmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt;
   }

   public int sending_alarm2(VO vo, int set_start, int set_end, int cr_cnt) {

      int cnt = 0;
      try {
         getConnection(); // ����̹� �ε�

         String sql = "INSERT INTO alarm VALUES(?,?,?,?)"; // ?�ڸ��� TIPOFF ���̺� �� �������� ����
         psmt = conn.prepareStatement(sql); //

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

   //�˶��� �ִ� ȸ������? ���������ʾ� ���� ȸ������? üũ���ִ� �޼ҵ�
   public int check_alarm(VO vo) {
      int cnt2 = 0;
      try {
         getConnection(); // ����̹� �ε�
         String sql = "select id from alarm WHERE id = ?"; //

         psmt = conn.prepareStatement(sql); //

         psmt.setString(1, vo.getId());

         rs = psmt.executeQuery();
         
         if (rs.next()) {   
            cnt2 = 1;
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt2;
   }

//   public int save_alarminfo(VO vo) {
//
//      int cnt3 = 0;
//      try {
//         getConnection(); // ����̹� �ε�
//         String sql = "select * from alarm where id = ? ";
//         psmt = conn.prepareStatement(sql);
//
//         psmt.setString(1, vo.getId());
//
//         rs = psmt.executeQuery();
//         while(rs.next()) {
//            String id = rs.getString(1);
//            String cr_loc_id = rs.getString(2);
//            String cr_date = rs.getString(3);
//            String cr_type_id = rs.getString(4);
//            String evidence = rs.getString(5);
//            String cr_name = rs.getString(6);
//            tipoff_VO vo = new tipoff_VO(tip_info_id, cr_type_id, cr_date, cr_loc_id, evidence, cr_name); // 1~4�����ͼ�
//         }
//         
//      } catch (SQLException e) {
//         e.printStackTrace();
//      } finally {
//         close();
//      }
//      return cnt3;
//   }

   // ������������ ���������� �����͸� �Ѱ���� Ȯ�ο�
   public boolean sended() {
      boolean result = false;
      try {
         getConnection();

         String sql = "select * from crime where cr_id = '1'";

         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();

         if (rs.next()) {
            result = true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return result;
   }

   //�˶��� �ִ� ȸ���� �˶�����(myPage)
   public VO_alarm check_alarm2(VO vo) {
      VO_alarm vo1 = null;
      try {
         getConnection(); // ����̹� �ε�
        
         String sql = "select * from alarm WHERE id = ?";

         psmt = conn.prepareStatement(sql);
        
         psmt.setString(1, vo.getId());

         rs = psmt.executeQuery();

         while (rs.next()) {
            String id = rs.getString(1);
            String set_start = rs.getString(2);
            String set_end = rs.getString(3);
            String cr_cnt = rs.getString(4);
            vo1 = new VO_alarm(id, set_start, set_end, cr_cnt);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return vo1;
   }

   public int delete_alarm(VO vo) {
      int cnt4 = 0;
      try {
         getConnection(); // ����̹� �ε�
         String sql = "delete from alarm where id = ? ";
         psmt = conn.prepareStatement(sql);

         psmt.setString(1, vo.getId());

         cnt4 = psmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt4;
   }

   // tipoff���� admin_tipoff�� �������� �ѱ�� �޼ҵ�
   public int tipoff_insert(tipoff_VO tipoff_vo) {
      int cnt = 0;
      try {
         getConnection();
         String sql = "";
         if (tipoff_vo.getCr_date().equals("")) {
            sql = "insert into tip_info values(tip_info_id_seq.nextval, ?, sysdate, ?, ?,null)";
            psmt = conn.prepareStatement(sql);

            psmt.setString(1, tipoff_vo.getCr_type_id());
            psmt.setString(2, tipoff_vo.getCr_loc_id());
            psmt.setString(3, tipoff_vo.getEvidence());
         } else {
            sql = "insert into tip_info values(tip_info_id_seq.nextval, ?, to_date(?, 'YYYYMMDD'), ?, ?,null)";
            psmt = conn.prepareStatement(sql);

            psmt.setString(1, tipoff_vo.getCr_type_id());
            psmt.setString(2, tipoff_vo.getCr_date());
            psmt.setString(3, tipoff_vo.getCr_loc_id());
            psmt.setString(4, tipoff_vo.getEvidence());
         }

         cnt = psmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }

      return cnt;
   }

   // VO�˶��� id,pw,name,email�� ���Ե� VO�� ��ȯ
   public VO alarmToVO(VO_alarm vo_alarm) {
      VO vo2 = null;
      try {
         getConnection();

         String sql = "SELECT * FROM member where id = ?";

         psmt = conn.prepareStatement(sql);
         psmt.setString(1, vo_alarm.getId());

         rs = psmt.executeQuery();

         while (rs.next()) {
            String id = rs.getString(1);
            String pw = rs.getString(2);
            String name = rs.getString(3);
            String email = rs.getString(4);
            vo2 = new VO(id, pw, name, email); // 1~4�����ͼ� vo�� ����
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return vo2; // ��ȯ����
   }

   public void alarmPlayer() {
	      player.play(DAO.class.getResource("").getPath() + "..\\src\\res\\ppipp.mp3");
	   }
	   
	   public void alarmStop() {
	      if (player.isPlaying())
	      player.stop();
	   }
}