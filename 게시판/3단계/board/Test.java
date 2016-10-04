package board;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		// 저장할 인덱스 위치와 입력된 데이터의 실 크기
		int pos = 0;
		// 글번호
		int no = 0;
		
		final int INIT_SIZE = 5;
		
		Board[] list = new Board[INIT_SIZE];
		
		Scanner sc = new Scanner(System.in);
		outer : 
		while (true) {
			System.out.println("------------------------------------");
			System.out.println("1. 전체 게시물 조회");
			System.out.println("2. 글번호 조회");
			System.out.println("3. 글등록");
			System.out.println("4. 글수정");
			System.out.println("5. 글삭제");
			System.out.println("0. 종료");
			System.out.println("------------------------------------");
			System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.printf("전체 %d개\n", pos);
				System.out.println("-------------------------------");
				System.out.println("번호\t글쓴이\t제목");
				System.out.println("-------------------------------");
				for (int i = pos - 1; i >= 0; i--) {
					System.out.printf(
						"%d\t%s\t%s\n", 
						list[i].no, 
						list[i].writer, 
						list[i].title);
				}
				if (pos == 0) {
					System.out.println("게시물이 존재하지 않습니다.");
				}
				System.out.println("-------------------------------");
				break;
			case 2:
				System.out.print("조회할 글번호를 입력하세요 : ");
				int findNo = Integer.parseInt(sc.nextLine());
				System.out.println("-------------------------------");
				boolean flag = false;
				for (int i = 0; i < pos; i++) {
					if (findNo == list[i].no) {
						flag = true;
						System.out.println("번호 : " + findNo);
						System.out.println("글쓴이 : " + list[i].writer);
						System.out.println("제목 : " + list[i].title);
						System.out.println("내용 : " + list[i].content);
						break;
					}
				}
				if (flag == false) {
					System.out.println("입력된 번호는 존재하지 않습니다.");
				}
				System.out.println("-------------------------------");
				
				
				break;
			case 3:
				// 현재 배열에 모든 데이터가 꽉 차있음
				// 데이터를 추가로 입력받기 위해서는 
				// 1. 배열의 크기를 2배로 새롭게 생성
				// 2. 새롭게 생성된 배열로 기존의 입력된 내용을 복사
				if (pos == list.length) {
					Board[] tempList = new Board[pos * 2];
					System.arraycopy(list, 0, tempList, 0, pos);
					list = tempList;
				}
				// 글번호 입력
				list[pos] = new Board();
				
				list[pos].no = ++no;
				System.out.print("제목을 입력하세요 : ");
				list[pos].title = sc.nextLine();
				System.out.print("글쓴이를 입력하세요 : ");
				list[pos].writer = sc.nextLine();
				System.out.print("내용을 입력하세요 : ");
				list[pos].content = sc.nextLine();
				
				pos++;
				System.out.println("게시글 등록이 완료되었습니다.");
				break;
			case 4:
				
				System.out.print("수정할 글번호를 입력하세요 : ");
				int modNo = Integer.parseInt(sc.nextLine());
				System.out.print("변경할 제목을 입력하세요 : ");
				String modTitle = sc.nextLine();
				
				boolean modFlag = false;
				for (int i = 0; i < pos; i++) {
					if (modNo == list[i].no) {
						modFlag = true;
						list[i].title = modTitle;
						break;
					}
				}
				if (modFlag == false) {
					System.out.println("입력된 번호는 존재하지 않습니다.");
				} else {
					System.out.println("게시글이 수정되었습니다.");
				}
				break;
			case 5:
				System.out.print("삭제할 글번호를 입력하세요 : ");
				int delNo = Integer.parseInt(sc.nextLine());
				// 글번호 배열을 반복하면서 사용자가 입력한
				// 삭제할 글번호의 인덱스 위치를 찾는다.
				int delIndex = -1;
				for (int i = 0; i < pos; i++) {
					if (delNo == list[i].no) {
						delIndex = i;
						break;
					}
				}
				if (delIndex == -1) {
					System.out.println(
						"입력하신 번호에 해당하는 게시글이 없습니다.");
					break;
				}
				
				int moveCnt = pos - delIndex -1;
				if (moveCnt != 0) {
					System.arraycopy(
						list, delIndex + 1, list, delIndex, moveCnt);
				}
				--pos;
				list[pos] = null;
				
				System.out.println("게시글이 삭제되었습니다.");
				break;
			case 0:
				System.out.println("게시판 프로그램을 종료합니다");
				break outer;
			}
		}
	}
}
/*
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 0
게시판 프로그램을 종료합니다
*/








