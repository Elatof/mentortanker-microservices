package com.korbiak.two.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "one")
public interface OneClient {

    @GetMapping(value = "/one-message")
    String getMassage();
}
