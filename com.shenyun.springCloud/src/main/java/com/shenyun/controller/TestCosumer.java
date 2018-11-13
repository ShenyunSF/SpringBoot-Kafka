package com.shenyun.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestCosumer {
    @KafkaListener(topics = {"test"})
    public void listener(String content) {
        System.out.println(content);
    }
}
