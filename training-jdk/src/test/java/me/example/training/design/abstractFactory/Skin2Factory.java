package me.example.training.design.abstractFactory;

import me.example.training.design.factory.IShape;
import me.example.training.design.factory.Square;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:57
 */
public class Skin2Factory extends SkinFactory {
    @Override
    public IColor getColor() {
        return new Blue();
    }

    @Override
    public IShape getShape() {
        return new Square();
    }
}
