package book.深入理解JAVA虚拟机.q3_6_3_Age;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 15:18
 **/
public class Age {
    // VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8  -XX:+UseSerialGC -XX:MaxTenuringThreshold=10
    //-XX:MaxTenuringThreshold=10 ??结果跟书上讲的不一样，估计是动态对象年龄判断算法改了
    // def new generation   total 9216K, used 4233K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
    //  eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff022608, 0x00000000ff400000)
    //  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400190, 0x00000000ff500000)
    //  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
    // tenured generation   total 10240K, used 9056K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
    //   the space 10240K,  88% used [0x00000000ff600000, 0x00000000ffed8188, 0x00000000ffed8200, 0x0000000100000000)
    // Metaspace       used 3179K, capacity 4496K, committed 4864K, reserved 1056768K
    //  class space    used 344K, capacity 388K, committed 512K, reserved 1048576K

    //-XX:MaxTenuringThreshold=1
    // def new generation   total 9216K, used 4234K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
    //  eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff0228a0, 0x00000000ff400000)
    //  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400178, 0x00000000ff500000)
    //  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
    // tenured generation   total 10240K, used 9051K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
    //   the space 10240K,  88% used [0x00000000ff600000, 0x00000000ffed6ef8, 0x00000000ffed7000, 0x0000000100000000)
    // Metaspace       used 3234K, capacity 4496K, committed 4864K, reserved 1056768K
    //  class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
    public static final int _M=1*1024*1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[_M/1024];
        allocation2=new byte[4*_M];
        allocation3=new byte[4*_M];
//        allocation4=null;
        allocation4=new byte[4*_M];
    }
}
