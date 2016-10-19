package array;

/**
 * @decription:快速模乘算法
 * @version:1.0
 * @date: 2016年10月19日上午9:56:42
 * @author: lfq
 * 
 */
public class MM {

	public static void main(String[] args) {
		int x = 2;
		int e = 1000;
		int m = 89;
		System.out.println(mm(x, e, m));

	}
	
	public static int mm(int x,int e,int m)
	{
		int y = 1;
		while(e != 0)
		{
			if(e % 2 !=0)
			{
				e = e-1;
				y = x*y % m;
			}
			else
			{
				e = e/2;
				x = x*x % m;
			}
		}
		return y;
	}

}
