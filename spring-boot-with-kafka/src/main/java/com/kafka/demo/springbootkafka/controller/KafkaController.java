package com.kafka.demo.springbootkafka.controller;

import com.kafka.demo.springbootkafka.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final Producer producerService;

    @Autowired
    public KafkaController(Producer producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publish")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody String message) {
        this.producerService.sendMessage(message);
        return ResponseEntity.ok("Message received: " + message);
    }
}
