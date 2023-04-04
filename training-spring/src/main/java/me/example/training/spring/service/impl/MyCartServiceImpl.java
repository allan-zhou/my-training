package me.example.training.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.example.training.export.CartServiceExport;
import me.example.training.spring.service.CartExportServiceManager;
import me.example.training.spring.service.MyCartService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * @author zhoujialiang9
 * @date 2023/3/13 20:20
 **/
@Slf4j
@Service
public class MyCartServiceImpl implements MyCartService{

    CartServiceExport cartExtService = CartExportServiceManager.getFirsetCartExtService();

    @PostConstruct
    private void init(){
        // 调用扩展点方法
        String name = cartExtService.getName();

        log.info("调用扩展点方法， 结果={}", name);
    }

    @Override
    public String cartQuery(String pin) {
        log.info("查询购物车，pin={}", pin);


        return "ok";
    }
}
