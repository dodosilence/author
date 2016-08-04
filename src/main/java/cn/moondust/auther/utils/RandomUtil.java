package cn.moondust.auther.utils;

import java.util.Random;

/**
 * Created by j0 on 2016/8/4.
 */
public class RandomUtil {
    public static String numberRedom(int howlong) {
        if (howlong<=0){
            return "";
        }
        Random random = new Random();
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < howlong; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}
