package com.fish.threadTest;

/**
 * Created by YuRuijie on 2016/3/16.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest test = new ThreadTest();
        test.synchronizedDemo();
    }

    /**
     * join 直到线程结束之后再开始继续当前线程
     * @throws InterruptedException
     */
    public void joinDemo() throws InterruptedException {
        System.out.println("main:start");
        Thread t1 = new Thread(new ThreadJoin("one"));
        Thread t2 = new Thread(new ThreadJoin("two"));
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("main:end");
    }

    /**
     * yield 暂停当前线程，然后唤醒一个线程，包括当前线程
     */
    public void yieldDemo(){
        Thread t1 = new Thread(new ThreadYield("t1"));
        Thread t2 = new Thread(new ThreadYield("t2"));
        t1.start();
        t2.start();
    }

    /**
     * priority 线程优先级设置 1-10 默认当前线程优先级最高
     */
    public void priorityDemo(){
        Thread t1 = new Thread(new ThreadJoin("one"));
        Thread t2 = new Thread(new ThreadJoin("two"));
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
    /**
     *synchronized 关键词
     */
    public void synchronizedDemo(){
        ThreadHelp name = new ThreadHelp(0);
        Thread t1 = new Thread(new ThreadSync(name));
        Thread t2 = new Thread(new ThreadSync(name));
        t1.start();
        t2.start();
    }
    /**
     *synchronized 关键词
     */
    public void failSynchronizedDemo(){
        ThreadHelp name = new ThreadHelp(0);
        Thread t1 = new Thread(new ThreadSyncF(name));
        Thread t2 = new Thread(new ThreadSyncF(name));
        t1.start();
        t2.start();
    }


}
