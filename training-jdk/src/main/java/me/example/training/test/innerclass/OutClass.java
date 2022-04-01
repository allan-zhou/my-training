package me.example.training.test.innerclass;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 成员内部类
 *
 * @author zhoujialiang9
 * @date 2022/4/1 1:49 PM
 **/
@Slf4j
public class OutClass {

    private String name;

    private String city;

    private List<InnerClass> innerClassList =new ArrayList<>();


    public OutClass(String name, String city) {
        this.name = name;
        this.city = city;

        log.info("outClass 初始化。");
    }

    @Override
    public String toString() {
        return "OutClass{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", innerClassList=" + innerClassList +
                '}';
    }

    public void createInner(String s){
        InnerClass innerClass = new InnerClass(s);

        innerClassList.add(innerClass);
    }


    class InnerClass {
        // 允许存在与外部类同名的成员属性
        String name = "";

        public InnerClass(String name){
            this.name = name;

            log.info("inner class 初始化。 name={}。 我的外部类信息：name={}, city={}", name, OutClass.this.name, OutClass.this.city);
        }

        @Override
        public String toString() {
            return "InnerClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass("zhang san", "beijing");

        log.info(outClass.toString());


        for (int i = 1; i <= 10; i++) {
            outClass.createInner("zhang san - 0" + i);
        }

        log.info(outClass.toString());

        // 从外部实例化，内部类
        OutClass.InnerClass innerClass = outClass.new InnerClass("aaa");

    }

}
