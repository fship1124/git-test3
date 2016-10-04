package board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardFile {
	public static Map<String, Object> fileLoading() 
			throws Exception {
		Map<String, Object> result = null;
		try (
			FileInputStream fis = new FileInputStream("src/data/board.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);	
		) {
			result = new HashMap<>();
			result.put("no", ois.readInt());
			result.put("list", ois.readObject());
			return result;
		} catch (FileNotFoundException fne) {
			result = new HashMap<>();
			result.put("no", 0);
			result.put("list", new ArrayList<>());
			return result;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void saveFile(int no, ArrayList<Board> list) throws Exception {
		try (
				FileOutputStream fos = new FileOutputStream("src/data/board.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);	
		) {
				oos.writeInt(no);
				oos.writeObject(list);
		} catch (Exception e) {
			throw e;
		}
	}
}




