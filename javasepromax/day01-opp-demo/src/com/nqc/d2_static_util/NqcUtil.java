package com.nqc.d2_static_util;

import java.util.Random;

/**
 * 工具类
 */
public class NqcUtil {

    /**
        注意：由于工具类无需创建对象，所以把其构造器私有化
     */

    private NqcUtil(){

    }

    public static String createverifycode(int n){
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r =new Random();
        for (int i = 0; i < n; i++) {
            int index = r.nextInt(data.length());
            code += data.charAt(index);
        }
        return code;
    }
}
