package me.example.training.designpattern.factory.simpleFactory;

import lombok.extern.slf4j.Slf4j;
import me.example.training.designpattern.factory.ApplePhone;
import me.example.training.designpattern.factory.IPhone;
import me.example.training.designpattern.factory.XiaoMiPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:28 PM
 **/
@Slf4j
public class Main {

    public static void main(String[] args) {
        int myMoney = 3000;

        if(myMoney >= 5000) {
            ApplePhone applePhone = new ApplePhone();
            applePhone.takePhotos();
            applePhone.turnOnWIFI();
        } else if (myMoney >= 2000 && myMoney < 5000){
            XiaoMiPhone xiaoMiPhone = new XiaoMiPhone();
            xiaoMiPhone.takePhotos();
            xiaoMiPhone.turnOnWIFI();
        } else {
            log.info("其他手机");
        }

    }

}
