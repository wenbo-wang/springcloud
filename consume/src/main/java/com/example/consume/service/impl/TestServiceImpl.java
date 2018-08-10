package com.example.consume.service.impl;

import com.example.consume.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.concurrent.Future;

/**
 * @program: springboot
 * @description: 测试
 * @author: liujc
 * @create: 2018-07-23 15:59
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 断路器， 当访问出错时，
     *         服务降级  当请求失败时，调用fallback
     *
     * 忽略异常，不会被下级捕获，直接抛给用户，不会触发降级服务
     * @HystrixCommand(fallbackMethod = "error1",ignoreExceptions = ArithmeticException.class)
     *
     * @return
     */
    @Override
    @HystrixCommand(defaultFallback = "error")
    public String test() {
        return restTemplate.getForObject("http://springboot/config",String.class);
    }

    /**
     *  Hystrix
     * 用于异步请求
     *
     * @return
     */
    @Override
    @HystrixCommand(defaultFallback = "error")
    public Future<String> asyncTest() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://springboot/config",String.class);
            }
        };
    }

    /**
     * 响应式请求
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "error")
    public Observable<String> reactiveTest() {
        return Observable.create(subscriber -> {
            if(!subscriber.isUnsubscribed()) {
                String s = restTemplate.getForObject("http://SPRINGBOOT/config",String.class);
                subscriber.onNext(s);
                subscriber.onCompleted();
            }
        });
    }

    /**
     *
     * @param throwable 可以抛出上层报错
     * @return
     */
    private String error(Throwable throwable) {
        System.out.println("error");
        return "error";
    }
}
