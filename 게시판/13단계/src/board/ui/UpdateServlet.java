package board.ui;

import board.Board;
import server.HttpServletRequest;

public class UpdateServlet extends BaseServlet {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		Board board = new Board();
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		System.out.println(board);
		
		dao.updateBoard(board);
		
		String result = "";
		result += "<!DOCTYPE html>";
        result += "<html>";
        result += "<head>";
        result += "  <meta charset=\"utf-8\">";
        result += "</head>";
        result += "<body>";
        result += "	 <h2>게시글 수정이 완료되었습니다.</h2>";
        result += "	 <a href='list'>목록</a>";
        result += "</body>";
        result += "</html>";
		return result;
	}
}