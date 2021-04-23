package bug;

import java.util.Scanner;
import java.util.Vector;

//���� ���� á���� Ȯ��
//������ ������ ������
//������ �� ������ ������ ��� ó��
public class Bug {
	
	int count;
	int cur_x = 0, cur_y = 0;
	int size;
	
	Vector<Integer>v_c=new Vector<Integer>();
	Vector<Long>v_t=new Vector<Long>();
	
	{
		while(true) 
		{
			System.out.println("��ũ�� �Է� : ");
			
			Scanner scanner=new Scanner(System.in);
			size=scanner.nextInt();
			
			int[][]map=new int[size][size];
			count =0;	//�̵�Ƚ��
			int map_size=size*size;	//���� ����
			
			System.out.println("���� ��ġ �Է� : (1.�����ڸ� 2.������ 3.���)");
			
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
				System.out.println("�߸��Է� �Ͽ����ϴ�. �ٽ� �Է� �� �ֽʽÿ�.");
				pos=scanner.nextInt();
			}
			
			long start_time=System.currentTimeMillis();
			
			while(true) 
			{
				//�� �� ���Ҵ��� Ȯ��
				map[cur_x][cur_y]++;
				if(map[cur_x][cur_y]==1)	//ó�� �濡 �����ϸ�
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
					
					//�� ������ �������� Ȯ���� �� �̵�
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
			
			System.out.println("�̵� �ð� : "+(time_gap));
			System.out.println("�̵� Ƚ��: "+count);
			
			for(int i=0;i<size;i++) 
			{
				for(int j=0;j<size;j++) 
				{
					System.out.printf("%3d",map[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("�ݺ��Ͻðڽ��ϱ�?(1.�ݺ� 2.����)");
			int ans=scanner.nextInt();
			
			if(ans==1) 
			{
				continue;
			}
			else if(ans==2) 
			{
				System.out.println("�����ϰڽ��ϴ�.");
				break;
			}
			else
			{
				System.out.println("�߸��Է� �Ͽ����ϴ�. �ٽ� �Է� �� �ֽʽÿ�.");
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