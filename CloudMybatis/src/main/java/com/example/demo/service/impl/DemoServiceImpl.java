package com.example.demo.service.impl;

import com.example.demo.dao.DemoMapper;
import com.example.demo.domain.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/8/8.
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Resource
    private DemoMapper demoMapper;

    @Override
    public Demo selectByPrimaryKey(Long id) {

        return demoMapper.selectByPrimaryKey(id);
    }
}
