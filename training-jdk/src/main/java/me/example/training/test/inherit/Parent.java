package me.example.training.test.inherit;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/6/13 8:19 PM
 **/
@Getter
@Setter
@Slf4j
public class Parent {
    private String name;

    public Parent(){
        this.name = "parent";

        log.info("Parent - class loader name={}", this.getClass().getClassLoader().getClass().getSimpleName());

    }

    public void say(){
        log.info("i am parent. name={}", name);
    }

}
