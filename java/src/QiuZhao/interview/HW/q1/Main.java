package QiuZhao.interview.HW.q1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author Created by Fangzj
 * @data 2021/10/22 14:29
 **/
//["1","2"]
public class Main {
    public static void main(String[] args) {
        ForgetSystem forgetSystem = new ForgetSystem();

        
        System.out.println(forgetSystem.addEvent(2,"eat a burger",2,3));;
        System.out.println(Arrays.toString(forgetSystem.queryTodo(0,5)));
        System.out.println(forgetSystem.finishEvent(2,"eat a burger"));
        System.out.println(forgetSystem.removeEvent(2,"eat a burger"));
        //2
        //[eat a burger, eat a burger]
        //true
        //true


//        System.out.println(forgetSystem.addEvent(2,"eat a burger",2,3));
//        System.out.println(Arrays.toString(forgetSystem.queryTodo(0,5)));
//        System.out.println(forgetSystem.finishEvent(2,"eat a burger"));
//        System.out.println(forgetSystem.removeEvent(2,"eat a burger"));

//
//        System.out.println(forgetSystem.addEvent(2,"save files",1,1));
//        System.out.println(forgetSystem.addEvent(2,"eat a burger",1,1));
//        System.out.println(forgetSystem.addEvent(2,"drink water",1,1));
//        System.out.println(Arrays.toString(forgetSystem.queryTodo(0,5)));
//        System.out.println(forgetSystem.finishEvent(2,"eat a burger"));
//        System.out.println(forgetSystem.removeEvent(2,"eat a burger"));
//

// todo 输入输出来不及处理了

    }
}

class ForgetSystem{
    TreeMap<Integer,String[]> map=new TreeMap<Integer,String[]>();
    public int addEvent(int startDate, String content, int num, int period){
        int c=0;

        for (int i = 1; i <= num; i++) {
            int key=period*i-1;
            if(!map.containsKey(key)){
                map.put(key,new String[]{content,"0"});
                c++;
            }
        }
        return c;

    }
    public boolean finishEvent(int date, String content){
        if(!map.containsKey(date)) return false;
        if(map.get(date)[1].equals("1")) return false;
        map.put(date,new String[]{content,"1"});
        return true;
    }
    public boolean removeEvent(int date, String content){
        if(!map.containsKey(date)) return false;
        map.remove(date);
        return true;

    }
    public String[] queryTodo(int startDate, int endDate){
        LinkedList<String> list = new LinkedList<>();
        for (int k : map.keySet()) {
            if(k>=startDate&&k<=endDate) {
                if("0".equals(map.get(k)[1])){
                    list.add(map.get(k)[0]);
                }

            }
        }
        String[] r = new String[list.size()];
        int k=0;
        for (String s : list) {
            r[k++]=s;
        }
        return r;
    }
}