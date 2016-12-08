

import java.util.*;

/**
 * @decription: 布隆过滤器
 * @version:1.0
 * @date: 2016年12月8日下午9:56:02
 * @author: lfq
 * 
 */
public class BloomFilter {
	
	//创建布隆过滤器的数组 大小为2^24 bit
	private static BitSet bloomSet = new BitSet(2 << 24);
	//定义7个hash函数
	private static int[] hashFunction = {3, 7, 11, 13, 31, 37, 61};
	
	
	public static void main(String[] args) {
//	    BitGraphic();
		
		List<String> items = new ArrayList<>();
		items.add("https://www.google.com.hk/");
		items.add("https://www.bing.com");
		items.add("https://www.baidu.com");
		initBloomFilter(items);
		
		System.out.println(isInBloomFilter("http://www.qq.com/"));
		System.out.println(isInBloomFilter("http://www.google.com.hk/"));
		System.out.println(isInBloomFilter("https://www.bing.com"));
		System.out.println(isInBloomFilter("http://www.baidu.com"));
		
	}
	
	/**初始化布隆过滤器
	 * @param items
	 */
	public static void initBloomFilter(List<String> items)
	{
		if(items == null || items.size() == 0)
			return;
		for (String item : items) 
		{
			for (int i = 0; i < hashFunction.length; i++)
			{
				int hash = getHashValue(item, i);
				if(!bloomSet.get(hash))
					bloomSet.set(hash);
			}
		}
	}
	
	
	/**判断一个元素(可以是整数，字符，文件等待，使用特点hash函数即可)是否在一个集合中
	 * @param str
	 * @return
	 */
	public static boolean isInBloomFilter(String item)
	{
		for (int i = 0; i < hashFunction.length; i++) //利用7个hash函数进行hash
		{
			int hash = getHashValue(item,i);
			if(!bloomSet.get(hash))//映射到false了，则为该str并不会初始集合中
				return false;
		}
		return true;
	}
	
	/**利用一个hash函数计算元素的hash值
	 * @param str
	 * @param n
	 * @return
	 */
	private static int getHashValue(String item, int n) 
	{
		int result = 0;
		for (int i = 0; i < item.length(); i++)
		{
			result += hashFunction[n] * (int)item.charAt(i);
			int max = 2 << 24;
			if(result > max)
				result %=  max;
		}
		return result;
	}
	
	
	/**
	 * 位图：适合处理大量整数判重
	 */
	public static void BitGraphic() {
		int[] arr = {1,2,3,4,2};
		int len = arr.length;
		BitSet bitSet = new BitSet(4);
		for(int i = 0; i < len; i++)
		{
			if(bitSet.get(arr[i]))
				System.out.println("重复元素为："+ arr[i]);
			else
				bitSet.set(arr[i]);
		}
	}
	
}
