/********************************************** 
 * Project Name:springboot-redis 
 * File Name:RedisController.java  
 * Package Name:com.cloudtop.springbootredis.Controller 
 * Date:2019年04月08日 17:21
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootredis.Controller;

import com.cloudtop.springbootredis.common.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyingjie
 * @Title: RedisController.java
 * @Package com.cloudtop.springbootredis.Controller
 * @Description: 空值层
 * @date 2019年04月08日 17:21
 */
@RestController
public class RedisController {

    @Autowired
    private  RedisUtil redisUtil;

    //查询String
    @RequestMapping(value = "/query/string",method = RequestMethod.GET)
    public Object queryString(String key){

        return redisUtil.get(key);
    }
    //查询list
    @RequestMapping(value = "/query/list",method = RequestMethod.GET)
    public Object queryList(String key,long start,long end){

        return redisUtil.lGet(key,start,end);
    }
    //查询set
    @RequestMapping(value = "/query/set",method = RequestMethod.GET)
    public Object querySet(String key){

        return redisUtil.sGet(key);
    }
    //查询hash
    @RequestMapping(value = "/query/hash",method = RequestMethod.GET)
    public Object queryHash(String key,String item){

       return redisUtil.hget(key,item);
    }
    //查询hashmap
    @RequestMapping(value = "/query/hashMap",method = RequestMethod.GET)
    public Object queryHashMap(String key){

        return redisUtil.hmget(key);
    }


    //添加string
    @RequestMapping(value = "/add/string",method = RequestMethod.POST)
    public boolean addString(String key,String value){

        return redisUtil.set(key,value);
    }

    //添加list
    @RequestMapping(value = "/add/list",method = RequestMethod.POST)
    public boolean addList(String key,String value){

        return redisUtil.lSet(key,value);
    }


}
