
//member���̺��� ������ �ִ� �Ʒ� �÷����� �ϳ��� ��� ������ �� �ִ� �޼ҵ�
public class VO {   
   private String id;
   private String pw;
   private String name;
   private String email;
   private int[] settings;
   
   //ȸ������ ��� ������ ���
   public VO(String id, String pw, String name, String email) {
      this.id = id;      //line4�� �ν��Ͻ�����(this.id)�� line10�� �Ű������� ���ǵ� ��������(id)�� �����ϱ� ����.
      this.pw = pw;
      this.name = name;
      this.email = email;
   }

   //�α��� ��� ������ ���
   public VO(String id, String pw) {
      this.id = id;
      this.pw = pw;
   }
   
   
   
   public VO(String id, int[] settings) {
      this.id = id;
      this.settings = settings;
   }
   
   
   public int[] getSettings() {
      return settings;
   }

   public void setSettings(int[] settings) {
      this.settings = settings;
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