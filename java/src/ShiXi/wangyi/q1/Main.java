package ShiXi.wangyi.q1;

/**
 * @author Created by Fangzj
 * @data 2021/4/24 15:32
 **/

import java.util.*;



public class Main {
    static int[][] nums;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int T=scanner.nextInt();
        nums=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                nums[i][j]=scanner.nextInt();
            }
        }
        scanner.nextLine();
        for (int n=0;n<T;n++){
            int r1=scanner.nextInt()-1;
            int r2=scanner.nextInt()-1;
            int c1=scanner.nextInt()-1;
            int c2=scanner.nextInt()-1;
            int s=scanner.nextInt()-1;
            int A=scanner.nextInt();
            int index=0;
            ArrayList<Node> nodes=new ArrayList<Node>();
            for(int i=r1;i<=r2;i++){
                nodes.add((new Node(i,nums[i][s])));
            }
            Collections.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(A==0){
                        return o1.value-o2.value;
                    }else {
                        return o2.value-o1.value;
                    }
                }
            });
            int[][] des=new int[r2-r1+1][c2-c1+1];
            for (int i=0;i<nodes.size();i++){
                int row=nodes.get(i).row;
                index=0;
                for(int j=c1;j<=c2;j++){
                    des[i][index++]=nums[row][j];
                }
            }

            for (int i=0;i<des.length;i++){
                for(int j=0;j<des[0].length;j++){
                    nums[r1+i][c1+j]=des[i][j];
                }
            }

        }
        for(int i=0;i<nums.length;i++){
            for (int j=0;j<nums[i].length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    static class Node{
        int row;
        int value;

        public Node(int row, int value) {
            this.row = row;
            this.value = value;
        }

    }
}

//1
//3 3
//3
//6
//9

//4 4 1
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16
//2 3 2 3 3 1

//1 2 3 4
//5 10 11 8
//9 6 7 12
//13 14 15 16