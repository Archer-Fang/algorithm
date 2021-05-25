package book.深入理解JAVA虚拟机.q3_6_1_TestAllocation;

/**
 * @author Created by Fangzj
 * @data 2021/5/22 17:06
 **/
public class TestAllocation {
    // VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[2*1024*1024];
        allocation2=new byte[2*1024*1024];
        allocation3=new byte[2*1024*1024];
        allocation4=new byte[4*1024*1024];
    }

}
