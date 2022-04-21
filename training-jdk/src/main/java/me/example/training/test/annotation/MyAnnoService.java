package me.example.training.test.annotation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/4/21 4:30 PM
 **/
@Slf4j
public class MyAnnoService {

    @MyDesc(description = "干活儿")
    public void doSomething(@MyParam(name = "userName", defaultValue = "zhang san") String userName){

        log.info(userName + " do something...");

    }
}
