package book.深入理解JAVA虚拟机.Interview.BasicDataTypeAndExpand;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:14
 **/
public class ConstantPool {
    public static void main(String[] args) {
        //Byte,Short,Integer,Long； 4 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);// 输出 true
        Integer i11 = 333;
        Integer i22 = 333;
        System.out.println(i11 == i22);// 输出 false
        Double i3 = 1.2;
        Double i4 = 1.2;
        System.out.println(i3 == i4);// 输出 false
    }
}
