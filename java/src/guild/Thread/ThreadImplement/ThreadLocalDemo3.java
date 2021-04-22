package guild.Thread.ThreadImplement;

import java.lang.reflect.Field;

/**
 * @author Created by Fangzj
 * @data 2021/4/20 11:25
 **/
public class ThreadLocalDemo3 {

    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>() {
        @Override
        protected String initialValue() {
            return "1";
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("threadLocal1被回收");
        }
    };
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>() {
        @Override
        protected String initialValue() {
            return "2";
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("threadLocal2被回收");
        }
    };

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        // 获取ThreadLocalMap
        Thread thread = Thread.currentThread();
        Class<? extends Thread> clazz = thread.getClass();
        Field threadLocals = clazz.getDeclaredField("threadLocals");
        threadLocals.setAccessible(true);
        Object threadLocalsObj = threadLocals.get(thread);
        // 获取ThreadLocalMap下的table数组
        Class<?> threadLocalsMapClass = threadLocalsObj.getClass();
        Field tableField = threadLocalsMapClass.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] tableObj = (Object[]) tableField.get(threadLocalsObj);
        threadLocal1.set("zhazha");
        threadLocal2.set("xixi");
        System.out.println(threadLocal1.get());
        System.out.println(threadLocal2.get());
        // 在这里下一个断点看看ThreadLocal被回收, Entry是否被回收
//        threadLocal1 = null;
//        threadLocal2 = null;
        threadLocal1.remove();
        threadLocal2.remove();
        System.gc();
        Thread.sleep(5000);
        System.out.println(tableObj);
        System.out.println("主线程结束");
    }
}

