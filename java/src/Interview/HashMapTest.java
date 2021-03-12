package Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by Fangzj
 * @data 2021/3/11 15:57
 **/
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>(310);
        map.put("Android", 1);
        map.put("Java", 2);
        map.put("iOS", 3);
        map.put("数据挖掘", 4);
        map.put("产品经理", 5);
    }

}
