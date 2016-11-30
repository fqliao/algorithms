package offer;

import java.math.BigInteger;

/**
 * @decription:打印1到n位数
 * @version:1.0
 * @date: 2016年11月30日下午9:18:32
 * @author: lfq
 * 
 */
public class _12Print1ToMaxOfNDigits {

	public static void main(String[] args) {
//		printNumber1(2);
		printNumber2(3);
	}
	
	//用Java中的BigInteger解决
	public static void printNumber1(int n)
	{
		if(n <= 0)
			return;
		BigInteger number = BigInteger.ONE;
		BigInteger i = BigInteger.ZERO;
		BigInteger N = BigInteger.valueOf(n);
		while(i.compareTo(N) == -1)
		{
			number = number.multiply(BigInteger.TEN);
			i = i.add(BigInteger.ONE);
		}
		i = BigInteger.ONE;
		for(; i.compareTo(number) == -1; i = i.add(BigInteger.ONE))
			System.out.println(i);
	}
	
	//利用数组解决
	public static void printNumber2(int n)
	{
		if(n <= 0)
			return;
		int[] number = new int[n];
		for(int i = 0; i < 10; i++)
		{
			number[0] = i;
			printRecursively(number, n, 0);
		}
	}

	private static void printRecursively(int[] number, int length, int index)
	{
		if(index == length -1)
		{
			print(number);
			return;
		}
		
		for(int i = 0; i < 10; i++)
		{
			number[index + 1] = i;
			printRecursively(number, length, index + 1);
		}
		
	}

	private static void print(int[] number) 
	{
		boolean isBegin0 = true, printSpace = false;
		int length = number.length;
		
		for(int i = 0; i < length; i++)
		{
			if(isBegin0 && number[i] != 0)
				isBegin0 = false;
			if(!isBegin0)
			{
				printSpace = true;
				System.out.print(number[i]);
			}
		}
		if(printSpace)
			System.out.println(" ");
		
	}

}
