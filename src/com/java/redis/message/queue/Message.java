package com.java.redis.message.queue;

import java.io.Serializable;

/**
      * <p>Title: 应用模块名称</p>
      * <p>Description: 代码描述</p>
      * <p>Copyright: Copyright (C) 2012 Seeyon, Inc. All rights reserved. </p>
      * <p>Company: 北京致远协创软件有限公司</p>
      * @author wangqing 
      * 2017年11月30日上午10:15:24 
      */

public class Message implements Serializable {

    /** */

    private static final long serialVersionUID = 1L;

    private int               id;

    private String            content;

    /** 
      * @param id
      * @param content 
      */

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    /** 
      * 获取id 
      * @return id 
      */

    public int getId() {
        return id;
    }

    /** 
      * 设置id 
      * @param id id 
      */

    public void setId(int id) {
        this.id = id;
    }

    /** 
      * 获取content 
      * @return content 
      */

    public String getContent() {
        return content;
    }

    /** 
      * 设置content 
      * @param content content 
      */

    public void setContent(String content) {
        this.content = content;
    }

}
