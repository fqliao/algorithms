package offer.java;

import java.util.Arrays;

public class SortString {

	public static void main(String[] args) {
		String str[] = {"B","A","a","ad","C","c"};
		bubbleSort(str);
		System.out.println(Arrays.toString(str));
	}
	
	public static void bubbleSort(String[] str){
		if(str == null || str.length < 2){
			return;
		}
		int len = str.length;
		for(int i = 0; i < len - 1; i++){
			for(int j = 0; j < len -i -1; j++){
				if(stringCmp(str[j],str[j+1]) > 0){
					swap(str,j,j+1);
				}
			}
		}
	}
	public static int stringCmp(String s1,String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		int nResult = len1 - len2;
		int minLen = Math.min(len1, len2);
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int n1,n2;
		for(int i = 0; i < minLen; i++){
			if(c1[i] != c2[i]){
				n1 = c1[i] > 96 ? c1[i]-96 : c1[i]-64;
				n2 = c2[i] > 96 ? c2[i]-96 : c2[i]-64;
				if(n1 != n2){
					nResult = n1 -n2;
					break;
				}
				else{
					nResult = c1[i] - c2[i];
					break;
				}
			}
		}
		return nResult;
	}
	public static void swap(String[] str , int i ,int j){
		String temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
}
