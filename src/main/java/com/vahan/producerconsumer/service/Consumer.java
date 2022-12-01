package com.vahan.producerconsumer.service;

import org.springframework.stereotype.Component;

import static com.vahan.producerconsumer.service.ApplicationProcessor.isStarted;

@Component
public class Consumer implements Runnable {

    public void run() {
        while (isStarted()) {
            while (Queue.getQueue().size() > 0) {
                ThreadSleep.sleep();
                Queue.takeNumber();
                if (Queue.getQueue().size() <= 75) {
                    Queue.unBlock();
                }
            }
        }
        Thread.currentThread().interrupt();
    }
}
