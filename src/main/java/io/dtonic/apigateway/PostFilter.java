package io.dtonic.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

// 받은 응답을 처리함
public class PostFilter extends ZuulFilter {
    @Override
    public boolean shouldFilter() {
        return false;
    }
 
    @Override
    public String filterType() {
        return "post";
    }
 
    @Override
    public int filterOrder() {
        return 2;
    }
 
    @Override
    public Object run() throws ZuulException {
        return null;
    }
    
}
