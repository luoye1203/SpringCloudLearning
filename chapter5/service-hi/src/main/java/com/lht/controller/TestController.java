package com.lht.controller;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RefreshScope
@RestController
@RequestMapping("/router")
public class TestController {


    // 计数器
    private static AtomicInteger count = new AtomicInteger(1);

    @PostMapping("/query")
    String queryTransRec(@RequestBody String query) throws InterruptedException {

        System.out.println(String.format("输入参数： %s", query));
        Thread.sleep(500);
        System.out.println(String.format("查询支付结果......计数： %s", count.getAndAdd(1)));
        return count + "";
    }

}