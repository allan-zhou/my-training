package me.example.training.spring.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhoujialiang9
 * @date 2023/7/21 15:33
 **/
@Getter
@Setter
public class ABResultVO implements Serializable {
    /**
     * 实验id
     */
    private String expId;
    /**
     * 实验分流版本
     */
    private String label;
}
