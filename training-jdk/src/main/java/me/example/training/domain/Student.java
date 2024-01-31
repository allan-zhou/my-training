package me.example.training.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author zhoujialiang9
 * @date 2022/6/2 11:25 AM
 **/
@Getter
@Setter
public class Student extends User {
    private Integer studentNumber;
    private Map<Long, String> tags;
}
