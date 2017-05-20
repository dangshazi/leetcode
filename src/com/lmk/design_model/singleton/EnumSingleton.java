package com.lmk.design_model.singleton;

/**
 * Created by limingkun on 2017/5/1.
 */
public enum EnumSingleton {
    INSTANCE;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
