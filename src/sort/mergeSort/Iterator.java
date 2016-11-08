package sort.mergeSort;

import java.util.Arrays;

/**
 * @decription:归并排序 迭代方式
 * 1 时间复杂度：O(nlogn) O(nlogn)
 * 2 稳定性：稳定
 * 3 辅助空间：O(n)
 * 4 比较：冒泡 < 简单选择 < 插入 < 希尔 < 堆排序 < 归并排序
 * @version:1.0
 * @date: 2016年11月8日上午11:17:01
 * @author: lfq
 * 
 */
public class Iterator {

	public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
        sort(nums);  
        System.out.println(Arrays.toString(nums)); 

	}
	
    public static void sort(int[] nums)
    {
        if(nums == null || nums.length < 2)
        	return;
        int len = nums.length;
        int k = 1;
        while(k < len)
        {
            mergePass(nums, k, len);
            k *= 2;            
        }
    }

    //mergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
    private static void mergePass(int[] nums, int k, int n)
    {
        int i = 0;
        //排序子序列并合并
        while(i < n - 2*k + 1)
        {
            merge(nums, i, i + k-1, i + 2*k - 1);
            i += 2*k;
        }
        //将“落单的”长度不足两两merge的部分和前面merge起来。
        if(i < n - k )
        {
            merge(nums, i, i+k-1, n-1);
        }

    }

    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] nums, int low, int mid, int high)
    {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid+1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for(; i <= mid && j <= high; k++)
        {
            if(nums[i] < nums[j])
                temp[k] = nums[i++];
            else
                temp[k] = nums[j++];
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while(i <= mid)
            temp[k++] = nums[i++];

        while(j <= high)
            temp[k++] = nums[j++];

        //将temp数组中的元素写入到待排数组中
        for(int k2 = 0; k2 < temp.length; k2++)
            nums[k2+low] = temp[k2];
    }
}
