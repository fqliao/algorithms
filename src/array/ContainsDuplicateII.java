package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出重复位置之间的最小差的范围，不必具体计算差值再比较
 * 利用set集合的add,remove方法解决
 * 对遍历过的元素进行简化处理是核心，最终至多只需要完全遍历一次
 * @author lfq
 *
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {
		int[] nums = {1,0,1,1};
		System.out.println(containsNearbyDuplicate(nums,1));
	}
	
    public static boolean containsNearbyDuplicate(int[] nums,int k) {
    	//核心：遍历依次，对遍历过的元素进行处理，分析，简化
        Set<Integer> set = new HashSet<Integer>();
    	//如果i>k，则删除集合中已经判断的元素 两次判断顺序不能改变
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
	

}
