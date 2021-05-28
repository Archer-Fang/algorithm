package book.深入理解JAVA虚拟机.Interview.BasicDataTypeAndExpand;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:16
 **/
public class ContantPoolAndHeap {
    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1==i2);//输出 false

    }
}
