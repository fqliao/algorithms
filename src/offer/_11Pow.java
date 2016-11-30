package offer;

/**
 * @decription:实现整数次幂
 * 边界条件： 幂为负数，地数为0，幂为最小负数处理
 * 幂的平方算法
 * 判断能否被2整除，除2用位操作，提供性能
 * 小数判断相等
 * @version:1.0
 * @date: 2016年11月30日下午4:15:36
 * @author: lfq
 * 
 */
public class _11Pow {

	public static void main(String[] args) {
		System.out.println(pow(2, 3));
		System.out.println(pow(-2, 1));
		System.out.println(pow(2, -1));
		
		System.out.println(pow(0, 3));
		System.out.println(pow(3, 0));
		System.out.println(pow(0, 0));
		
		System.out.println(pow(-4, -2));
		
		System.out.println(pow(2, Integer.MIN_VALUE));

	}
	
    public static double pow(double base, int exponent) {
    	//判断小数是否相等，不能直接判断精确相等，要定义范围
        if(equalDouble(base, 0.0) || exponent == 1){
            return base;
        }
        if(base == 1.0 || exponent == 0){
            return 1.0;
        }

        if(exponent < 0){
            if(exponent == Integer.MIN_VALUE){//avoid overflow
            	exponent++;
                if(base < 0){
                    base = -base;//ensure positive
                }
            }
            exponent = -exponent;
            base = 1.0 / base;
        }
        //判断是否能被2整除，用位&运算；除2，用位移运算；提供性能！
        return (exponent & 0x1) == 0 ? pow(base * base,exponent >> 1) : base * pow(base * base,exponent >> 1);
         
     }
    
    private static boolean equalDouble(double num1, double num2)
    {
    	if((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
    		return true;
    	else
    		return false;
    }
}
