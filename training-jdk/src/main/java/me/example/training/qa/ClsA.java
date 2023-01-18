package me.example.training.qa;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/8/9 17:48
 **/

@Slf4j
public class ClsA {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("me.example.training.qa.ClsB");

            log.info("class name={}", aClass.getCanonicalName());

            Class aClass2 = Class.forName("me.example.training.qa.ClsB_1");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            log.error("ClassNotFoundException={}", e);
        }

    }
}
