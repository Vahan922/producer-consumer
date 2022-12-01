package com.vahan.producerconsumer.service;

import org.springframework.stereotype.Component;

import static com.vahan.producerconsumer.service.ApplicationProcessor.isStarted;

@Component
public class Producer implements Runnable{

    public void run() {
        while (isStarted()) {
            while (Queue.getQueue().size() <= 100 && isStarted()) {
                if (Queue.getQueue().size() == 100) {
                    Queue.block();
                }
                ThreadSleep.sleep();
                Queue.addNumber();
            }
        }
        Thread.currentThread().interrupt();
    }
}
