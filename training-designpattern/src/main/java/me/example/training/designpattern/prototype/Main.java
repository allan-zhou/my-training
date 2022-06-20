package me.example.training.designpattern.prototype;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/6/13 8:59 PM
 **/
@Slf4j
public class Main {

    public static void main(String[] args) {
        // 对象
        // 浅拷贝 & 深拷贝
        DollySheep d1 = DollySheep.builder().name("dolly").year(2000).build();

        log.info("clone data={}", JSON.toJSONString(d1.clone()));

        log.info("{}", d1.clone().getClass().equals(d1.getClass()));

        log.info("{}", d1.clone() == d1);

        log.info("{}", d1.clone().equals(d1));

        // 整数
        log.info("============= Integer");
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);

        log.info("{}", i1 == i2);
        log.info("{}", i1 == i2.intValue());
        log.info("{}", i1.equals(i2));

        // 字符串
        log.info("============= 字符串");
        String s1 = "abc";
        String s2 = "a" + "bc";
        String s3 = "a" + new String("bc");

        log.info("{}", s1 == s2);
        log.info("{}", s1 == s3);
        log.info("{}", s1 == s3.intern());
        log.info("{}", s1.equals(s3));

    }
}
