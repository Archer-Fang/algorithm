package ShiXi.wangyi.q2;

/**
 * @author Created by Fangzj
 * @data 2021/4/24 14:12
 **/

import java.util.*;

class Solution {
    public void needNum(int left,int right,int top,int bottom,ArrayList points,ArrayList operators,int[] t,int M,int N) {
        //一有结果直接sout
        //对操作中的时间进行排序
        Collections.sort(operators, new Comparator<Operator>() {
            @Override
            public int compare(Operator o1, Operator o2) {
                return o1.t-o2.t;
            }
        });

        int maxT= Arrays.stream(t).max().getAsInt();
        int[] sums=new int[maxT+1];
        int k=0;
        while (k<=maxT){
            //对于当前时间点
            int sum=0;
            for (int i=0;i<points.size();i++){
                Point point= (Point) points.get(i);
                if(point.getX()<=right&&point.getX()>=left&&point.getY()>=bottom&&point.getY()<=top){
                    sum++;
                }
            }
            sums[k++]=sum;
            int curT=((Operator) operators.get(0)).getT();
            while (k<curT){
                sums[k++]=sum;
            }
            for (int i=0;i<operators.size();i++){
                int curT2=((Operator) operators.get(i)).getT();
                if(curT2==k){
                    Operator tmp=(Operator) operators.get(i);
                    Point tmp2=(Point) points.get(tmp.getId()-1);
                    if(tmp.getDirection().equals("W")){
                        tmp2.setY((tmp2.getY()+tmp.getStep())>N?N:tmp2.getY()+tmp.getStep());
                    }
                    if(tmp.getDirection().equals("S")){
                        tmp2.setY((tmp2.getY()-tmp.getStep())<0?0:tmp2.getY()-tmp.getStep());
                    }
                    if(tmp.getDirection().equals("A")){
                        tmp2.setY((tmp2.getX()-tmp.getStep())<0?0:tmp2.getX()-tmp.getStep());
                    }
                    if(tmp.getDirection().equals("D")){
                        tmp2.setY((tmp2.getX()+tmp.getStep())>M?M:tmp2.getX()+tmp.getStep());
                    }
                    points.set(tmp.getId()-1,tmp2 );
                }

            }

        }
        StringBuffer sb=new StringBuffer();
        for (Integer tmp:t){
            sb.append(sums[tmp]+" ");
        }
        String r=sb.toString();
        System.out.print(r.substring(0,r.length()-1));

        return;
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
class Operator{
    int id;
    int t;
    int step;
    String direction;

    public Operator(int id, int t, int step, String direction) {
        this.id = id;
        this.t = t;
        this.step = step;
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public int getStep() {
        return step;
    }

    public String getDirection() {
        return direction;
    }

    public int getT() {
        return t;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int[] d1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left=(d1[2]-d1[4])<0?0:(d1[2]-d1[4]);
        int right=(d1[2]+d1[4])>d1[0]?d1[0]:(d1[2]+d1[4]);
        int bottom=(d1[3]-d1[4])<0?0:(d1[3]-d1[4]);
        int top=(d1[3]+d1[4])>d1[1]?d1[1]:(d1[3]+d1[4]);
        int[] d2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        Point[] points=new Point[d2[0]];
        ArrayList<Point> points=new ArrayList<>();
        for (int i=0;i<d2[0];i++){
            int[] d3 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            points.add(new Point(d3[0],d3[1]));
        }
        int[] d4 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Operator> operators=new ArrayList<>();
        for (int i=0;i<d4[0];i++){
            String[] d5 = in.nextLine().split(" ");
            operators.add(new Operator(Integer.parseInt(d5[0]),Integer.parseInt(d5[1]),Integer.parseInt(d5[2]),d5[3]));
        }
        int[] d6 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] t = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();//具体的每个时间的范围
        solution.needNum( left, right, top, bottom, points, operators, t,d1[0],d1[1]);


    }
}

//10 10 3 3 1
//1
//3 5
//1
//1 2 1 S
//2
//2 1