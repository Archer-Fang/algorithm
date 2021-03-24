package Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Fangzj
 * @data 2021/3/23 20:20
 **/
class Common{
    public List<List<Integer>> convert(int[][] tmp){
        List<List<Integer>> nums= new ArrayList<>();
        for (int i=0;i<tmp.length;i++){
            List<Integer> tmp2=new ArrayList<>();
            for (int j=0;j<tmp[i].length;j++){
                tmp2.add(tmp[i][j]);
            }
            nums.add(tmp2);
        }
        return nums;
    }
}

public class TwoDimArrayToTwoDimList {

}
