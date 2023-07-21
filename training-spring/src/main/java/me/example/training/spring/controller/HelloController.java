package me.example.training.spring.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.spring.domain.convert.ComConvert;
import me.example.training.spring.domain.convert.HelloConvert;
import me.example.training.spring.domain.dto.ComDTO;
import me.example.training.spring.domain.query.ComQuery;
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
    public ResultVO hello(HttpServletRequest request, ComQuery comQuery){

        log.info("comQuery={}", JSON.toJSONString(comQuery));

        // 转VO
        HelloVO helloVO = HelloConvert.INSTANCE.convert2HelloVO(comQuery);

        log.info("VO={}", JSON.toJSONString(helloVO));

        return ResultVO.success(helloVO);
    }

    @RequestMapping("/hello2")
    public String hello2(HttpServletRequest request,@RequestBody ComQuery comQuery){

        log.info("request.getParameter key={}", request.getParameter("key"));

        log.info("comQuery={}", JSON.toJSONString(comQuery));

        return JSON.toJSONString(comQuery);
    }
}
