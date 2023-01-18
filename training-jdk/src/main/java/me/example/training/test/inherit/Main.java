package me.example.training.test.inherit;


import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/6/13 8:20 PM
 **/
@Slf4j
public class Main {
    public static void main(String[] args) {

        try {
            Parent parent = new Parent();
            parent.say();

            Child child = new Child();
            child.say();

            log.info("class loader name={}", Main.class.getClass().getClassLoader().getClass().getSimpleName());



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
