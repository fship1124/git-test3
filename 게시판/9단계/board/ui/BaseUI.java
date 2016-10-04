package board.ui;

import java.util.Scanner;

import board.BoardDAO;

public abstract class BaseUI {
	protected Scanner sc = new Scanner(System.in);
	protected static BoardDAO dao = new BoardDAO();
	public abstract void execute() throws Exception;
	
}



