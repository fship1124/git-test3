package server;

import java.net.ServerSocket;

public class WebServer {

	// 서버 구동
	public void startServer() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(8800); 
			while (true) {
				// 요청 처리 진행
				new WebClient( server.accept() ).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
}
