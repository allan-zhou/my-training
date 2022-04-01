package me.example.training.test.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 局部内部类
 *
 * @author zhoujialiang9
 * @date 2022/4/1 3:35 PM
 **/
@Slf4j
public class OutClass2 {

    private String name;

    private String city;

    public OutClass2(String name, String city) {
        this.name = name;
        this.city = city;

        log.info("outClass 初始化。");
    }

    @Override
    public String toString() {
        return "OutClass2{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


    public void doSomething(String s){

        class InnerClass {

            private String name;

            public InnerClass(){}

            public InnerClass(String name){
                this.name = name;
            }

            @Override
            public String toString() {
                return "InnerClass{" +
                        "name='" + name + '\'' +
                        '}';
            }

            public void setName(){
                this.name = s;
            }

            public void doSomething(){

                log.info("内部类, doSomething... {}", s);

            }

        }

        InnerClass innerClass = new InnerClass("my inner");
        log.info("内部类：{}", innerClass);

        innerClass.doSomething();

    }

    public static void main(String[] args) {
        OutClass2 outClass2 = new OutClass2("zhang san", "beijing");

        outClass2.doSomething("XXX");

    }

}
