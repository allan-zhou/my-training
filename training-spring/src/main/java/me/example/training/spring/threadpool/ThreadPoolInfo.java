package me.example.training.spring.threadpool;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhoujialiang9
 * @date 2023/1/18 18:04
 **/
@Getter
@Setter
public class ThreadPoolInfo {
    /**
     * 名称
     */
    private String name;
    /**
     * 核心线程数
     */
    private  int corePoolSize = 1;
    /**
     * 最大线程数
     */
    private  int maxPoolSize = 5;
    /**
     * 保活时长(秒)
     */
    private long keepAliveTime = 1000;
    /**
     * 队列长度
     */
    private  int queueCapacity = 100;
}
