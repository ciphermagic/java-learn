package com.cipher.jvm;

/**
 * @Author: CipherCui
 * @Description: 对象可以在被 GC 时自我拯救；
 * 这种机会只有一次，因为一个对象的 finalize() 方法最多只会被系统自动调用一次
 * @Date: Created in 16:02 2018/8/16
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, I am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize 方法优先级很低，所以暂停一段时间等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, I am dead :(");
        }

        // 下面这段代码与上面的完全相同，但是这次自我拯救失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize 方法优先级很低，所以暂停一段时间等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, I am dead :(");
        }
    }

}
