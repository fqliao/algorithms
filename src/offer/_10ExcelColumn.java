package offer;

/**
 * @decription:A:1 B:2 ... Z:26 AA:27 AB:28,则根据字母输出数值
 * @version:1.0
 * @date: 2016年11月29日下午8:48:52
 * @author: lfq
 * 
 */
public class _10ExcelColumn {

	public static void main(String[] args) {
		System.out.println(column("AB"));
	}
	
	public static int column(String str)
	{
		if(str == null || "".equals(str))
			return 0;
		str = str.toUpperCase();
		char[] charColumn = str.toCharArray();
		int column = 0;
		int len = charColumn.length;
		for(int i = len-1, j = 0; i >= 0; i--, j++)
			column += Math.pow(26, i) * (charColumn[j] - 64);
		return column;
	}

}
