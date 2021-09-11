package ShiXi.tenxun.qtenxunv4ermian;

/**
 * @author Created by Fangzj
 * @data 2021/5/12 21:42
 **/
//1. ip统计 4G文件统计最频繁的10个ip
//要解决该问题首先要找到一种分类方式，把重复出现的IP都放到一个文件里面，一共分成100份，这可以通过把IP对100取模得到，具体方法如去掉IP中的点转化为一个long型变量，这样取模为0,1,2...99的IP都分到一个文件了。
// 那么这个分就能保证每一文件都能载入内存吗？这可不一定，万一模为9的IP特别多怎么办，可以再对这一类IP做一次取模，直到每个小文件足够载入内存为止。
// 这个分类很关键，如果是随便分成100份，相同的IP被分在了不同的文件中，接下来再对每个文件统计次数并做归并，这个思路就没有意义了。
//
//好了，接下来把每个小文件载入内存，建立哈希表unordered_map<string,int>，将每个IP作为关键字映射为出现次数，这个哈希表建好之后也得先写入硬盘，因为内存就那么多。
//
//在统计完100个文件之后，我再建立一个小顶堆，大小为100，把建立好并存在硬盘哈希表载入内存，逐个对出现次数排序，挑出出现次数最多的100个，由于次数直接和IP是对应的，找出最多的次数也就找出了相应的IP。
//
//2. 0-xy的概率问题。实质为 将1~n数组随机打乱顺序，生成一个新的数组
//思路：
//每次随机获得一个数，将其对应的元素与“最后一个元素”交换位置
//随机数随着遍历，最大范围依次减一，所谓“最后一个元素”也在变化
//
//3. 数组中重复的大于1/2 时间复杂度O(n) 空间复杂度O(1) lc75 ,本人当时只想到时空复杂度都为O（N）的，依赖hashmap。
//https://www.cnblogs.com/zl1991/p/13109760.html
public class Test {
}