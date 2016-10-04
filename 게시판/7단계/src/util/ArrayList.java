package util;

public class ArrayList {
	private int pos = 0;
	private Object[] elements;
	public ArrayList() {
		elements = new Object[2];
	}
	public void add(Object data) {
		if (pos == elements.length) {
			Object[] temp = new Object[pos * 2];
			System.arraycopy(
					elements, 0, temp, 0, pos);
			elements = temp;
		}
		elements[pos++] = data;
	}
	
	public void remove(int index) {
		int moveCount = pos - index -1;
		if (moveCount > 0) {
			System.arraycopy(
				elements, index + 1, elements, index, moveCount);
		}
		elements[--pos] = null;
	}
	
	public Object get(int index) {
		return elements[index];
	}
	
	public int size() {
		return pos;
	}
	
	public String toString() {
		if (pos == 0) return "[]";
		if (pos == 1) return "[" + elements[0] + "]";
		
		String result = "[";
		for (int i = 0; i < pos - 1; i++) {
			result += elements[i] + ",";
		}
		result += elements[pos - 1] + "]";
		return result;
	}
}









