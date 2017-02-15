package offer.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateString {

	public static void main(String[] args) {
		String input = "aavzcadfdsfsdhshgWasdfasdfdddaaa";
		doString(input);

	}
	
	public static void doString(String input){
		char[] chars = input.toCharArray();
		List<String> lists = new ArrayList<>();
		Set<String> set = new TreeSet<>();
		for(int i = 0; i < chars.length; i++){
			lists.add(String.valueOf(chars[i]));
			set.add(String.valueOf(chars[i]));
		}
		Collections.sort(lists);
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < lists.size(); i++){
			sb.append(lists.get(i));
		}
		input = sb.toString();
		int max = 0;
		String maxString = "";
		List<String> maxlist = new ArrayList<>();
		Iterator<String> its = set.iterator();
		while(its.hasNext()){
			String str = its.next();
			int begin = input.indexOf(str);
			int end = input.lastIndexOf(str);
			int value = end - begin + 1;
			if(value > max){
				max = value;
				maxString = str;
				maxlist.add(str);
			}
			else if(value == max){
				maxlist.add(str);
			}
		}
		int index = 0;
		for(int i = 0; i < maxlist.size(); i++){
			if(maxlist.get(i).equals(maxString)){
				index = i;
				break;
			}
		}
		System.out.println("max data");
		for(int i = index; i < maxlist.size(); i++){
			System.out.print(maxlist.get(i)+" ");
		}
		System.out.println();
		System.out.println("max:"+max);
	}

}
