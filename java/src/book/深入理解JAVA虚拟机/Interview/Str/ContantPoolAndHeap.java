package book.深入理解JAVA虚拟机.Interview.Str;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:06
 **/
public class ContantPoolAndHeap {
    public static void main(String[] args) {

        String str1 = "abcd";//先检查字符串常量池中有没有"abcd"，如果字符串常量池中没有，则创建一个，然后 str1 指向字符串常量池中的对象，如果有，则直接将 str1 指向"abcd""；
        String str2 = new String("abcd");//堆中创建一个新的对象
        String str3 = new String("abcd");//堆中创建一个新的对象
        System.out.println(str1==str2);//false
        System.out.println(str2==str3);//false
    }
}
