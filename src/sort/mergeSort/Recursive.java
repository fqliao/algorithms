package sort.mergeSort;

import java.util.Arrays;

/**
 * @decription:归并排序，递归方式
 * 1 时间复杂度：O(nlogn) O(nlogn)
 * 2 稳定性：稳定
 * 3 辅助空间：O(n+logn)
 * 4 比较：冒泡 < 简单选择 < 插入 < 希尔 < 堆排序 < 归并排序
 * @version:1.0
 * @date: 2016年11月8日上午10:23:45
 * @author: lfq
 * 
 */
public class Recursive {

	public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
        
        sort(nums, 0, nums.length-1);  
        System.out.println(Arrays.toString(nums)); 

	}
	
    private static void sort(int[] nums, int low, int high) {
    	if(nums == null || nums.length < 2)
    		return;
        
    	int mid = (low + high) / 2;//设置中间值，进行分割  
        
        if (low < high) {  
            // 左边递归排序 
            sort(nums, low, mid);  
            // 右边递归排序
            sort(nums, mid + 1, high);  
            // 左右归并  
            merge(nums, low, mid, high);  
        }
    } 
    
    public static void merge(int[] nums, int low, int mid, int high) {  
    	
    	int[] temp = new int[high - low + 1];  // 保存排好序的临时数组
        int i = low;// 左指针  
        int j = mid + 1;// 右指针  
        int k = 0;  //合并后数组的指针
  
        // 把较小的数先移到新数组中  
        while (i <= mid && j <= high) 
        {  
            if (nums[i] < nums[j]) 
                temp[k++] = nums[i++];  
            else 
                temp[k++] = nums[j++];  
        }  
  
        // 把左边剩余的数移入数组  
        while (i <= mid)
            temp[k++] = nums[i++];  
  
        // 把右边边剩余的数移入数组  
        while (j <= high) 
            temp[k++] = nums[j++];  
  
        // 把新数组中的数覆盖nums数组  
        for (int k2 = 0; k2 < temp.length; k2++) 
            nums[k2 + low] = temp[k2];  
    }  

}
