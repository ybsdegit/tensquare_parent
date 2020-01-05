package com.tenquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * WebFilter
 *
 * @author Paulson
 * @date 2020/1/5 15:23
 */
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Zuul 过滤器");
        // 得到 request 上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 得到 request 域
        HttpServletRequest request = currentContext.getRequest();
        // 得到头信息
        String header = request.getHeader("Authorization");
        // 判断是否有头信息
        if (StringUtils.isNotBlank(header)){
            currentContext.addZuulRequestHeader("Authorization", header);
        }
        return null;
    }
}
