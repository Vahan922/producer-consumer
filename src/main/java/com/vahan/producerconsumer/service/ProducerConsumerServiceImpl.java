package com.vahan.producerconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerConsumerServiceImpl implements ProducerConsumerService {

    private final Producer producer;
    private final Consumer consumer;

    @Autowired
    public ProducerConsumerServiceImpl(final Producer producer, final Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void start(final Integer producerCount, final Integer consumerCount) {
        ApplicationProcessor.start();
        for (int i = 0; i < producerCount; i++) {
            new Thread(producer).start();
        }
        for (int i = 0; i < consumerCount; i++) {
            new Thread(consumer).start();
        }
    }

    @Override
    public void stop() {
        ApplicationProcessor.stop();
    }
}
