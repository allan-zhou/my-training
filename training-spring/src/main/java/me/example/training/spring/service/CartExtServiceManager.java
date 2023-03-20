package me.example.training.spring.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.inerface.CartExtService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author zhoujialiang9
 * @date 2023/3/13 21:31
 **/
@Slf4j
public class CartExtServiceManager {

    private static Map<String, CartExtService> map = new HashMap<>();

    private static CartExtService first = null;

    static {
        ServiceLoader<CartExtService> serviceLoader = ServiceLoader.load(CartExtService.class);

        Iterator<CartExtService> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            CartExtService cartExtService = iterator.next();
            if(first == null) {
                first = cartExtService;
            }

            map.put(cartExtService.getClass().getCanonicalName(), cartExtService);
        }

        log.info("CartExtServiceManager初始化完成，map={}", JSON.toJSONString(map));

    }

    public static CartExtService getFirsetCartExtService(){
        return first;
    }

    public static CartExtService getCartExtService(String name){
        return map.get(name);
    }
}
