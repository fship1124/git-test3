package board.ui;

public class ExitUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("게시판 프로그램을 종료합니다");

		// BoardDAO 의 list 의 내용을 파일에 저장
		dao.save();
		
		System.exit(0);
	}
}