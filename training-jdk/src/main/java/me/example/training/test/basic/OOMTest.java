package me.example.training.test.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存溢出：Out Of Memory。
 * 1、java堆溢出
 * 2、栈溢出（java栈、本地方法栈）
 * 3、直接内存溢出、方法区溢出
 *
 * 常见参数设置：
 * -Xms：初始堆大小
 * -Xmx：最大堆大小
 * -Xmn：新生代大小
 *
 * 垃圾回收器：
 * - 查看JVM使用的默认GC回收器：java -XX:+PrintCommandLineFlags -version
 * - 分代收集器：新生代（serial，ParallelNew，Parallel scavenge），老年代（serial Old，Parallel Old，CMS）
 * - 分区收集器：G1、ZGC（java 17）
 *
 * - 概念：GC Root、SafePoint安全点、SafeRegion
 * - Serial：单线程。
 * - Parallel：串行的多线程版本。
 * - Parallel Scavenge：注重的吞吐量；自适应；
 * - CMS：划时代、真正意义并发的GC。注重减少STW停顿时长
 * **** 4个步骤： 1、初始标记（GC Root） 2、并发标记（引用链） 3、重新标记（并发期间新生成的对象） 4、并行整理。
 * **** 3个问题：1、CPU敏感 2、浮动垃圾 3、Mark Sweep标记-清除算法，多少次full gc进行一次带压缩的full gc
 * - G1：把java堆化整为零。
 * **** 执行步骤：与CMS相似。其中，第4步不同，G1是并行执行。
 * **** 特点：可预测停顿时长
 *
 *
 * 文章参考：
 * GC概述及常见问题 https://tech.meituan.com/2020/11/12/java-9-cms-gc.html
 *
 * @author zhoujialiang9
 * @date 2022/7/21 10:45
 **/
@Slf4j
public class OOMTest {

    public static void main(String[] args) {
        //oomHeap();

        //oomStack();

        try {

            int i = 0;
            while (true) {
                int duration = 1000 * 3;

                log.info("sleep time = {}s", i++ * duration/1000);

                Thread.sleep(duration);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 堆溢出
     */
    public static void oomHeap() {

        List<Object> objectList = new ArrayList<>();

        while (true) {
            objectList.add(new Object());
        }
    }

    private static int loop = 0;
    /**
     * 栈溢出
     * Exception in thread "main" java.lang.StackOverflowError
     */
    public static void oomStack() {
        while (true) {
            log.info("loop={}", loop++);
            oomStack();
        }
    }


}
