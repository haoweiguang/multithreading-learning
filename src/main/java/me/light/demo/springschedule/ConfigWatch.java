package me.light.demo.springschedule;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ScheduledFuture;

/**
 * @author light.hao
 * @date 2020/9/25 3:00 下午
 */
public class ConfigWatch {
    private final TaskScheduler taskScheduler;
    private ScheduledFuture<?> watchFuture;

    public ConfigWatch() {
        taskScheduler = getTaskScheduler();
    }

    private static ThreadPoolTaskScheduler getTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.initialize();
        return taskScheduler;
    }

    public void start() {
        this.watchFuture = this.taskScheduler.scheduleWithFixedDelay(this::servicesRule, 1000);
    }

    private void servicesRule() {
        System.out.println("ConfigWatch...");
    }
}
