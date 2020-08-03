import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class login {

   private JFrame frame;
   private JLabel lbl_signup;
   private JLabel lbl_name;
   private JLabel lbl_newid;
   private JLabel lbl_newpw;
   private JLabel lbl_email;
   private JLabel lbl_title;

   DAO dao = new DAO();
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               login window = new login();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public login() {
      initialize();
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      
      //프로젝트 내 src/res 폴더의 경로 바로 가기(알람기능 구현시 사용) 
      String url = getClass().getResource("").getPath() + "..\\..\\src\\res\\";   
   
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(230, 230, 250));
      frame.setBounds(100, 100, 375, 812);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel lbl_id = new JLabel("ID");
      lbl_id.setBounds(65, 248, 57, 15);
      lbl_id.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      frame.getContentPane().add(lbl_id);
      
      JLabel lbl_pw = new JLabel("PASSWORD");
      lbl_pw.setBounds(65, 291, 75, 15);
      lbl_pw.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      frame.getContentPane().add(lbl_pw);
      
      TextField txt_id = new TextField();         //JLabel이 아닌 TextField 사용(line86,87 사용위해 txtfield사용하고 형식 맞춤)
      txt_id.setBounds(146, 245, 155, 21);
      frame.getContentPane().add(txt_id);
      txt_id.setColumns(10);
      
      TextField txt_pw = new TextField();         //JLabel이 아닌 TextField 사용(line86,87 사용위해 txtfield사용하고 형식 맞춤)
      txt_pw.setBounds(146, 288, 155, 21);
      txt_pw.setColumns(10);
      frame.getContentPane().add(txt_pw);
      txt_pw.selectAll();       //txt_pw에 입력된 모든 문자열 선택
      txt_pw.setEchoChar('*');   //==> line86에서 선택된 모든문자열(비밀번호)이 *로 나오게 설정
      
      lbl_signup = new JLabel("SIGN UP");
      lbl_signup.setForeground(new Color(0, 0, 128));
      lbl_signup.setBounds(65, 405, 97, 30);
      lbl_signup.setFont(new Font("함초롬돋움", Font.BOLD, 24));
      frame.getContentPane().add(lbl_signup);
      
      lbl_name = new JLabel("NAME");
      lbl_name.setBounds(65, 459, 57, 15);
      lbl_name.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      frame.getContentPane().add(lbl_name);
      
      lbl_newid = new JLabel("ID");
      lbl_newid.setBounds(65, 500, 57, 15);
      lbl_newid.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      frame.getContentPane().add(lbl_newid);
      
      lbl_newpw = new JLabel("PASSWORD");
      lbl_newpw.setBounds(65, 545, 65, 15);
      lbl_newpw.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      frame.getContentPane().add(lbl_newpw);
      
      lbl_email = new JLabel("EMAIL");
      lbl_email.setBounds(65, 590, 57, 15);
      lbl_email.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      frame.getContentPane().add(lbl_email);
      
      TextField txt_name = new TextField();      //JLabel이 아닌 TextField 사용(line86,87 사용위해 txtfield사용하고 형식 맞춤)
      txt_name.setBounds(146, 456, 155, 21);
      txt_name.setColumns(10);
      frame.getContentPane().add(txt_name);
      
      TextField txt_newid = new TextField();      //JLabel이 아닌 TextField 사용(line86,87 사용위해 txtfield사용하고 형식 맞춤)
      txt_newid.setBounds(146, 497, 155, 21);
      txt_newid.setColumns(10);
      frame.getContentPane().add(txt_newid);
      
      TextField txt_newpw = new TextField();      //JLabel이 아닌 TextField 사용(line86,87 사용위해 txtfield사용하고 형식 맞춤)
      txt_newpw.setBounds(146, 542, 155, 21);
      txt_newpw.setColumns(10);
      frame.getContentPane().add(txt_newpw);
      
      TextField txt_email = new TextField();      //JLabel이 아닌 TextField 사용(line86,87 사용위해 txtfield사용하고 형식 맞춤)
      txt_email.setBounds(146, 587, 155, 21);
      txt_email.setColumns(10);
      frame.getContentPane().add(txt_email);
      
      lbl_title = new JLabel("");
      lbl_title.setBounds(39, -16, 282, 212);
      lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
      
      //title로고를 클릭하면 현재 로그인페이지 새로고침 
      lbl_title.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();         //현재 frame(창) 닫기
            login login = new login();
//            아래와같이 페이지 이동해도 되지만, line144처럼 new생성자 사용하여 선언해 주는 방식을 더 추천 (무조건 null로 불러오기때문에 값이 있다면 불러오지 못함)
//            login.main(null);      
         }
      });
      
      lbl_title.setIcon(new ImageIcon(login.class.getResource("/res/\uBC30\uACBD\uC5C6\uC74C.png")));
      frame.getContentPane().add(lbl_title);
      
      JButton btn_signup = new JButton("SIGN UP");
      btn_signup.setBounds(65, 640, 236, 23);
      //회원가입 구현
      btn_signup.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //페이지의 textField에 있는 값들을 변수에 담아 줌
            String id = txt_newid.getText();
            String pw = txt_newpw.getText();
            String name = txt_name.getText();
            String email = txt_email.getText();
            
            //line159~162에서 변수에 담아준 값들을 VO에 담아줌
            VO vo = new VO(id, pw, name, email);   
            int cnt = dao.insert(vo);
            if(cnt > 0) {   
               //변경되는 사항이 있다면(cnt>0) 회원가입 성공
               //팝업창 (부모컴포넌트, 메세지, 제목, 아이콘모양)
               JOptionPane.showMessageDialog(null, "회원가입 완료.\n로그인 하세요.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
               txt_newid.setText("");   //회원가입 후 textfield 리셋
               txt_newpw.setText("");
               txt_name.setText("");
               txt_email.setText("");
            } else {
               //(제약조건에 맞지 않아)회원가입 실패했을 때 팝업창 띄우기!
               JOptionPane.showMessageDialog(null, "사용할 수 없는 아이디 또는 이메일입니다.", "회원가입", JOptionPane.ERROR_MESSAGE);      //아이디:pk 이메일:uk
            }
         }
      });
      btn_signup.setBackground(new Color(204, 204, 255));
      btn_signup.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      frame.getContentPane().add(btn_signup);
      
      JButton btn_login = new JButton("SIGN IN");
      //ip,pw 입력 후, 로그인 버튼 클릭시 연결되는 페이지 지정
      btn_login.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            String id = txt_id.getText();
            String pw = txt_pw.getText();

            //line191,192에서 변수에 담아준 값들을 VO에 담아줌
            VO vo = new VO(id, pw);
            VO result = dao.login(vo);
            if(result != null) {
               if (vo.getId().equals("admin")) {   //관리자는 관리자페이지로
                  frame.dispose();
                  admin_select asel = new admin_select(vo);
               } else {                     //회원은 범죄조회페이지로
                  frame.dispose();
                  if(dao.check_alarm(vo)==0) {      //알람이 없는 회원이라면
                     crime_main crime = new crime_main(new VO_alarm(vo.getId(),null,null,null));
                  }else {                        //알람을 설정하여 있는 회원이라면
                     crime_main crime = new crime_main(dao.check_alarm2(vo));
                  }
               }
            } else {
               JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 다시 확인하세요", "로그인 실패", JOptionPane.WARNING_MESSAGE);
               txt_pw.setText("");
            }
         }
      });
      btn_login.setFont(new Font("함초롬돋움", Font.BOLD, 12));
      btn_login.setBackground(new Color(204, 204, 255));
      btn_login.setBounds(65, 340, 236, 23);
      frame.getContentPane().add(btn_login);
      
      JLabel lbl_signin = new JLabel("SIGN IN");
      lbl_signin.setForeground(new Color(0, 0, 128));
      lbl_signin.setFont(new Font("함초롬돋움", Font.BOLD, 24));
      lbl_signin.setBounds(65, 185, 97, 30);
      frame.getContentPane().add(lbl_signin);
   }
}