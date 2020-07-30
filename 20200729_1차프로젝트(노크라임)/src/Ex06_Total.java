

import java.util.ArrayList;
import java.util.Scanner;

public class Ex06_Total {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();

//		�켱 ��¹� �ݺ��ǰ� ���ֽð�
//		������ ���ǿ� ���� �ٸ� ����� �����ϵ��� if���� ������ּ���!
//		�׷��� ���� �츮 ������ ���� �ڵ�� �״�� ���� �ٿ��ֱ� ����!
		while (true) {
			System.out.print("[1]�α��� [2]ȸ������ [3]ȸ���������� [4]ȸ��Ż�� [5]ȸ���������� [6]���� >> ");
			int input = sc.nextInt();

			if (input == 1) {
				System.out.println("====== �α��� ======");
				System.out.print("���̵� �Է� >> ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� >> ");
				String pw = sc.next();

				String result = dao.login(id, pw);
				System.out.println(result);

			} else if (input == 2) {
				System.out.println("====== ȸ������ ======");
				System.out.print("���̵� �Է� >> ");
				String id = sc.next();
				System.out.print("�н����� �Է� >> ");
				String pw = sc.next();
				System.out.print("�̸� �Է� >>");
				String name = sc.next();
				System.out.print("���� �Է� >> ");
				int age = sc.nextInt();

				int cnt = dao.insert(id, pw, name, age);
				if (cnt > 0) {
					System.out.println("ȸ������ ����!");
				} else {
					System.out.println("ȸ������ ����!");
				}

			} else if (input == 3) {
				System.out.println("====== ȸ���������� ======");
				System.out.print("���̵� �Է� >> ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� >> ");
				String pw = sc.next();
				System.out.print("������ ���̵� �Է� >>");
				String newId = sc.next();

				int cnt = dao.update(newId, newId, pw);
				if (cnt > 0) {
					System.out.println("ȸ���������� ����!");
				} else {
					System.out.println("ȸ���������� ����!");
				}

			} else if (input == 4) {
				System.out.println("====== ȸ��Ż�� ======");
				System.out.print("���̵� �Է��ϼ��� >> ");
				String id = sc.next();
				System.out.print("��й�ȣ�� �Է��ϼ��� >> ");
				String pw = sc.next();

				int cnt = dao.delete(id, pw);
				if (cnt > 0) {
					System.out.println("Ż�𼺰�!");
				} else {
					System.out.println("Ż�����!");
				}

			} else if (input == 5) {
				System.out.println("======��üȸ�� �������� ======");
				System.out.println("��ȣ\t���̵�\t��й�ȣ\t�̸�\t����");
				ArrayList<VO> result = dao.allSelect();
				int num = 1;
				for (int i = 0; i < result.size(); i++) {
					// result.get(0) --> ����Ÿ���� VO!
					// VO�� ������ �ִ� ����߿� id�� ������ �� �ִ� ��� ---> getId()
					System.out.println(num++ + "\t" + result.get(i).getId() + "\t" + result.get(i).getPw() + "\t"
							+ result.get(i).getName() + "\t" + result.get(i).getAge());
				}

			} else if (input == 6) {
				System.out.println("�����մϴ�.");
				break;

			} else {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�.");
			}
		}

	}
}
