package sort.insertSort;

import java.util.Arrays;

/**
 * @decription:插入排序--->直接插入算法
 * 1 时间复杂度：O(n^2) O(n)
 * 2 稳定性：稳定
 * 3 辅助空间：O(1) (临时值记录值 和位置指针)
 * 4 比较：冒泡 < 简单选择 < 插入
 * @version:1.0
 * @date: 2016年11月6日下午5:21:38
 * @author: lfq
 * 
 */
public class DirectInsertSort {

	public static void main(String[] args) {
		int[] arr = {6,5,4,3,2,1};
		directInsertSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	//扑克理牌
	public static void directInsertSort(int[] arr)
	{
		if(arr == null || arr.length < 2)
			return;
		int len = arr.length;
        for (int i = 1; i < len; i++) {  
            
        	int currentValue = arr[i]; //从第二个数启作为标杆  
            int position = i; //记住位置
            
            for (int j = i - 1; j >= 0; j--) 
            {  
                if (arr[j] > currentValue) 
                {  
                    arr[j + 1] = arr[j];  
                    position--; //位置向前一步，因为大的元素占了当前位置
                } 
                else 
                {  
                    break;  
                }  
            }  
  
            arr[position] = currentValue; //还原保存的当前值 
        }
	}

}
