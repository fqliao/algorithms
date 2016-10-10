package array;

/**
 * 数组去重
 * 双指针操作
 * @author lfq
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = {1,1};
		System.out.println(removeDuplicates(nums));
	}
	

    public static int removeDuplicates(int[] nums) {
    	//特殊情况判断，数组是否为null和空数组，是就返回0
    	if(nums == null || nums.length == 0)
    	{
    		return 0;
    	}
    	
    	//用两个指针i,j变量数组,n统计重复个数，k跟踪依次设置不重复的元素
        int i = 0,j = 1,n = 0,k = 0;
        while(i < nums.length && j < nums.length)
        {	//遍历重复元素
            while(j < nums.length && nums[i] == nums[j])
            {
                j++;
            }
            n += j-i-1;
            i = j;
            //将不重复的元素依次设置
            if(i < nums.length)
            {
            	nums[++k] = nums[i];
            }
            j++;
        }
        //返回不重复元素的个数=总个数-重复个数
        return nums.length-n;
    }

}
