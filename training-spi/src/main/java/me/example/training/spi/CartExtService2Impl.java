package me.example.training.spi;

import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.inerface.CartExtService;

/**
 * @author zhoujialiang9
 * @date 2023/3/13 21:43
 **/
@Slf4j
public class CartExtService2Impl implements CartExtService {
    @Override
    public String getName() {
        String result = "HUAWEI";

        log.info("cart扩展点服务，新方法实现，获取名称，result={}", result);

        return result;
    }
}
