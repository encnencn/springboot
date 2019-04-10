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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "redis接口")
@RestController
public class RedisController {

    @Autowired
    private  RedisUtil redisUtil;

    //查询String
    @ApiOperation(value="查询String", notes="查询String")
    @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "query")
    @RequestMapping(value = "/query/string",method = RequestMethod.GET)
    public Object queryString(String key){

        return redisUtil.get(key);
    }
    //查询list
    @ApiOperation(value="查询list", notes="查询list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "start", value = "start", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "end", value = "end", required = true, dataType = "long", paramType = "query")
    })
    @RequestMapping(value = "/query/list",method = RequestMethod.GET)
    public Object queryList(String key,long start,long end){

        return redisUtil.lGet(key,start,end);
    }
    //查询set
    @ApiOperation(value="查询list", notes="查询list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "start", value = "start", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "end", value = "end", required = true, dataType = "long", paramType = "query")
    })
    @RequestMapping(value = "/query/set",method = RequestMethod.GET)
    public Object querySet(String key){

        return redisUtil.sGet(key);
    }
    //查询hash
    @ApiOperation(value="查询list", notes="查询list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "start", value = "start", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "end", value = "end", required = true, dataType = "long", paramType = "query")
    })
    @RequestMapping(value = "/query/hash",method = RequestMethod.GET)
    public Object queryHash(String key,String item){

       return redisUtil.hget(key,item);
    }
    //查询hashmap
    @ApiOperation(value="查询hashmap", notes="查询hashmap")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/query/hashMap",method = RequestMethod.GET)
    public Object queryHashMap(String key){

        return redisUtil.hmget(key);
    }


    //添加string
    @ApiOperation(value="添加string", notes="添加string")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "value", value = "value", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/add/string",method = RequestMethod.POST)
    public boolean addString(String key,String value){

        return redisUtil.set(key,value);
    }

    //添加list
    @ApiOperation(value="添加list", notes="添加list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "value", value = "value", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/add/list",method = RequestMethod.POST)
    public boolean addList(String key,String value){

        return redisUtil.lSet(key,value);
    }


}
