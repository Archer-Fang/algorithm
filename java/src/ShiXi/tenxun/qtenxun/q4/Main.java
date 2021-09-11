package ShiXi.tenxun.qtenxun.q4;
import java.util.*;
//https://www.nowcoder.com/discuss/632244?type=all&order=time&pos=&page=1&channel=-1&source_id=search_all_nctrack
public class Main {
    //充电功率8
    //剩余电量 消耗功率
    //3 4
    //2 8
    //1 6
    //分配完可充电量以后可用时间0.5  8->4 6->2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            double w = sc.nextDouble();
            PriorityQueue<double[]> minHeap = new PriorityQueue<>((a, b) -> (int) (a[0] * b[1] - a[1] * b[0]));
            for(int j = 0; j < n; j++) {
                minHeap.offer(new double[]{sc.nextInt(), sc.nextInt()});
            }
            while(w > 0) {
                if(minHeap.size() == 1) {
                    double[] cur = minHeap.poll();
                    if(cur[1] <= w) {
                        System.out.println(-1);
                        w = 0;
                    } else {
                        System.out.println(cur[0]/(cur[1] - w));
                        w = 0;
                    }
                } else {
                    double[] cur = minHeap.poll();
                    double[] next = minHeap.peek();
                    double temp = (next[0] * cur[1] - cur[0] * next[1]) / next[0];
                    if(w  > temp) {
                        w -= temp;
                        minHeap.poll();
                        minHeap.offer(new double[]{cur[0] + next[0], cur[1] + next[1] - temp});
                    } else if(w <= temp) {
                        System.out.println(cur[0]/(cur[1] - w));
                        w = 0;
                    }
                }
            }
        }
    }
}

