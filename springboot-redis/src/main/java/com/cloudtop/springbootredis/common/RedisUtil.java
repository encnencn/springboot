/********************************************** 
 * Project Name:springboot-redis 
 * File Name:RedisUtil.java  
 * Package Name:com.cloudtop.springbootredis.common 
 * Date:2019年04月04日 16:44
 * Copyright (c) 2019, 西安众盈医疗信息科技有限公司
 *
 *********************************************/
package com.cloudtop.springbootredis.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author yangyingjie
 * @Title: RedisUtil.java
 * @Package com.cloudtop.springbootredis.common
 * @Description: redis工具类
 *
 * 直接用RedisTemplate操作Redis，需要很多行代码，因此直接封装好一个RedisUtils，
 * 这样写代码更方便点。这个RedisUtils交给Spring容器实例化，使用时直接注解注入。
 *
 * @date 2019年04月04日 16:44
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key   键
     * @param time  时间（秒）
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if (time>0){
                redisTemplate.expire(key,time,TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     *
     * @param key 键
     * @return 时间（秒） 返回0代表永久有效
     */
    public long getExpire(String key){

        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key){

        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    public void del(String... key) {

        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
             }
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key
     * @return
     */
    public Object get(String key){

        return key == null? null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){

        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key 键
     * @param value 值
     * @param time  时间秒 time小于0则设置无限期
     * @return true成功 false失败
     */
    public boolean set(String key,Object value,long time){

        try {
            if (time>0){
                redisTemplate.opsForValue().set(key,value,time);
            }else {
                set(key,value);
            }
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递减（失效时间 递减）
     *
     * @param key 键
     * @param delta 要减少几（大于0）
     * @return
     */
    public long incr(String key,long delta){

        if (delta < 0){
            throw  new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key,-delta);
    }

    /**
     * hashget
     *
     * @param key 键 不能为空
     * @param item 项 不能为空
     * @return 值
     */
    public  Object hget(String key,String item){

        return redisTemplate.opsForHash().get(key,item);
    }



}
