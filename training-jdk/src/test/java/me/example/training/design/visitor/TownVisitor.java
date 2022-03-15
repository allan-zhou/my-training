package me.example.training.design.visitor;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 小镇的人
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 10:55
 */
@Slf4j
@Data
@Builder
public class TownVisitor implements HouseVisitor {
    private String name;

    @Override
    public void visit(HouseCouch houseCouch) {
        log.info("沙发的颜色没见过~，颜色={}", houseCouch.getColor());
    }

    @Override
    public void visit(HouseTv houseTv) {
        log.info("电视机什么牌子啊，品牌={}", houseTv.getBrand());
    }

    @Override
    public void visit(HouseDiningTable houseDiningTable) {
        log.info("餐桌的款式这么土，款式={}", houseDiningTable.getStyle());
    }
}
