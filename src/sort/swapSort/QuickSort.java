package sort.swapSort;

import java.util.Arrays;


import sort.insertSort.DirectInsertSort;

/**
 * @decription:交换排序--->快速排序
 * 1 时间复杂度：O(nlogn) O(n^2)
 * 2 稳定性：不稳定
 * 3 辅助空间：O(n)
 * 4 比较：冒泡 < 简单选择 < 插入 < 希尔 < 堆排序 < 归并排序 < 快速排序
 * @version:
 * @date: 2016年11月9日上午10:20:21
 * @author: lfq
 * 
 */
public class QuickSort {

	private static final int MAX_LENGTH_INSERT_SORT = 7;

	public static void main(String[] args) throws Exception {
		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
        sort(nums,0,nums.length-1);  
        System.out.println(Arrays.toString(nums)); 

	}
	
	public static void sort(int[] nums,int low,int high) throws Exception
	{
		if(nums == null || nums.length < 2)
			return;
		if(high - low < MAX_LENGTH_INSERT_SORT)//小数组交给直接插入排序
			DirectInsertSort.directInsertSort(nums);
		else//大数组交给快速排序
		{
			int pivot;
			while(low < high)//利用尾递归优化
			{
				pivot = Partition(nums,low,high);
				sort(nums,low,pivot-1);
//				sort(nums,pivot+1,high);
				low = pivot + 1;
			}
		}
	}

	/**交子序列的位置，返回枢轴位置
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 * @throws Exception
	 */
	private static int Partition(int[] nums, int low, int high) throws Exception 
	{
		int pivotKey;
		
		//3数选中
//		int mid = low + (high-low)/2;//计算数组中间的元素的下标
//		if(nums[low] > nums[high])
//			SortUtil.swap(nums, low, high);
//		if(nums[mid] > nums[high])
//			SortUtil.swap(nums, mid, high);
//		if(nums[mid] > nums[low])
//			SortUtil.swap(nums, low, mid);
		
		pivotKey = nums[low];
		int currentValue = pivotKey;//将枢轴关键字备份到currentValue
		while(low < high)
		{
			while(low < high && nums[high] >= pivotKey)
				high--;
//			SortUtil.swap(nums,low,high);//比枢轴记录小的记录交换到低端
			nums[low] = nums[high];//采用替换，而不是交换,这样减少了多次交换数据操作，提高性能
			while(low < high && nums[low] <= pivotKey)
				low++;
//			SortUtil.swap(nums, low, high);//比枢轴记录大的记录交换到低端
			nums[high] = nums[low];
		}
		nums[low] = currentValue;
		return low;
	}

}
