package array;

import java.util.Arrays;
import java.util.BitSet;


/**
 * @decription:字符串替换空格
 * @version:1.0
 * @date: 2016年10月23日下午4:21:21
 * @author: lfq
 * 
 */
public class SubSpace {

	public static void main(String[] args){
		//测试用例
		/**
		 * 1 数组为null
		 * 2 只有空格
		 * 3 首尾有空格
		 * 4 中间有空格
		 * 5 无空格
		 * 6只有一个字符
		 */
//		String[] str = null;
//		String[] str = {" "," "};
//		String[] str = {" ","y"," "};
//		String[] str = {"W","e"," ","a","r","e"," ","h","a","p","p","y"};
//		String[] str = {"w","e"," r"};
		String[] str = {"w"};
	    str = Arrays.copyOf(str, 20);
//		System.out.println(Arrays.toString(str));
		trimSpace(str);
		System.out.println(Arrays.toString(str));
	}
	
	public static void trimSpace(String[] str){
		if(str == null)
			return;
		int len = 0;//实际长度
		int count = 0;//空格个数
		for(int i = 0; i < str.length; i++)
		{
			if(str[i] != null && str[i].equals(" "))
			{
				count++;
			}
			if(str[i] != null)
			{
				len++;
			}
		}
		int size = len + 2*count;//填充之后的大小
		int p1 = len-1,p2 = size-1;
		String[] replaceStr = {"0","2","%"};
		while(p1 != p2)
		{
			while(!str[p1].equals(" "))
			{
				str[p2] = str[p1];
				p1--;
				p2--;
			}
			p1--;
			for(int j = 0; j < 3; j++)
			{
				str[p2] = replaceStr[j];
				p2--;
			}
		}
	}

	
}
