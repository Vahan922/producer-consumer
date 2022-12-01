package com.vahan.producerconsumer.service;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Queue {

    private static final Logger logger = LoggerFactory.getLogger(Queue.class);

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
    private static final AtomicBoolean blocker = new AtomicBoolean(false);

    public static void addNumber() {
        if (!blocker.get()) {
            final int number = RandomUtils.nextInt(1, 100);
            try {
                queue.put(number);
            } catch (InterruptedException e) {
                throw new RuntimeException("Could not add the number");
            }
            logger.info("Number:{} is produced to the queue (queueSize:{})", number, queue.size());
        }
    }

    public static void takeNumber() {
        try {
            final Integer number = queue.take();
            logger.info("Number:{} is consumed from the queue (queueSize:{})", number, queue.size());
        } catch (InterruptedException e) {
            throw new RuntimeException("Could not take the number");
        }
    }

    public static BlockingQueue<Integer> getQueue() {
        return queue;
    }

    public static void block() {
        if (!Queue.blocker.get()) {
            Queue.blocker.set(true);
            logger.info("Queue is blocked.");
        }
    }

    public static void unBlock() {
        if (Queue.blocker.get()) {
            Queue.blocker.set(false);
            logger.info("Queue is unblocked.");
        }
    }
}
