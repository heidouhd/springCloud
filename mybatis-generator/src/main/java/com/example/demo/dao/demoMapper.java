package com.example.demo.dao;

import com.example.demo.domain.demo;

public interface demoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(demo record);

    int insertSelective(demo record);

    demo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(demo record);

    int updateByPrimaryKey(demo record);
}