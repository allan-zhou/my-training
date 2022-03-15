package me.example.training.design.visitor;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 10:44
 */
@Slf4j
@Data
@Builder
public class HouseDiningTable implements HouseElement {
    private String style;

    @Override
    public void accept(HouseVisitor visitor) {
        visitor.visit(this);
    }
}
