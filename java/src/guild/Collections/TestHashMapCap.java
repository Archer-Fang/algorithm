package guild.Collections;

/**
 * @author Created by Fangzj
 * @data 2021/4/6 10:24
 **/

public class TestHashMapCap {
    public static void main(String[] args) {
        int cap=31;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int r=(n < 0) ? 1 : (n >= 16) ? 16 : n + 1;
        System.out.println();
    }
}
