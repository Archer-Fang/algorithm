package book.深入理解JAVA虚拟机.q3_6_2_Size;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 15:09
 **/
public class PretenureSize {
    // VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
    //3145728=3MB
    public static void main(String[] args) {
        byte[] allocation4;
        allocation4=new byte[9*1024*1024];
    }
}
