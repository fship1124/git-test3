package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardCommentVO;
import board.BoardDAO;

@WebServlet("/board/updateComment")
public class UpdateCommentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UpdateCommentController");
		BoardDAO dao = new BoardDAO();
		BoardCommentVO comment = new BoardCommentVO();
		
		comment.setCommentNo(Integer.parseInt(req.getParameter("commentNo")));
		comment.setCommentContent(req.getParameter("updateContent"));
		dao.updateBoardComment(comment);
		
		resp.sendRedirect("detail?no=" + req.getParameter("no") + "&inputComment=N");
	}
}
