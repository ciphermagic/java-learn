package com.cipher.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CipherCui
 * @Description: VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 将堆的最小值 -Xms 参数与最大值 -Xmx 参数设置为一样，可以避免堆自动扩展
 * -XX:+HeapDumpOnOutOfMemoryError 参数可以让虚拟机出现OOM时 Dump 出当时的内存堆快照
 * @Date: Created in 15:19 2018/8/2
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
