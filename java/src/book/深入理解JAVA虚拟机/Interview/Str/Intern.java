package book.深入理解JAVA虚拟机.Interview.Str;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:06
 **/
public class Intern {
    public static void main(String[] args) {
        //可以使用 String 提供的 intern() 方法。String.intern() 是一个 Native 方法.
        // 它的作用是：如果运行时常量池中已经包含一个等于此 String 对象内容的字符串，则返回常量池中该字符串的引用；
        // 如果没有，JDK1.7 之前（不包含 1.7）的处理方式是在常量池中创建与此 String 内容相同的字符串，并返回常量池中创建的字符串的引用。
        String s1 = "计算机";
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//true
        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象

    }
}
