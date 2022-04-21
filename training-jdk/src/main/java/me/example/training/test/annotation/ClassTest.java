package me.example.training.test.annotation;

import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zhoujialiang9
 * @date 2022/4/21 11:22 AM
 **/
@Slf4j
public class ClassTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Class<MyAnnoService> annoServiceClass = MyAnnoService.class;

        for (Method method: annoServiceClass.getDeclaredMethods()) {

            printMethodAnnoInfo(method);

        }

        MyAnnoService myAnnoService = annoServiceClass.newInstance();

        myAnnoService.doSomething("abc");

    }

    private static void printMethodAnnoInfo(Method method){
        log.info("method = {}", method.getName());

        log.info("方法的注解：");

        if(method.isAnnotationPresent(MyDesc.class)){

            MyDesc myDesc = method.getAnnotation(MyDesc.class);

            log.info("MyDesc内容：{}", myDesc.description());
        }

        log.info("方法参数的注解：");


        for (int i = 0; i < method.getParameterAnnotations().length; i++) {

            for (Annotation ma: method.getParameterAnnotations()[i]) {

                if (ma instanceof MyParam) {
                    MyParam param = (MyParam)ma;

                    log.info("param name={}, defaultValue={}", param.name(), param.defaultValue());
                }

            }
        }

    }

}
