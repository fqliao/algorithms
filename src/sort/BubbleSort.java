package sort;

import java.util.Arrays;

/**
 * @decription:交换排序--->冒泡排序算法(相邻元素比较交换)
 * 1 时间复杂度：O(n^2) O(n)(出现在数组已经排序好了)
 * 2 稳定性：稳定
 * 3 辅助空间：O(1) (交换时使用了一个临时变量，若是数值交换，则可以也不用临时变量)
 * @version:1.0
 * @date: 2016年11月6日下午4:17:51
 * @author: lfq
 * 
 */
public class BubbleSort {

	public static void main(String[] args) throws Exception {
		int[] arr = {1,3,2,4,6,5};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void bubbleSort(int[] arr) throws Exception
	{
		if(arr == null || arr.length == 0 || arr.length == 1)
			return;
		int len = arr.length;
		boolean flag = false;//true表示排序完，false表示未排序完
		for (int i = 0; i < len-1 && !flag; i++) 
		{
			flag = true;//每次排序前加将标志位赋值为true
			for (int j = 0; j < len-i-1; j++) 
			{	
				if(arr[j] > arr[j+1])
				{
					flag = false;
					SortUtil.swap(arr, j, j+1);
				}
			}
		}
	}

}
