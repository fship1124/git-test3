package util;

import board.exception.BoardException;

// ArrayList<String> list = new ArrayList<>();
public class ArrayList<E> {
	private int pos = 0;
	private Object[] elements;
	public ArrayList() {
		elements = new Object[2];
	}
	public void add(E data) {
		if (pos == elements.length) {
			Object[] temp = new Object[pos * 2];
			System.arraycopy(
					elements, 0, temp, 0, pos);
			elements = temp;
		}
		elements[pos++] = data;
	}
	
	public void remove(int index) throws BoardException {
		if (index < 0 || index >= pos) {
			throw new BoardException(
					"잘못된 인덱스(" + index + ") 입니다.");
		}
		int moveCount = pos - index -1;
		if (moveCount > 0) {
			System.arraycopy(
				elements, index + 1, elements, index, moveCount);
		}
		elements[--pos] = null;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) throws BoardException {
		if (index < 0 || index >= pos) {
			throw new BoardException(
					"잘못된 인덱스(" + index + ") 입니다.");
		}
		return (E)elements[index];
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









