package book.深入理解JAVA虚拟机.Interview.JVMTuning;

/**
 * @author Created by Fangzj
 * @data 2021/5/28 10:44
 **/
public class Main {
    public static void main(String[] args) {
        //-Xmx20m -Xms5m -XX:+PrintGCDetails
        byte[] b = new byte[10 * 1024 * 1024];
        System.out.println("分配了1M空间给数组");
        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");    //系统的最大空间
        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");  //系统的空闲空间
        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  //当前可用的总空间
    }
}
