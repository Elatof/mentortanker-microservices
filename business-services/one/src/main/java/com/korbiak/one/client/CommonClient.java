package com.korbiak.one.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "common")
public interface CommonClient {

    @GetMapping(value = "/hello-property")
    String getMassage();
}
