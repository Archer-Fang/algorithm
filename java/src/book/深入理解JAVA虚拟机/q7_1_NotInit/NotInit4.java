package book.深入理解JAVA虚拟机.q7_1_NotInit;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 16:36
 **/
public class NotInit4 {
    static class SuperClass{
        static {
            System.out.println("superclass init");
        }
        public static String v="123";
    }
    static class SubClass extends SuperClass{
        static {
            System.out.println("sub init");
        }
//        public static int v=123;
    }

    public static void main(String[] args) {
        System.out.println(SubClass.v);
    }

}
