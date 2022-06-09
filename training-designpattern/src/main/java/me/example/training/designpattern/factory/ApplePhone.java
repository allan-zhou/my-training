package me.example.training.designpattern.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:34 PM
 **/
@Slf4j
public class ApplePhone implements IPhone {
    private String name;

    public ApplePhone(){
        this.name = "苹果手机";
    }

    public ApplePhone(String name) {
        this.name = name;
    }

    @Override
    public void takePhotos() {
        log.info( "{}，开始拍照", name);
    }

    @Override
    public void turnOnWIFI() {
        log.info( "{}，打开了wifi", name);
    }
}
