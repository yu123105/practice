package com.fish.threadTest;

/**
 * Created by YuRuijie on 2016/3/17.
 */
public abstract class ThreadTemplate<T> {
    T name;
    public ThreadTemplate(T name){
        this.name = name;
    }
}
