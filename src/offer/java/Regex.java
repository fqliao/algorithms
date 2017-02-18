package offer.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @decription:正则表达式
 * @version:1.0
 * @date: 2017年2月16日下午12:02:53
 * @author: lfq
 * 
 */
public class Regex {

	public static void main(String[] args) {
		//电话号码
		String phoneRegex = "((13|15|17|18))\\d{9}";
		
		System.out.println("15229395121".matches(phoneRegex));
		
		String str = "我们是15229395121，你们是13698745282";
		Matcher m = Pattern.compile(phoneRegex).matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
		
		//邮箱
		String mailRegex = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		System.out.println("fqliao@yeah.net".matches(mailRegex));
		System.out.println("lfqsw123@163.com".matches(mailRegex));

	}

}
