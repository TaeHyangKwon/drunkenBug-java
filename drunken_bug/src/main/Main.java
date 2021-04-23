package main;

import bug.*;

//평균 이동 횟수와, 평균 이동 시간을 출력

public class Main {
	public static void main(String[] args) {
		Stats bug=new Stats();
		
		System.out.println("평균 이동 횟수 : "+bug.get_avg());
		System.out.println("평균 이동 시간 : "+bug.get_avg_t());
	}
}