package bug;

import java.util.Scanner;
import java.util.Vector;

//방이 가득 찼는지 확인
//벌레의 무작위 움직임
//벌레가 방 밖으로 나갔는 경우 처리
public class Bug {
	
	int count;
	int cur_x = 0, cur_y = 0;
	int size;
	
	Vector<Integer>v_c=new Vector<Integer>();
	Vector<Long>v_t=new Vector<Long>();
	
	{
		while(true) 
		{
			System.out.println("판크기 입력 : ");
			
			Scanner scanner=new Scanner(System.in);
			size=scanner.nextInt();
			
			int[][]map=new int[size][size];
			count =0;	//이동횟수
			int map_size=size*size;	//판의 넓이
			
			System.out.println("시작 위치 입력 : (1.가장자리 2.모퉁이 3.가운데)");
			
			int pos=scanner.nextInt();
			
			if(pos==1) 
			{
				cur_x=0;
				cur_y=size/2;
			}
			else if(pos==2) 
			{
				cur_x=0;
				cur_y=0;
			}
			else if(pos==3) 
			{
				cur_x=size/2;
				cur_y=size/2;
			}
			else 
			{
				System.out.println("잘못입력 하였습니다. 다시 입력 해 주십시오.");
				pos=scanner.nextInt();
			}
			
			long start_time=System.currentTimeMillis();
			
			while(true) 
			{
				//방 다 돌았는지 확인
				map[cur_x][cur_y]++;
				if(map[cur_x][cur_y]==1)	//처음 방에 도착하면
				{
					map_size--;
					if(map_size==0)
						break;
				}
				
				while(true) 
				{
					int pre_x=cur_x,pre_y=cur_y;
					
					int random=(int)(Math.random()*8);
					
					switch(random) 
					{
					case 0:
						pre_x--;
						pre_y++;
						break;
					case 1:
						pre_y++;
						break;	
					case 2:
						pre_x++;
						pre_y++;
						break;
					case 3:
						pre_x++;
						break;
					case 4:
						pre_x++;
						pre_y--;
						break;
					case 5:
						pre_y--;
						break;
					case 6:
						pre_x--;
						pre_y--;
						break;
					case 7:
						pre_x--;
						break;
					}
					
					//방 밖으로 나가는지 확인한 후 이동
					if(pre_x>=0&&pre_x<size&&pre_y>=0&&pre_y<size) 
					{
						cur_x=pre_x;
						cur_y=pre_y;
						break;
					}
					count++;
				}
			}
			
			v_c.add(count);
			
			long end_time=System.currentTimeMillis();
			
			long time_gap=end_time-start_time;
			v_t.add(time_gap);
			
			System.out.println("이동 시간 : "+(time_gap));
			System.out.println("이동 횟수: "+count);
			
			for(int i=0;i<size;i++) 
			{
				for(int j=0;j<size;j++) 
				{
					System.out.printf("%3d",map[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("반복하시겠습니까?(1.반복 2.종료)");
			int ans=scanner.nextInt();
			
			if(ans==1) 
			{
				continue;
			}
			else if(ans==2) 
			{
				System.out.println("종료하겠습니다.");
				break;
			}
			else
			{
				System.out.println("잘못입력 하였습니다. 다시 입력 해 주십시오.");
				ans=scanner.nextInt();
			}
		}
	}
	
	public Vector<Integer> get_v_c() {
		return v_c;
	}
	
	public void set_v_c(Vector<Integer> v_c) {
		this.v_c=v_c;
	}
	
	public Vector<Long> get_v_t() {
		return v_t;
	}
	
	public void set_v_t(Vector<Long> v_t) {
		this.v_t=v_t;
	}
}