package me.example.training.design.abstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:36
 */
@Slf4j
public class Blue implements IColor {
    @Override
    public void fill() {
        log.info("填充蓝色");
    }
}
