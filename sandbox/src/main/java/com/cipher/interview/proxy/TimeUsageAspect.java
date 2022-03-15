package com.cipher.interview.proxy;

/**
 * @author cipher
 */
public class TimeUsageAspect implements Aspect {

    long start;

    @Override
    public void before() {
        start = System.currentTimeMillis();
    }

    @Override
    public void after() {
        long usage = System.currentTimeMillis() - start;
        System.out.format("time usage : %dms\n", usage);

    }
}
