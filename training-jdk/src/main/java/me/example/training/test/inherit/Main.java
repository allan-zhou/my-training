package me.example.training.test.inherit;


/**
 * @author zhoujialiang9
 * @date 2022/6/13 8:20 PM
 **/
public class Main {
    public static void main(String[] args) {

        try {
            Object child = new Child();

//            Class<Child> childClass = Child.class;
//            Constructor constructor =  childClass.getDeclaredConstructor();
//            Object child =  constructor.newInstance();

            Parent parent = (Parent) child;

            parent.say();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
