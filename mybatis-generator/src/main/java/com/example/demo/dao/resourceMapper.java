package com.example.demo.dao;

import com.example.demo.domain.resource;

public interface resourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(resource record);

    int insertSelective(resource record);

    resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(resource record);

    int updateByPrimaryKey(resource record);
}