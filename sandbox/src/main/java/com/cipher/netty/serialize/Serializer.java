package com.cipher.netty.serialize;

import com.cipher.netty.serialize.impl.JSONSerializer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:29 2019/3/19
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);

}
