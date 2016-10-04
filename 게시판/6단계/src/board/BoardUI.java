package board;

import java.util.Scanner;

import util.ArrayList;

public class BoardUI {

	private Scanner sc = new Scanner(System.in);
	
	// 화면 출력 양식 지정
	private char viewChar = '^';
	private int viewCount = 30;
	
	private BoardDAO dao;
	
	public BoardUI() {
		dao = new BoardDAO();
	}
	
	public void start() {
		
		while (true) {
			printChar(viewChar, viewCount);
			System.out.println("1. 전체 게시물 조회");
			System.out.println("2. 글번호 조회");
			System.out.println("3. 글등록");
			System.out.println("4. 글수정");
			System.out.println("5. 글삭제");
			System.out.println("0. 종료");
			printChar(viewChar, viewCount);
			System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:   searchAll();    break;
			case 2:   searchOne();    break;
			case 3:   add();          break;
			case 4:   mod();          break;
			case 5:   del();          break;
			case 0:   exit();
			}
		}
	}

	private void exit() {
		System.out.println("게시판 프로그램을 종료합니다");
		System.exit(0);
	}
	
	private void del() {
		System.out.print("삭제할 글번호를 입력하세요 : ");
		int delNo = Integer.parseInt(sc.nextLine());

		boolean result = dao.deleteBoard(delNo);
		if (result == false) {
			System.out.println(
					"입력하신 번호에 해당하는 게시글이 없습니다.");
		} else {
			System.out.println("게시글이 삭제되었습니다.");
		}
		
	}

	private void mod() {
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

	public void add() {
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
	
	public void searchOne() {
		System.out.print("조회할 글번호를 입력하세요 : ");
		int findNo = Integer.parseInt(sc.nextLine());
		Board board = dao.selectBoardByNo(findNo);

		printChar(viewChar, viewCount);
		if (board == null) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
		} else {
			System.out.println("번호 : " + findNo);
			System.out.println("글쓴이 : " + board.getWriter());
			System.out.println("제목 : " + board.getTitle());
			System.out.println("내용 : " + board.getContent());
		}
		printChar(viewChar, viewCount);
	}
	
	public void searchAll() {
		ArrayList list = dao.selectBoard();
		
		System.out.printf("전체 %d개\n", list.size());
		printChar(viewChar, viewCount);
		System.out.println("번호\t글쓴이\t제목");
		printChar(viewChar, viewCount);
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
		printChar(viewChar, viewCount);
	}

	private void printChar(char c, int count) {
		for (int i = 1; i <= count; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	



}
/*
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 0
게시판 프로그램을 종료합니다
*/








