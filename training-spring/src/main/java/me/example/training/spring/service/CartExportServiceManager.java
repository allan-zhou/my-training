package me.example.training.spring.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.export.CartServiceExport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author zhoujialiang9
 * @date 2023/3/13 21:31
 **/
@Slf4j
public class CartExportServiceManager {

    private static Map<String, CartServiceExport> map = new HashMap<>();

    private static CartServiceExport first = null;

    static {
        ServiceLoader<CartServiceExport> serviceLoader = ServiceLoader.load(CartServiceExport.class);

        Iterator<CartServiceExport> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            CartServiceExport cartServiceExport = iterator.next();
            if(first == null) {
                first = cartServiceExport;
            }

            map.put(cartServiceExport.getClass().getCanonicalName(), cartServiceExport);
        }

        log.info("CartExportServiceManager 初始化完成，map={}", JSON.toJSONString(map));

    }

    public static CartServiceExport getFirsetCartExtService(){
        return first;
    }

    public static CartServiceExport getCartExtService(String name){
        return map.get(name);
    }
}
