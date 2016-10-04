package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static final int INIT_COUNT = 3;
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			for (int i = 1; i <= INIT_COUNT; i++) {
				free.add(DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE", 
						"hr", "hr"));
			}
			System.out.println("연결 객체 풀에 등록 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		if (free.isEmpty()) {
			throw new Exception("풀이 비어있습니다.");
		}
		Connection con = free.remove(0);
		used.add(con);
		
		// 임시 확인 
//		System.out.println("free : " + free.size());
//		System.out.println("used : " + used.size());
		
		return con;
	}
	
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
	
	public static void main(String[] args) {
		try {
			for (int i = 1; i <= 4; i++) {
				Thread.sleep(2000);
				Connection con = ConnectionPool.getConnection();
				ConnectionPool.releaseConnection(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










