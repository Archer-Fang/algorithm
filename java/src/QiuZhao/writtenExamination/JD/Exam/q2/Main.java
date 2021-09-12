package QiuZhao.writtenExamination.JD.Exam.q2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Created by Fangzj
 * @data 2021/9/12 21:48
 **/

//你可能不喜欢 systemd，但很可能每天都要面对它——Linux 下广泛使用的 init 程序。
//
//​ 在一个 systemd units 中，可以使用 Requires=… 的语法来引入依赖，当服务 a 引入了服务 b 作为依赖之后，服务 a 启动时 b 会随之启动，b 停止时 a 会随之停止。本题会给你 n 个服务和它们之间的依赖关系，一开始所有服务都处于停止状态，然后进行若干次启动和停止操作，你需要在每一次操作后输出当前正在运行的服务数量。假设所有服务都能稳定运行、正常启动和退出。为了简化输入，所有服务名使用序号（1~n）代替。可以启动正在运行的程序，也可以停止已经停止的程序，这样的操作将不会造成任何变化。
//
//输入描述
//第一行两个空格隔开的整数 n, q，表示服务的数量和询问的数量，1 <= n, q <= 500。
//
//下面 n 行，其中的第 i 行第一个整数 c 表示第 i 个服务所依赖的服务数量，后面 c 个整数表示它所依赖的各个服务，保证这 c 个整数在 1~n 范围内，互不相等且都不等于 i。
//
//下面 q 行，每行两个空格隔开的整数 x, y。x 为 1 或 0，1 表示启动服务，0 表示停止服务。y 表示启动或停止的服务的序号。
//
//输出描述
//q 行，每行一个整数，表示每次操作后这 n 个服务中正在运行的服务数量。
//
//样例输入
//3 2
//1 2
//1 3
//0
//1 1
//0 2
//样例输出
//3
//1

    //2->1,3->2


public class Main{
    static int liveHost;
    static int[] service;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        service = new int[n+1];
        liveHost = 0;
        ArrayList[] start = new ArrayList[n+1];
        ArrayList[] stop = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            start[i] = new ArrayList<Integer>();
            stop[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i<=n; i++){
            int c = sc.nextInt();
            for(int j = 0; j<c; j++){
                int b = sc.nextInt();
                start[i].add(b);
                stop[b].add(i);
            }
        }

        for(int i = 0; i<q; i++){
            if(sc.nextInt() == 1){
                dfsStart(n, start, sc.nextInt());
            }
            else{
                dfsStop(n, stop, sc.nextInt());
            }

            if(i == q-1){
                System.out.print(liveHost);
            }
            else{
                System.out.println(liveHost);
            }
        }
    }

    public static void dfsStart(int n, ArrayList[] start, int cur){
        if(service[cur] == 1){
            return;
        }

        if(service[cur] == 0){
            service[cur] = 1;
            liveHost++;
        }

        for(Object i: start[cur]){
            dfsStart(n, start, (Integer)i);
        }
    }

    public static void dfsStop(int n, ArrayList[] stop, int cur){
        if(service[cur] == 0){
            return;
        }

        if(service[cur] == 1){
            service[cur] = 0;
            liveHost--;
        }

        for(Object i: stop[cur]){
            dfsStop(n, stop, (Integer)i);
        }
    }
}
