package board.ui;

import board.Board;
import util.ArrayList;
import util.PrintUtil;

public class ListAllUI extends BaseUI {

	private char viewChar = '^';
	private int viewCount = 30;
	
	@Override
	public void execute() {
		ArrayList list = dao.selectBoard();
		
		System.out.printf("전체 %d개\n", list.size());
		PrintUtil.printChar(viewChar, viewCount);
		System.out.println("번호\t글쓴이\t제목");
		PrintUtil.printChar(viewChar, viewCount);
		for (int i = list.size() - 1; i >= 0; i--) {
			Board b = (Board)list.get(i);
			System.out.printf("%d\t%s\t%s\n", 
								b.getNo(), 
								b.getWriter(), 
								b.getTitle());
		}
		if (list.size() == 0) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		PrintUtil.printChar(viewChar, viewCount);
	}
}