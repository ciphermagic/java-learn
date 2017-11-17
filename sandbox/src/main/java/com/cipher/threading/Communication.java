package com.cipher.threading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

/**
 * 线程间通信
 * Created by cipher on 2017/11/9.
 */
public class Communication {

    // 打印 1-3 三个数字
    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print:" + i);
        }
    }

    // 假设有两个线程，一个是线程 A，另一个是线程 B，两个线程分别依次打印 1-3 三个数字即可
    private static void demo1() {
        Thread A = new Thread(new Runnable() {
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            public void run() {
                printNumber("B");
            }
        });
        A.start();
        B.start();
    }

    // 如果希望 B 在 A 全部打印完后再开始打印
    private static void demo2() {
        final Thread A = new Thread(new Runnable() {
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
    }

    // 让两个线程按照指定方式有序交叉运行
    // A 在打印完 1 后，再让 B 打印 1, 2, 3，最后再回到 A 继续打印 2, 3
    private static void demo3() {
        final Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            public void run() {
                System.out.println("INFO: A 等待锁");
                synchronized (lock) {
                    System.out.println("INFO: A 得到了锁 lock");
                    System.out.println("A 1");
                    try {
                        System.out.println("INFO: A 准备进入等待状态，放弃锁 lock 的控制权");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("INFO: 有人唤醒了 A, A 重新获得锁 lock");
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            public void run() {
                System.out.println("INFO: B 等待锁");
                synchronized (lock) {
                    System.out.println("INFO: B 得到了锁 lock");
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    System.out.println("INFO: B 打印完毕，调用 notify 方法");
                    lock.notify();
                }
            }
        });
        A.start();
        B.start();
    }

    // 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
    private static void runDAfterABC() {
        int worker = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            public void run() {
                System.out.println("D 正在等待其他三个进程");
                try {
                    countDownLatch.await();
                    System.out.println("全部完成，D 开始执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String name = String.valueOf(threadName);
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(name + " 正在执行");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + " 执行完成");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    // 线程 A B C 各自开始准备，直到三者都准备完毕，然后再同时运行
    // 有三个跑步运动员，各自准备好后等待其他人，全部准备好后才开始跑
    private static void runABCWhenAllReady() {
        int runner = 3;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char name = 'A'; name <= 'C'; name++) {
            final String runnerName = String.valueOf(name);
            new Thread(new Runnable() {
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(runnerName + " 正在准备，需时：" + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(runnerName + " 准备完毕，等待其他进程");
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(runnerName + " 开始执行");
                }
            }).start();
        }
    }

    // 让子线程去计算从 1 加到 100，并把算出的结果返回到主线程
    private static void doTaskWithResultInWorker() {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("任务开始");
                Thread.sleep(1000);
                int total = 0;
                for (int i = 0; i <= 100; i++) {
                    total += i;
                }
                System.out.println("任务执行完成，返回结果");
                return total;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        try {
            Thread.sleep(2000);
            System.out.println("Before futureTask.get()");
            System.out.println("Result:" + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doTaskWithResultInWorker();
    }

}
