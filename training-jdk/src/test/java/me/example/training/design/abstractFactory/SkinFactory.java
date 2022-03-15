package me.example.training.design.abstractFactory;

import me.example.training.design.factory.IShape;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:38
 */
public abstract class SkinFactory {
    public abstract IColor getColor();
    public abstract IShape getShape();
}
