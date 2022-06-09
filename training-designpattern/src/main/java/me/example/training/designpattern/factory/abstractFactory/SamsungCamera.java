package me.example.training.designpattern.factory.abstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 5:20 PM
 **/
@Slf4j
public class SamsungCamera implements ICamera{
    private String name;

    public SamsungCamera(){
        this.name = "samsung三星";
    }

    @Override
    public void focus() {
        log.info("{}，聚焦中。。。", name);
    }
}
