package com.java.redis.message.queue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
      * <p>Title: 应用模块名称</p>
      * <p>Description: 代码描述</p>
      * <p>Copyright: Copyright (C) 2012 Seeyon, Inc. All rights reserved. </p>
      * <p>Company: 北京致远协创软件有限公司</p>
      * @author wangqing 
      * 2017年11月30日上午10:09:37 
      */

public class ObjectUtil {

    /**
     *      将Obj转换为byte[]数组
          * @param obj
          * @return
          * @throws IOException
     */
    public static byte[] object2Bytes(Object obj) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        byte[] bytes = bo.toByteArray();
        bo.close();
        oo.close();
        return bytes;
    }

    /**
     *      将byte[]数组转换为Obj对象
          * @param bytes
          * @return
          * @throws Exception
     */
    public static Object bytes2Object(byte[] bytes) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream sIn = new ObjectInputStream(in);
        return sIn.readObject();
    }

}
