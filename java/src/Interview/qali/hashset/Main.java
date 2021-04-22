package Interview.qali.hashset;

import java.util.HashSet;

/**
 * @author Created by Fangzj
 * @data 2021/4/20 20:54
 **/
public class Main {
    public static void main(String[] args) {
        String s1=new String("1");
        String s2=new String("1");
        System.out.println(s1==s2);
        Integer i1=new Integer(1);
//        Integer i2=new Integer(1);
//        Integer i3=new Integer(9999);
//        Integer i4=new Integer(9999);
        Test test1=new Test(1,"fzj");
        Test test2=new Test(1,"fzj");
        Test2 test3=new Test2(2);
        Test2 test4=new Test2(2);
        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s1.hashCode());
        HashSet hashSet=new HashSet();
//        hashSet.add(i1);
//        hashSet.add(i2);
//        hashSet.add(i3);
//        hashSet.add(i4);
//        hashSet.add(s1);
//        hashSet.add(s2);
        hashSet.add(test1);
        hashSet.add(test2);
        hashSet.add(test3);
        hashSet.add(test4);
        System.out.println(hashSet);
    }
}
class Test{
    public int id;
    public String name;

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class Test2{
    public int id;

    public Test2(int id) {
        this.id = id;
    }
}
