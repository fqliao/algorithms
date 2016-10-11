package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断集合中有无重复元素
 * 利用集合Set添加元素时返回值判断，重复添加返回false，且不会添加到Set中
 * @author lfq
 *
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = {3,3};
		System.out.println(containsDuplicate(nums));
	}
	
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) return false;
    	Set<Integer> set = new HashSet<>();
    	for (int i = 0; i < nums.length; i++) {
			if(!set.add(nums[i]))
			{
				return true;
			}
		}
    	return false;
    }

}
