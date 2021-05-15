package book.实战Java高并发程序设计.q2_2_2_StopThread;

/**
 * @author Created by Fangzj
 * @data 2021/5/13 13:58
 **/
public class StopThread {
    public static User u=new User();
    public static class User{
        private int id;
        private String name;

        public User() {
            this.id = 0;
            this.name = "0";
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ChangeThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (u){
                    int id= (int) (System.currentTimeMillis()/1000);
                    u.setId(id);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(id));
                    Thread.yield();
                }
            }
        }
    }
    public static  class ReadThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (u){
                    if(u.getId()!= Integer.parseInt(u.getName())){
                        System.out.println(u);
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {

        ReadThread readThread = new ReadThread();
        readThread.start();
        while (true){
            ChangeThread changeThread = new ChangeThread();
            changeThread.start();
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeThread.stop();

        }
    }
}
