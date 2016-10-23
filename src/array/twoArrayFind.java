package array;

/**
 * @decription:二维数组的查找
 * @version:1.0
 * @date: 2016年10月23日上午11:35:07
 * @author: lfq
 * 
 */
public class twoArrayFind {
	
	public static boolean find(int[][] arr,int target){
		if(arr != null)
		{	int rows = arr.length;
			int columns = arr[0].length;
			int i = 0,j = columns-1;
			while(i < rows && j > -1)
			{
				if(arr[i][j] == target)
				{
					return true;
				}
				else if(arr[i][j] > target)
				{
					j--;
				}
				else
				{
					i++;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		//测试用例
		/**
		 * 1 数组为null
		 * 2 数组不为null，值在数组的最小值，最大值，中间值
		 * 3 数组不为null，值小于数组的最小值，大于数组的最大值，在数组最小值与最大值之间，但不在数组内
		 */
		System.out.println(find(null,2));
		int[][] arr = {{1,2,3},{4,6,7},{5,8,9},{10,11,14}};
		System.out.println(find(arr, 1));
		System.out.println(find(arr, 14));
		System.out.println(find(arr, 5));
		System.out.println(find(arr, 0));
		System.out.println(find(arr, 20));
		System.out.println(find(arr, 12));

	}

}
