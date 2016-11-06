package sort;

/**
 * @decription:排序用的工具方法，交换两元素位置
 * @version:1.0
 * @date: 2016年11月6日下午3:36:38
 * @author: lfq
 * 
 */
public class SortUtil {
	
	/**交换数组中下标为i和小标为j的元素
	 * @param arr
	 * @param i
	 * @param j
	 * @throws Exception
	 */
	public static void swap(int[] arr,int i,int j) throws Exception
	{
		if(arr == null || arr.length == 0 || arr.length == 1)
			return;
		if(i < 0 || i > arr.length-1 || j < 0 || j > arr.length-1)
			throw new Exception("下标越界");
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		//数值可以不用临时变量进行两个数值的交换
//		arr[i] = arr[i] + arr[j];
//		arr[j] = arr[i] - arr[j];
//		arr[i] = arr[i] - arr[j];
	}
}
