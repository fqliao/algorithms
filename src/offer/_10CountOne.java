package offer;

/**
 * @decription:统计数值二进制表示时1的个数
 * @version:1.0 
 * @date: 2016年11月29日下午9:18:04
 * @author: lfq
 * 
 */
public class _10CountOne {

	public static void main(String[] args)
	{
		//测试
		System.out.println(count1(5));
		System.out.println(count1(7));
		System.out.println(count1(0));
		System.out.println(count1(-5));
		System.out.println(count1(-1));
		System.out.println(count1(1200));
		
		System.out.println(count2(5));
		System.out.println(count2(7));
		System.out.println(count2(0));
		System.out.println(count2(-5));
		System.out.println(count2(-1));
		System.out.println(count2(1200));

	}
	
	//经典解法
	public static int count1(int n)
	{	
		int count = 0;
		int flag = 1;//作为& n的值，不断左移与
		while(flag != 0)//循环int位 即32位
		{
			if((n & flag) != 0)
				count++;
			flag = flag << 1;
		}
		return count;
	}
	
	//惊喜解法
	public static int count2(int n)
	{
		int count = 0;
		while(n != 0)//有几个1 循环几次
		{
			n = (n - 1) & n;
			count++;
		}
		return count;
	}

}
