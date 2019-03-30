/********************************************** 
 * Project Name:springboot-mybatis 
 * File Name:City.java  
 * Package Name:com.cloudtop.springbootmybatis.model 
 * Date:2019年03月30日 17:43
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootmybatis.model;

/**
 * @author yangyingjie
 * @Title: City.java
 * @Package com.cloudtop.springbootmybatis.model
 * @Description: city模型
 * @date 2019年03月30日 17:43
 */
public class City {

    private Integer id;

    private String name;

    private String countryCode;

    private String district;

    private String population;

    public void setId(Integer id){

        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

}
