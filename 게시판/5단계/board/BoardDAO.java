/**
 *  DAO : Date Access Object
 *  insert 
 *  update
 *  delete
 *  select
 */
package board;

public class BoardDAO {
	
	// 글번호
	private int no = 0;
	// 저장할 인덱스 위치와 입력된 데이터의 실 크기
	private int pos = 0;
	private final int INIT_SIZE = 5;
	private Board[] list = new Board[INIT_SIZE];
	
	public void insertBoard(Board board) {
		// 현재 배열에 모든 데이터가 꽉 차있음
		// 데이터를 추가로 입력받기 위해서는 
		// 1. 배열의 크기를 2배로 새롭게 생성
		// 2. 새롭게 생성된 배열로 기존의 입력된 내용을 복사
		if (pos == list.length) {
			Board[] tempList = new Board[pos * 2];
			System.arraycopy(list, 0, tempList, 0, pos);
			list = tempList;
		}
		board.setNo(++no);
		// 글번호 입력
		list[pos++] = board;
	}
	public boolean updateBoard(Board board) {
		for (int i = 0; i < pos; i++) {
			if (board.getNo() == list[i].getNo()) {
				list[i].setTitle(board.getTitle());
				return true;
			}
		}
		return false;
	}
	public boolean deleteBoard(int delNo) {
		// 글번호 배열을 반복하면서 사용자가 입력한
		// 삭제할 글번호의 인덱스 위치를 찾는다.
		int delIndex = -1;
		for (int i = 0; i < pos; i++) {
			if (delNo == list[i].getNo()) {
				delIndex = i;
				break;
			}
		}
		if (delIndex == -1) {
			return false;
		}
		
		int moveCnt = pos - delIndex -1;
		if (moveCnt != 0) {
			System.arraycopy(
				list, delIndex + 1, list, delIndex, moveCnt);
		}
		--pos;
		list[pos] = null;
		return true;
	}
	public Board[] selectBoard() {
		Board[] rList = new Board[pos];
		System.arraycopy(list, 0, rList, 0, pos);
		return rList;
	}
	/**
	 * 매개변수에 해당하는 글번호의 게시물을 반환하는 기능
	 * @param no
	 * @return  null 이 반환될 경우 해당 번호의 게시물이 존재하지 않는경우
	 *          null 이 아닌값이 반환된 경우는 해당 번호의 게시물을 찾은 경우
	 */
	public Board selectBoardByNo(int findNo) {
		for (int i = 0; i < pos; i++) {
			if (findNo == list[i].getNo()) {
				return list[i];
			}
		}
		return null;
	}
}















