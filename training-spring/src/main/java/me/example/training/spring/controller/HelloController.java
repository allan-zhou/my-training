package me.example.training.spring.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.spring.domain.convert.HelloConvert;
import me.example.training.spring.domain.query.HelloQuery;
import me.example.training.spring.domain.vo.HelloVO;
import me.example.training.spring.domain.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhoujialiang9
 * @date 2022/7/18 17:23
 **/
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public ResultVO hello(HttpServletRequest request, HelloQuery helloQuery){

        log.info("comQuery={}", JSON.toJSONString(helloQuery));

        // 转VO
        HelloVO helloVO = HelloConvert.INSTANCE.convert2HelloVO(helloQuery);

        log.info("VO={}", JSON.toJSONString(helloVO));

        return ResultVO.success(helloVO);
    }

    @RequestMapping("/hello2")
    public String hello2(HttpServletRequest request,@RequestBody HelloQuery helloQuery){

        log.info("request.getParameter key={}", request.getParameter("key"));

        log.info("comQuery={}", JSON.toJSONString(helloQuery));

        return JSON.toJSONString(helloQuery);
    }
}
