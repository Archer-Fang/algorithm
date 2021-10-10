package nowcoder.meituan.ten.q1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/10/9 20:17
 **/
public class Main {
    public static void main(String[] args) {
        //尽可能淘汰少的人，晋级多的人
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -(a - b));
        Scanner in = new Scanner(System.in);
        int[] s = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int[] scores = Arrays.stream(in.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        for (int score : scores) {
            minHeap.add(score);
            maxHeap.add(score);
        }
        int x=s[1],y=s[2];
        int d=y-x;
        int minScore=-1;
        int ans=-1;

        while (maxHeap.size()!=0&&(x--)>0){
            minScore=minHeap.poll();
            ans=maxHeap.poll();
        }
        if(maxHeap.size()==0) {
            System.out.println("-1");
            return;
        }

        while (maxHeap.size()!=0&&(d--)>0&&maxHeap.peek()>=minScore){
            ans=maxHeap.poll();
        }
        System.out.println(ans);
    }

}
