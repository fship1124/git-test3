package board.ui;

import board.Board;
import server.HttpServletRequest;

public class UpdateFormServlet extends BaseServlet {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = dao.selectBoardByNo(no);
		String result = "";
		result += "<!DOCTYPE html>";
        result += "<html>";
        result += "<head>";
        result += "  <meta charset='utf-8'>";
        result += "</head>";
        result += "<body>";
        result += "	 <hr />";
        result += "	 <h2>자바 네트워크 게시판</h2>";
        result += "	 <hr />";
        result += "	 <form method='post' action='update'>";
        result += "	   <input type='hidden' name='no' value='" + no + "' />";
        result += "	    제목 : <input type='text' name='title' size='70' value='" + board.getTitle() + "' /><br>";
        result += "	    글쓴이 : <input type='text' name='writer' size='30' readonly value='" + board.getWriter() + "' /><br>";
        result += "	    내용 : <textarea name='content' rows='7' cols='70'>" + board.getContent() + "</textarea><br>";
        result += "	   <button type='submit'>수정</button>";
        result += "	 </form>";
        result += "</body>";
        result += "</html>";
		return result;
	}
}