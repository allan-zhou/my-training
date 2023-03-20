package me.example.training.spi;

import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.inerface.CartExtService;

/**
 * @author zhoujialiang9
 * @date 2023/3/13 20:41
 **/
@Slf4j
public class CartExtServiceImpl implements CartExtService {
    @Override
    public String getName() {
        String result = "Apple";

        log.info("cart扩展点服务，获取名称，result={}", result);

        return result;
    }
}
