package me.example.training.domain;

/**
 * @author zhoujialiang9
 * @date 2024/6/17 10:51
 **/
public class Son extends Father{

    public void hello() {
        System.out.println("son say hello.");
    }

    public void hi(){
        System.out.println("son say hi.");
    }

    public void nihao(){
       super.nihao();
    }


}
