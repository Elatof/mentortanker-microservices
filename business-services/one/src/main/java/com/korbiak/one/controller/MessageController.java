package com.korbiak.one.controller;

import com.korbiak.one.client.CommonClient;
import com.netflix.servo.annotations.DataSourceType;
import com.netflix.servo.annotations.Monitor;
import com.netflix.servo.annotations.MonitorTags;
import com.netflix.servo.monitor.Monitors;
import com.netflix.servo.tag.BasicTagList;
import com.netflix.servo.tag.TagList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MessageController {
    @Monitor(name = "requestCounter", type = DataSourceType.COUNTER, description = "Total number of requests")
    private final AtomicInteger requestCounter = new AtomicInteger(0);

    @Monitor(name = "messageControllerLogs")
    private final List<String> messageControllerLogs = new ArrayList<>();

    @MonitorTags
    private final TagList tags =
            BasicTagList.of("id", "messageController", "class", "com.korbiak.one.controller.MessageController");

    private final CommonClient client;

    @PostConstruct
    public void init() {
        messageControllerLogs.add("Register test controller monitors");
        Monitors.registerObject("messageController", this);
    }

    public MessageController(CommonClient client) {
        this.client = client;
    }

    @GetMapping("/one-message")
    public String getMessage() {
        requestCounter.incrementAndGet();
        String response = client.getMassage();
        return String.format("Response from one service: {%s}", response);
    }
}
