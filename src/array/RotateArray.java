package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @decription:数组旋转
 * 3种方式实现：
 * 1 最直接的两段复制：利用System.arraycopy方法,clone方法
 * 2 利用列表集合的旋转方法：Collections.rotate(list,k)
 * 3 经典三步倒序（与旋转不一样，旋转不到倒序，但倒序可用组合到旋转）法：
 * 三次倒序，倒序实现：头尾两两交换

 * ***注意：优先处理特殊情况，好处主要有两点
 * 1）一些特殊情况通用算法不适应，要单独处理，否则存在bug
 * 2）特殊情况的特殊处理非常快速，不用进入通用算法，优化性能
 * 特殊请求一般是值为0,1，null,对象为null等
 * @version:
 * @date: 2016年10月15日下午4:37:33
 * @author: lfq
 * 
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6,7};
		int[] nums2 = {1,2,3,4,5,6,7};
		int[] nums3 = {1,2,3,4,5,6,7};
		int k = 3;
		//测试三种方式
		rotate1(nums1, k);
		rotate2(nums2, k);
		rotate3(nums3, k);
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(Arrays.toString(nums3));
	}
	
	//直接两段复制，这种方式实现不了完全倒序
    public static void rotate1(int[] nums, int k) {
    	if(nums == null) return;
    	int len = nums.length;
        if(len < 2 || k ==1) return;
        k = k % len;
        int d = len - k;
        int[] numBak = nums.clone();
        //先复制后面移动的元素
        System.arraycopy(numBak,d,nums,0,k);
        System.arraycopy(numBak,0,nums,k,d);

    }
	
    //利用集合旋转方法，但是要先从数组转集合，旋转后从集合再转回数组，两次转回开销大
    public static void rotate2(int[] nums, int k) {
    	if(nums == null) return;
    	int len = nums.length;
        if(len < 2 || k ==1) return;
        k = k % len;
        List<Integer> list = new ArrayList<>(len);
        for(int i = 0; i < len; i++)
        {
            list.add(nums[i]);
        }
        Collections.rotate(list,k);
        Integer[] newNums = list.toArray(new Integer[0]);
        for(int i = 0; i <len; i++)
        {
            nums[i] = newNums[i];
        }
    }
    
	//倒序组合实现旋转
    public  static void rotate3(int[] nums, int k) {
    	if(nums == null) return;
    	int len = nums.length;
        if(len < 2 || k ==1) return;
        k = k % len;
        //三步反转法
        subrotate(nums,0,len-1);
        subrotate(nums,0,k-1);
        subrotate(nums,k,len-1);
        
    }
    
    private  static void subrotate(int[] nums,int l ,int r){
        while(l < r)
        {
            //交换nums[l]与nums[r],不引入临时变量，以时间（多了计算）换空间（少了一个存储空间开销）
            nums[l] = nums[l] + nums[r];
            nums[r] = nums[l] - nums[r];
            nums[l] = nums[l] - nums[r];
            l++;
            r--;
        }
    }
    	

}
