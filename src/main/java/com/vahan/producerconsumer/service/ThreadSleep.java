package com.vahan.producerconsumer.service;

public class ThreadSleep {

    public static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
