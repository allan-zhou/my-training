package me.example.training.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @author zhoujialiang9
 * @date 2021/12/29 9:25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable, Comparable<User> {
    private Integer id;
    private String name;
    private String type;

    @Override
    public int compareTo(User o) {
        return this.getId() - o.getId();
    }
}
