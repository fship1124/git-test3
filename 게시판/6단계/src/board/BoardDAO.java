/**
 *  DAO : Date Access Object
 *  insert 
 *  update
 *  delete
 *  select
 */
package board;

import util.ArrayList;

public class BoardDAO {
	
	// 글번호
	private int no = 0;
	private ArrayList list;
	public BoardDAO() {
		list = new ArrayList();
	}
	
	public void insertBoard(Board board) {
		board.setNo(++no);
		list.add(board);
	}
	public boolean updateBoard(Board board) {
		for (int i = 0; i < list.size(); i++) {
			Board b = (Board)list.get(i);
			if (board.getNo() == b.getNo()) {
				b.setTitle(board.getTitle());
				return true;
			}
		}
		return false;
	}
	public boolean deleteBoard(int delNo) {
		// 글번호 배열을 반복하면서 사용자가 입력한
		// 삭제할 글번호의 인덱스 위치를 찾는다.
		for (int i = 0; i < list.size(); i++) {
			Board b = (Board)list.get(i);
			if (delNo == b.getNo()) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	public ArrayList selectBoard() {
		return list;
	}
	/**
	 * 매개변수에 해당하는 글번호의 게시물을 반환하는 기능
	 * @param no
	 * @return  null 이 반환될 경우 해당 번호의 게시물이 존재하지 않는경우
	 *          null 이 아닌값이 반환된 경우는 해당 번호의 게시물을 찾은 경우
	 */
	public Board selectBoardByNo(int findNo) {
		for (int i = 0; i < list.size(); i++) {
			Board b = (Board)list.get(i);
			if (findNo == b.getNo()) {
				return b;
			}
		}
		return null;
	}
}















