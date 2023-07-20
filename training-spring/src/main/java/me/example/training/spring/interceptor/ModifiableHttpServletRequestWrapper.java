package me.example.training.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhoujialiang9
 * @date 2023/7/18 20:24
 **/
public class ModifiableHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> parameterMap = new ConcurrentHashMap();
    private boolean merged;

    public ModifiableHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    private void parseParameterMap() {
        if (!this.merged) {
            super.getParameterMap().forEach((k, v) -> {
                this.parameterMap.putIfAbsent(k, v);
            });
            this.merged = true;
        }
    }

    public String getParameter(String name) {
        String[] values = (String[])this.parameterMap.get(name);
        if (values != null && values.length != 0) {
            return values[0];
        } else {
            return this.merged ? null : super.getParameter(name);
        }
    }

    public Map<String, String[]> getParameterMap() {
        this.parseParameterMap();
        return this.parameterMap;
    }

    public Enumeration<String> getParameterNames() {
        this.parseParameterMap();
        return Collections.enumeration(this.parameterMap.keySet());
    }

    public String[] getParameterValues(String name) {
        String[] values = (String[])this.parameterMap.get(name);
        if (values != null && values.length != 0) {
            return values;
        } else {
            return this.merged ? null : super.getParameterValues(name);
        }
    }

    public void setParameter(String name, String... values) {
        this.parameterMap.put(name, values);
    }
}
