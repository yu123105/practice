package com.fish.threadTest;

/**
 * Created by YuRuijie on 2016/3/17.
 * Thread.yield 暂停此线程并且唤醒一个线程（包括此线程 呵呵）
 */
public class ThreadYield extends ThreadTemplate implements Runnable{
    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            System.out.println("我暂停啦");
            Thread.yield();
            System.out.println("我继续拉");
            System.out.println(this.name+":"+i);
        }
    }
}
