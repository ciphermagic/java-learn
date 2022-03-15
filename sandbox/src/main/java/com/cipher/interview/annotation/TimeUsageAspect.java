package com.cipher.interview.annotation;

public class TimeUsageAspect implements IAspect {

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
