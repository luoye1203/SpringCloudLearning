package com.lht.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RouterFeignFallBack  implements FallbackFactory<RouterFeign>{


    @Override
    public RouterFeign create(Throwable throwable) {
        return new RouterFeign() {
            @Override
            public String queryTransRec(String add) {
                return "错误降级";
            }
        };
    }
}
