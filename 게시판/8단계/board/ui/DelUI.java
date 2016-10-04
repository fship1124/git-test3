package board.ui;

public class DelUI extends BaseUI {

	@Override
	public void execute() {
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
}