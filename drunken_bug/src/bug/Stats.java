package bug;

//��� �̵� �ð��� �̵� Ƚ���� ���ϱ�
public class Stats extends Bug {
	int t_count = v_c.size();	//��ü ���� Ƚ��
	int sum=0;	//Ƚ�� ��
	double avg=0;	//Ƚ�� ���
	
	long sum_t=0;
	double avg_t=0;
	
	{
		for(int i=0;i<t_count;i++) {
			int n=v_c.elementAt(i);
			sum+=n;
		}
		
		avg=(double)sum/t_count;
	}
	
	{
		for(int i=0;i<t_count;i++) {
			long n=v_t.elementAt(i);
			sum_t+=n;
		}
		avg_t=(double)sum_t/t_count;
	}
	
	public double get_avg() {
		return avg;
	}
	
	public void set_avg (double avg) {
		this.avg=avg;
	}
	
	public double get_avg_t() {
		return avg_t;
	}
	
	public void set_avg_t (double avg_t) {
		this.avg_t=avg_t;
	}
}