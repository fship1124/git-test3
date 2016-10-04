package board.ui;

import board.Board;

public class ModUI extends BaseUI {

	@Override
	public void execute() {
		Board board = new Board();
		
		System.out.print("수정할 글번호를 입력하세요 : ");
		int modNo = Integer.parseInt(sc.nextLine());
		board.setNo(modNo);
		System.out.print("변경할 제목을 입력하세요 : ");
		String modTitle = sc.nextLine();
		board.setTitle(modTitle);
		
		boolean modFlag = dao.updateBoard(board);
		if (modFlag == false) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
		} else {
			System.out.println("게시글이 수정되었습니다.");
		}
	}
}