package guild.JVM;

/**
 * @author Created by Fangzj
 * @data 2021/4/6 15:42
 **/
public class BasicDataType {
    public static void main(String[] args) {
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
