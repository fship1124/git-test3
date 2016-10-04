package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import board.ui.BaseServlet;

public class WebClient {
	
	private Socket client;
	
	public WebClient(Socket client) {
		this.client = client;
	}
	
	/**
	 * 클라이언트 처리 진행
	 * @throws Exception
	 */
	public void start() {
		try {
			System.out.println("접속한 클라이언트 정보");
			System.out.println(client);
			
			
			// 클라이언트에서 보내온 메시지를 읽어올 입력 객체 생성
			InputStream in = client.getInputStream();
		    
			// 사용자 요청 정보 파싱하기
			HttpServletRequest request = new HttpServletRequest(in);
			
			// 클라이언트 요청 페이지 얻기
			String requestUri = request.getRequestUri();
			if (requestUri == null) return;
			
			// 클라이언트 요청 view 얻기
			BaseServlet servlet = HandlerUrlMapping.getServlet(requestUri);
	
			// 클라이언트의 메시지를 재전송
			String msg = servlet.execute(request);
			String sendData = "HTTP/1.1 200 OK\r\n"
					+ "Cache-Control: no-cache\r\n"
					+ "Content-Length: " + msg.getBytes().length + "\r\n"
					+ "Content-Type: text/html; charset=UTF-8\r\n\r\n"
					+ msg;

			// 클라이언트로 출력
			OutputStream os = client.getOutputStream();
			os.write(sendData.getBytes());
			os.flush();
		} catch (Exception e) {
			System.out.println("클라이언트 처리 오류 발생");
			e.printStackTrace();
		}
	}
}
