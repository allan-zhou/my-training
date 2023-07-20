package me.example.training.domain;

import lombok.*;

/**
 * @author zhoujialiang9
 * @date 2021/12/29 9:25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;
    private String name;
    private String type;
}
