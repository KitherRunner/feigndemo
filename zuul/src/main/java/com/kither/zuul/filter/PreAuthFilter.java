package com.kither.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * zuul网关的前置过滤器，检验身份信息
 */
@Component
public class PreAuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        return currentContext.sendZuulResponse() && !currentContext.containsKey(FilterConstants.FORWARD_TO_KEY)
                && !currentContext.getRequest().getRequestURI().contains("validate");
    }

    /**
     * 校验逻辑,打到鉴权中心
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String authorization = request.getParameter("Authorization");
        if (StringUtils.isBlank(authorization)) {
        } else {
            context.setSendZuulResponse(false);
        }
        return null;
    }
}
