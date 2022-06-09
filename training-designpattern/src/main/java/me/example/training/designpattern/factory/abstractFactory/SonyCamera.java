package me.example.training.designpattern.factory.abstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 5:22 PM
 **/
@Slf4j
public class SonyCamera implements ICamera {
    private String name;

    public SonyCamera(){
        this.name = "sony索尼";
    }

    @Override
    public void focus() {
        log.info("{}，聚焦中。。。", name);
    }
}
