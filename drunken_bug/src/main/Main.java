package main;

import bug.*;

//��� �̵� Ƚ����, ��� �̵� �ð��� ���

public class Main {
	public static void main(String[] args) {
		Stats bug=new Stats();
		
		System.out.println("��� �̵� Ƚ�� : "+bug.get_avg());
		System.out.println("��� �̵� �ð� : "+bug.get_avg_t());
	}
}