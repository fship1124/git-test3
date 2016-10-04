package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;

@WebServlet("/board/deleteComment")
public class DeleteCommentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		dao.deleteComment(Integer.parseInt(req.getParameter("commentNo")));
		
		resp.sendRedirect("detail?no=" + Integer.parseInt(req.getParameter("no"))
				+ "&inputComment=N");
	}
}
