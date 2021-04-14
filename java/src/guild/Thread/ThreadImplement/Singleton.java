package guild.Thread.ThreadImplement;

/**
 * @author Created by Fangzj
 * @data 2021/4/14 20:09
 **/
public class Singleton {
    private volatile static Singleton uniqueSingleton;

    public Singleton() {
    }
    public Singleton getSingleton(){
        if(uniqueSingleton==null){
            synchronized (this){//底层用到了monitorenter表示同步开始的位置，monitorexit表示同步结束的位置。（修饰类的） 如果修饰的方法用的是acc——synchronized的标识
                if (uniqueSingleton == null) {
                    uniqueSingleton=new Singleton();
                }
            }
        }
        return uniqueSingleton;
    }
}
