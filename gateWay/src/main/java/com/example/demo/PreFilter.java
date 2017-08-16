package com.example.demo;

import com.example.demo.util.HttpUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by lenovo on 2017/7/29.
 */
public class PreFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(PreFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Map<String,ArrayList<String>> map = HttpUtil.getParamMap(request);
        System.out.print("id:"+request.getParameter("id"));
        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        map.put("id",list);
        System.out.print("加载完成");
        return null;
    }
}
