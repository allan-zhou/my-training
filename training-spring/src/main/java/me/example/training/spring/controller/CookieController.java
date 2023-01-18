package me.example.training.spring.controller;

import cn.hutool.extra.servlet.ServletUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.spring.domain.ComQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author zhoujialiang9
 * @date 2022/8/16 20:11
 **/
@Slf4j
@RestController
public class CookieController {

    @RequestMapping("/cookie/add")
    public String hello(HttpServletRequest request, HttpServletResponse response){

        //ServletUtil.addCookie(response, buildCookie("updateTime", String.valueOf(System.currentTimeMillis() / 1000)));

        response.addCookie(buildCookie("updateTime", String.valueOf(System.currentTimeMillis() / 1000)));

        return "ok";
    }

    private Cookie buildCookie(String name, String value){
        Cookie cookie = new Cookie(name, value);

        cookie.setDomain("localhost");
        cookie.setPath("/");
        // 1年
        cookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(365));
        return cookie;

    }
}
