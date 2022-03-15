package me.example.training.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 10:58
 */
public class HouseThing {
    private List<HouseElement> houseElements = new ArrayList<>();

    /**
     * 添加元素
     * @param element
     */
    public void addThing(HouseElement element){
        houseElements.add(element);
    }

    public void feel(HouseVisitor visitor){
        for (HouseElement element: houseElements) {
            element.accept(visitor);
        }
    }
}
