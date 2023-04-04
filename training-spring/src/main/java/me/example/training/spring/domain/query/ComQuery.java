package me.example.training.spring.domain.query;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhoujialiang9
 * @date 2022/7/18 17:25
 **/
@Getter
@Setter
public class ComQuery implements Serializable {
    private String key;
    private Integer num;
}
