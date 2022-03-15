package me.example.training.design.visitor;


/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 10:37
 */
public interface HouseElement {
    void accept(HouseVisitor visitor);
}
