package board.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardDAO;

@WebServlet("/updateForm")
public class UpdateFormServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
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
        out.println(result);
		out.close();
	}
}