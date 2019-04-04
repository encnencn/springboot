/********************************************** 
 * Project Name:springboot-mybatis 
 * File Name:CityService.java  
 * Package Name:com.cloudtop.springbootmybatis.service 
 * Date:2019年04月01日 9:45
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootmybatis.service.impl;

import com.cloudtop.springbootmybatis.mapper.CityMapper;
import com.cloudtop.springbootmybatis.model.City;
import com.cloudtop.springbootmybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangyingjie
 * @Title: CityService.java
 * @Package com.cloudtop.springbootmybatis.service
 * @Description: 城市业务类
 * @date 2019年04月01日 9:45
 */
@Service(value = "cityService")
public class CityServiceImpl implements CityService {

@Autowired
private CityMapper cityMapper;

    @Override
    public City getCityById(Integer id) {
        return cityMapper.getCityById(id);
    }
}
