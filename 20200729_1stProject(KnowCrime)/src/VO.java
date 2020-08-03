
//member테이블이 가지고 있는 아래 컬럼들을 하나로 묶어서 관리할 수 있는 메소드
public class VO {   
   private String id;
   private String pw;
   private String name;
   private String email;
   
   //회원가입 기능 구현시 사용
   public VO(String id, String pw, String name, String email) {
      this.id = id;      //line4의 인스턴스변수(this.id)와 line10의 매개변수로 정의된 지역변수(id)를 구분하기 위함.
      this.pw = pw;
      this.name = name;
      this.email = email;
   }

   //로그인 기능 구현시 사용
   public VO(String id, String pw) {
      this.id = id;
      this.pw = pw;
   }
   
   
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }

   
   
}