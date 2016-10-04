package board.ui;

import java.text.SimpleDateFormat;

import board.Board;
import java.util.ArrayList;
import util.PrintUtil;

public class ListAllUI extends BaseUI {

	private char viewChar = '^';
	private int viewCount = 30;
	
	@Override
	public void execute() {
		ArrayList<Board> list = dao.selectBoard();
		
		System.out.printf("전체 %d개\n", list.size());
		PrintUtil.printChar(viewChar, viewCount);
		System.out.println("번호\t글쓴이\t제목\t등록일");
		PrintUtil.printChar(viewChar, viewCount);
		
		// 등록일 처리 부분 
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				
		for (int i = list.size() - 1; i >= 0; i--) {
			Board b = list.get(i);
			System.out.printf("%d\t%s\t%s\t%s\n", 
								b.getNo(), 
								b.getWriter(), 
								b.getTitle(),
								sdf.format(b.getRegDate()));
		}
		if (list.size() == 0) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		PrintUtil.printChar(viewChar, viewCount);
	}
}