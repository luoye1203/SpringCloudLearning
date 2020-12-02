package com.lht.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "service-hi", fallbackFactory = RouterFeignFallBack.class, path = "/router")
public interface RouterFeign {

    /**
     * 代扣结果查询
     * @return
     */
    @PostMapping("/query")
    String queryTransRec(@RequestBody String add);

}
