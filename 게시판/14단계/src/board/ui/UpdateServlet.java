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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		Board board = new Board();
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		System.out.println(board);
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(board);
		
		String result = "";
		result += "<!DOCTYPE html>";
        result += "<html>";
        result += "<head>";
        result += "  <meta charset=\"utf-8\">";
        result += "  <meta http-equiv='refresh' content='1; url=/LecBoard/list'>";        
        result += "</head>";
        result += "<body>";
        result += "	 <h2>게시글 수정이 완료되었습니다.</h2>";
        result += "	 <a href='list'>목록</a>";
        result += "</body>";
        result += "</html>";
        
        out.println(result);
		out.close();
	}
}





