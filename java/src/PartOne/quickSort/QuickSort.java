package PartOne.quickSort;

/**
 * @author Created by Fangzj
 * @data 2021/3/25 23:35
 **/


public class QuickSort {
    private static int count;

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] num = {6,2,7,3,8,9};
        QuickSort(num, 0, num.length - 1);
        System.out.println("数组个数：" + num.length);
        System.out.println("循环次数：" + count);

    }

    /**
     * 快速排序
     *
     * @param num   排序的数组
     * @param left  数组的前针
     * @param right 数组后针
     */
    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;
        count++;
        QuickSort(num, left, i - 1);
        QuickSort(num, i + 1, right);
    }


}
