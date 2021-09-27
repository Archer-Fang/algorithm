package QiuZhao.writtenExamination.Tencent.q1;

/**
 * @author Created by Fangzj
 * @data 2021/9/26 21:03
 **/
public class Main2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n=Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < n; i++) {
//            long diff=Integer.parseInt(scanner.nextLine());
//            System.out.println(divisor(diff));
//        }
        divisor(3);

    }

    private static long divisor(long diff) {
        long no2=findPrime(1+diff);
        long no3=findPrime(no2+diff);
        return no2*no3;
    }

    private static long findPrime(long start) {
        long s=start;
        if(isPrime(s)){
            return s;
        }else {
            while (!isPrime(s)){
                s++;
            }
            return s;
        }
    }

    private static boolean isPrime(long value) {
        if(value==2||value==3) return true;
        else {
            long a=(long) Math.sqrt(value);
            for (int i = 2; i <=a; i++) {
                if(value%i==0){
                    return false;
                }
            }
            return true;
        }
    }
}
