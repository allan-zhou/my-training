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
public class Child extends Parent {
    private String name;

    public Child(){
        this.name = "child";
    }

    public void say(){
        log.info("i am Child.");
    }
}
