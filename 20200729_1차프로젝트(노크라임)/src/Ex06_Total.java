

import java.util.ArrayList;
import java.util.Scanner;

public class Ex06_Total {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();

//		우선 출력문 반복되게 해주시고
//		각각의 조건에 따라서 다른 기능을 수행하도록 if문만 만들어주세요!
//		그러고 나서 우리 이전에 만든 코드들 그대로 복사 붙여넣기 진행!
		while (true) {
			System.out.print("[1]로그인 [2]회원가입 [3]회원정보수정 [4]회원탈퇴 [5]회원정보보기 [6]종료 >> ");
			int input = sc.nextInt();

			if (input == 1) {
				System.out.println("====== 로그인 ======");
				System.out.print("아이디 입력 >> ");
				String id = sc.next();
				System.out.print("비밀번호 입력 >> ");
				String pw = sc.next();

				String result = dao.login(id, pw);
				System.out.println(result);

			} else if (input == 2) {
				System.out.println("====== 회원가입 ======");
				System.out.print("아이디 입력 >> ");
				String id = sc.next();
				System.out.print("패스워드 입력 >> ");
				String pw = sc.next();
				System.out.print("이름 입력 >>");
				String name = sc.next();
				System.out.print("나이 입력 >> ");
				int age = sc.nextInt();

				int cnt = dao.insert(id, pw, name, age);
				if (cnt > 0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패!");
				}

			} else if (input == 3) {
				System.out.println("====== 회원정보수정 ======");
				System.out.print("아이디 입력 >> ");
				String id = sc.next();
				System.out.print("비밀번호 입력 >> ");
				String pw = sc.next();
				System.out.print("변경할 아이디 입력 >>");
				String newId = sc.next();

				int cnt = dao.update(newId, newId, pw);
				if (cnt > 0) {
					System.out.println("회원정보수정 성공!");
				} else {
					System.out.println("회원정보수정 실패!");
				}

			} else if (input == 4) {
				System.out.println("====== 회원탈퇴 ======");
				System.out.print("아이디를 입력하세요 >> ");
				String id = sc.next();
				System.out.print("비밀번호를 입력하세요 >> ");
				String pw = sc.next();

				int cnt = dao.delete(id, pw);
				if (cnt > 0) {
					System.out.println("탈퇴성공!");
				} else {
					System.out.println("탈퇴실패!");
				}

			} else if (input == 5) {
				System.out.println("======전체회원 정보보기 ======");
				System.out.println("번호\t아이디\t비밀번호\t이름\t나이");
				ArrayList<VO> result = dao.allSelect();
				int num = 1;
				for (int i = 0; i < result.size(); i++) {
					// result.get(0) --> 리턴타입은 VO!
					// VO가 가지고 있는 기능중에 id를 꺼내올 수 있는 기능 ---> getId()
					System.out.println(num++ + "\t" + result.get(i).getId() + "\t" + result.get(i).getPw() + "\t"
							+ result.get(i).getName() + "\t" + result.get(i).getAge());
				}

			} else if (input == 6) {
				System.out.println("종료합니다.");
				break;

			} else {
				System.out.println("잘못된 숫자를 입력하셨습니다.");
			}
		}

	}
}
