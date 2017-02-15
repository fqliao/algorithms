package offer.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumberCombine2 {

	public static void main(String[] args) {
		String[] str = new String[]{"1","2","2","3","4"};
		print(Arrays.asList(str), "");
	}
	
	public static void print(List<String> list , String prefix){
		if(prefix.length() == 5){
			System.out.println(prefix);
		}
		for(int i = 0; i < list.size(); i++){
			List<String> temp = new LinkedList<>(list);
			print(temp, prefix+temp.remove(i));
		}
	}

}
