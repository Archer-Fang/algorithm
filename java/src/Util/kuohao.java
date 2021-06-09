package Util;

import com.sun.deploy.util.StringUtils;

/**
 * @author Created by Fangzj
 * @data 2021/6/5 15:51
 **/
public class kuohao {
    public static void main(String[] args) {

        String s="[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]"
                .replace("[","{").replace("]","}");
        System.out.println(s);
    }
}
