package me.example.training.domain;

import cn.hutool.core.util.StrUtil;

import java.io.Serializable;

/**
 * @author zhoujialiang9
 * @date 2024/6/17 10:50
 **/
public class Father {

    /**
     * 方法的分派：
     * 调用hello，使用的指令是invokespecial，在类加载阶段可以确定具体调用哪个方法
     * 调用hi、nihao，使用的治理是invokevirtual，在运行时去解析使用哪个方法
     *
     * 类加载：
     * 加载-链接（验证、准备、解析）-初始化-使用-卸载
     *
     */
    public void say(){
        System.out.println("i am father.");
        System.out.println(this);
        this.hello();
        this.hi();
        this.nihao();
    }

    private void hello(){
        System.out.println("father say hello.");
    }

    public void hi(){
        System.out.println("father say hi.");
    }

    /**
     * protected修饰符，使用invokevirtual调用
     */
    protected void nihao(){
        System.out.println("father say nihao.");
    }

    /**
     * final方法，不能被子类重写
     */
    public final void notOverride(){
        System.out.println("father notOverride.");
    }

    public String speak(Integer msg) {
        String content = StrUtil.format("father speak Integer={}.", msg);
        System.out.println(content);
        return content;
    }

    public String speak(int msg) {
        String content = StrUtil.format("father speak int={}.", msg);
        System.out.println(content);
        return content;
    }

    public String speak(String msg) {
        String content = StrUtil.format("father speak string={}.", msg);
        System.out.println(content);
        return content;
    }

    public String speak(Object msg) {
        String content = StrUtil.format("father speak object={}.", msg);
        System.out.println(content);
        return content;
    }

    public String speak(Serializable msg) {
        String content = StrUtil.format("father speak Serializable={}.", msg);
        System.out.println(content);
        return content;
    }
}
