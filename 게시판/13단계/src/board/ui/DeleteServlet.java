package board.ui;

import server.HttpServletRequest;

public class DeleteServlet extends BaseServlet {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		dao.deleteBoard(no);

		String result = "";
		result += "<!DOCTYPE html>";
        result += "<html>";
        result += "<head>";
        result += "  <meta charset='utf-8'>";
        result += "</head>";
        result += "<body>";
        result += "	 <h2>게시글이 삭제되었습니다.</h2>";
        result += "	 <a href='list'>목록</a>";
        result += "</body>";
        result += "</html>";
		return result;
	}
}