package com.cipher.netty.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.cipher.netty.constant.SerializerAlgorithm;
import com.cipher.netty.serialize.Serializer;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:31 2019/3/19
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }

}
