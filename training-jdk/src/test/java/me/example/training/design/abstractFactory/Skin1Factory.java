package me.example.training.design.abstractFactory;


import me.example.training.design.factory.Circle;
import me.example.training.design.factory.IShape;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:56
 */
public class Skin1Factory extends SkinFactory {
    @Override
    public IColor getColor() {
        return new Red();
    }

    @Override
    public IShape getShape() {
        return new Circle();
    }
}
