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
		int base = 2;
		int exponent = 7;
		int mode = 3;
		System.out.println(mm(base, exponent, mode));

	}
	
	public static int mm(int base,int exponent,int mode)
	{
		int result = 1;
		while(exponent != 0)
		{
			if(exponent % 2 !=0)
			{
				exponent = exponent-1;
				result = (base * result) % mode;
			}
			else
			{
				exponent = exponent/2;
				base = (base * base) % mode;
			}
		}
		return result;
	}

}
