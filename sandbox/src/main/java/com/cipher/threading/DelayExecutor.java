package com.cipher.threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: CipherCui
 * @Description: 从 dubbo 源码抄过来的延时调度执行器
 * @Date: Created in 9:51 2018/9/7
 */
public class DelayExecutor {

    private static final ScheduledExecutorService delayExportExecutor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("DemoDelayExporter", true));

    public static void main(String[] args) throws InterruptedException {
        delayExportExecutor.schedule(() -> {
            System.out.println(111);
        }, 1000, TimeUnit.MILLISECONDS);
        System.out.println(222);
        Thread.sleep(5000);
    }

}
