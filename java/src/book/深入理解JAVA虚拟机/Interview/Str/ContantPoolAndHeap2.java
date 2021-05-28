package book.深入理解JAVA虚拟机.Interview.Str;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:07
 **/
public class ContantPoolAndHeap2 {
    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str4 == str5);//false

        System.out.println(str3 == str5);//true

    }
}
