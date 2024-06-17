package me.example.training.export;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2024/6/15 14:56
 **/
@Slf4j
public class ClassA implements InterfaceA{

    @Override
    public String action() {
        String str = this.getClass().getCanonicalName() + " action.";

        return str;
    }
}
