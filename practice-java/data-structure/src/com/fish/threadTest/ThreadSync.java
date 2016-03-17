package com.fish.threadTest;

import java.util.List;

/**
 * Created by YuRuijie on 2016/3/17.
 */
public class ThreadSync extends ThreadTemplate<ThreadHelp> implements Runnable{
    public ThreadSync(ThreadHelp list) {
        super(list);
    }

    @Override
    public void run() {
        for(int i=1; i<=100; i++){
            synchronized (ThreadSync.class){
                name.content+=i;
                System.out.println(name.content);
            }
        }
    }
}
