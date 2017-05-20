package com.lmk.design_model.singleton;

/**
 * Created by limingkun on 2017/5/1.
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton(){}

    public StaticInnerClassSingleton getInstance(){
        return Holder.instance;
    }

    private static class Holder{
        private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }
}
