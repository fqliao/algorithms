package offer;

/**
 * @decription: 判断是否为2的幂，两数有几位二进制位不同
 * @version:1.0
 * @date: 2016年11月29日下午9:56:56
 * @author: lfq
 * 
 */
public class _10Extend {

	public static void main(String[] args) {
		
		System.out.println(isPowOfTwo(8));
		System.out.println(isPowOfTwo(2));
		System.out.println(isPowOfTwo(1));
		System.out.println(isPowOfTwo(3));
		
		System.out.println(isPowOfTwo(0));
		System.out.println(isPowOfTwo(-4));
		
		System.out.println(isPowOfTwo(256));
		System.out.println(isPowOfTwo(-1024));
		
		System.out.println(transter(10, 13));
		
		System.out.println(transter(10, 10));
		
		System.out.println(transter(13, 10));
		
		System.out.println(transter(11, 14));
	}
	
	//判断一个数是否是2的整数次幂
	public static boolean isPowOfTwo(int n)
	{
		if(n < 0)//负数变正数
			n = -n;
		
		if( ((n-1) & n) == 0)//减1 再&本身 就是将二进制数最右边的1变为0,2的幂只有一个1
			return true;
		else
			return false;
	}
	
	//输入两个数m,n,需要改变m的多少位可以变到n
	public static int transter(int m, int n)
	{
		int k = m ^ n;//m异或n得到的数的二进制1的个数就是m和n不同的位数，数1就行
		int count = 0;
		while(k != 0)//数k中1的个数
		{
			k = (k - 1) & k;
			count++;
		}
		return count;
	}
}
