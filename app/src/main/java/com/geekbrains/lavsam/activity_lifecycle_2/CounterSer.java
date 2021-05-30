package com.geekbrains.lavsam.activity_lifecycle_2;

import java.io.Serializable;

public class CounterSer implements Serializable {

    private int value;

    public CounterSer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }
}
