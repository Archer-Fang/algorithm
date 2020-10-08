import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {
    public static void setAdd(TreeSet<Integer> set, Integer i){
        if(!set.add(i)){
            set.remove(i);
            setAdd(set,i<<1);
        }
}
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();     Integer[] array = new Integer[n];  for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        TreeSet<Integer> res = new TreeSet<>((x,y)->(y-x));
        for (int i = 0; i < array.length; i++) { setAdd(res,array[i]);  }
        Iterator<Integer> iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
