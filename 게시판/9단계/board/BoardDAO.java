/**
 *  DAO : Date Access Object
 *  insert 
 *  update
 *  delete
 *  select
 */
package board;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class BoardDAO {
	
	// 글번호
	private int no = 0;
	private ArrayList<Board> list;
	public BoardDAO() {
		try {
			Map<String, Object> map = BoardFile.fileLoading();
			no = (Integer)map.get("no");
			list = (ArrayList<Board>)map.get("list");
		} catch (Exception e) {
			System.out.println("파일 로딩시 오류 발생");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void insertBoard(Board board) {
		board.setNo(++no);
		// 등록일시 추가
		board.setRegDate(new Date());
		list.add(board);
	}
	public boolean updateBoard(Board board) {
		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
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
			Board b = list.get(i);
			if (delNo == b.getNo()) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	public ArrayList<Board> selectBoard() {
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
			Board b = list.get(i);
			if (findNo == b.getNo()) {
				return b;
			}
		}
		return null;
	}
	
	public void save() throws Exception {
		BoardFile.saveFile(no, list);
	}
}















