package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
	
	private String method;
	private String requestUri;
	private Map<String, String> paramMap;
	
	public HttpServletRequest (InputStream in) throws Exception {
		init(in);
	}

	public void init(InputStream in) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		
		// 시작라인 정보 
		String startLine = br.readLine();
		System.out.println("startLine ::: " + startLine);
		if (startLine == null) return;
		
		String [] data = startLine.split(" ");
		method = data[0];

		String [] url = data[1].split("\\?");
		if (url != null) {
			requestUri = url[0];
		}
		System.out.println("method ::: " + method);
		System.out.println("url.length ::: " + url.length);
		
		if (url.length > 1) {
			setParamMap(url[1]);
		}
		
		/* 1번 방법
		int contentLength = 0;
		final String contentHeader = "Content-Length: ";
		*/
	    while (true) {
	    	String line = br.readLine();
	    	if (line.equals("")) break;
	    	/* 1번 방법
            if (line.startsWith(contentHeader)) {
                contentLength = Integer.parseInt(line.substring(contentHeader.length()));
            }
            */
        }
		
		if (method.equals("POST")) {


		    StringBuilder body = new StringBuilder();
	    	int c = 0;
	    	/* 1번 방법
	    	for (int i = 0; i < contentLength; i++) {
	    		c = br.read();
	    		body.append((char) c);
	    	}
	    	*/
	    	while (br.ready()) {
	    		c = br.read();
	    		body.append((char) c);
	    	}
	    	System.out.println("body ::: " + body);
	    	setParamMap(body.toString());
	    }
	}
	
	private void setParamMap(String queryString) {
		paramMap = new HashMap<String, String>();
		String [] params = queryString.split("&");
		for (String val : params) {
			String [] pArr = val.split("=");
			try {
				paramMap.put(pArr[0], URLDecoder.decode(pArr[1], "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getParameter(String key) {
		if (paramMap == null) {
			return null;
		}
		return paramMap.get(key);
	}

	public Map<String, String> getParamMap() { return paramMap; }
	public String getMethod()                { return method; }
	public String getRequestUri()            { return requestUri; }
}