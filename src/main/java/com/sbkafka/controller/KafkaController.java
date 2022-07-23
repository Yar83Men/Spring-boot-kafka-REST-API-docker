package com.sbkafka.controller;

import com.sbkafka.model.Person;
import com.sbkafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/api1")
    public void writeMessageToTopic1(@RequestParam("message") String message) {
        kafkaProducer.writeMessage(message);
    }

    @PostMapping("/api2")
    public void writeMessageToTopic2(@RequestBody Person person) {
        kafkaProducer.writeMessage(person.toString());
    }
}
