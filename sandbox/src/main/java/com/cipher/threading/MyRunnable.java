package com.cipher.threading;

/**
 * 创建10个线程，每个线程都打印从0到99这100个数字，希望线程之间不会出现交叉乱序打印，而是顺序地打印。
 */
public class MyRunnable implements Runnable {

    private static Object lock = new Object();

    public void run() {
        synchronized (lock) {
            for (int i = 0; i <= 99; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(new MyRunnable()).start();
        }
    }

}
