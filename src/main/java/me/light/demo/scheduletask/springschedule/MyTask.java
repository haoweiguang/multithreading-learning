package me.light.demo.scheduletask.springschedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author light.hao
 * @date 2020/12/1 1:22 下午
 */
@Component
public class MyTask {
    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
