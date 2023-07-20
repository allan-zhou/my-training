package me.example.training.spring.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhoujialiang9
 * @date 2023/7/18 20:48
 **/
@Slf4j
@WebFilter(filterName = "ParamFilter", urlPatterns = "/*")
@Component
public class RequestParamFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("doFilterInternal");

        ModifiableHttpServletRequestWrapper requestWrapper = new ModifiableHttpServletRequestWrapper(request);
        filterChain.doFilter(requestWrapper, response);
    }
}
