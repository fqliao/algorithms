package sort.selectSort;

import java.util.Arrays;
import sort.SortUtil;

/**
 * @decription:选择排序--->堆排序
 * 1 时间复杂度：O(nlogn) O(nlogn)
 * 2 稳定性：不稳定
 * 3 辅助空间：O(1)
 * 4 比较：冒泡 < 简单选择 < 插入 < 希尔 < 堆排序
 * @version:1.0
 * @date: 2016年11月7日下午8:51:08
 * @author: lfq
 * 
 */
public class HeapSort {

	public static void main(String[] args) throws Exception {
		int[] nums = {4,5,3,2,1};
//		int[] nums = {1,2,3,4,5};
		headSort(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void headSort(int[] nums) throws Exception
	{
        if (nums == null || nums.length <= 1) {  
            return;  
        }  
        buildMaxHeap(nums);  
        for (int i = nums.length - 1; i >= 1; i--) {  
            SortUtil.swap(nums, 0, i);  

            maxHeap(nums, i, 0);  
        }
	}

	private static void maxHeap(int[] nums, int heapSize, int index) throws Exception 
	{
        int left = index * 2 + 1;  
        int right = index * 2 + 2;  

        int largest = index;  
        if (left < heapSize && nums[left] > nums[index]) {  
            largest = left;  
        }  

        if (right < heapSize && nums[right] > nums[largest]) {  
            largest = right;  
        }  

        if (index != largest) {  
            SortUtil.swap(nums, index, largest);  

            maxHeap(nums, heapSize, largest);  
        } 
		
	}

	private static void buildMaxHeap(int[] nums) throws Exception 
	{
        if (nums == null || nums.length <= 1) {  
            return;  
        }  

        int half = nums.length / 2;  
        for (int i = half; i >= 0; i--) {  
            maxHeap(nums, nums.length, i);  
        } 
		
	}

}
