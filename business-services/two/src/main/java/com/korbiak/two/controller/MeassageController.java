package com.korbiak.two.controller;

import com.korbiak.two.client.OneClient;
import com.netflix.servo.annotations.DataSourceType;
import com.netflix.servo.annotations.Monitor;
import com.netflix.servo.annotations.MonitorTags;
import com.netflix.servo.monitor.BasicTimer;
import com.netflix.servo.monitor.MonitorConfig;
import com.netflix.servo.monitor.Monitors;
import com.netflix.servo.monitor.Stopwatch;
import com.netflix.servo.tag.BasicTagList;
import com.netflix.servo.tag.TagList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MeassageController {
    @Monitor(name = "requestCounter", type = DataSourceType.COUNTER, description = "Total number of requests")
    private final AtomicInteger requestCounter = new AtomicInteger(0);

    @MonitorTags
    private final TagList tags =
            BasicTagList.of("id", "timeoutController", "class", "com.korbiak.two.controller.RandomTimeoutController");

    private final OneClient client;

    @PostConstruct
    public void init() {
        Monitors.registerObject("messageController", this);
    }

    public MeassageController(OneClient client) {
        this.client = client;
    }

    @GetMapping("/two-message")
    public String getMessage() {
        requestCounter.incrementAndGet();
        String response = client.getMassage();
        return String.format("Response from two service: {%s}", response);
    }
}
