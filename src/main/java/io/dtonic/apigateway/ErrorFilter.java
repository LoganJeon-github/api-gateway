package io.dtonic.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

// 받은 요청의 유효성을 검증함
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
    
}