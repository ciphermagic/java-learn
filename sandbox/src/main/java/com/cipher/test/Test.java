package com.cipher.test;

public class Test {

    public static void main(String[] args) throws Exception {
        StopThread thread = new StopThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("stop");
    }

    private static class StopThread extends Thread {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("aaa");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

}
