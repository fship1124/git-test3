package board.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(no);

		String result = "";
		result += "<!DOCTYPE html>";
        result += "<html>";
        result += "<head>";
        result += "  <meta charset='utf-8'>";
        result += "  <meta http-equiv='refresh' content='1; url=/LecBoard/list'>";        
        result += "</head>";
        result += "<body>";
        result += "	 <h2>게시글이 삭제되었습니다.</h2>";
        result += "	 <a href='list'>목록</a>";
        result += "</body>";
        result += "</html>";
        
        out.println(result);
        out.close();
	}
}