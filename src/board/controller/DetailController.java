package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardCommentVO;
import board.BoardDAO;
import board.BoardFile;
import member.Member;

@WebServlet("/board/detail")
public class DetailController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DetailController");
		System.out.println("commentNo : " + request.getParameter("commentNo"));
		System.out.println("no : " + request.getParameter("no"));
		System.out.println("int no : " + Integer.parseInt(request.getParameter("no")));
		
		int findNo = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		Board board = dao.selectBoardByNo(findNo);
		
		// 댓글 입력
		if (request.getParameter("inputComment").equals("Y")) {
			System.out.println("inputComment");
			BoardCommentVO comment = new BoardCommentVO();
			comment.setNo(findNo);
			comment.setCommentContent(request.getParameter("commentContent"));
			Member member = new Member();
			comment.setId(request.getParameter("id"));
			dao.insertBoardComment(comment);
		}
		
		// 댓글 리스트 
		List<BoardCommentVO> list = dao.selectBoardComment(findNo);
		request.setAttribute("list", list);
		
		
		// 게시물과 연관된 파일 정보 추출
		BoardFile file = dao.selectBoardFileByNo(findNo);
		
		request.setAttribute("board", board);
		// 파일 정보 공유
		request.setAttribute("file", file);
		
		RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
		rd.forward(request, response);
	}
}











