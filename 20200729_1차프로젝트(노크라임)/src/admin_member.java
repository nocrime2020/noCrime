import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class admin_member {

   private JFrame frame;
   private JTable table_member;

   DAO dao = new DAO();

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               A_member window = new A_member();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the application.
    */
   public admin_member(VO vo) {
      initialize(vo);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(VO vo) {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(230, 230, 250));
      frame.setBounds(100, 100, 375, 812);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JLabel lbl_title = new JLabel("");
      lbl_title.setIcon(new ImageIcon(
            "C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\\uC791\uC740 \uD22C\uBA85.png"));
      lbl_title.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

            frame.dispose();
//            admin_select.main(null);
            admin_select admin_select = new admin_select(vo);

         }
      });
      lbl_title.setFont(new Font("굴림", Font.PLAIN, 23));
      lbl_title.setBounds(12, 10, 103, 56);
      frame.getContentPane().add(lbl_title);

      JLabel lbl_signout = new JLabel("");
      lbl_signout.setIcon(new ImageIcon(
            "C:\\Users\\SMT053\\Desktop\\\uAE30\uBCF8\uD504\uB85C\uC81D\uD2B8\uC0B0\uCD9C\uBB3C\\\uB178\uD06C\uB77C\uC784\\icon\\off_logout_17916.png"));
      lbl_signout.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
//            login.main(null);
            login login = new login();

         }
      });
      lbl_signout.setBounds(307, 10, 40, 29);
      frame.getContentPane().add(lbl_signout);

      JLabel lbl_member = new JLabel("\uD68C\uC6D0 \uAD00\uB9AC");
      lbl_member.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_member.setFont(new Font("함초롬돋움", Font.BOLD, 24));
      lbl_member.setBounds(90, 76, 180, 60);
      frame.getContentPane().add(lbl_member);

      ArrayList<VO> memberList = dao.allSelect();
      String[] column = { "아이디", "비밀번호", "이름", "이메일" };
      Object[][] data = new Object[memberList.size()][column.length];
      for (int i = 0; i < memberList.size(); i++) {
         data[i][0] = memberList.get(i).getId();
         data[i][1] = memberList.get(i).getPw();
         data[i][2] = memberList.get(i).getName();
         data[i][3] = memberList.get(i).getEmail();
      }
      DefaultTableModel model = new DefaultTableModel(data, column); //DefaultTableModel 선언 후 데이터 담기
      table_member = new JTable(model);   //JTable에 DefaultTableModel을 담기
      table_member.setBounds(37, 146, 287, 493);
      
      JScrollPane scrollPane = new JScrollPane(table_member); //JScrollPane에 JTable을 담기
      scrollPane.setBounds(37, 146, 287, 493);
      frame.getContentPane().add(scrollPane);

      JButton btn_deletemember = new JButton("\uAC15\uC81C \uD0C8\uD1F4");
      btn_deletemember.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            int result = JOptionPane.showConfirmDialog(null, "선택한 회원을 탈퇴시키겠습니까?", "회원 관리", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
               // 관리자가 선택회원을 강제탈퇴 시키고 싶은 경우
               return;

            } else if ((result == JOptionPane.CLOSED_OPTION) || (result == JOptionPane.NO_OPTION)) {
               return; // 관리자가 취소버튼 혹은 창닫기 버튼을 누른 경우
            }
            
         }
      });
      btn_deletemember.setFont(new Font("함초롬돋움", Font.BOLD, 14));
      btn_deletemember.setBounds(37, 666, 287, 43);
      frame.getContentPane().add(btn_deletemember);


   }
}