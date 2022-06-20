package me.example.training.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhoujialiang9
 * @date 2022/6/20 20:49
 **/
@Getter
@Setter
@Builder
public class TestUser {
    private Integer id;
    private String name;
}
