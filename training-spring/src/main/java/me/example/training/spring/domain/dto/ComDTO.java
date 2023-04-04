package me.example.training.spring.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhoujialiang9
 * @date 2023/3/20 17:28
 **/
@Getter
@Setter
public class ComDTO implements Serializable {
    private String key;
    private Integer num;
}
