package com.vahan.producerconsumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ProducerConsumerInputParametersDto {

    @NotNull
    @Max(10)
    @JsonProperty("producerCount")
    private Integer producerCount;

    @NotNull
    @Max(10)
    @JsonProperty("consumerCount")
    private Integer consumerCount;

    public ProducerConsumerInputParametersDto(Integer producerCount, Integer consumerCount) {
        this.producerCount = producerCount;
        this.consumerCount = consumerCount;
    }

    public Integer getProducerCount() {
        return producerCount;
    }

    public Integer getConsumerCount() {
        return consumerCount;
    }
}
