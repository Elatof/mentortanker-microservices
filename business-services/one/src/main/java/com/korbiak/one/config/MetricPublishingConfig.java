package com.korbiak.one.config;

import com.netflix.servo.publish.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.concurrent.TimeUnit;

@Component
public class MetricPublishingConfig {

    @Value("${metrics.dir}")
    private String metricsDir;

    @PostConstruct
    public void initMetricsPublishing() {
        PollScheduler scheduler = PollScheduler.getInstance();
        scheduler.start();
        FileMetricObserver observer = new FileMetricObserver("one","yyyy", new File(metricsDir), false);
        PollRunnable task = new PollRunnable(
                new MonitorRegistryMetricPoller(),
                BasicMetricFilter.MATCH_ALL,
                observer);
        scheduler.addPoller(task, 1, TimeUnit.MINUTES);
    }

}
