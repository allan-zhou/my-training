package me.example.training.spring.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author zhoujialiang9
 * @date 2023/1/18 17:47
 **/
@Slf4j
@Component
public class ThreadPoolManager {

    @Resource
    private ThreadPoolConfigurationProperties threadPoolConfigurationProperties;

    private Map<String, ExecutorService> executorServiceMap = new HashMap<>();

    @PostConstruct
    public void init(){
        List<ThreadPoolInfo> threadPoolInfos = threadPoolConfigurationProperties.getInstances();

        if(CollectionUtils.isEmpty(threadPoolInfos)) {
            log.error("线程池配置为空");
            return;
        }

        threadPoolInfos.forEach(item->{

            ExecutorService executorService = createThreadPoolExecutor(item);

            executorServiceMap.put(item.getName(), executorService);

            log.info("线程池初始化完成。name={}", item.getName());
        });


    }

    public ExecutorService createThreadPoolExecutor(ThreadPoolInfo threadPoolInfo){

        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(threadPoolInfo.getQueueCapacity());

        ExecutorService executorService = new ThreadPoolExecutor(
                threadPoolInfo.getCorePoolSize(),
                threadPoolInfo.getMaxPoolSize(),
                threadPoolInfo.getKeepAliveTime(),
                TimeUnit.SECONDS,
                workQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        return executorService;
    }

    public ExecutorService getThreadPoolExecutor(String name){
        if(StringUtils.isEmpty(name)) {
            log.error("参数name不能为空");
        }

        ExecutorService executorService = executorServiceMap.get(name);
        if(executorService == null) {
            log.error("线程池配置异常，不存在该线程池。name={}", name);
            return null;
        }

        return executorService;
    }

    public void getThreadPoolStatus(String name){

        ThreadPoolExecutor threadPool = (ThreadPoolExecutor)getThreadPoolExecutor(name);

        log.info("线程池名称={}", name);
        log.info("线程池中约定的核心线程数:" + threadPool.getCorePoolSize());
        log.info("线程池中约定的最大线程数:" + threadPool.getMaximumPoolSize());
        log.info("线程池中的当前线程数:" + threadPool.getPoolSize());
        log.info("线程池中的当前活动线程数:" + threadPool.getActiveCount());
        log.info("曾计划执行的近似任务总数:" + threadPool.getTaskCount());
        log.info("已完成执行的近似任务总数:" + threadPool.getCompletedTaskCount());
        log.info("池中曾出现过的最大线程数:" + threadPool.getLargestPoolSize());
        log.info("线程池当前排队线程数:" + threadPool.getQueue().size());
    }
}
