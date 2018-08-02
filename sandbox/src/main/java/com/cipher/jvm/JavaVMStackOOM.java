package com.cipher.jvm;

/**
 * @Author: CipherCui
 * @Description: VM Args: -Xss2M
 * @Date: Created in 15:51 2018/8/2
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
