package Util;

import com.sun.deploy.util.StringUtils;

/**
 * @author Created by Fangzj
 * @data 2021/6/5 15:51
 **/
public class kuohao {
    public static void main(String[] args) {

        String s="[[1,3,1],[1,5,1],[4,2,1]]"
                .replace("[","{").replace("]","}");
        System.out.println(s);
    }
}
