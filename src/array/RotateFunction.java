package array;

import java.util.Arrays;
/**
 * 逆时针循环移位数组，计算累加和，求最大值
 * 分解出几个子问题，即用子函数实现
 * 1 设计循环移位数组函数
 * 2 设计累加值
 * 3 将各个累加值放入数组，排序，即可求出最大值
 * @author lfq
 *
 */
public class RotateFunction {

	public static void main(String[] args) {
		int[] A = {4,3,2,6};
		int maxValue = maxRotateFunction(A);
		System.out.println(maxValue);
	}
	
    public static int maxRotateFunction(int[] A) {
        int length = A.length;
        if(length == 0)
        {
        	return 0;
        }
        int[] value = new int[length];
        for(int i= 0; i<length; i++)
        {
            value[i] = calc(rotate(A,i));
        }
        Arrays.sort(value);;
        return value[length-1];
    }
    
    //顺时针移位数组
    public static int[] rotate(int[] A,int i){
        if(i == 0)
        {
            return A;
        }
        int[] B = new int[A.length];
        System.arraycopy(A,A.length-i,B,0,i);
        System.arraycopy(A,0,B,i,A.length-i);
        return B;
    }
    
    //计算函数值
    public static int calc(int[] B){
        int value = 0;
        for(int i = 0; i<B.length; i++)
        {
            value += i*B[i];
        }
        return value;
    }

}
