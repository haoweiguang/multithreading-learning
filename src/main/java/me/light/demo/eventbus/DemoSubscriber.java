package me.light.demo.eventbus;

import org.greenrobot.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订阅者
 *
 * @author light.hao
 * @date 2020/9/25 11:09 上午
 */
@Component
public class DemoSubscriber {
    private static final Logger log = LoggerFactory.getLogger(DemoSubscriber.class);

    @Subscribe
    public void onDemoUpdated(DemoEvent demoEvent) {
        log.info("demo is updated,thread={}", Thread.currentThread().getName());

        String demo = demoEvent.getDemo();
        log.info("get demo info is:{}", demo);
    }
}
