package board.ui;

import server.HttpServletRequest;

public class WriteFormServlet extends BaseServlet {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
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
        result += "	 <form method='post' action='write'>";
        result += "	    제목 : <input type='text' name='title' size='70' /><br>";
        result += "	    글쓴이 : <input type='text' name='writer' size='30' /><br>";
        result += "	    내용 : <textarea name='content' rows='7' cols='70'></textarea><br>";
        result += "	   <button type='submit'>등록</button>";
        result += "	 </form>";
        result += "</body>";
        result += "</html>";
		return result;
	}
}