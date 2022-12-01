package com.vahan.producerconsumer.controller;

import com.vahan.producerconsumer.dto.ProducerConsumerInputParametersDto;
import com.vahan.producerconsumer.service.ProducerConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/producer-consumers")
public class ProducerConsumerController {

    private final ProducerConsumerService service;

    @Autowired
    public ProducerConsumerController(final ProducerConsumerService service) {
        this.service = service;
    }

    @PostMapping("/start")
    void start(@RequestBody @Valid final ProducerConsumerInputParametersDto parametersDto) {
        service.start(parametersDto.getProducerCount(), parametersDto.getConsumerCount());
    }

    @PostMapping("/stop")
    void stop() {
        service.stop();
    }
}
