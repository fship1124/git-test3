package board.ui;

import util.PrintUtil;

public class BoardUI extends BaseUI {
	// 화면 출력 양식 지정
	private char viewChar = '^';
	private int viewCount = 30;
	
	public void execute() {
		while (true) {
			PrintUtil.printChar(viewChar, viewCount);
			System.out.println("1. 전체 게시물 조회");
			System.out.println("2. 글번호 조회");
			System.out.println("3. 글등록");
			System.out.println("4. 글수정");
			System.out.println("5. 글삭제");
			System.out.println("0. 종료");
			PrintUtil.printChar(viewChar, viewCount);
			System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
			int menu = Integer.parseInt(sc.nextLine());
			BaseUI ui = null;
			switch (menu) {
			case 1:   ui = new ListAllUI();    break;
			case 2:   ui = new ListOneUI(); break;
			case 3:   ui = new AddUI();     break;
			case 4:   ui = new ModUI();     break;
			case 5:   ui = new DelUI();     break;
			case 0:   ui = new ExitUI();
			}
			ui.execute();
		}
	}
}








