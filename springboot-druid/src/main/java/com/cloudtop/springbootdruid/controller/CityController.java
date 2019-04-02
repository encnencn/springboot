/********************************************** 
 * Project Name:springboot-mybatis 
 * File Name:CityController.java  
 * Package Name:com.cloudtop.springbootmybatis.controller 
 * Date:2019年04月01日 9:40
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootdruid.controller;


import com.cloudtop.springbootdruid.model.City;
import com.cloudtop.springbootdruid.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyingjie
 * @Title: CityController.java
 * @Package com.cloudtop.springbootmybatis.controller
 * @Description: 城市controller
 * @date 2019年04月01日 9:40
 */
@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/getCityById",produces = {"application/json;charset=UTF-8"})
    public City getCityById(Integer id){

        return cityService.getCityById(id);
    }
}
