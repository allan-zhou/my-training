package me.example.training.spring.threadpool;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhoujialiang9
 * @date 2023/1/18 17:42
 **/
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolConfigurationProperties {

    private List<ThreadPoolInfo> instances;

}
