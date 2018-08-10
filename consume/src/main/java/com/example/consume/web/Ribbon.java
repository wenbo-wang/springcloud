package com.example.consume.web;

import com.example.consume.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @program springboot
 * @description 测试接口
 * @author liujc
 * @create 2018-07-23 15:55
 */
@RestController
public class Ribbon {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        return testService.test();
    }

    @GetMapping("/async-test")
    public String asyncTest() throws ExecutionException, InterruptedException {
        return testService.asyncTest().get();
    }

    @GetMapping("/zuul-test")
    public String zuulTest() throws ExecutionException, InterruptedException {
        return "zuul";
    }
    // todo 响应式编程使用
}
