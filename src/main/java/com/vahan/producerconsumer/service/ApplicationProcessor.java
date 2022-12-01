package com.vahan.producerconsumer.service;

import java.util.concurrent.atomic.AtomicBoolean;

public class ApplicationProcessor {

    private final static AtomicBoolean start = new AtomicBoolean(false);

    public static void start() {
        start.set(true);
    }

    public static void stop() {
        start.set(false);
    }

    public static boolean isStarted() {
        return start.get();
    }
}
