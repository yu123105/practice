package com.fish.threadTest;

/**
 * Created by YuRuijie on 2016/3/16.
 *
 */
public class ThreadJoin implements Runnable{
    private String name;
    public ThreadJoin(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name+"start");
        for(int i=0; i<5; i++){
            System.out.println(name+i);
        }
        System.out.println(name+"end");
    }
}
