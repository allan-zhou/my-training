package me.example.training.spring.service;

/**
 * @author zhoujialiang9
 * @date 2023/3/13 20:18
 **/
public interface MyCartService {
    /**
     * 查询购物车
     * @param pin
     * @return
     */
    String cartQuery(String pin);
}
