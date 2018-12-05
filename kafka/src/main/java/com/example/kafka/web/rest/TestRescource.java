package com.example.kafka.web.rest;

import com.example.kafka.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRescource {


    @Autowired
    private IndicatorService indicatorService;

    @GetMapping("/test/{string}")
    public void test(@PathVariable String string) {
        indicatorService.sendMessage("topic1",string);
    }
}
