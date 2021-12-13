import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// 객체 지향 설계 - SOLID
	public static void main(String[] args) {
		// 1. 로그인 2. 회원가입 3. 회원목록보기 4. 회원정보수정 5. 회원탈퇴 6. 종료
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원관리 시스템 =====");
		MemberDAO dao = new MemberDAO();
		while (true) {
			System.out.print("1. 로그인 2. 회원가입 3. 회원목록보기 4. 회원정보수정 5. 회원탈퇴 6. 종료 >>> ");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("==== 로그인 ====");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();

				String nick = dao.login(id, pw);
				
				if ( nick != null) {
					System.out.println(nick + "님 환영합니다!");
				} else {
					System.out.println("로그인 실패");
				}

			} else if (choice == 2) {
				System.out.println("==== 회원가입 ====");
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.print("닉네임 입력 : ");
				String nick = sc.next();

				int cnt = dao.join(id, pw, nick);
				// 출력은 메인에서 해주는게 좋음
				if (cnt > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}

			} else if (choice == 3) {
				// 회원 목록 보기
				System.out.println("===== 회원 목록 보기 =====");
				
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
				// 회원 정보 수정
				// finally -> conn psmt rs
				// 닫아주는 순서 : rs -> psmt -> conn 순
				// id -> pbk 인 회원의 닉네임을
				// '킹병관' 으로 바꾸어 주세요!
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("수정할 닉네임 >> ");
				String inputNick = sc.next();

				int cnt = dao.update(id, inputNick);
				
				if (cnt > 0) {
					System.out.println("회원정보 수정 완료");
				} else {
					System.out.println("회원정보 수정 실패");
				}
			} else if (choice == 5) {
				// 회원 탈퇴

			} else if (choice == 6) {
				System.out.println("프로그램을 종료합니다...");
				break;
			} else {
				System.out.println("정확한 숫자를 다시 입력해주세요");
			}
		}

	}

}
