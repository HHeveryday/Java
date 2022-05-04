package com.nqc.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试类
 */

public class TestUserService {

    /**
     * 注意：1、必须是公开的，无参数，无返回值，非静态
     * 2、测试方法必须使用@Test注解
     */

    @Test
    public void testLoginName(){
        UserService service = new UserService();
        String rs = service.loginname("admin1", "123456");
        //进行预期结果的正确性测试：断言
        Assert.assertEquals("您的登录业务有问题", "登录成功", rs);
    }

}
