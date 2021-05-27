package book.深入理解JAVA虚拟机.q_7_InitExplore;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 20:57
 **/
//https://github.com/doocs/jvm/blob/main/docs/09-load-class-process.md
public class ParentSon {
    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B); // 输出 2
        //但接口与类不同，接口的 <clinit>() 方法不需要先执行父类的 <clinit>() 方法，只有当父接口中定义的变量使用时，父接口才会初始化。
    }
}
