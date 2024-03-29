package PartOne.Stack;

import java.util.ArrayList;
import java.util.List;

public class RandomList {
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args)
            result.add(item);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> ls2 = makeList(2, 1, 3);
        System.out.println(ls2);

    }
}