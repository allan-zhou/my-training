package me.example.training.spring.interceptor;

import lombok.extern.slf4j.Slf4j;
import me.example.training.spring.domain.vo.ABResultVO;
import me.example.training.spring.domain.vo.ResultVO;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author zhoujialiang9
 * @date 2023/7/18 20:26
 **/
@Slf4j
@ControllerAdvice
public class AbResponseBody implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        //通过RequestContextHolder获取request
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        ModifiableHttpServletRequestWrapper requestWrapper = (ModifiableHttpServletRequestWrapper) httpServletRequest;

        if(body instanceof ResultVO){
            String key = requestWrapper.getParameter("key");
            ((ResultVO) body).setAbPower(buildABResult(key));
        }


        return body;
    }

    /**
     * 临时方法
     * @param key
     * @return
     */
    private List<ABResultVO> buildABResult(String key){
        List<ABResultVO> list = new ArrayList<>();

        ABResultVO abResultVO = new ABResultVO();
        abResultVO.setLabel(key);
        abResultVO.setExpId(key);
        list.add(abResultVO);

        return list;
    }
}
