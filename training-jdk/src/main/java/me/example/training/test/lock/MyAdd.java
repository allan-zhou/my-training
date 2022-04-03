package me.example.training.test.lock;

/**
 * @author zhoujialiang9
 * @date 2022/4/2 1:41 PM
 **/
public class MyAdd {
    private Integer total = 0;

    // 方案1：synchronized 声明
    // 方案2：手动加锁, 详见LockTest2
    // 方案3：thread join
    public Integer increase() {
        return total++;
    }

    public Integer getTotal(){
        return total;
    }
}
