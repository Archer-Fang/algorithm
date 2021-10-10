package nowcoder.meituan.ten.q3;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/9 20:54
 **/
public class Main {
    public static void main(String[] args) {
        //第一行输入一个整数T（1<=T<=10），表示数据组数。
        //
        //每组数据占四行，第一行输入一个整数N（1<=N<=500000）；
        //
        //第二行输入一个长度为N且仅包含数字0、1、2的字符串，第i个数字表示左起第i张餐桌已坐有的用餐人数；
        //
        //第三行输入一个整数M（1<=M<=2N且保证排队的每个人进入食堂时都有可供选择的餐桌）；
        //
        //第四行输入一个长度为M且仅包含字母M、F的字符串，若第i个字母为M，则排在第i的人为男性，否则其为女性。
        Scanner in = new Scanner(System.in);
        int T=Integer.parseInt(in.nextLine());
        while ((T--)>0){
            int N=Integer.parseInt(in.nextLine());
            char[] t = in.nextLine().toCharArray();
            HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
            for (int i = 0; i < t.length; i++) {
                int k=Integer.parseInt(String.valueOf(t[i]));
                LinkedList<Integer> list = map.getOrDefault(k, new LinkedList<Integer>());
                list.add(i+1);
                map.put(k,list);
            }

            int M=Integer.parseInt(in.nextLine());
            String p = in.nextLine();
            char[] persons = p.toCharArray();
            int[] ans = new int[M];
            for (int i = 0; i < persons.length; i++) {
                if(persons[i]=='M'){
                    LinkedList<Integer> list = map.get(1);
                    if(list.size()==0){
                        LinkedList<Integer> list0 = map.get(0);
                        ans[i]=list0.get(0);
                        list0.removeFirst();
                        map.put(0,list0);
                        LinkedList<Integer> list1 = map.get(1);
                        list1.add(ans[i]);
                        list1.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1-o2;
                            }
                        });
                        map.put(1,list1);
                    }else {
                        LinkedList<Integer> list1 = map.get(1);
                        ans[i]=list1.get(0);
                        list1.removeFirst();
                        map.put(1,list1);
                    }
                }

                if(persons[i]=='F'){
                    LinkedList<Integer> list = map.get(0);
                    if(list.size()!=0){
                        LinkedList<Integer> list0 = map.get(0);
                        ans[i]=list0.get(0);
                        list0.removeFirst();
                        map.put(0,list0);
                        LinkedList<Integer> list1 = map.get(1);
                        list1.add(ans[i]);
                        list1.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1-o2;
                            }
                        });
                        map.put(1,list1);
                    }else {
                        LinkedList<Integer> list1 = map.get(1);
                        ans[i]=list1.get(0);
                        list1.removeFirst();
                        map.put(1,list1);
                    }
                }
            }
            for (int an : ans) {
                System.out.println(an);
            }
        }




    }
}
