package com.example.consume.service;

import rx.Observable;

import java.util.concurrent.Future;

public interface TestService {

    String test();

    /**
     * 用于异步请求
     * @return
     */
    Future<String> asyncTest();

    Observable<String> reactiveTest();
}
