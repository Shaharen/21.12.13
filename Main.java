import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// ��ü ���� ���� - SOLID
	public static void main(String[] args) {
		// 1. �α��� 2. ȸ������ 3. ȸ����Ϻ��� 4. ȸ���������� 5. ȸ��Ż�� 6. ����
		Scanner sc = new Scanner(System.in);
		System.out.println("===== ȸ������ �ý��� =====");
		MemberDAO dao = new MemberDAO();
		while (true) {
			System.out.print("1. �α��� 2. ȸ������ 3. ȸ����Ϻ��� 4. ȸ���������� 5. ȸ��Ż�� 6. ���� >>> ");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("==== �α��� ====");
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();

				String nick = dao.login(id, pw);
				
				if ( nick != null) {
					System.out.println(nick + "�� ȯ���մϴ�!");
				} else {
					System.out.println("�α��� ����");
				}

			} else if (choice == 2) {
				System.out.println("==== ȸ������ ====");
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				System.out.print("�г��� �Է� : ");
				String nick = sc.next();

				int cnt = dao.join(id, pw, nick);
				// ����� ���ο��� ���ִ°� ����
				if (cnt > 0) {
					System.out.println("ȸ������ ����");
				} else {
					System.out.println("ȸ������ ����");
				}

			} else if (choice == 3) {
				// ȸ�� ��� ����
				System.out.println("===== ȸ�� ��� ���� =====");
				
				ArrayList<MemberDTO> list = dao.selectAll();
				
				for (int i = 0 ; i < list.size(); i++) {
					
//					MemberDTO m = list.get(i);
//					System.out.print(m.getId() + " - ");
//					System.out.print(m.getPw() + " - ");
//					System.out.print(m.getNick());
					
					System.out.print(list.get(i).getId() + " - ");
					System.out.print(list.get(i).getPw() + " - ");
					System.out.print(list.get(i).getNick());
					System.out.println();
				}
				
				
				
			} else if (choice == 4) {
				// ȸ�� ���� ����
				// finally -> conn psmt rs
				// �ݾ��ִ� ���� : rs -> psmt -> conn ��
				// id -> pbk �� ȸ���� �г�����
				// 'ŷ����' ���� �ٲپ� �ּ���!
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("������ �г��� >> ");
				String inputNick = sc.next();

				int cnt = dao.update(id, inputNick);
				
				if (cnt > 0) {
					System.out.println("ȸ������ ���� �Ϸ�");
				} else {
					System.out.println("ȸ������ ���� ����");
				}
			} else if (choice == 5) {
				// ȸ�� Ż��

			} else if (choice == 6) {
				System.out.println("���α׷��� �����մϴ�...");
				break;
			} else {
				System.out.println("��Ȯ�� ���ڸ� �ٽ� �Է����ּ���");
			}
		}

	}

}
