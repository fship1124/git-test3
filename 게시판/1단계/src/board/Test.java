package board;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		outer : 
		while (true) {
			System.out.println("------------------------------------");
			System.out.println("1. ��ü �Խù� ��ȸ");
			System.out.println("2. �۹�ȣ ��ȸ");
			System.out.println("3. �۵��");
			System.out.println("4. �ۼ���");
			System.out.println("5. �ۻ���");
			System.out.println("0. ����");
			System.out.println("------------------------------------");
			System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				System.out.println("��ü �Խñ� ��ȸ �޴� ������");
				break;
			case 2:
				System.out.print("��ȸ�� �۹�ȣ�� �Է��ϼ��� : ");
				sc.nextLine();
				System.out.println("�۹�ȣ ��ȸ �޴� ������");
				break;
			case 3:
				System.out.print("������ �Է��ϼ��� : ");
				sc.nextLine();
				System.out.print("�۾��̸� �Է��ϼ��� : ");
				sc.nextLine();
				System.out.println("�۵�� �޴� ������");
				break;
			case 4:
				System.out.print("������ �۹�ȣ�� �Է��ϼ��� : ");
				sc.nextLine();
				System.out.print("������ ������ �Է��ϼ��� : ");
				sc.nextLine();
				System.out.println("�ۼ��� �޴� ������");
				break;
			case 5:
				System.out.print("������ �۹�ȣ�� �Է��ϼ��� : ");
				sc.nextLine();
				System.out.println("�ۻ��� �޴� ������");
				break;
			case 0:
				System.out.println("�Խ��� ���α׷��� �����մϴ�");
				break outer;
			}
		}
	}
}
/*
------------------------------------
�޴� �� ó���� �׸��� �����ϼ��� : 0
�Խ��� ���α׷��� �����մϴ�
*/








