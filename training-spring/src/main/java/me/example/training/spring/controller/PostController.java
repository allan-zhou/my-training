package me.example.training.spring.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.spring.domain.query.ComQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhoujialiang9
 * @date 2023/6/21 14:45
 **/
@Slf4j
@RestController
public class PostController {

    @RequestMapping("/post")
    public String hello(ComQuery getComQuery, @RequestBody ComQuery postComQuery){

        log.info("get params={}", JSON.toJSONString(getComQuery));
        log.info("post params={}", JSON.toJSONString(postComQuery));

        return "ok";
    }
}
