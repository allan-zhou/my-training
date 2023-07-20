package me.example.training.spring.domain.query;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhoujialiang9
 * @date 2023/6/21 14:47
 **/
@Getter
@Setter
public class MyUser implements Serializable {
    private String id;
    private String name;
}
