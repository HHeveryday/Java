package com.nqc.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志框架快速入门，记录程序的执行情况到控制台和文件中
 */
public class Test {

    //1、创建logback的日志对象，代表了日志技术

    public static final Logger LOGGER = LoggerFactory.getLogger("Test.class");
    public static void main(String[] args) {
        try {
            LOGGER.debug("开始执行程序~");
            LOGGER.info("开始进行除法运算~");
            int a = 10;
            int b = 0;
            LOGGER.trace("a=" + a);
            LOGGER.trace("b=" + b);
            System.out.println(a / b);
        } catch (Exception e){
            e.printStackTrace();
            LOGGER.error("功能出现异常，" + e);
        }

    }
}
