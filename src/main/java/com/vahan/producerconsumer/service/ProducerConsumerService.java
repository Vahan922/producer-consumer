package com.vahan.producerconsumer.service;

public interface ProducerConsumerService {

    void start(Integer producerCount, Integer consumerCount);

    void stop();
}
