package book.深入理解JAVA虚拟机.Interview.BasicDataTypeAndExpand;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:16
 **/
public class ContantPoolAndHeap2 {
    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2   " + (i1 == i2));//true
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));//true
        System.out.println("i1=i4   " + (i1 == i4));//false
        System.out.println("i4=i5   " + (i4 == i5));//false
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));//true!!!相加会进行拆箱，然后i4是Interge跟int比较也要拆箱
        System.out.println("40=i5+i6   " + (40 == i5 + i6));//true
    }
}
