package com.nqc.junit;

/**
 * 业务方法
 */

public class UserService {
    public String loginname(String name, String psd){
        if ("admin".equals(name) && "123456".equals(psd)){
            return "登录成功";
        }else {
            return "登录失败";
        }
    }

    public void selectNames(){
        System.out.println(10/0);
        System.out.println("查询成功");
    }
}
