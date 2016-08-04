package cn.moondust.auther.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by j0 on 2016/8/3.
 */
public class PatternUtil {

    private PatternUtil(){}

    public static boolean isPhone(String phoneNum) {

        Pattern p1 = Pattern.compile("^((\\+{0,1}86){0,1})1[0-9]{10}");
        Matcher m1 = p1.matcher(phoneNum);
        if (m1.matches()) {

            return true;

        } else {
            return false;
        }
    }
}
