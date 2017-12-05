package com.wq.mvc.redis.util;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
      * <p>Title: 应用模块名称</p>
      * <p>Description: 代码描述</p>
      * <p>Copyright: Copyright (C) 2012 Seeyon, Inc. All rights reserved. </p>
      * <p>Company: 北京致远协创软件有限公司</p>
      * @author wangqing 
      * 2017年8月29日下午3:23:40 
      */

public final class RedisUtil {
    private Logger                              logger = Logger.getLogger(RedisUtil.class);

    private RedisTemplate<Serializable, Object> redisTemplate;

    /** 
      * 获取redisTemplate 
      * @return redisTemplate 
      */

    public RedisTemplate<Serializable, Object> getRedisTemplate() {
        return redisTemplate;
    }

    /** 
      * 设置redisTemplate 
      * @param redisTemplate redisTemplate 
      */

    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /** 
     * 批量删除对应的value 
     *  
     * @param keys 
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /** 
     * 批量删除key 
     *  
     * @param pattern 
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /** 
     * 删除对应的value 
     *  
     * @param key 
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /** 
     * 判断缓存中是否有对应的value 
     *  
     * @param key 
     * @return 
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /** 
     * 读取缓存 
     *  
     * @param key 
     * @return 
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
