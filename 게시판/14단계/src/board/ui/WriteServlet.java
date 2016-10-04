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

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		System.out.println(board);
		
		// 게시물 저장 처리 부탁..
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(board);
		
		String result = "";
		result += "<!DOCTYPE html>";
        result += "<html>";
        result += "<head>";
        result += "  <meta charset='utf-8'>";
        result += "  <meta http-equiv='refresh' content='1; url=/LecBoard/list'>";
        result += "</head>";
        result += "<body>";
        result += "	 <h2>게시글 등록이 완료되었습니다.</h2>";
        result += "	 <a href='list'>목록</a>";
        result += "</body>";
        result += "</html>";
        out.println(result);
		out.close();
	}
}

