package offer;

/**
 * @decription:重复计算--->递归与循环 fabonacci数列的应用
 * @version:1.0
 * @date: 2016年11月28日下午8:59:10
 * @author: lfq
 * 
 */
public class _9Fabonacci {

	public static void main(String[] args) throws Exception {

		System.out.println(add1(1, 50));
		System.out.println(add2(1, 50));
//		System.out.println(fibonacci1(100));
		System.out.println(fibonacci2(100));
		System.out.println(jump1(99));
		System.out.println(jump2(5));
	}
	
	//循环
	public static int add1(int i, int n) 
	{
		int sum = 0;
		for (int j = i; j <= n; j++)
		{
			sum += j;
		}
		return sum;
	}
	
	//递归
	public static int add2(int i, int n)//加5000 栈溢出，运算不出结果
	{
		if(n <= i)
			return i;
		else
			return n + add2(i, n-1);
	}
	
	//递归实现斐波那契数列
	public static long fibonacci1(int n)//递归实现斐波那契数列效率很低！不实用
	{
		if(n == 0 || n == 1)
			return n;
		else
			return fibonacci1(n-1) + fibonacci2(n-2);
	}
	
	//循环实现斐波那契数列  实用
	public static long fibonacci2(int n)
	{
		if(n == 0 || n == 1)
			return n;
		long first = 0, second = 1, finN = 0;
		for (int i = 2; i <= n; i++) 
		{
			finN = first + second;
			first = second;//记下第一个值
			second = finN;//记下第二个值
		}
		return finN;
	}
	
	//青蛙跳台阶 一步可跳一阶或二阶，求跳上n阶有多少种跳法，斐波那契数列变形了点点
	public static long jump1(int n)
	{
		if(n < 1)
			return 0;
		if(n == 1 || n == 2)
			return n;
		long first = 1, second = 2, result = 0;
		for (int i = 3; i <= n; i++)
		{
			result = first + second;
			first = second;
			second = result;
		}
		return result;
		
	}
	
	//青蛙跳台阶扩展版，一步可以跳1阶，2阶，...n阶，那么跳n阶有2^(n-1)种
	public static long jump2(int n)
	{
		
		return pow(2,n-1);
//		long result = 1;
//		for (int i = 1; i <= n - 1; i++) 
//		{
//			result *= 2;
//		}
//		return result;
	}
	
	private static long pow(int x, int n) {
		if(x == 0 || x == 1 || n == 1)
			return x;
		if(n < 0)
			return 0;
		return n % 2 == 0 ? pow(x*x, n/2) : x * pow(x*x, n/2);
	}

}
