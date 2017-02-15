package offer.java;

import java.util.Arrays;

public class SievePrime {

	public static void main(String[] args) {
		printPrime2(100);

	}
	
	//素数筛法
	public static void printPrime1(int n){
		int[] a = new int[n+1];
	    Arrays.fill(a, 1);
	    for(int i = 2; i < a.length; i++){
	    	if(a[i] != 0){
	    		for(int j = i+1; j < a.length; j++){
	    			if(j % i == 0){
	    				a[j] = 0;
	    			}
	    		}
	    	}
	    }
	    for(int i = 2; i < a.length; i++){
	    	if(a[i] !=0){
	    		System.out.print(i+" ");
	    	}
	    }
	}
	
	//开根号法
	public static void printPrime2(int n){
		int j;
		for(int i = 2; i < n; i++){
			int k = (int) Math.sqrt(i);
			for(j = 2; j <=k; j++){
				if(i % j == 0){
					break;
				}
			}
			if(j > k){
				System.out.print( i + " ");
			}
		}
	}

}
