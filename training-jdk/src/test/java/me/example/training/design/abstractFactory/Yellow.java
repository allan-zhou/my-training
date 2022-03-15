package me.example.training.design.abstractFactory;

import lombok.extern.slf4j.Slf4j;
import me.example.training.design.abstractFactory.IColor;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:37
 */
@Slf4j
public class Yellow implements IColor {
    @Override
    public void fill() {
        log.info("填充黄色");
    }
}
