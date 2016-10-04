package server;

import java.util.HashMap;
import java.util.Map;

import board.ui.BaseServlet;
import board.ui.DeleteServlet;
import board.ui.DetailServlet;
import board.ui.ListServlet;
import board.ui.UpdateFormServlet;
import board.ui.UpdateServlet;
import board.ui.WriteFormServlet;
import board.ui.WriteServlet;

public class HandlerUrlMapping {
	public static Map<String, BaseServlet> uriMap;
	static {
		uriMap = new HashMap<>();
		uriMap.put("/writeForm", new WriteFormServlet());
		uriMap.put("/write", new WriteServlet());
		uriMap.put("/list", new ListServlet());
		uriMap.put("/detail", new DetailServlet());
		uriMap.put("/delete", new DeleteServlet());
		uriMap.put("/updateForm", new UpdateFormServlet());
		uriMap.put("/update", new UpdateServlet());
	}
	
	public static BaseServlet getServlet(String uri) {
		return uriMap.get(uri);
	}
}
