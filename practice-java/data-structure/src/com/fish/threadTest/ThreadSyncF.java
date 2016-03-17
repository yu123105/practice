package com.fish.threadTest;

import java.util.List;

/**
 * Created by YuRuijie on 2016/3/17.
 * 失败案例
 */

public class ThreadSyncF extends ThreadTemplate<ThreadHelp> implements Runnable{
    public ThreadSyncF(ThreadHelp name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=1; i<=100; i++){
            name.content += i;
            Thread.yield();
            System.out.println(name.content);
        }
    }
}
