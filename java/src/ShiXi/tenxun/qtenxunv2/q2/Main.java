package ShiXi.tenxun.qtenxunv2.q2;

/**
 * @author Created by Fangzj
 * @data 2021/4/18 20:32
 **/

import java.util.*;

class Solution {
    public void needNum(int n, int k, int[] nums) {
        //一有结果直接sout
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.stamp != b.stamp) {
                return a.stamp - b.stamp;
            } else {
                return a.id - b.id;
            }
        });
        for (int i=0;i<n;i++){
            priorityQueue.add(new Item(nums[i],i+1,nums[i]));
        }
        while ((k--)>0){
            Item item=priorityQueue.poll();
            System.out.println(item.id);
            priorityQueue.add(new Item(item.val,item.id,item.stamp+item.val));
        }
    }
}

class Item {
    int val;
    int id;
    int stamp;

    public Item(int val, int id, int stamp) {
        this.val = val;
        this.id = id;
        this.stamp = stamp;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int T=Integer.parseInt(in.nextLine());
        while ((T--)>0){
            int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n=d1[0],k=d1[1];
            int[] num=new int[n];
            for (int i=0;i<n;i++){
                num[i]=Integer.parseInt(in.nextLine());
            }
            solution.needNum(n,k,num);
        }

    }
}
//1
//3 3
//3
//6
//9