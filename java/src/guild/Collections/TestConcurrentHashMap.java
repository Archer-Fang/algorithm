package guild.Collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Created by Fangzj
 * @data 2021/5/6 15:36
 **/
public class TestConcurrentHashMap {
    public static void main(String[] args) {

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>(16, 0.75f);
        map.put("key", "value2");
    }
}
