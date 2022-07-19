package me.example.training.spring.controller;

import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.spring.domain.ComQuery;
import org.apache.commons.lang3.StringUtils;
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
    public String hello(HttpServletRequest request, ComQuery comQuery){

        log.info("query={}", JSON.toJSONString(comQuery));

        if(StringUtils.isNotBlank(comQuery.getKey())) {
            log.info("key={}, origin key={}", comQuery.getKey(), StringUtils.replaceChars(comQuery.getKey(), " ", "+"));
        }

        if(StringUtils.isNotBlank(request.getParameter("key"))) {
            log.info("key={}, origin key={}", request.getParameter("key"), StringUtils.replaceChars(request.getParameter("key"), " ", "+"));
        }


        return JSON.toJSONString(comQuery);
    }
}
