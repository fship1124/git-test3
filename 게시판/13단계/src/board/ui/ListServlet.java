package board.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import board.Board;
import server.HttpServletRequest;

public class ListServlet extends BaseServlet {
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		String html = "";
		
		List<Board> list = dao.selectBoard();
		
		html += "<!DOCTYPE html>";
		html += "<html>";
		html += "<head>";
		html += "  <meta charset='utf-8'>";
		html += "  <title>네트워크 게시판</title>";
		html += "</head>";
		html += "<body>";
		html += "  <h2>네트워크 게시판</h2>";
		html += String.format("전체 %d개<br>", list.size());
		html += "  <hr>";
		html += "  <table width='80%' border='1'>";
		html += "  <tr>";
		html += "    <th>번호</th>";
		html += "    <th>글쓴이</th>";
		html += "    <th>제목</th>";
		html += "    <th>등록일</th>";
		html += "  </tr>";
        
		// 등록일 처리 부분 
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				
		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			html += "<tr>";
			html += "  <td>" + b.getNo() + "</td>";
			html += "  <td>" + b.getWriter() + "</td>";
			html += "  <td><a href='detail?no=" + b.getNo() + "'>" + b.getTitle() + "</a></td>";
			html += "  <td>" + sdf.format(b.getRegDate()) + "</td>";
			html += "</tr>";
		}
		if (list.size() == 0) {
			html += "  <tr>";
			html += "    <td colspan='4'>게시물이 존재하지 않습니다.</td>";
			html += "  </tr>";
		}
		html += "	 </table>";
		html += "	 <a href='writeForm'>글쓰기</a>";
		html += "</body>";
		html += "</html>";
		return html;
	}
}