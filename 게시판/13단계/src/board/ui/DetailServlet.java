package board.ui;

import java.text.SimpleDateFormat;

import board.Board;
import server.HttpServletRequest;

public class DetailServlet extends BaseServlet {
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		int findNo = Integer.parseInt(request.getParameter("no"));
		Board board = dao.selectBoardByNo(findNo);

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
		result += "	 <br><br>";
		result += "	 <hr />";
		result += String.format("번호 : %d<br>", findNo);
		result += String.format("글쓴이 : %s<br>", board.getWriter());
		result += String.format("제목 : %s<br>", board.getTitle());
		result += String.format("내용 : %s<br>", board.getContent());
		result += String.format("등록일시 : %s<br>",  
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.format(board.getRegDate()));
		result += "	 <hr />";
		result += String.format("<a href='updateForm?no=%d'>수정</a>", findNo);
		result += String.format("<a href='delete?no=%d'>삭제</a>", findNo);
		result += "<a href='list'>목록</a>";
        result += "</body>";
        result += "</html>";		
		return result;
	}
}





