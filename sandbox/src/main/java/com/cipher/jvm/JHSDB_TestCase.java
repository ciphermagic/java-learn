package com.cipher.jvm;

/**
 * staticObj, instanceObj, localObj 存放在哪里
 * -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 *
 * @author: CipherCui
 * @since 2020/6/30
 */
public class JHSDB_TestCase {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("down"); // 这里设一个断点
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }

}
