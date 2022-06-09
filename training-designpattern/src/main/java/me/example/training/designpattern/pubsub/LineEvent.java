package me.example.training.designpattern.pubsub;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 10:34 PM
 **/
public class LineEvent {
    /**
     * 列车id
     */
    private String id;
    /**
     * 是否在站台
     */
    private boolean isOnThePlatform;
    /**
     * 下一站
     */
    private String nextStation;
    /**
     * 上一站
     */
    private String preStation;

    // 经纬度坐标
}
