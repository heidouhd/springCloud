package com.example.demo.web;

import com.example.demo.domain.Demo;
import com.example.demo.service.DemoService;
import com.example.demo.util.HttpUtil;
import com.example.demo.util.ImageUploadUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2017/8/8.
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private AutoConfig autoConfig;

    @RequestMapping(value = "/getDemoById",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Demo Demo(
            @RequestParam(value = "id" , required = true) Long id,
            HttpServletRequest request
    ){
        HttpUtil.getParamMap(request);
        System.out.print(request.getParameter("fuck"));
        Demo demo = demoService.selectByPrimaryKey(id);
        demo.setName(autoConfig.getName());
        demo.setAddress(autoConfig.getAddress());
        demo.setAge(autoConfig.getAge());
        return demo;
    }

    /**
     * ckeditor图片上传
     *
     * @Title imageUpload
     * @param request
     * @param response
     */
    @RequestMapping("imageUpload")
    public void imageUpload(MultipartHttpServletRequest request, HttpServletResponse response) {
        String DirectoryName = "upload/";
        try {
            ImageUploadUtil.ckeditor(request, response, DirectoryName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
