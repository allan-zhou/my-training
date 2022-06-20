package me.example.training.designpattern.prototype;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 多莉羊
 *
 * @author zhoujialiang9
 * @date 2022/6/13 8:58 PM
 **/
@Getter
@Setter
@Builder
public class DollySheep implements Cloneable {
    private String name;
    private Integer year;


    @Override
    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
