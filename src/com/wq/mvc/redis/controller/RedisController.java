package com.wq.mvc.redis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.wq.mvc.redis.util.RedisUtil;

/**
  * <p>Title: 应用模块名称</p>
  * <p>Description: 代码描述</p>
  * <p>Copyright: Copyright (C) 2012 Seeyon, Inc. All rights reserved. </p>
  * <p>Company: 北京致远协创软件有限公司</p>
  * @author wangqing 
  * 2017年8月29日下午2:52:58 
  */

public class RedisController implements Controller {

    private RedisUtil redisUtil = null;

    /** 
      * {@inheritDoc} 
      */

    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        redisUtil.set("name", "wq");
        Object object = redisUtil.get("name");
        System.out.println(object);
        return null;
    }

    /** 
      * 获取redisUtil 
      * @return redisUtil 
      */

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }

    /** 
      * 设置redisUtil 
      * @param redisUtil redisUtil 
      */

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

}
