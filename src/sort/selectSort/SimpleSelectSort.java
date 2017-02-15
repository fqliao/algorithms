package sort.selectSort;

import java.util.Arrays;

import sort.SortUtil;

/**
 * @decription:选择排序--->简单选择排序算法(选最值比较交换) 
 * 1 时间复杂度：O(n^2) O(n^2)(数组之前是否有序这个规律不起作用，选择直接按最值来选，只注重最值规律，忽略了顺序规律)
 * 2 稳定性：不稳定(挑选最值的过程中可能变化相同元素之前的位置 比如 1 3 3 2 )
 * 3 辅助空间：O(1) (交换时使用了一个临时变量，若是数值交换，则可以也不用临时变量)
 * 4 比较：虽然复杂度与冒泡排序算法一样，但是性能还是优于冒泡排序，因为只是数量级一样，但是具体次数简单选择法要少
 * @version:1.0
 * @date: 2016年11月6日下午5:04:28
 * @author: lfq
 * 
 */
public class SimpleSelectSort {

	public static void main(String[] args) throws Exception {
		int[] arr = {1,3,2,4,6,5};
		simpleSelectSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	//高级点炒股
	public static void simpleSelectSort(int[] arr) throws Exception
	{
		if(arr == null || arr.length < 2)
			return;
		int len = arr.length;
		for (int i = 0; i < len; i++) 
		{
			int min = i;
			for (int j = i+1; j < len; j++) 
			{
				if(arr[min] > arr[j])//经过大量观测，找到最小值
					min = j;
			}
			if(min != i)//关键一击
				SortUtil.swap(arr, min, i);
		}
	}

}
