package me.example.training.design.visitor;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 10:37
 */
public interface HouseVisitor {
    /**
     * 沙发
     * @param houseCouch
     */
    void visit(HouseCouch houseCouch);

    /**
     * 电视
     * @param houseTv
     */
    void visit(HouseTv houseTv);

    /**
     * 餐桌
     * @param houseDiningTable
     */
    void visit(HouseDiningTable houseDiningTable);
}
