package book.深入理解JAVA虚拟机.Interview.ClassLoader;

/**
 * @author Created by Fangzj
 * @data 2021/5/27 21:34
 **/
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());//null并不代表ExtClassLoader没有父类加载器，而是 BootstrapClassLoader 。
    }
}
