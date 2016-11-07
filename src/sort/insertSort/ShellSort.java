package sort.insertSort;

import java.util.Arrays;

/**
 * @decription:插入排序--->希尔排序(直接插入排序的升级版)
 * 1 时间复杂度：O(n^3/2) O(n)
 * 2 稳定性：不稳定（多次分组插入）
 * 3 辅助空间：O(1) (临时值记录值 和位置指针)
 * 4 比较：冒泡 < 简单选择 < 插入 < 希尔
 * @version:1.0
 * @date: 2016年11月7日下午4:18:46
 * @author: lfq
 * 
 */
public class ShellSort {

	public static void main(String[] args) {
//		int[] nums = {4,5,3,2,1};
		int[] nums = {1,2,3,4,5};
		shellSort(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void shellSort(int[] arr)
	{
		if(arr == null || arr.length < 2)
			return;
		int len = arr.length;
		int k = len;//增量初始化
		do 
		{
			k = k/3 + 1;//增量序列的生成算法 4 2 1 序列元素个数数即分组的次数 元素的值是间隔比较的距离
			for (int i = k ; i < len; i++) 
			{
				if(arr[i] < arr[i-k])//需要交换，后面的比前面小
				{
					int currentValue = arr[i];
					int j = i - k;
					for (; j >= 0 && currentValue < arr[j]; j -= k) 
					{
						arr[j+k] = arr[j];
					}
					arr[j+k] = currentValue;//+k是由于最后一次退出for循环时-k了，因此+k，补全到j的位置
				}
			}
		} while (k > 1);
	}
}
