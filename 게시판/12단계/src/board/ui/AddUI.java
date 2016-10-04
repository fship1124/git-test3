package board.ui;

import board.Board;

public class AddUI extends BaseUI {

	@Override
	public void execute() {
		Board board = new Board();
		
		System.out.print("제목을 입력하세요 : ");
		board.setTitle(sc.nextLine());
		
		System.out.print("글쓴이를 입력하세요 : ");
		board.setWriter(sc.nextLine());
		
		System.out.print("내용을 입력하세요 : ");
		board.setContent(sc.nextLine());
		
		// 게시물 저장 처리 부탁..
		dao.insertBoard(board);
		
		System.out.println("게시글 등록이 완료되었습니다.");
	}
}