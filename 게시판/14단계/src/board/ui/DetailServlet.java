package board.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;

@WebServlet("/detail")
public class DetailServlet  extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int findNo = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
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
        out.println(result);
        out.close();
	}
}





