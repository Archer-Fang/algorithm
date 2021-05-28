package book.深入理解JAVA虚拟机.Interview.Str;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:08
 **/
public class ContantPoolAndHeap3 {
    //String s1 = new String("abc");这句话创建了几个字符串对象？
    //将创建 1 或 2 个字符串。如果池中已存在字符串常量“abc”，则只会在堆空间创建一个字符串常量“abc”。如果池中没有字符串常量“abc”，那么它将首先在池中创建，然后在堆空间中创建，因此将创建总共 2 个字符串对象。
    public static void main(String[] args) {
        String s1 = new String("abc");// 堆内存的地址值
        String s2 = "abc";
        System.out.println(s1 == s2);// 输出 false,因为一个是堆内存，一个是常量池的内存，故两者是不同的。
        System.out.println(s1.equals(s2));// 输出 true

    }
}
