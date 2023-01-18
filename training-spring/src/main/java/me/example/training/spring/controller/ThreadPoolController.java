package me.example.training.spring.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.spring.domain.ComQuery;
import me.example.training.spring.threadpool.ThreadPoolManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

/**
 * @author zhoujialiang9
 * @date 2023/1/18 18:40
 **/
@Slf4j
@RestController
public class ThreadPoolController {

    @Resource
    private ThreadPoolManager threadPoolManager;

    @RequestMapping("/threadPool/status")
    public void status(String name){
        threadPoolManager.getThreadPoolStatus(name);
    }

    @RequestMapping("/threadPool/exe")
    public void exe(String name, Integer num){
        ExecutorService executorService = threadPoolManager.getThreadPoolExecutor(name);

        for (int i = 0; i < num; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    log.info("线程池name={}, 执行了任务", name);
                }
            });
        }
        threadPoolManager.getThreadPoolStatus(name);
    }
}
