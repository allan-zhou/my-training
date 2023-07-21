package me.example.training.spring.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhoujialiang9
 * @date 2023/7/21 16:01
 **/
@Getter
@Setter
public class HelloVO implements Serializable {
    private String key;
    private Integer num;
}
