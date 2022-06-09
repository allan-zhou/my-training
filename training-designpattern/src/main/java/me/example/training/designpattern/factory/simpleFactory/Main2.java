package me.example.training.designpattern.factory.simpleFactory;

import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:50 PM
 **/
public class Main2 {

    /**
     * 简单工厂（静态工厂）
     *
     * - 将客户端的 if/else逻辑 移动至静态工厂
     *
     *
     */
    public static void main(String[] args) {
        int myMoney = 3000;

        IPhone phone = SimplePhoneFactory.createPhone(myMoney);
        phone.takePhotos();
        phone.turnOnWIFI();
    }
}
