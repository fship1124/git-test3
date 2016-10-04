package board.ui;

import board.BoardDAO;
import server.HttpServletRequest;

public abstract class BaseServlet {
	protected static BoardDAO dao = new BoardDAO();
	public abstract String execute(HttpServletRequest request) throws Exception;
}