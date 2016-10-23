package array;

import java.util.Arrays;

/**
 * @decription:一个排序的数组插入另外一个排序的数组，并且插入后还是排序的
 * @version:1.0
 * @date: 2016年10月23日下午4:48:03
 * @author: lfq
 * 
 */
public class InsertArray {

	public static void main(String[] args) {
		//测试用例
		/**
		 * 1 a或b为null
		 * 2 b中的元素都比a小或大或相等
		 * 3 b中有元素比a小，大，相等
		 */
		int[] a = {8,12,15};
//		int[] b = {2,3,7};
//		int[] b = {22,23,24};
//		int[] b = {8,12,15};
		int[] b = {4,12,18,19};
//		int[] result = insert(a, null);
		int[] result = insert(a, b);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] insert(int[] a,int[] b){
		if(a == null)
			return null;
		if(a != null && b == null)
			return a;
		int aLen = a.length;
		int bLen = b.length;
		int len = aLen+bLen;//插入之后a的实际大小
		a = Arrays.copyOf(a, len);//确保b插入a后可以存下
		int p1 = aLen-1,p2 = len-1;
		int i = bLen-1;//访问b数组的索引
		while(p1 != p2)//从后往前插入，与替换空格思路一样
		{
			if(p1 > -1 && b[i] <= a[p1])//边界检查很重要，通过测试用例可以发现边界问题，这里要判断p1，否则当p1到0了还去比较（出现在要在a前面插入数的时候），出现错误
			{
				a[p2] = a[p1];
				p2--;
				p1--;
			}
			else
			{
				a[p2] = b[i];
				p2--;
				i--;
			}
				
		}
		return a;
		
	}

}
