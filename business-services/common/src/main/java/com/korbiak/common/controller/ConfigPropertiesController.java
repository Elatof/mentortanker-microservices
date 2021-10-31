package com.korbiak.common.controller;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigPropertiesController {

    private final DynamicStringProperty dynamicHelloProperty =
            DynamicPropertyFactory.getInstance()
                    .getStringProperty("archaius.properties.hello", "not found");

    @GetMapping("/hello-property")
    public String getHelloProperty() {
        return "Response from common service:" + dynamicHelloProperty.getName() + ": " + dynamicHelloProperty.get();
    }

}
