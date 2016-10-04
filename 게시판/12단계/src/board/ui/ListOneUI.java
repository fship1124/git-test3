package board.ui;

import java.text.SimpleDateFormat;

import board.Board;
import util.PrintUtil;

public class ListOneUI extends BaseUI {
	
	private char viewChar = '^';
	private int viewCount = 30;
	
	@Override
	public void execute() {
		System.out.print("조회할 글번호를 입력하세요 : ");
		int findNo = Integer.parseInt(sc.nextLine());
		Board board = dao.selectBoardByNo(findNo);

		PrintUtil.printChar(viewChar, viewCount);
		if (board == null) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
		} else {
			System.out.println("번호 : " + findNo);
			System.out.println("글쓴이 : " + board.getWriter());
			System.out.println("제목 : " + board.getTitle());
			System.out.println("내용 : " + board.getContent());
			System.out.println("등록일시 : " + 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.format(board.getRegDate()));
		}
		PrintUtil.printChar(viewChar, viewCount);
	}
}





