package me.example.training.design.abstractFactory;

import lombok.extern.slf4j.Slf4j;
import me.example.training.design.abstractFactory.IColor;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:35
 */
@Slf4j
public class Red implements IColor {
    @Override
    public void fill() {
        log.info("填充红色");
    }
}
