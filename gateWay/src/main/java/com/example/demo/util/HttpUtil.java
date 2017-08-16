package com.example.demo.util;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/14.
 */
public class HttpUtil {

    public static Map getParamMap(HttpServletRequest request){
        Map<String,ArrayList<String>> map = new HashMap<>();
        try {
            Class clazz = request.getClass();
            Field requestField1 = clazz.getDeclaredField("request");
            requestField1.setAccessible(true);
            Object innerRequest1 = requestField1.get(request);//获取到request对象

            Field requestField = innerRequest1.getClass().getDeclaredField("request");
            requestField.setAccessible(true);
            Object innerRequest = requestField.get(innerRequest1);

            //设置尚未初始化 (否则在获取一些参数的时候，可能会导致不一致)
            Field field = innerRequest.getClass().getDeclaredField("parametersParsed");
            field.setAccessible(true);
            field.setBoolean(innerRequest , false);

            Field coyoteRequestField = innerRequest.getClass().getDeclaredField("coyoteRequest");
            coyoteRequestField.setAccessible(true);
            Object coyoteRequestObject = coyoteRequestField.get(innerRequest);//获取到coyoteRequest对象

            Field parametersField = coyoteRequestObject.getClass().getDeclaredField("parameters");
            parametersField.setAccessible(true);
            Object parameterObject = parametersField.get(coyoteRequestObject);//获取到parameter的对象
//获取hashtable来完成对参数变量的修改
            Field hashTabArrField = parameterObject.getClass().getDeclaredField("paramHashValues");
            hashTabArrField.setAccessible(true);
            map = (Map<String,ArrayList<String>>)hashTabArrField.get(parameterObject);
            ArrayList<String> list = new ArrayList<>();
            list.add("fuck you!");
            map.put("fuck",list);
//也可以通过下面的方法，不过下面的方法只能添加参数，如果有相同的key，会追加参数，即，同一个key的结果集会有多个
//            Method method = parameterObject.getClass().getDeclaredMethod("addParameterValues" , String.class , String[].class);
//            method.invoke(parameterObject , "fuck" , new String[] {"fuck you!" , "sssss"});

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        System.out.println(request.getParameter("fuck"));
        return map;
    }

    public static Map getParametersMap(HttpServletRequest request){
        Map<String,ArrayList<String>> map = new HashMap<>();
        try {
            Class clazz = request.getClass();
            Field requestField = clazz.getSuperclass().getDeclaredField("parameters");
            requestField.setAccessible(true);
            map = (Map<String,ArrayList<String>>)requestField.get(request);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        System.out.println(request.getParameter("fuck"));
        return map;
    }
}
