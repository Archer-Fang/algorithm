package book.深入理解JAVA虚拟机.q_7_InitExplore;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 20:51
 **/
//https://github.com/doocs/jvm/blob/main/docs/09-load-class-process.md
public class BeforeStaticBlockDef {
    static class Parent{
        static int i=1;
        static {
            i=0;
            System.out.println(i);
        }


    }

    public static void main(String[] args) {
        new Parent();
    }
}
