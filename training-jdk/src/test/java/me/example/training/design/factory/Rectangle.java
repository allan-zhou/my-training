package me.example.training.design.factory;

import lombok.extern.slf4j.Slf4j;
import me.example.training.design.factory.IShape;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:26
 */
@Slf4j
public class Rectangle implements IShape {
    @Override
    public void draw() {
        log.info("画一个长方形");
    }
}
