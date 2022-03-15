package me.example.training.design.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:29
 */
@Slf4j
public class ShapeFactory {
    public static IShape getShape(String type){
        if(type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if(type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if(type.equalsIgnoreCase("square")) {
            return new Square();
        }

        return null;
    }
}
