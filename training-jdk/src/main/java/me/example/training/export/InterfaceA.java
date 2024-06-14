package me.example.training.export;

/**
 *
 *
 * @author zhoujialiang9
 * @date 2024/6/13 10:07
 **/
public interface InterfaceA {
    int NUM = 123456;

    String action();

    default String defaultAction(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("className=").append(this.getClass().getCanonicalName());
        stringBuilder.append(",").append("defaultAction");
        stringBuilder.append(",").append("num=").append(NUM);

        return stringBuilder.toString();
    }

    static String hello(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("hello");
        stringBuilder.append(",").append("className=").append(InterfaceA.class.getSimpleName());
        stringBuilder.append(",").append("num=").append(NUM);

        return stringBuilder.toString();
    }
}
